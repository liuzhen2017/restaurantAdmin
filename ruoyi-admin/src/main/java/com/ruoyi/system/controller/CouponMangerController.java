package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.CouponManger;
import com.ruoyi.system.service.ICouponMangerService;

/**
 * 优惠券管理 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/couponManger")
public class CouponMangerController extends BaseController
{
    private String prefix = "system/couponManger";
	
	@Autowired
	private ICouponMangerService couponMangerService;
	
	@RequiresPermissions("system:couponManger:view")
	@GetMapping()
	public String couponManger()
	{
	    return prefix + "/couponManger";
	}
	
	/**
	 * 查询优惠券管理列表
	 */
	@RequiresPermissions("system:couponManger:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CouponManger couponManger)
	{
		startPage();
        List<CouponManger> list = couponMangerService.selectCouponMangerList(couponManger);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出优惠券管理列表
	 */
	@RequiresPermissions("system:couponManger:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CouponManger couponManger)
    {
    	List<CouponManger> list = couponMangerService.selectCouponMangerList(couponManger);
        ExcelUtil<CouponManger> util = new ExcelUtil<CouponManger>(CouponManger.class);
        return util.exportExcel(list, "couponManger");
    }
	
	/**
	 * 新增优惠券管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存优惠券管理
	 */
	@RequiresPermissions("system:couponManger:add")
	@Log(title = "优惠券管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CouponManger couponManger)
	{	
		couponManger.setCreateBy(ShiroUtils.getSysUser().getLoginName()+"");
		couponManger.setCreateDate(new Date());
		return couponMangerService.insertCouponManger(couponManger);
	}

	/**
	 * 修改优惠券管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		CouponManger couponManger = couponMangerService.selectCouponMangerById(id);
		mmap.put("couponManger", couponManger);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存优惠券管理
	 */
	@RequiresPermissions("system:couponManger:edit")
	@Log(title = "优惠券管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CouponManger couponManger)
	{		
		couponManger.setUpdateBy(ShiroUtils.getSysUser().getLoginName()+"");
		couponManger.setUpdateDate(new Date());
		return couponMangerService.updateCouponManger(couponManger);
	}
	
	/**
	 * 删除优惠券管理
	 */
	@RequiresPermissions("system:couponManger:remove")
	@Log(title = "优惠券管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(couponMangerService.deleteCouponMangerByIds(ids));
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
		couponMangerService.showQC(id,response,request);
	}
	
	/**
	 * 查询优惠券管理列表
	 */
	@RequestMapping("/selectMembers.do")
	public String selectMembers()
	{
        return prefix + "/selectMembers";
	}
	/**
	 * 發放優惠券
	 * @param ids
	 * @param couponCode
	 * @return
	 */
	@RequestMapping( "/grantMembers.do")
	@ResponseBody
	public AjaxResult grantMembers(@RequestParam("ids") String ids,@RequestParam("couponCode") String couponCode){
		return couponMangerService.grantMembers(ids,couponCode);
	}
}
