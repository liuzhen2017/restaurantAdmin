package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.MenuFoodType;

/**
 * 餐牌類型 服务层
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
public interface IMenuFoodTypeService 
{
	/**
     * 查询餐牌類型信息
     * 
     * @param id 餐牌類型ID
     * @return 餐牌類型信息
     */
	public MenuFoodType selectMenuFoodTypeById(Integer id);
	
	/**
     * 查询餐牌類型列表
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 餐牌類型集合
     */
	public List<MenuFoodType> selectMenuFoodTypeList(MenuFoodType menuFoodType);
	
	/**
     * 新增餐牌類型
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 结果
     */
	public int insertMenuFoodType(MenuFoodType menuFoodType);
	
	/**
     * 修改餐牌類型
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 结果
     */
	public int updateMenuFoodType(MenuFoodType menuFoodType);
		
	/**
     * 删除餐牌類型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuFoodTypeByIds(String ids);
	
}
