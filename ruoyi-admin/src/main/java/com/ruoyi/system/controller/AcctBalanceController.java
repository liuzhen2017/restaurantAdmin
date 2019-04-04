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
import com.ruoyi.system.domain.AcctBalance;
import com.ruoyi.system.service.IAcctBalanceService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 賬戶餘額 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/acctBalance")
public class AcctBalanceController extends BaseController
{
    private String prefix = "system/acctBalance";
	
	@Autowired
	private IAcctBalanceService acctBalanceService;
	
	@RequiresPermissions("system:acctBalance:view")
	@GetMapping()
	public String acctBalance()
	{
	    return prefix + "/acctBalance";
	}
	
	/**
	 * 查询賬戶餘額列表
	 */
	@RequiresPermissions("system:acctBalance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AcctBalance acctBalance)
	{
		startPage();
        List<AcctBalance> list = acctBalanceService.selectAcctBalanceList(acctBalance);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出賬戶餘額列表
	 */
	@RequiresPermissions("system:acctBalance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AcctBalance acctBalance)
    {
    	List<AcctBalance> list = acctBalanceService.selectAcctBalanceList(acctBalance);
        ExcelUtil<AcctBalance> util = new ExcelUtil<AcctBalance>(AcctBalance.class);
        return util.exportExcel(list, "acctBalance");
    }
	
	/**
	 * 新增賬戶餘額
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存賬戶餘額
	 */
	@RequiresPermissions("system:acctBalance:add")
	@Log(title = "賬戶餘額", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AcctBalance acctBalance)
	{		
		return toAjax(acctBalanceService.insertAcctBalance(acctBalance));
	}

	/**
	 * 修改賬戶餘額
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AcctBalance acctBalance = acctBalanceService.selectAcctBalanceById(id);
		mmap.put("acctBalance", acctBalance);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存賬戶餘額
	 */
	@RequiresPermissions("system:acctBalance:edit")
	@Log(title = "賬戶餘額", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AcctBalance acctBalance)
	{		
		return toAjax(acctBalanceService.updateAcctBalance(acctBalance));
	}
	
	/**
	 * 删除賬戶餘額
	 */
	@RequiresPermissions("system:acctBalance:remove")
	@Log(title = "賬戶餘額", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(acctBalanceService.deleteAcctBalanceByIds(ids));
	}
	
}
