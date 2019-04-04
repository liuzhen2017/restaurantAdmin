package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.IntegralRoleMapper;
import com.ruoyi.system.domain.IntegralRole;
import com.ruoyi.system.service.IIntegralRoleService;
import com.ruoyi.common.support.Convert;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 积分规则 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class IntegralRoleServiceImpl implements IIntegralRoleService 
{
	@Autowired
	private IntegralRoleMapper integralRoleMapper;

	/**
     * 查询积分规则信息
     * 
     * @param id 积分规则ID
     * @return 积分规则信息
     */
    @Override
	public IntegralRole selectIntegralRoleById(Integer id)
	{
	    return integralRoleMapper.selectIntegralRoleById(id);
	}
	
	/**
     * 查询积分规则列表
     * 
     * @param integralRole 积分规则信息
     * @return 积分规则集合
     */
	@Override
	public List<IntegralRole> selectIntegralRoleList(IntegralRole integralRole)
	{
	    return integralRoleMapper.selectIntegralRoleList(integralRole);
	}
	
    /**
     * 新增积分规则
     * 
     * @param integralRole 积分规则信息
     * @return 结果
     */
	@Override
	public int insertIntegralRole(IntegralRole integralRole)
	{
		integralRole.setCreateBy(ShiroUtils.getSysUser().getLoginName()+"");
		integralRole.setCreateDate(new Date());
	    return integralRoleMapper.insertIntegralRole(integralRole);
	}
	
	/**
     * 修改积分规则
     * 
     * @param integralRole 积分规则信息
     * @return 结果
     */
	@Override
	public int updateIntegralRole(IntegralRole integralRole)
	{
		integralRole.setUpdateBy(ShiroUtils.getSysUser().getLoginName()+"");
		integralRole.setUpdateDate(new Date());
	    return integralRoleMapper.updateIntegralRole(integralRole);
	}

	/**
     * 删除积分规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralRoleByIds(String ids)
	{
		return integralRoleMapper.deleteIntegralRoleByIds(Convert.toStrArray(ids));
	}
	
}
