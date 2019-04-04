package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScoreHisMapper;
import com.ruoyi.system.domain.ScoreHis;
import com.ruoyi.system.service.IScoreHisService;
import com.ruoyi.common.support.Convert;

/**
 * 积分记录 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class ScoreHisServiceImpl implements IScoreHisService 
{
	@Autowired
	private ScoreHisMapper scoreHisMapper;

	/**
     * 查询积分记录信息
     * 
     * @param id 积分记录ID
     * @return 积分记录信息
     */
    @Override
	public ScoreHis selectScoreHisById(Integer id)
	{
	    return scoreHisMapper.selectScoreHisById(id);
	}
	
	/**
     * 查询积分记录列表
     * 
     * @param scoreHis 积分记录信息
     * @return 积分记录集合
     */
	@Override
	public List<ScoreHis> selectScoreHisList(ScoreHis scoreHis)
	{
	    return scoreHisMapper.selectScoreHisList(scoreHis);
	}
	
    /**
     * 新增积分记录
     * 
     * @param scoreHis 积分记录信息
     * @return 结果
     */
	@Override
	public int insertScoreHis(ScoreHis scoreHis)
	{
	    return scoreHisMapper.insertScoreHis(scoreHis);
	}
	
	/**
     * 修改积分记录
     * 
     * @param scoreHis 积分记录信息
     * @return 结果
     */
	@Override
	public int updateScoreHis(ScoreHis scoreHis)
	{
	    return scoreHisMapper.updateScoreHis(scoreHis);
	}

	/**
     * 删除积分记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScoreHisByIds(String ids)
	{
		return scoreHisMapper.deleteScoreHisByIds(Convert.toStrArray(ids));
	}
	
}
