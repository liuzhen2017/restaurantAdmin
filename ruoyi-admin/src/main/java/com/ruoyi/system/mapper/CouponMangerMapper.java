package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.CouponManger;

/**
 * 优惠券管理 数据层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface CouponMangerMapper 
{
	/**
     * 查询优惠券管理信息
     * 
     * @param id 优惠券管理ID
     * @return 优惠券管理信息
     */
	public CouponManger selectCouponMangerById(Integer id);
	
	/**
     * 查询优惠券管理列表
     * 
     * @param couponManger 优惠券管理信息
     * @return 优惠券管理集合
     */
	public List<CouponManger> selectCouponMangerList(CouponManger couponManger);
	
	/**
     * 新增优惠券管理
     * 
     * @param couponManger 优惠券管理信息
     * @return 结果
     */
	public int insertCouponManger(CouponManger couponManger);
	
	/**
     * 修改优惠券管理
     * 
     * @param couponManger 优惠券管理信息
     * @return 结果
     */
	public int updateCouponManger(CouponManger couponManger);
	
	/**
     * 删除优惠券管理
     * 
     * @param id 优惠券管理ID
     * @return 结果
     */
	public int deleteCouponMangerById(Integer id);
	
	/**
     * 批量删除优惠券管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCouponMangerByIds(String[] ids);

	public CouponManger selectCouponMangerByCouponCode(@Param(value = "couponCode")  String couponCode);
	
}