package com.ruoyi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.NoticeInfo;
import com.ruoyi.system.service.INoticeInfoService;

/**
 * 通知 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-02-15
 */
@Controller
@RequestMapping("/api/noticeInfo")
public class NoticeInfoController extends BaseController
{
	
	@Autowired
	private INoticeInfoService noticeInfoService;
	
	
	/**
	 * 查询通知列表
	 */
	@PostMapping("/list.do")
	@ResponseBody
	public TableDataInfo list(NoticeInfo noticeInfo)
	{
		startPage();
//		noticeInfo.setMemId(getUserInfo().getId());
        List<NoticeInfo> list = noticeInfoService.selectNoticeInfoList(noticeInfo);
		return getDataTable(list);
	}
	
	


	
	/**
	 * 新增保存通知
	 */
	@PostMapping("/add.do")
	@ResponseBody
	public AjaxResult addSave(NoticeInfo noticeInfo)
	{		
		return toAjax(noticeInfoService.insertNoticeInfo(noticeInfo));
	}

	
	/**
	 * 修改保存通知
	 */
	@PostMapping("/edit.do")
	@ResponseBody
	public AjaxResult editSave(NoticeInfo noticeInfo)
	{		
		return toAjax(noticeInfoService.updateNoticeInfo(noticeInfo));
	}
	
	/**
	 * 删除通知
	 */
	@PostMapping( "/remove.do")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(noticeInfoService.deleteNoticeInfoByIds(ids));
	}
	
}
