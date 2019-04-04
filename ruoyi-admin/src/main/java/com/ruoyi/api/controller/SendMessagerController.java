package com.ruoyi.api.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.api.domain.SendMessager;
import com.ruoyi.api.service.ISendMessagerService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;

/**
 * 短信發送記錄 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-25
 */
@Controller
@RequestMapping("/api/sendMessager")
public class SendMessagerController extends BaseController
{
    private String prefix = "api/sendMessager";
	
	@Autowired
	private ISendMessagerService sendMessagerService;
	
	@RequiresPermissions("api:sendMessager:view")
	@GetMapping()
	public String sendMessager()
	{
	    return prefix + "/sendMessager";
	}
	
	/**
	 * 查询短信發送記錄列表
	 */
	@RequiresPermissions("api:sendMessager:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SendMessager sendMessager)
	{
		startPage();
        List<SendMessager> list = sendMessagerService.selectSendMessagerList(sendMessager);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出短信發送記錄列表
	 */
	@RequiresPermissions("api:sendMessager:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SendMessager sendMessager)
    {
    	List<SendMessager> list = sendMessagerService.selectSendMessagerList(sendMessager);
        ExcelUtil<SendMessager> util = new ExcelUtil<SendMessager>(SendMessager.class);
        return util.exportExcel(list, "sendMessager");
    }
	
	/**
	 * 新增保存短信發送記錄
	 */
	@Log(title = "短信發送記錄", businessType = BusinessType.INSERT)
	@PostMapping("/sendSMS")
	@ResponseBody
	public AjaxResult sendSMS(String phone)
	{		
		return sendMessagerService.sendSMS(phone);
	}

	
}
