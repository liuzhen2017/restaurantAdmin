package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 賬戶餘額表 acct_balance
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public class AcctBalance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 賬號 */
	private BigDecimal accNo;
	/** 賬戶類型 */
	private Integer accType;
	/** 可用餘額 */
	private BigDecimal canBalance;
	/** 凍結金額 */
	private BigDecimal freezingBalance;
	/** 創建日期 */
	private Date createDate;
	/** 創建用戶 */
	private String createBy;
	/** 修改日期 */
	private Date updataDate;
	/** 修改用戶 */
	private String updateBy;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAccNo(BigDecimal accNo) 
	{
		this.accNo = accNo;
	}

	public BigDecimal getAccNo() 
	{
		return accNo;
	}
	public void setAccType(Integer accType) 
	{
		this.accType = accType;
	}

	public Integer getAccType() 
	{
		return accType;
	}
	public void setCanBalance(BigDecimal canBalance) 
	{
		this.canBalance = canBalance;
	}

	public BigDecimal getCanBalance() 
	{
		return canBalance;
	}
	public void setFreezingBalance(BigDecimal freezingBalance) 
	{
		this.freezingBalance = freezingBalance;
	}

	public BigDecimal getFreezingBalance() 
	{
		return freezingBalance;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setUpdataDate(Date updataDate) 
	{
		this.updataDate = updataDate;
	}

	public Date getUpdataDate() 
	{
		return updataDate;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accNo", getAccNo())
            .append("accType", getAccType())
            .append("canBalance", getCanBalance())
            .append("freezingBalance", getFreezingBalance())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updataDate", getUpdataDate())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
