package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.MenuFoodType;
import com.ruoyi.system.mapper.MenuFoodTypeMapper;
import com.ruoyi.system.service.IMenuFoodTypeService;

/**
 * 餐牌類型 服务层实现
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Service
public class MenuFoodTypeServiceImpl implements IMenuFoodTypeService 
{
	@Autowired
	private MenuFoodTypeMapper menuFoodTypeMapper;

	/**
     * 查询餐牌類型信息
     * 
     * @param id 餐牌類型ID
     * @return 餐牌類型信息
     */
    @Override
	public MenuFoodType selectMenuFoodTypeById(Integer id)
	{
	    return menuFoodTypeMapper.selectMenuFoodTypeById(id);
	}
	
	/**
     * 查询餐牌類型列表
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 餐牌類型集合
     */
	@Override
	public List<MenuFoodType> selectMenuFoodTypeList(MenuFoodType menuFoodType)
	{
	    return menuFoodTypeMapper.selectMenuFoodTypeList(menuFoodType);
	}
	
    /**
     * 新增餐牌類型
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 结果
     */
	@Override
	public int insertMenuFoodType(MenuFoodType menuFoodType)
	{
	    return menuFoodTypeMapper.insertMenuFoodType(menuFoodType);
	}
	
	/**
     * 修改餐牌類型
     * 
     * @param menuFoodType 餐牌類型信息
     * @return 结果
     */
	@Override
	public int updateMenuFoodType(MenuFoodType menuFoodType)
	{
	    return menuFoodTypeMapper.updateMenuFoodType(menuFoodType);
	}

	/**
     * 删除餐牌類型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMenuFoodTypeByIds(String ids)
	{
		return menuFoodTypeMapper.deleteMenuFoodTypeByIds(Convert.toStrArray(ids));
	}
	
}
