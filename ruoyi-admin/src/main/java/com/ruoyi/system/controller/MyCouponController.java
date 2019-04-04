package com.ruoyi.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.MyCoupon;
import com.ruoyi.system.service.IMyCouponService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 我的优惠券 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/myCoupon")
public class MyCouponController extends BaseController
{
    private String prefix = "system/myCoupon";
	
	@Autowired
	private IMyCouponService myCouponService;
	
	@RequiresPermissions("system:myCoupon:view")
	@GetMapping("/{couponId}")
	public String myCoupon(@PathVariable("couponId") Integer couponId, ModelMap mmap)
	{
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("couponId", couponId);
		mmap.put("mycoupon", map);
	    return prefix + "/myCoupon";
	}
	
	/**
	 * 查询我的优惠券列表
	 */
	@RequiresPermissions("system:myCoupon:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MyCoupon myCoupon)
	{
		if(myCoupon.getCouponId() ==null){
			return new TableDataInfo();
		}
		startPage();
        List<MyCoupon> list = myCouponService.selectMyCouponList(myCoupon);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出我的优惠券列表
	 */
	@RequiresPermissions("system:myCoupon:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyCoupon myCoupon)
    {
    	List<MyCoupon> list = myCouponService.selectMyCouponList(myCoupon);
        ExcelUtil<MyCoupon> util = new ExcelUtil<MyCoupon>(MyCoupon.class);
        return util.exportExcel(list, "myCoupon");
    }
	
	/**
	 * 新增我的优惠券
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存我的优惠券
	 */
	@RequiresPermissions("system:myCoupon:add")
	@Log(title = "我的优惠券", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MyCoupon myCoupon)
	{		
		return toAjax(myCouponService.insertMyCoupon(myCoupon));
	}

	/**
	 * 修改我的优惠券
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MyCoupon myCoupon = myCouponService.selectMyCouponById(id);
		mmap.put("myCoupon", myCoupon);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存我的优惠券
	 */
	@RequiresPermissions("system:myCoupon:edit")
	@Log(title = "我的优惠券", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MyCoupon myCoupon)
	{		
		return toAjax(myCouponService.updateMyCoupon(myCoupon));
	}
	@Log(title = "設置优惠券狀態", businessType = BusinessType.UPDATE)
	@PostMapping("/settingVaild")
	@ResponseBody
	public AjaxResult settingVaild(@RequestParam("id") int id)
	{		
		
		return toAjax(myCouponService.settingVaild(id));
	}
	
	/**
	 * 删除我的优惠券
	 */
	@RequiresPermissions("system:myCoupon:remove")
	@Log(title = "我的优惠券", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(myCouponService.deleteMyCouponByIds(ids));
	}
	
}
