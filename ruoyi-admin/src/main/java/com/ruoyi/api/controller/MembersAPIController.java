package com.ruoyi.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.ruoyi.system.domain.Members;
import com.ruoyi.system.service.IMembersService;

/**
 * 会员管理 信息操作处理
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/api/bigape")
public class MembersAPIController extends BaseController
{
    private String prefix = "system/members";
	
	@Autowired
	private IMembersService membersService;
	
	/**
	 * 首页
	 * @return
	 */
	@GetMapping()
	public String members()
	{
	    return prefix + "/index";
	}
	/**
	 * 登陆
	 * @return
	 */
	@GetMapping("loginPage")
	public String membersLogin() {
		 return prefix + "/loginPage";
	}
	/**
	 * 登陆
	 * @param email
	 * @param passWord
	 * @return
	 */
	@PostMapping("login")
	public AjaxResult membersLogin(String email,String passWord,HttpServletRequest request) {
		try {
			//获取I派
//			String ip =NetworkUtil.getIpAddress(request);
		    return	membersService.login(email,passWord);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取IP错误!");
		}
	}
	/**
	 * 登陆
	 * @return
	 */
	@GetMapping("registPage")
	public String memberRegist() {
		 return prefix + "/registPage";
	}
	/**
	 * 登陆
	 * @param email
	 * @param passWord
	 * @return
	 */
	@PostMapping("regist")
	public AjaxResult memberRegist(Members members) {
		try {
		    return	membersService.regist(members);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("系统错误!"+e.getMessage());
		}
	}
	/**
	 * 忘记密码页面
	 * @return
	 */
	@GetMapping("forgetPwdPage")
	public String forgetPwdPage() {
		 return prefix + "/forgetPwdPage";
	}
	/**
	 * 发送邮件
	 * <li>查找该会员邮箱</li>
	 * <li>封装openId</li>
	 * <li>发送邮件,携带连接</li>
	 * <li>解析openID,获取该会员ID</li>
	 * <li>重置密码</li>
	 * @param email
	 * @param passWord
	 * @param request
	 * @return
	 */
	@PostMapping("sendEmail")
	public AjaxResult sendEmail(String tokenId) {
		try {
		    return	membersService.sendEmail(tokenId);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("系统错误!"+e.getMessage());
		}
	}
	/**
	 * 发送邮件
	 * <li>解析openID,获取该会员ID</li>
	 * <li>判断openID失效没,如果失效了</li>
	 * <li>重置密码</li>
	 * @param email
	 * @param passWord
	 * @param request
	 * @return
	 */
	@GetMapping("restPwd")
	public AjaxResult restPwd(String oepnId) {
		try {
		    return	membersService.restPwd(oepnId);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("系统错误!"+e.getMessage());
		}
	}
	/**
	 * 修改密码
	 * @param passWord
	 * @param request
	 * @return
	 */
	@GetMapping("updatePwdPage")
	public String updatePwdPage(String passWord) {
		 return prefix + "/updatePwdPage";
	}
	
	/**
	 * 修改密码
	 * @param passWord
	 * @param request
	 * @return
	 */
	@PostMapping("updatePwd")
	public AjaxResult updatePwd(String passWord) {
		try {
			
		    return	membersService.updatePwd(passWord);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("修改密码错误!"+e.getMessage());
		}
	}
	
	
	/**
	 * 修改会员信息
	 * @param request
	 * @return
	 */
	@GetMapping("updateMembersPage")
	public String updateMembersPage() {
		 return prefix + "/updateMembersPage";
	}
	
	/**
	 * 修改密码
	 * @param passWord
	 * @param request
	 * @return
	 */
	@PostMapping("updateMembers")
	public AjaxResult updateMembers(Members members) {
		try {
			
		    return	toAjax(membersService.updateMembers(members));
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("系统错误!"+e.getMessage());
		}
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
	 * 导出会员管理列表
	 */
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
	@Log(title = "会员管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(membersService.deleteMembersByIds(ids));
	}
	
}
