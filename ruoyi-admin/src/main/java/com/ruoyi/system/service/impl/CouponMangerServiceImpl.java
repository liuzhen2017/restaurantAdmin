package com.ruoyi.system.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.WriterException;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.quartz.po.SendEmaill;
import com.ruoyi.quartz.util.SendEmailUtil;
import com.ruoyi.system.domain.CouponManger;
import com.ruoyi.system.domain.Members;
import com.ruoyi.system.domain.MyCoupon;
import com.ruoyi.system.domain.NoticeInfo;
import com.ruoyi.system.mapper.CouponMangerMapper;
import com.ruoyi.system.mapper.NoticeInfoMapper;
import com.ruoyi.system.service.ICouponMangerService;
import com.ruoyi.system.service.IMembersService;
import com.ruoyi.system.service.IMyCouponService;
import com.ruoyi.util.sms.AESUtil;
import com.ruoyi.util.sms.QrCodeCreateUtil;
import com.ruoyi.util.sms.RC4;

/**
 * 优惠券管理 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class CouponMangerServiceImpl implements ICouponMangerService 
{
	@Autowired
	private CouponMangerMapper couponMangerMapper;
	@Autowired
	private IMyCouponService myCouponManger;
	
	@Autowired
	private IMembersService membersService;
	@Autowired
	private SendEmailUtil sendEmailUtil;
	@Autowired
	private NoticeInfoMapper noticeInfoMapper;
	
	/**
     * 查询优惠券管理信息
     * 
     * @param id 优惠券管理ID
     * @return 优惠券管理信息
     */
    @Override
	public CouponManger selectCouponMangerById(Integer id)
	{
	    return couponMangerMapper.selectCouponMangerById(id);
	}
	
	/**
     * 查询优惠券管理列表
     * 
     * @param couponManger 优惠券管理信息
     * @return 优惠券管理集合
     */
	@Override
	public List<CouponManger> selectCouponMangerList(CouponManger couponManger)
	{
	    return couponMangerMapper.selectCouponMangerList(couponManger);
	}
	
    /**
     * 新增优惠券管理
     * 
     * @param couponManger 优惠券管理信息
     * @return 结果
     */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public AjaxResult insertCouponManger(CouponManger couponManger)
	{
		couponManger.setCouponCode(RC4.encry_RC4_string(String.format("%07d",(int) (Math.random()*1000))+"",UUID.randomUUID().toString()));
		
		CouponManger mangerByCouponCode = couponMangerMapper.selectCouponMangerByCouponCode(couponManger.getCouponCode());
		if(mangerByCouponCode != null){
			couponManger.setCouponCode(RC4.encry_RC4_string(String.format("%07d",(int) (Math.random()*1000))+"",UUID.randomUUID().toString()));
		}
		
		//未發放數量等於 總數量
		couponManger.setNoGrantNum(couponManger.getNum());
		
		
	    int result =couponMangerMapper.insertCouponManger(couponManger);
	    
	    if(result >0){
	    	MyCoupon my=null;
	    	String code =null;
	    	for(int i=0;i<couponManger.getNum();i++){
	    		my =new MyCoupon();
	    		my.setCouponId(couponManger.getId());
	    		my.setCouponType(couponManger.getTypes());
	    		my.setEffectiveTimeBegin(couponManger.getEffectiveTimeBegin());
	    		my.setEffectiveTimeEnd(couponManger.getEffectiveTimeEnd());
	    		my.setTitle(couponManger.getTitle());
	    		my.setInstructions(couponManger.getInstructions());
	    		my.setMembersType(couponManger.getMembersType());
	    		my.setStatus(0);
	    		my.setCreateBy(couponManger.getCreateBy());
	    		my.setCreateDate(couponManger.getCreateDate());
	    		my.setCouponValues(couponManger.getCouponValues());
	    		my.setPicUrl(couponManger.getPicUrl());
	    		my.setCouponRole(couponManger.getCouponRole());
	    		my.setExplanation(couponManger.getExplanation());
	    		//如果是优惠代码
    			code =RC4.encry_RC4_string(String.format("%07d",i)+"",UUID.randomUUID().toString());
    			my.setCouponCode(code.toUpperCase());
	    		myCouponManger.insertMyCoupon(my);
	    	}
	    	return AjaxResult.success();
	    }
	    return AjaxResult.error();
	}
	
	/**
     * 修改优惠券管理
     * 
     * @param couponManger 优惠券管理信息
     * @return 结果
     */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public AjaxResult updateCouponManger(CouponManger couponManger)
	{
		CouponManger selectCouponMangerById = couponMangerMapper.selectCouponMangerById(couponManger.getId());
		if(selectCouponMangerById ==null){
			return AjaxResult.error("該數據不再數據庫!");
		}
		String begin =selectCouponMangerById.getEffectiveTimeBegin();
		String end =selectCouponMangerById.getEffectiveTimeEnd();
		
		if(StringUtils.isNotEmpty(begin) && DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", begin).after(new Date())){
			return AjaxResult.error("該優惠券已經生效,不允許修改!");
		}
		if(StringUtils.isNotEmpty(end) && DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", end).before(new Date())){
			return AjaxResult.error("該優惠券已經失效,不允許修改!");
		}
		if(selectCouponMangerById.getIsVaild().equals("no")){
			return AjaxResult.error("該優惠券已經失效,不允許修改!");
		}
		selectCouponMangerById.setTitle(couponManger.getTitle());
		selectCouponMangerById.setCouponValues(couponManger.getCouponValues());
		selectCouponMangerById.setEffectiveTimeBegin(couponManger.getEffectiveTimeBegin());
		selectCouponMangerById.setEffectiveTimeEnd(couponManger.getEffectiveTimeEnd());
		selectCouponMangerById.setPicUrl(couponManger.getPicUrl());
		if(StringUtils.isNoneBlank(couponManger.getIsVaild()) && !couponManger.getIsVaild().equals("請選擇")){
		   selectCouponMangerById.setIsVaild("no");
		}
		if(couponMangerMapper.updateCouponManger(selectCouponMangerById)>0){
			MyCoupon myCoupon =new MyCoupon();
			myCoupon.setCouponId(couponManger.getId());
			List<MyCoupon> selectMyCouponList = myCouponManger.selectMyCouponList(myCoupon);
			for(int i=0;i<selectMyCouponList.size();i++){
				myCoupon =selectMyCouponList.get(i);
				myCoupon.setTitle(couponManger.getTitle());
				myCoupon.setCouponValues(couponManger.getCouponValues());
				myCoupon.setEffectiveTimeBegin(couponManger.getEffectiveTimeBegin());
				myCoupon.setEffectiveTimeEnd(couponManger.getEffectiveTimeEnd());
				myCoupon.setPicUrl(couponManger.getPicUrl());
				myCoupon.setCouponRole(couponManger.getCouponRole());
				myCoupon.setExplanation(couponManger.getExplanation());
				//如果是强制失效所有      應急處理,如果有紕漏，可以緊急去掉優惠
				if(StringUtils.isNoneBlank(couponManger.getIsVaild()) && couponManger.getIsVaild().equals("all")){
					myCoupon.setIsVaild("no");
					
					//如果是强制失效所有為發放的   應急處理,如果有紕漏，可以緊急去掉優惠 
				}else if(StringUtils.isNoneBlank(couponManger.getIsVaild()) && couponManger.getIsVaild().equals("allNoGrant") &&myCoupon.getMembersId() ==null && myCoupon.getStatus().equals("0")){
					myCoupon.setIsVaild("no");	
				}
	    		myCouponManger.updateMyCoupon(myCoupon);
	    	}
		}
	    return AjaxResult.success();
	}

	/**
     * 删除优惠券管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCouponMangerByIds(String ids)
	{
		return couponMangerMapper.deleteCouponMangerByIds(Convert.toStrArray(ids));
	}
	public static void main(String[] args) {
		
		System.out.println(JSONObject.toJSONString(AjaxResult.error("數據不存在!")));
	}

	@Override
	public void showQC(Integer id, HttpServletResponse response,HttpServletRequest request) throws WriterException, IOException {
		response.setCharacterEncoding("utf-8");
		CouponManger selectCouponMangerById = couponMangerMapper.selectCouponMangerById(id);
		ServletOutputStream outputStream = response.getOutputStream();
		if(selectCouponMangerById != null){
			if(selectCouponMangerById.getIsVaild().equals("no") && StringUtils.isNotEmpty(selectCouponMangerById.getEffectiveTimeEnd()) && DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", selectCouponMangerById.getEffectiveTimeEnd()).before(new Date())) {
				outputStream.print(JSONObject.toJSONString(AjaxResult.error("數據已經失效!")));	
			}
			File tempFile = File.createTempFile(selectCouponMangerById.getCouponCode(), ".JPEG");
			FileOutputStream fileOutputStream  =new FileOutputStream(tempFile);
			boolean uploadFile =true;
			uploadFile =QrCodeCreateUtil.createQrCode(fileOutputStream, AESUtil.AES_CBC_Encrypt(selectCouponMangerById.getCouponCode()),900, "JPEG");
			if(!uploadFile){
				outputStream.print(JSONObject.toJSONString(AjaxResult.error("創建二維碼失敗!")));
			}
			//下載文件
			//设置文件下载头
			String fileName = new String((selectCouponMangerById.getTitle()+"_"+DateUtils.dateTime()).getBytes(request.getCharacterEncoding()), "ISO8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" +  fileName+".JPEG");
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            InputStream bis = new BufferedInputStream(new FileInputStream(tempFile));
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            fileOutputStream.close();
            bis.close();
            out.close();
		}else{
			outputStream.print(JSONObject.toJSONString(AjaxResult.error("數據不存在!")));
		}
		outputStream.flush();
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public AjaxResult grantMembers(String ids,String couponCode) {
		//加鎖
		Lock lock =new ReentrantLock();
		lock.lock();
		try {
			CouponManger mangerByCouponCode = couponMangerMapper.selectCouponMangerByCouponCode(couponCode);
			if(mangerByCouponCode ==null){
				return AjaxResult.error("優惠券已經失效!");
			}
			if(mangerByCouponCode.getIsVaild().equals("no")){
				return AjaxResult.error("優惠券已經失效!");
			}
			if(StringUtils.isNotEmpty(mangerByCouponCode.getEffectiveTimeEnd()) && DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", mangerByCouponCode.getEffectiveTimeEnd()).before(new Date())){
				return AjaxResult.error("優惠券已經失效!");
			}
			MyCoupon myCoupon =new MyCoupon();
			myCoupon.setIsVaild("yes");
			myCoupon.setStatus(0);
			
			//查找優惠券
			List<MyCoupon> myCouponList = myCouponManger.selectMyCouponList(myCoupon);
			//查找會員
			List<String> listStr =Arrays.asList(ids.split(","));
			if(myCouponList ==null || myCouponList.size() < listStr.size()){
				return AjaxResult.error("可發放的優惠券不足，優惠券數量:"+myCouponList.size()+",發放會員數量:"+listStr.size());
			}
			String content ="尊敬的怵八金巴利 會員,恭喜您,獲得系統贈送 "+mangerByCouponCode.getTitle()+" 優惠券一張,請登錄APP領取.";
			
			List<Members> listMem =membersService.selectMembersByIds(listStr);
			List<Members> listMems =new ArrayList<Members>(); 
			StringBuffer sendEmail =new StringBuffer();
			listMem.forEach(e->{if(e.getIsVaild().equals("no")){listMems.add(e);};});
			if(listMem.size() != listStr.size()){
				return AjaxResult.error("會員數據庫數量不匹配,請重新選擇分配");
			}
			//修改優惠券狀態為 已發送,待領取
			for(int i=0;i< listMem.size(); i++){
				myCouponList.get(i).setMembersId(listMem.get(i).getId());
				myCouponList.get(i).setStatus(1);
				myCouponList.get(i).setSpareField1("系統發放");
				//修改
				myCouponManger.updateMyCoupon(myCouponList.get(i));
				
				//寫入消息
				NoticeInfo noticeInfo =new NoticeInfo();
				noticeInfo.setTitle(content);
			//	noticeInfo.setCreateBy(ShiroUtils.getSysUser().getLoginName()+"");
				noticeInfo.setCreateDate(new Date());
				noticeInfo.setIsSee("no");
				noticeInfo.setMemId(listMem.get(i).getId());
				noticeInfo.setResourceId(myCouponList.get(i).getId());;
				noticeInfo.setResourceTable("MyCoupon");
				noticeInfo.setPicUrl(myCouponList.get(i).getPicUrl());
				noticeInfoMapper.insertNoticeInfo(noticeInfo);
				
				
				sendEmail.append(listMem.get(i).getEmail()+";");
				
			}
			//修改优惠券主表,未发放数量
			mangerByCouponCode.setNoGrantNum(mangerByCouponCode.getNoGrantNum() - listMem.size());
			mangerByCouponCode.setStatus(1);
			couponMangerMapper.updateCouponManger(mangerByCouponCode);
			
			//发送邮件
			SendEmaill sendEmaill =new SendEmaill();
			
			sendEmaill.setSendContent(content);
			sendEmaill.setSendTo(sendEmail.toString());
			sendEmaill.setTitle("怵八金巴利贈送"+mangerByCouponCode.getTitle()+" 優惠券");
			sendEmailUtil.sendEmail(sendEmaill);
			

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("處理失敗!");
		}finally{
			//解鎖
			lock.unlock();
		}
		return AjaxResult.success("優惠券發放成功!");
	}
}
