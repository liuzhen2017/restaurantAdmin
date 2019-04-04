package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.MenuFood;

/**
 * 餐牌 数据层
 * 
 * @author liuzhen
 * @date 2019-02-16
 */
public interface MenuFoodMapper 
{
	/**
     * 查询餐牌信息
     * 
     * @param id 餐牌ID
     * @return 餐牌信息
     */
	public MenuFood selectMenuFoodById(Integer id);
	
	/**
     * 查询餐牌列表
     * 
     * @param menuFood 餐牌信息
     * @return 餐牌集合
     */
	public List<MenuFood> selectMenuFoodList(MenuFood menuFood);
	
	/**
     * 新增餐牌
     * 
     * @param menuFood 餐牌信息
     * @return 结果
     */
	public int insertMenuFood(MenuFood menuFood);
	
	/**
     * 修改餐牌
     * 
     * @param menuFood 餐牌信息
     * @return 结果
     */
	public int updateMenuFood(MenuFood menuFood);
	
	/**
     * 删除餐牌
     * 
     * @param id 餐牌ID
     * @return 结果
     */
	public int deleteMenuFoodById(Integer id);
	
	/**
     * 批量删除餐牌
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuFoodByIds(String[] ids);
	
}