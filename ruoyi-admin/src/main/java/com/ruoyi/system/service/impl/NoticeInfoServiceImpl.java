package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.NoticeInfo;
import com.ruoyi.system.mapper.NoticeInfoMapper;
import com.ruoyi.system.service.INoticeInfoService;

/**
 * 通知 服务层实现
 * 
 * @author liuzhen
 * @date 2019-02-15
 */
@Service
public class NoticeInfoServiceImpl implements INoticeInfoService 
{
	@Autowired
	private NoticeInfoMapper noticeInfoMapper;

	/**
     * 查询通知信息
     * 
     * @param id 通知ID
     * @return 通知信息
     */
    @Override
	public NoticeInfo selectNoticeInfoById(Integer id)
	{
	    return noticeInfoMapper.selectNoticeInfoById(id);
	}
	
	/**
     * 查询通知列表
     * 
     * @param noticeInfo 通知信息
     * @return 通知集合
     */
	@Override
	public List<NoticeInfo> selectNoticeInfoList(NoticeInfo noticeInfo)
	{
	    return noticeInfoMapper.selectNoticeInfoList(noticeInfo);
	}
	
    /**
     * 新增通知
     * 
     * @param noticeInfo 通知信息
     * @return 结果
     */
	@Override
	public int insertNoticeInfo(NoticeInfo noticeInfo)
	{
	    return noticeInfoMapper.insertNoticeInfo(noticeInfo);
	}
	
	/**
     * 修改通知
     * 
     * @param noticeInfo 通知信息
     * @return 结果
     */
	@Override
	public int updateNoticeInfo(NoticeInfo noticeInfo)
	{
	    return noticeInfoMapper.updateNoticeInfo(noticeInfo);
	}

	/**
     * 删除通知对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteNoticeInfoByIds(String ids)
	{
		return noticeInfoMapper.deleteNoticeInfoByIds(Convert.toStrArray(ids));
	}
	
}
