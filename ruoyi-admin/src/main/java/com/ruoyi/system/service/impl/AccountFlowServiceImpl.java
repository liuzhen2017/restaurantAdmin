package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.AccountFlow;
import com.ruoyi.system.mapper.AccountFlowMapper;
import com.ruoyi.system.service.IAccountFlowService;

/**
 * 賬戶流水 服务层实现
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Service
public class AccountFlowServiceImpl implements IAccountFlowService 
{
	@Autowired
	private AccountFlowMapper accountFlowMapper;
	

	/**
     * 查询賬戶流水信息
     * 
     * @param id 賬戶流水ID
     * @return 賬戶流水信息
     */
    @Override
	public AccountFlow selectAccountFlowById(Integer id)
	{
	    return accountFlowMapper.selectAccountFlowById(id);
	}
	
	/**
     * 查询賬戶流水列表
     * 
     * @param accountFlow 賬戶流水信息
     * @return 賬戶流水集合
     */
	@Override
	public List<AccountFlow> selectAccountFlowList(AccountFlow accountFlow)
	{
	    return accountFlowMapper.selectAccountFlowList(accountFlow);
	}
	
    /**
     * 新增賬戶流水
     * 
     * @param accountFlow 賬戶流水信息
     * @return 结果
     */
	@Override
	public int insertAccountFlow(AccountFlow accountFlow)
	{
	    return accountFlowMapper.insertAccountFlow(accountFlow);
	}
	
	/**
     * 修改賬戶流水
     * 
     * @param accountFlow 賬戶流水信息
     * @return 结果
     */
	@Override
	public int updateAccountFlow(AccountFlow accountFlow)
	{
	    return accountFlowMapper.updateAccountFlow(accountFlow);
	}

	/**
     * 删除賬戶流水对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAccountFlowByIds(String ids)
	{
		return accountFlowMapper.deleteAccountFlowByIds(Convert.toStrArray(ids));
	}
	
}
