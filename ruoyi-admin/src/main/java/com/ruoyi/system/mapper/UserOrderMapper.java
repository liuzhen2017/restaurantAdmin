package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.UserOrder;

/**
 * 訂單 数据层
 * 
 * @author liuzhen
 * @date 2019-01-31
 */
public interface UserOrderMapper 
{
	/**
     * 查询訂單信息
     * 
     * @param id 訂單ID
     * @return 訂單信息
     */
	public UserOrder selectOrderById(Integer id);
	
	/**
     * 查询訂單列表
     * 
     * @param order 訂單信息
     * @return 訂單集合
     */
	public List<UserOrder> selectOrderList(UserOrder order);
	
	/**
     * 新增訂單
     * 
     * @param order 訂單信息
     * @return 结果
     */
	public int insertOrder(UserOrder order);
	
	/**
     * 修改訂單
     * 
     * @param order 訂單信息
     * @return 结果
     */
	public int updateOrder(UserOrder order);
	
	/**
     * 删除訂單
     * 
     * @param id 訂單ID
     * @return 结果
     */
	public int deleteOrderById(Integer id);
	
	/**
     * 批量删除訂單
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String[] ids);
	
}