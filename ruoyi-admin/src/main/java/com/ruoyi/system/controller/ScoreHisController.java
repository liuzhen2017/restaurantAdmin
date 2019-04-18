package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.ScoreHis;
import com.ruoyi.system.po.ReadUtil;
import com.ruoyi.system.service.IScoreHisService;

/**
 * 积分记录 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/scoreHis")
public class ScoreHisController extends BaseController
{
    private String prefix = "system/scoreHis";
	
	@Autowired
	private IScoreHisService scoreHisService;
	
	@RequiresPermissions("system:scoreHis:view")
	@GetMapping()
	public String scoreHis()
	{
	    return prefix + "/scoreHis";
	}
	
	/**
	 * 查询积分记录列表
	 */
	@RequiresPermissions("system:scoreHis:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ScoreHis scoreHis)
	{
		startPage();
        List<ScoreHis> list = scoreHisService.selectScoreHisList(scoreHis);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出积分记录列表
	 *//*
	@RequiresPermissions("system:scoreHis:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoreHis scoreHis)
    {
    	List<ScoreHis> list = scoreHisService.selectScoreHisList(scoreHis);
        ExcelUtil<ScoreHis> util = new ExcelUtil<ScoreHis>(ScoreHis.class);
        return util.exportExcel(list, "scoreHis");
    }*/
	
	/**
	 * 新增积分记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/importView";
	}
	
	/**
	 * 新增保存积分记录
	 */
	@RequiresPermissions("system:scoreHis:add")
	@Log(title = "积分记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ScoreHis scoreHis)
	{		
		return toAjax(scoreHisService.insertScoreHis(scoreHis));
	}

	/**
	 * 修改积分记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		ScoreHis scoreHis = scoreHisService.selectScoreHisById(id);
		mmap.put("scoreHis", scoreHis);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分记录
	 */
	@RequiresPermissions("system:scoreHis:edit")
	@Log(title = "积分记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ScoreHis scoreHis)
	{		
		return toAjax(scoreHisService.updateScoreHis(scoreHis));
	}
	
	/**
	 * 删除积分记录
	 */
	@RequiresPermissions("system:scoreHis:remove")
	@Log(title = "积分记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scoreHisService.deleteScoreHisByIds(ids));
	}
	/**
	 * 導入积分
	 */
	@Log(title = "導入积分记录", businessType = BusinessType.DELETE)
	@PostMapping( "/import")
	@ResponseBody
	public AjaxResult importScord(@RequestParam("file") MultipartFile file)
	{		
		List<ScoreHis> resolveExcel = ReadUtil.resolveExcel(file);
		resolveExcel.forEach(s ->{ try {
			scoreHisService.insertScoreHis(s);	
		} catch (Exception e) {
			e.printStackTrace();
		}});
		return AjaxResult.success("導入積分成功!");
	}
	@GetMapping("/importView")
	public String importView()
	{
	    return prefix + "/importView";
	}
	
}
