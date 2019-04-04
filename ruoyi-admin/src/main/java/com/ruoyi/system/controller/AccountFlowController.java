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
import com.ruoyi.system.domain.AccountFlow;
import com.ruoyi.system.service.IAccountFlowService;

/**
 * 賬戶流水 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/system/accountFlow")
public class AccountFlowController extends BaseController
{
    private String prefix = "system/accountFlow";
	
	@Autowired
	private IAccountFlowService accountFlowService;
	
	@RequiresPermissions("system:accountFlow:view")
	@GetMapping()
	public String accountFlow()
	{
	    return prefix + "/accountFlow";
	}
	
	/**
	 * 查询賬戶流水列表
	 */
	@RequiresPermissions("system:accountFlow:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AccountFlow accountFlow)
	{
		startPage();
        List<AccountFlow> list = accountFlowService.selectAccountFlowList(accountFlow);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出賬戶流水列表
	 */
	@RequiresPermissions("system:accountFlow:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AccountFlow accountFlow)
    {
    	List<AccountFlow> list = accountFlowService.selectAccountFlowList(accountFlow);
        ExcelUtil<AccountFlow> util = new ExcelUtil<AccountFlow>(AccountFlow.class);
        return util.exportExcel(list, "accountFlow");
    }
	
	/**
	 * 新增賬戶流水
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存賬戶流水
	 */
	@RequiresPermissions("system:accountFlow:add")
	@Log(title = "賬戶流水", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AccountFlow accountFlow)
	{		
		return toAjax(accountFlowService.insertAccountFlow(accountFlow));
	}

	/**
	 * 修改賬戶流水
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AccountFlow accountFlow = accountFlowService.selectAccountFlowById(id);
		mmap.put("accountFlow", accountFlow);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存賬戶流水
	 */
	@RequiresPermissions("system:accountFlow:edit")
	@Log(title = "賬戶流水", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AccountFlow accountFlow)
	{		
		return toAjax(accountFlowService.updateAccountFlow(accountFlow));
	}
	
	/**
	 * 删除賬戶流水
	 */
	@RequiresPermissions("system:accountFlow:remove")
	@Log(title = "賬戶流水", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(accountFlowService.deleteAccountFlowByIds(ids));
	}
	
}
