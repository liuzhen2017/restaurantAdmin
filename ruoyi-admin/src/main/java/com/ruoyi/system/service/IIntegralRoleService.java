package com.ruoyi.system.service;

import com.ruoyi.system.domain.IntegralRole;
import java.util.List;

/**
 * 积分规则 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface IIntegralRoleService 
{
	/**
     * 查询积分规则信息
     * 
     * @param id 积分规则ID
     * @return 积分规则信息
     */
	public IntegralRole selectIntegralRoleById(Integer id);
	
	/**
     * 查询积分规则列表
     * 
     * @param integralRole 积分规则信息
     * @return 积分规则集合
     */
	public List<IntegralRole> selectIntegralRoleList(IntegralRole integralRole);
	
	/**
     * 新增积分规则
     * 
     * @param integralRole 积分规则信息
     * @return 结果
     */
	public int insertIntegralRole(IntegralRole integralRole);
	
	/**
     * 修改积分规则
     * 
     * @param integralRole 积分规则信息
     * @return 结果
     */
	public int updateIntegralRole(IntegralRole integralRole);
		
	/**
     * 删除积分规则信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralRoleByIds(String ids);
	
}
