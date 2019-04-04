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
import com.ruoyi.system.domain.UserOrder;
import com.ruoyi.system.service.IUserOrderService;

/**
 * 訂單 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-31
 */
@Controller
@RequestMapping("/system/order")
public class UserOrderController extends BaseController
{
    private String prefix = "system/order";
	
	@Autowired
	private IUserOrderService orderService;
	
	@RequiresPermissions("system:order:view")
	@GetMapping()
	public String order()
	{
	    return prefix + "/order";
	}
	
	/**
	 * 查询訂單列表
	 */
	@RequiresPermissions("system:order:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserOrder order)
	{
		startPage();
        List<UserOrder> list = orderService.selectOrderList(order);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出訂單列表
	 */
	@RequiresPermissions("system:order:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserOrder order)
    {
    	List<UserOrder> list = orderService.selectOrderList(order);
        ExcelUtil<UserOrder> util = new ExcelUtil<UserOrder>(UserOrder.class);
        return util.exportExcel(list, "order");
    }
	
	/**
	 * 新增訂單
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存訂單
	 */
	@RequiresPermissions("system:order:add")
	@Log(title = "訂單", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserOrder order)
	{		
		return toAjax(orderService.insertOrder(order));
	}

	/**
	 * 修改訂單
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		UserOrder order = orderService.selectOrderById(id);
		mmap.put("order", order);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存訂單
	 */
	@RequiresPermissions("system:order:edit")
	@Log(title = "訂單", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserOrder order)
	{		
		return toAjax(orderService.updateOrder(order));
	}
	
	/**
	 * 删除訂單
	 */
	@RequiresPermissions("system:order:remove")
	@Log(title = "訂單", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderService.deleteOrderByIds(ids));
	}
	
}
