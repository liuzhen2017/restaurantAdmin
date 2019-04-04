package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.ShowAdve;
import com.ruoyi.system.mapper.ShowAdveMapper;
import com.ruoyi.system.service.IShowAdveService;

/**
 * 首頁廣告 服务层实现
 * 
 * @author liuzhen
 * @date 2019-04-02
 */
@Service
public class ShowAdveServiceImpl implements IShowAdveService 
{
	@Autowired
	private ShowAdveMapper showAdveMapper;

	/**
     * 查询首頁廣告信息
     * 
     * @param id 首頁廣告ID
     * @return 首頁廣告信息
     */
    @Override
	public ShowAdve selectShowAdveById(Integer id)
	{
	    return showAdveMapper.selectShowAdveById(id);
	}
	
	/**
     * 查询首頁廣告列表
     * 
     * @param showAdve 首頁廣告信息
     * @return 首頁廣告集合
     */
	@Override
	public List<ShowAdve> selectShowAdveList(ShowAdve showAdve)
	{
	    return showAdveMapper.selectShowAdveList(showAdve);
	}
	
    /**
     * 新增首頁廣告
     * 
     * @param showAdve 首頁廣告信息
     * @return 结果
     */
	@Override
	public int insertShowAdve(ShowAdve showAdve)
	{
	    return showAdveMapper.insertShowAdve(showAdve);
	}
	
	/**
     * 修改首頁廣告
     * 
     * @param showAdve 首頁廣告信息
     * @return 结果
     */
	@Override
	public int updateShowAdve(ShowAdve showAdve)
	{
	    return showAdveMapper.updateShowAdve(showAdve);
	}

	/**
     * 删除首頁廣告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShowAdveByIds(String ids)
	{
		return showAdveMapper.deleteShowAdveByIds(Convert.toStrArray(ids));
	}
	
}
