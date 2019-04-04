package com.ruoyi.system.service;

import com.google.zxing.WriterException;
import com.ruoyi.system.domain.MenuFood;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 餐牌 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface IMenuFoodService 
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
     * 删除餐牌信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuFoodByIds(String ids);

	/**生產二維碼
	 * @param id
	 * @param response
	 * @param request
	 * @throws IOException 
	 * @throws WriterException 
	 */
	public void showQC(Integer id, HttpServletResponse response,
			HttpServletRequest request) throws WriterException, IOException;
	
}
