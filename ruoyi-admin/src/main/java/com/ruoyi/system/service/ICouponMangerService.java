package com.ruoyi.system.service;

import com.google.zxing.WriterException;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.system.domain.CouponManger;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 优惠券管理 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface ICouponMangerService 
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
	public AjaxResult insertCouponManger(CouponManger couponManger);
	
	/**
     * 修改优惠券管理
     * 
     * @param couponManger 优惠券管理信息
     * @return 结果
     */
	public AjaxResult updateCouponManger(CouponManger couponManger);
		
	/**
     * 删除优惠券管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCouponMangerByIds(String ids);

	public void showQC(Integer id, HttpServletResponse response,HttpServletRequest request) throws WriterException, IOException;

	public AjaxResult grantMembers(String ids, String couponCode);
	
	
	
}
