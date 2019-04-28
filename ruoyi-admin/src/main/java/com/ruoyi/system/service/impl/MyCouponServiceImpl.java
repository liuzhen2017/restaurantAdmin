package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.MyCouponMapper;
import com.ruoyi.system.domain.MyCoupon;
import com.ruoyi.system.service.IMyCouponService;
import com.ruoyi.common.support.Convert;

/**
 * 我的优惠券 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class MyCouponServiceImpl implements IMyCouponService 
{
	@Autowired
	private MyCouponMapper myCouponMapper;

	/**
     * 查询我的优惠券信息
     * 
     * @param id 我的优惠券ID
     * @return 我的优惠券信息
     */
    @Override
	public MyCoupon selectMyCouponById(Integer id)
	{
	    return myCouponMapper.selectMyCouponById(id);
	}
	
	/**
     * 查询我的优惠券列表
     * 
     * @param myCoupon 我的优惠券信息
     * @return 我的优惠券集合
     */
	@Override
	public List<MyCoupon> selectMyCouponList(MyCoupon myCoupon)
	{
	    return myCouponMapper.selectMyCouponList(myCoupon);
	}
	
    /**
     * 新增我的优惠券
     * 
     * @param myCoupon 我的优惠券信息
     * @return 结果
     */
	@Override
	public int insertMyCoupon(MyCoupon myCoupon)
	{
	    return myCouponMapper.insertMyCoupon(myCoupon);
	}
	
	/**
     * 修改我的优惠券
     * 
     * @param myCoupon 我的优惠券信息
     * @return 结果
     */
	@Override
	public int updateMyCoupon(MyCoupon myCoupon)
	{
//		MyCoupon selectMyCouponById = myCouponMapper.selectMyCouponById(myCoupon.getId());
//		///只能修改 有效和無效
//		selectMyCouponById.setIsVaild(myCoupon.getIsVaild());
	    return myCouponMapper.updateMyCoupon(myCoupon);
	}

	/**
     * 删除我的优惠券对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMyCouponByIds(String ids)
	{
		return myCouponMapper.deleteMyCouponByIds(Convert.toStrArray(ids));
	}

	@Override
	public int settingVaild(int id) {
		MyCoupon selectMyCouponById = myCouponMapper.selectMyCouponById(id);
		///只能修改 有效和無效
		String isVaild =selectMyCouponById.getIsVaild();
		if(isVaild.contains("yes")){
			isVaild ="no";
		}else{
			isVaild ="yes";
		}
		selectMyCouponById =new MyCoupon();
		selectMyCouponById.setId(id);
		selectMyCouponById.setIsVaild(isVaild);
	    return myCouponMapper.updateMyCoupon(selectMyCouponById);
	}

	/* (non-Javadoc)
	 * @see com.ruoyi.system.service.IMyCouponService#selectCouponMangerByCouponCode(java.lang.String)
	 */
	@Override
	public String selectCouponMangerByCouponCode(String code) {
		return myCouponMapper.selectCouponMangerByCouponCode(code);
		
	}
	
}
