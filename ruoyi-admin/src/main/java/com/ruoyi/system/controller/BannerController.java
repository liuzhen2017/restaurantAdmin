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
import com.ruoyi.system.domain.Banner;
import com.ruoyi.system.service.IBannerService;

/**
 * 首頁banner 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/system/banner")
public class BannerController extends BaseController
{
    private String prefix = "system/banner";
	
	@Autowired
	private IBannerService bannerService;
	
	@RequiresPermissions("api:banner:view")
	@GetMapping()
	public String banner()
	{
	    return prefix + "/banner";
	}
	
	/**
	 * 查询首頁banner列表
	 */
	@RequiresPermissions("api:banner:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Banner banner)
	{
		startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出首頁banner列表
	 */
	@RequiresPermissions("api:banner:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Banner banner)
    {
    	List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        return util.exportExcel(list, "banner");
    }
	
	/**
	 * 新增首頁banner
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存首頁banner
	 */
	@RequiresPermissions("api:banner:add")
	@Log(title = "首頁banner", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Banner banner)
	{		
		return toAjax(bannerService.insertBanner(banner));
	}

	/**
	 * 修改首頁banner
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Banner banner = bannerService.selectBannerById(id);
		mmap.put("banner", banner);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存首頁banner
	 */
	@RequiresPermissions("api:banner:edit")
	@Log(title = "首頁banner", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Banner banner)
	{		
		return toAjax(bannerService.updateBanner(banner));
	}
	
	/**
	 * 删除首頁banner
	 */
	@RequiresPermissions("api:banner:remove")
	@Log(title = "首頁banner", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(bannerService.deleteBannerByIds(ids));
	}
	
}
