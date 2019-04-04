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
import com.ruoyi.system.domain.IntegralRole;
import com.ruoyi.system.service.IIntegralRoleService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 积分规则 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/integralRole")
public class IntegralRoleController extends BaseController
{
    private String prefix = "system/integralRole";
	
	@Autowired
	private IIntegralRoleService integralRoleService;
	
	@RequiresPermissions("system:integralRole:view")
	@GetMapping()
	public String integralRole()
	{
	    return prefix + "/integralRole";
	}
	
	/**
	 * 查询积分规则列表
	 */
	@RequiresPermissions("system:integralRole:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralRole integralRole)
	{
		startPage();
        List<IntegralRole> list = integralRoleService.selectIntegralRoleList(integralRole);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出积分规则列表
	 */
	@RequiresPermissions("system:integralRole:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IntegralRole integralRole)
    {
    	List<IntegralRole> list = integralRoleService.selectIntegralRoleList(integralRole);
        ExcelUtil<IntegralRole> util = new ExcelUtil<IntegralRole>(IntegralRole.class);
        return util.exportExcel(list, "integralRole");
    }
	
	/**
	 * 新增积分规则
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分规则
	 */
	@RequiresPermissions("system:integralRole:add")
	@Log(title = "积分规则", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralRole integralRole)
	{		
		return toAjax(integralRoleService.insertIntegralRole(integralRole));
	}

	/**
	 * 修改积分规则
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		IntegralRole integralRole = integralRoleService.selectIntegralRoleById(id);
		mmap.put("integralRole", integralRole);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分规则
	 */
	@RequiresPermissions("system:integralRole:edit")
	@Log(title = "积分规则", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralRole integralRole)
	{		
		return toAjax(integralRoleService.updateIntegralRole(integralRole));
	}
	
	/**
	 * 删除积分规则
	 */
	@RequiresPermissions("system:integralRole:remove")
	@Log(title = "积分规则", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralRoleService.deleteIntegralRoleByIds(ids));
	}
	
}
