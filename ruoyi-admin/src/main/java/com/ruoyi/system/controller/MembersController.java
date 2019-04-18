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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.Members;
import com.ruoyi.system.service.IMembersService;

/**
 * 会员管理 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/members")
public class MembersController extends BaseController
{
    private String prefix = "system/members";
	
	@Autowired
	private IMembersService membersService;
	
	@RequiresPermissions("system:members:view")
	@GetMapping()
	public String members()
	{
	    return prefix + "/members";
	}
	
	/**
	 * 查询会员管理列表
	 */
	@RequiresPermissions("system:members:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Members members)
	{
		startPage();
        List<Members> list = membersService.selectMembersList(members);
		return getDataTable(list);
	}
	/**
	 * 查询会员管理列表
	 */
	@PostMapping("/selectGrantList")
	@ResponseBody
	public TableDataInfo selectGrantList(Members members)
	{
		startPage();
		members.setIsVaild("yes");
		//如果是通用的
		if("2".equals(members.getMembersType())){
			members.setMembersType(null);
		}
        List<Members> list = membersService.selectGrantList(members);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会员管理列表
	 */
	@RequiresPermissions("system:members:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Members members)
    {
    	List<Members> list = membersService.selectMembersList(members);
        ExcelUtil<Members> util = new ExcelUtil<Members>(Members.class);
        return util.exportExcel(list, "members");
    }
	
	/**
	 * 新增会员管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会员管理
	 */
	@RequiresPermissions("system:members:add")
	@Log(title = "会员管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Members members)
	{		
		return toAjax(membersService.insertMembers(members));
	}

	/**
	 * 修改会员管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Members members = membersService.selectMembersById(id);
		mmap.put("members", members);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会员管理
	 */
	@RequiresPermissions("system:members:edit")
	@Log(title = "会员管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Members members)
	{		
		return toAjax(membersService.updateMembers(members));
	}
	
	/**
	 * 删除会员管理
	 */
	@RequiresPermissions("system:members:remove")
	@Log(title = "会员管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(membersService.deleteMembersByIds(ids));
	}
	/**
	 * 导入用户积分
	 * @param file
	 * @param membersId
	 * @param membersName
	 * @return
	 */
	public AjaxResult importScoket(@RequestParam("file") MultipartFile file,@RequestParam("membersId") String membersId,@RequestParam("membersName")String membersName){
		
		return null;
		
	}
	
}
