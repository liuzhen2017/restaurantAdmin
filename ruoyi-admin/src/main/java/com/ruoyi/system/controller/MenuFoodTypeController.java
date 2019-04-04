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
import com.ruoyi.system.domain.MenuFoodType;
import com.ruoyi.system.service.IMenuFoodTypeService;

/**
 * 餐牌類型 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/system/menuFoodType")
public class MenuFoodTypeController extends BaseController
{
    private String prefix = "system/menuFoodType";
	
	@Autowired
	private IMenuFoodTypeService menuFoodTypeService;
	
	@RequiresPermissions("api:menuFoodType:view")
	@GetMapping()
	public String menuFoodType()
	{
	    return prefix + "/menuFoodType";
	}
	
	/**
	 * 查询餐牌類型列表
	 */
	@RequiresPermissions("api:menuFoodType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MenuFoodType menuFoodType)
	{
		startPage();
        List<MenuFoodType> list = menuFoodTypeService.selectMenuFoodTypeList(menuFoodType);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出餐牌類型列表
	 */
	@RequiresPermissions("api:menuFoodType:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MenuFoodType menuFoodType)
    {
    	List<MenuFoodType> list = menuFoodTypeService.selectMenuFoodTypeList(menuFoodType);
        ExcelUtil<MenuFoodType> util = new ExcelUtil<MenuFoodType>(MenuFoodType.class);
        return util.exportExcel(list, "menuFoodType");
    }
	
	/**
	 * 新增餐牌類型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存餐牌類型
	 */
	@RequiresPermissions("api:menuFoodType:add")
	@Log(title = "餐牌類型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MenuFoodType menuFoodType)
	{		
		return toAjax(menuFoodTypeService.insertMenuFoodType(menuFoodType));
	}

	/**
	 * 修改餐牌類型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MenuFoodType menuFoodType = menuFoodTypeService.selectMenuFoodTypeById(id);
		mmap.put("menuFoodType", menuFoodType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存餐牌類型
	 */
	@RequiresPermissions("api:menuFoodType:edit")
	@Log(title = "餐牌類型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MenuFoodType menuFoodType)
	{		
		return toAjax(menuFoodTypeService.updateMenuFoodType(menuFoodType));
	}
	
	/**
	 * 删除餐牌類型
	 */
	@RequiresPermissions("api:menuFoodType:remove")
	@Log(title = "餐牌類型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(menuFoodTypeService.deleteMenuFoodTypeByIds(ids));
	}
	
}
