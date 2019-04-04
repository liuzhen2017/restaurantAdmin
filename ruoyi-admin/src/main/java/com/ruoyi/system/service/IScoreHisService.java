package com.ruoyi.system.service;

import com.ruoyi.system.domain.ScoreHis;
import java.util.List;

/**
 * 积分记录 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface IScoreHisService 
{
	/**
     * 查询积分记录信息
     * 
     * @param id 积分记录ID
     * @return 积分记录信息
     */
	public ScoreHis selectScoreHisById(Integer id);
	
	/**
     * 查询积分记录列表
     * 
     * @param scoreHis 积分记录信息
     * @return 积分记录集合
     */
	public List<ScoreHis> selectScoreHisList(ScoreHis scoreHis);
	
	/**
     * 新增积分记录
     * 
     * @param scoreHis 积分记录信息
     * @return 结果
     */
	public int insertScoreHis(ScoreHis scoreHis);
	
	/**
     * 修改积分记录
     * 
     * @param scoreHis 积分记录信息
     * @return 结果
     */
	public int updateScoreHis(ScoreHis scoreHis);
		
	/**
     * 删除积分记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScoreHisByIds(String ids);
	
}
