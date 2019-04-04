package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Members;

import java.util.List;
import java.util.Map;	

/**
 * 会员管理 数据层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface MembersMapper 
{
	/**
     * 查询会员管理信息
     * 
     * @param id 会员管理ID
     * @return 会员管理信息
     */
	public Members selectMembersById(Integer id);
	/**
     * 查询会员管理信息
     * 
     * @param id 会员管理ID
     * @return 会员管理信息
     */
	public Members selectMembersByEmail(String email);
	
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
     * 删除会员管理
     * 
     * @param id 会员管理ID
     * @return 结果
     */
	public int deleteMembersById(Integer id);
	
	/**
     * 批量删除会员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMembersByIds(String[] ids);
	public List<Members> selectMembersByIds(List<String> listStr);
	public List<Members> selectGrantList(Members members);
	public Members selectMembersByKey(Map<String, Object> map);
}