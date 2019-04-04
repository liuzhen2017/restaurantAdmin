package com.ruoyi.system.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.WriterException;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MenuFood;
import com.ruoyi.system.mapper.MenuFoodMapper;
import com.ruoyi.system.service.IMenuFoodService;
import com.ruoyi.util.sms.AESUtil;
import com.ruoyi.util.sms.QrCodeCreateUtil;

/**
 * 餐牌 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class MenuFoodServiceImpl implements IMenuFoodService 
{
	@Autowired
	private MenuFoodMapper menuFoodMapper;
	private String contentType="menuFood";

	/**
     * 查询餐牌信息
     * 
     * @param id 餐牌ID
     * @return 餐牌信息
     */
    @Override
	public MenuFood selectMenuFoodById(Integer id)
	{
	    return menuFoodMapper.selectMenuFoodById(id);
	}
	
	/**
     * 查询餐牌列表
     * 
     * @param menuFood 餐牌信息
     * @return 餐牌集合
     */
	@Override
	public List<MenuFood> selectMenuFoodList(MenuFood menuFood)
	{
	    return menuFoodMapper.selectMenuFoodList(menuFood);
	}
	
    /**
     * 新增餐牌
     * 
     * @param menuFood 餐牌信息
     * @return 结果
     */
	@Override
	public int insertMenuFood(MenuFood menuFood)
	{
		menuFood.setCreateBy(ShiroUtils.getSysUser().getLoginName()+"");
		menuFood.setCreateDate(new Date());
	    return menuFoodMapper.insertMenuFood(menuFood);
	}
	
	/**
     * 修改餐牌
     * 
     * @param menuFood 餐牌信息
     * @return 结果
     */
	@Override
	public int updateMenuFood(MenuFood menuFood)
	{
	    return menuFoodMapper.updateMenuFood(menuFood);
	}

	/**
     * 删除餐牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMenuFoodByIds(String ids)
	{
		return menuFoodMapper.deleteMenuFoodByIds(Convert.toStrArray(ids));
	}

	@Override
	public void showQC(Integer id, HttpServletResponse response,HttpServletRequest request) throws WriterException, IOException {
		response.setCharacterEncoding("utf-8");
		MenuFood selectCouponMangerById = menuFoodMapper.selectMenuFoodById(id);
		ServletOutputStream outputStream = response.getOutputStream();
		if(selectCouponMangerById != null){
			if(selectCouponMangerById.getIsValid().equals("no") && StringUtils.isNotEmpty(selectCouponMangerById.getInvalidDate()) && DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", selectCouponMangerById.getInvalidDate()).before(new Date())) {
				outputStream.print(JSONObject.toJSONString(AjaxResult.error("數據已經失效!")));	
			}
			File tempFile = File.createTempFile(selectCouponMangerById.getSpareField1(), ".JPEG");
			FileOutputStream fileOutputStream  =new FileOutputStream(tempFile);
			boolean uploadFile =true;
			uploadFile =QrCodeCreateUtil.createQrCode(fileOutputStream, AESUtil.AES_CBC_Encrypt("type="+contentType+";"+selectCouponMangerById.getId()),900, "JPEG");
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
	
}
