package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ruoyi.system.domain.NoticeInfo;

/**
 * 通知 数据层
 * 
 * @author liuzhen
 * @date 2019-02-15
 */
@Mapper
public interface NoticeInfoMapper 
{
	/**
     * 查询通知信息
     * 
     * @param id 通知ID
     * @return 通知信息
     */
	public NoticeInfo selectNoticeInfoById(Integer id);
	
	/**
     * 查询通知列表
     * 
     * @param noticeInfo 通知信息
     * @return 通知集合
     */
	public List<NoticeInfo> selectNoticeInfoList(NoticeInfo noticeInfo);
	
	/**
     * 新增通知
     * 
     * @param noticeInfo 通知信息
     * @return 结果
     */
	public int insertNoticeInfo(NoticeInfo noticeInfo);
	
	/**
     * 修改通知
     * 
     * @param noticeInfo 通知信息
     * @return 结果
     */
	public int updateNoticeInfo(NoticeInfo noticeInfo);
	
	/**
     * 删除通知
     * 
     * @param id 通知ID
     * @return 结果
     */
	public int deleteNoticeInfoById(Integer id);
	
	/**
     * 批量删除通知
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteNoticeInfoByIds(String[] ids);
	
}