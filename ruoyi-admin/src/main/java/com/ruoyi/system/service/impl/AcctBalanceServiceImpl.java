package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AcctBalanceMapper;
import com.ruoyi.system.domain.AcctBalance;
import com.ruoyi.system.service.IAcctBalanceService;
import com.ruoyi.common.support.Convert;

/**
 * 賬戶餘額 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class AcctBalanceServiceImpl implements IAcctBalanceService 
{
	@Autowired
	private AcctBalanceMapper acctBalanceMapper;

	/**
     * 查询賬戶餘額信息
     * 
     * @param id 賬戶餘額ID
     * @return 賬戶餘額信息
     */
    @Override
	public AcctBalance selectAcctBalanceById(Integer id)
	{
	    return acctBalanceMapper.selectAcctBalanceById(id);
	}
	
	/**
     * 查询賬戶餘額列表
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 賬戶餘額集合
     */
	@Override
	public List<AcctBalance> selectAcctBalanceList(AcctBalance acctBalance)
	{
	    return acctBalanceMapper.selectAcctBalanceList(acctBalance);
	}
	
    /**
     * 新增賬戶餘額
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 结果
     */
	@Override
	public int insertAcctBalance(AcctBalance acctBalance)
	{
	    return acctBalanceMapper.insertAcctBalance(acctBalance);
	}
	
	/**
     * 修改賬戶餘額
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 结果
     */
	@Override
	public int updateAcctBalance(AcctBalance acctBalance)
	{
	    return acctBalanceMapper.updateAcctBalance(acctBalance);
	}

	/**
     * 删除賬戶餘額对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAcctBalanceByIds(String ids)
	{
		return acctBalanceMapper.deleteAcctBalanceByIds(Convert.toStrArray(ids));
	}
	
}
