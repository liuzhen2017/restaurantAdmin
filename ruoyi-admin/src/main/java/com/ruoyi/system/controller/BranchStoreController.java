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
import com.ruoyi.system.domain.BranchStore;
import com.ruoyi.system.service.IBranchStoreService;

/**
 * 分店管理 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/branchStore")
public class BranchStoreController extends BaseController
{
    private String prefix = "system/branchStore";
	
	@Autowired
	private IBranchStoreService branchStoreService;
	
	@RequiresPermissions("system:branchStore:view")
	@GetMapping()
	public String branchStore()
	{
	    return prefix + "/branchStore";
	}
	
	/**
	 * 查询分店管理列表
	 */
	@RequiresPermissions("system:branchStore:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BranchStore branchStore)
	{
		startPage();
        List<BranchStore> list = branchStoreService.selectBranchStoreList(branchStore);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出分店管理列表
	 */
	@RequiresPermissions("system:branchStore:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BranchStore branchStore)
    {
    	List<BranchStore> list = branchStoreService.selectBranchStoreList(branchStore);
        ExcelUtil<BranchStore> util = new ExcelUtil<BranchStore>(BranchStore.class);
        return util.exportExcel(list, "branchStore");
    }
	
	/**
	 * 新增分店管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	/**
	 * 新增分店管理
	 */
	@GetMapping("/SelectStoreRegion")
	public String SelectStoreRegion()
	{
	    return prefix + "/SelectStoreRegion";
	}
	/**
	 * 新增保存分店管理
	 */
	@RequiresPermissions("system:branchStore:add")
	@Log(title = "分店管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BranchStore branchStore)
	{		
		return toAjax(branchStoreService.insertBranchStore(branchStore));
	}

	/**
	 * 修改分店管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		BranchStore branchStore = branchStoreService.selectBranchStoreById(id);
		mmap.put("branchStore", branchStore);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存分店管理
	 */
	@RequiresPermissions("system:branchStore:edit")
	@Log(title = "分店管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BranchStore branchStore)
	{		
		return toAjax(branchStoreService.updateBranchStore(branchStore));
	}
	
	/**
	 * 删除分店管理
	 */
	@RequiresPermissions("system:branchStore:remove")
	@Log(title = "分店管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(branchStoreService.deleteBranchStoreByIds(ids));
	}
	
	
	@RequiresPermissions("system:branchStore:showListView")
	@GetMapping("/showListView")
	public String showListView()
	{
	    return  "/system/menuFood/showListView";
	}
	
	/**
	 * 查询分店管理列表
	 */
	@RequiresPermissions("system:branchStore:showList")
	@PostMapping("/showList")
	@ResponseBody
	public TableDataInfo showList(BranchStore branchStore)
	{
		startPage();
        List<BranchStore> list = branchStoreService.selectBranchStoreList(branchStore);
		return getDataTable(list);
	}
	
}
