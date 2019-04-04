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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.MenuFoodExchange;
import com.ruoyi.system.service.IMenuFoodExchangeService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 兑换商品 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/menuFoodExchange")
public class MenuFoodExchangeController extends BaseController
{
    private String prefix = "system/menuFoodExchange";
	
	@Autowired
	private IMenuFoodExchangeService menuFoodExchangeService;
	
	@RequiresPermissions("system:menuFoodExchange:view")
	@GetMapping()
	public String menuFoodExchange()
	{
	    return prefix + "/menuFoodExchange";
	}
	
	/**
	 * 查询兑换商品列表
	 */
	@RequiresPermissions("system:menuFoodExchange:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MenuFoodExchange menuFoodExchange)
	{
		startPage();
        List<MenuFoodExchange> list = menuFoodExchangeService.selectMenuFoodExchangeList(menuFoodExchange);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出兑换商品列表
	 */
	@RequiresPermissions("system:menuFoodExchange:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MenuFoodExchange menuFoodExchange)
    {
    	List<MenuFoodExchange> list = menuFoodExchangeService.selectMenuFoodExchangeList(menuFoodExchange);
        ExcelUtil<MenuFoodExchange> util = new ExcelUtil<MenuFoodExchange>(MenuFoodExchange.class);
        return util.exportExcel(list, "menuFoodExchange");
    }
	
	/**
	 * 新增兑换商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存兑换商品
	 */
	@RequiresPermissions("system:menuFoodExchange:add")
	@Log(title = "兑换商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MenuFoodExchange menuFoodExchange)
	{		
		return toAjax(menuFoodExchangeService.insertMenuFoodExchange(menuFoodExchange));
	}

	/**
	 * 修改兑换商品
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MenuFoodExchange menuFoodExchange = menuFoodExchangeService.selectMenuFoodExchangeById(id);
		mmap.put("menuFoodExchange", menuFoodExchange);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存兑换商品
	 */
	@RequiresPermissions("system:menuFoodExchange:edit")
	@Log(title = "兑换商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MenuFoodExchange menuFoodExchange)
	{		
		return toAjax(menuFoodExchangeService.updateMenuFoodExchange(menuFoodExchange));
	}
	
	/**
	 * 删除兑换商品
	 */
	@RequiresPermissions("system:menuFoodExchange:remove")
	@Log(title = "兑换商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(menuFoodExchangeService.deleteMenuFoodExchangeByIds(ids));
	}
	
}
