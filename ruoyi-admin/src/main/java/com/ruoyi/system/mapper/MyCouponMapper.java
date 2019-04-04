package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.MyCoupon;
import java.util.List;	

/**
 * 我的优惠券 数据层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface MyCouponMapper 
{
	/**
     * 查询我的优惠券信息
     * 
     * @param id 我的优惠券ID
     * @return 我的优惠券信息
     */
	public MyCoupon selectMyCouponById(Integer id);
	
	/**
     * 查询我的优惠券列表
     * 
     * @param myCoupon 我的优惠券信息
     * @return 我的优惠券集合
     */
	public List<MyCoupon> selectMyCouponList(MyCoupon myCoupon);
	
	/**
     * 新增我的优惠券
     * 
     * @param myCoupon 我的优惠券信息
     * @return 结果
     */
	public int insertMyCoupon(MyCoupon myCoupon);
	
	/**
     * 修改我的优惠券
     * 
     * @param myCoupon 我的优惠券信息
     * @return 结果
     */
	public int updateMyCoupon(MyCoupon myCoupon);
	
	/**
     * 删除我的优惠券
     * 
     * @param id 我的优惠券ID
     * @return 结果
     */
	public int deleteMyCouponById(Integer id);
	
	/**
     * 批量删除我的优惠券
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMyCouponByIds(String[] ids);
	
}