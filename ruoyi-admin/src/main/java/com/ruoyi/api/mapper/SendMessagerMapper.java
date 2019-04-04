package com.ruoyi.api.mapper;

import com.ruoyi.api.domain.SendMessager;
import java.util.List;	

/**
 * 短信發送記錄 数据层
 * 
 * @author liuzhen
 * @date 2019-01-25
 */
public interface SendMessagerMapper 
{
	/**
     * 查询短信發送記錄信息
     * 
     * @param id 短信發送記錄ID
     * @return 短信發送記錄信息
     */
	public SendMessager selectSendMessagerById(Integer id);
	
	/**
     * 查询短信發送記錄列表
     * 
     * @param sendMessager 短信發送記錄信息
     * @return 短信發送記錄集合
     */
	public List<SendMessager> selectSendMessagerList(SendMessager sendMessager);
	
	/**
     * 新增短信發送記錄
     * 
     * @param sendMessager 短信發送記錄信息
     * @return 结果
     */
	public int insertSendMessager(SendMessager sendMessager);
	
	/**
     * 修改短信發送記錄
     * 
     * @param sendMessager 短信發送記錄信息
     * @return 结果
     */
	public int updateSendMessager(SendMessager sendMessager);
	
	/**
     * 删除短信發送記錄
     * 
     * @param id 短信發送記錄ID
     * @return 结果
     */
	public int deleteSendMessagerById(Integer id);
	
	/**
     * 批量删除短信發送記錄
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSendMessagerByIds(String[] ids);
	
}