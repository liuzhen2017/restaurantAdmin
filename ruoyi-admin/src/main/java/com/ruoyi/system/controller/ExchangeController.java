package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.MenuFood;
import com.ruoyi.system.service.IMenuFoodService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 餐牌 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-31
 */
@Controller
@RequestMapping("/system/exchange")
public class ExchangeController extends BaseController
{
    private String prefix = "system/exchange";
	
	@Autowired
	private IMenuFoodService menuFoodService;
	
	@RequiresPermissions("system:system:view")
	@GetMapping()
	public String menuFood()
	{
	    return prefix + "/menuFood";
	}
	
	/**
	 * 查询餐牌列表
	 */
	@RequiresPermissions("system:exchange:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MenuFood menuFood)
	{
		//查詢兌換的列表，菜品有兩種，一種是兌換的，一種是普通的餐牌
		menuFood.setIsExchange("yes");
		startPage();
        List<MenuFood> list = menuFoodService.selectMenuFoodList(menuFood);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出餐牌列表
	 */
	@RequiresPermissions("system:exchange:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MenuFood menuFood)
    {
		//查詢兌換的列表，菜品有兩種，一種是兌換的，一種是普通的餐牌
				menuFood.setIsExchange("yes");
    	List<MenuFood> list = menuFoodService.selectMenuFoodList(menuFood);
        ExcelUtil<MenuFood> util = new ExcelUtil<MenuFood>(MenuFood.class);
        return util.exportExcel(list, "menuFood");
    }
	
	/**
	 * 新增餐牌
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存餐牌
	 */
	@RequiresPermissions("system:exchange:add")
	@Log(title = "餐牌", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MenuFood menuFood)
	{		
		//查詢兌換的列表，菜品有兩種，一種是兌換的，一種是普通的餐牌
		menuFood.setIsExchange("yes");
		return toAjax(menuFoodService.insertMenuFood(menuFood));
	}

	/**
	 * 修改餐牌
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MenuFood menuFood = menuFoodService.selectMenuFoodById(id);
		mmap.put("menuFood", menuFood);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存餐牌
	 */
	@RequiresPermissions("system:exchange:edit")
	@Log(title = "餐牌", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MenuFood menuFood)
	{		
		return toAjax(menuFoodService.updateMenuFood(menuFood));
	}
	
	/**
	 * 删除餐牌
	 */
	@RequiresPermissions("system:exchange:remove")
	@Log(title = "餐牌", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(menuFoodService.deleteMenuFoodByIds(ids));
	}
	/**
	 * 加载二维码
	 * @throws IOException 
	 * @throws WriterException 
	 */
	@RequestMapping( "/showQC.do")
	@ResponseBody
	public void showQC(Integer id,HttpServletResponse response,HttpServletRequest request) throws WriterException, IOException
	{		
		menuFoodService.showQC(id,response,request);
	}
	
}
