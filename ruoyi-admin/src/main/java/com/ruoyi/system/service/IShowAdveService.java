package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.ShowAdve;

/**
 * 首頁廣告 服务层
 * 
 * @author liuzhen
 * @date 2019-04-02
 */
public interface IShowAdveService 
{
	/**
     * 查询首頁廣告信息
     * 
     * @param id 首頁廣告ID
     * @return 首頁廣告信息
     */
	public ShowAdve selectShowAdveById(Integer id);
	
	/**
     * 查询首頁廣告列表
     * 
     * @param showAdve 首頁廣告信息
     * @return 首頁廣告集合
     */
	public List<ShowAdve> selectShowAdveList(ShowAdve showAdve);
	
	/**
     * 新增首頁廣告
     * 
     * @param showAdve 首頁廣告信息
     * @return 结果
     */
	public int insertShowAdve(ShowAdve showAdve);
	
	/**
     * 修改首頁廣告
     * 
     * @param showAdve 首頁廣告信息
     * @return 结果
     */
	public int updateShowAdve(ShowAdve showAdve);
		
	/**
     * 删除首頁廣告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShowAdveByIds(String ids);
	
}
