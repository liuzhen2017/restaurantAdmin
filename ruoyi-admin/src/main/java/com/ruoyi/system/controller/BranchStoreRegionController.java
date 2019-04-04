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
import com.ruoyi.system.domain.BranchStoreRegion;
import com.ruoyi.system.service.IBranchStoreRegionService;

/**
 * 區域類型 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-02-24
 */
@Controller
@RequestMapping("/system/branchStoreRegion")
public class BranchStoreRegionController extends BaseController
{
    private String prefix = "system/branchStoreRegion";
	
	@Autowired
	private IBranchStoreRegionService branchStoreRegionService;
	
	@RequiresPermissions("system:branchStoreRegion:view")
	@GetMapping()
	public String branchStoreRegion()
	{
	    return prefix + "/branchStoreRegion";
	}
	
	/**
	 * 查询區域類型列表
	 */
	@RequiresPermissions("system:branchStoreRegion:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BranchStoreRegion branchStoreRegion)
	{
		startPage();
        List<BranchStoreRegion> list = branchStoreRegionService.selectBranchStoreRegionList(branchStoreRegion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出區域類型列表
	 */
	@RequiresPermissions("system:branchStoreRegion:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BranchStoreRegion branchStoreRegion)
    {
    	List<BranchStoreRegion> list = branchStoreRegionService.selectBranchStoreRegionList(branchStoreRegion);
        ExcelUtil<BranchStoreRegion> util = new ExcelUtil<BranchStoreRegion>(BranchStoreRegion.class);
        return util.exportExcel(list, "branchStoreRegion");
    }
	
	/**
	 * 新增區域類型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存區域類型
	 */
	@RequiresPermissions("system:branchStoreRegion:add")
	@Log(title = "區域類型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BranchStoreRegion branchStoreRegion)
	{		
		return toAjax(branchStoreRegionService.insertBranchStoreRegion(branchStoreRegion));
	}

	/**
	 * 修改區域類型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		BranchStoreRegion branchStoreRegion = branchStoreRegionService.selectBranchStoreRegionById(id);
		mmap.put("branchStoreRegion", branchStoreRegion);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存區域類型
	 */
	@RequiresPermissions("system:branchStoreRegion:edit")
	@Log(title = "區域類型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BranchStoreRegion branchStoreRegion)
	{		
		return toAjax(branchStoreRegionService.updateBranchStoreRegion(branchStoreRegion));
	}
	
	/**
	 * 删除區域類型
	 */
	@RequiresPermissions("system:branchStoreRegion:remove")
	@Log(title = "區域類型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(branchStoreRegionService.deleteBranchStoreRegionByIds(ids));
	}
	
}
