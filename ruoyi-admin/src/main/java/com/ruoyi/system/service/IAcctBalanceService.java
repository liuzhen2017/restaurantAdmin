package com.ruoyi.system.service;

import com.ruoyi.system.domain.AcctBalance;
import java.util.List;

/**
 * 賬戶餘額 服务层
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public interface IAcctBalanceService 
{
	/**
     * 查询賬戶餘額信息
     * 
     * @param id 賬戶餘額ID
     * @return 賬戶餘額信息
     */
	public AcctBalance selectAcctBalanceById(Integer id);
	
	/**
     * 查询賬戶餘額列表
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 賬戶餘額集合
     */
	public List<AcctBalance> selectAcctBalanceList(AcctBalance acctBalance);
	
	/**
     * 新增賬戶餘額
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 结果
     */
	public int insertAcctBalance(AcctBalance acctBalance);
	
	/**
     * 修改賬戶餘額
     * 
     * @param acctBalance 賬戶餘額信息
     * @return 结果
     */
	public int updateAcctBalance(AcctBalance acctBalance);
		
	/**
     * 删除賬戶餘額信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAcctBalanceByIds(String ids);
	
}
