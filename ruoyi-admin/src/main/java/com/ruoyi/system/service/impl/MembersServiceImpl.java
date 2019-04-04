package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.MembersMapper;
import com.ruoyi.system.domain.Members;
import com.ruoyi.system.service.IMembersService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.support.Convert;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 会员管理 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class MembersServiceImpl implements IMembersService 
{
	@Autowired
	private MembersMapper membersMapper;
	 @Autowired
	    private SysPasswordService passwordService;
	/**
     * 查询会员管理信息
     * 
     * @param id 会员管理ID
     * @return 会员管理信息
     */
    @Override
	public Members selectMembersById(Integer id)
	{
	    return membersMapper.selectMembersById(id);
	}
	
	/**
     * 查询会员管理列表
     * 
     * @param members 会员管理信息
     * @return 会员管理集合
     */
	@Override
	public List<Members> selectMembersList(Members members)
	{
	    return membersMapper.selectMembersList(members);
	}
	
    /**
     * 新增会员管理
     * 
     * @param members 会员管理信息
     * @return 结果
     */
	@Override
	public int insertMembers(Members members)
	{
		members.setCreateBy(ShiroUtils.getLoginName()+"");
		members.setCreateDate(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH-mm-ss"));
	    return membersMapper.insertMembers(members);
	}
	
	/**
     * 修改会员管理
     * 
     * @param members 会员管理信息
     * @return 结果
     */
	@Override
	public int updateMembers(Members members)
	{
	    return membersMapper.updateMembers(members);
	}

	/**
     * 删除会员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMembersByIds(String ids)
	{
		return membersMapper.deleteMembersByIds(Convert.toStrArray(ids));
	}

	@Override
	public AjaxResult login(String email, String passWord) {
		Members dbMem = membersMapper.selectMembersByEmail(email);

		
		if(dbMem !=null ) {
			if(dbMem.getIsVaild().equals("no")) {
				return AjaxResult.error("该該賬號狀態異常!");
			}else if(StringUtils.isEmpty(passWord) || !passwordService.encryptPassword(dbMem.getName(), passWord, dbMem.getSalt()).equals(dbMem.getPwd())){
				return AjaxResult.error("密碼錯誤!");
			}
			return AjaxResult.success("登陸成功!");
		}
		return AjaxResult.error("該賬號不存在!");
	}

	@Override
	public AjaxResult regist(Members members) {
		Members dbMembers = membersMapper.selectMembersByEmail(members.getEmail());
		
		if(dbMembers ==null ) {
			members.setSalt(ShiroUtils.randomSalt());
			members.setPwd(passwordService.encryptPassword(members.getName(), members.getPwd(), members.getSalt()));
			members.setCreateBy("admin");
			members.setCreateDate(DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
			membersMapper.insertMembers(members);
			return AjaxResult.success("註冊成功,請登陸");
		}
		return AjaxResult.error("註冊失敗!該email已經存在!");
	}

	@Override
	public AjaxResult sendEmail(String tokenId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult restPwd(String oepnId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResult updatePwd(String passWord) {
		Members dbMem = membersMapper.selectMembersByEmail(passWord);
		if(dbMem !=null) {
			
		}
		return null;
	}

	@Override
	public List<Members> selectMembersByIds(List<String> listStr) {
		
		return membersMapper.selectMembersByIds(listStr);
	}

	@Override
	public List<Members> selectGrantList(Members members) {
		return membersMapper.selectGrantList(members);
	}
	
}
