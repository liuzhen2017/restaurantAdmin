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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.ShowAdve;
import com.ruoyi.system.service.IShowAdveService;

/**
 * 首頁廣告 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/system/showAdve")
public class ShowAdveController extends BaseController
{
    private String prefix = "system/showAdve";
	
	@Autowired
	private IShowAdveService showAdveService;
	
	@RequiresPermissions("system:showAdve:view")
	@GetMapping()
	public String showAdve()
	{
	    return prefix + "/showAdve";
	}
	
	/**
	 * 查询首頁廣告列表
	 */
	@RequiresPermissions("system:showAdve:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShowAdve showAdve)
	{
		startPage();
        List<ShowAdve> list = showAdveService.selectShowAdveList(showAdve);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出首頁廣告列表
	 */
	@RequiresPermissions("system:showAdve:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShowAdve showAdve)
    {
    	List<ShowAdve> list = showAdveService.selectShowAdveList(showAdve);
        ExcelUtil<ShowAdve> util = new ExcelUtil<ShowAdve>(ShowAdve.class);
        return util.exportExcel(list, "showAdve");
    }
	
	/**
	 * 新增首頁廣告
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存首頁廣告
	 */
	@RequiresPermissions("system:showAdve:add")
	@Log(title = "首頁廣告", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShowAdve showAdve)
	{		
		return toAjax(showAdveService.insertShowAdve(showAdve));
	}

	/**
	 * 修改首頁廣告
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		ShowAdve showAdve = showAdveService.selectShowAdveById(id);
		mmap.put("showAdve", showAdve);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存首頁廣告
	 */
	@RequiresPermissions("system:showAdve:edit")
	@Log(title = "首頁廣告", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShowAdve showAdve)
	{		
		return toAjax(showAdveService.updateShowAdve(showAdve));
	}
	
	/**
	 * 删除首頁廣告
	 */
	@RequiresPermissions("system:showAdve:remove")
	@Log(title = "首頁廣告", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(showAdveService.deleteShowAdveByIds(ids));
	}
	
}
