package com.ruoyi.system.service;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.system.domain.Members;

import java.util.List;
import java.util.Map;

/**
 * 会员管理 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface IMembersService 
{
	/**
     * 查询会员管理信息
     * 
     * @param id 会员管理ID
     * @return 会员管理信息
     */
	public Members selectMembersById(Integer id);
	
	/**
     * 查询会员管理列表
     * 
     * @param members 会员管理信息
     * @return 会员管理集合
     */
	public List<Members> selectMembersList(Members members);
	
	/**
     * 新增会员管理
     * 
     * @param members 会员管理信息
     * @return 结果
     */
	public int insertMembers(Members members);
	
	/**
     * 修改会员管理
     * 
     * @param members 会员管理信息
     * @return 结果
     */
	public int updateMembers(Members members);
		
	/**
     * 删除会员管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMembersByIds(String ids);
	/**
	 * 登陆
	 * @param email
	 * @param passWord
	 * @return
	 */
	public AjaxResult login(String email, String passWord);
	/**
	 * 注册
	 * @param members
	 * @return
	 */
	public AjaxResult regist(Members members);
	/**
	 * 发送邮件
	 * @param tokenId
	 * @return
	 */
	public AjaxResult sendEmail(String tokenId);
	/**
	 * 重置密码
	 * @param oepnId
	 * @return
	 */
	public AjaxResult restPwd(String oepnId);
	/**
	 * 修改密码
	 * @param passWord
	 * @return
	 */
	public AjaxResult updatePwd(String passWord);

	public List<Members> selectMembersByIds(List<String> listStr);

	public List<Members> selectGrantList(Members members);
	
}
