package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 賬戶流水表 account_flow
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
public class AccountFlow extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 賬號 */
	private String accNo;
	/** 交易類型 */
	private Integer tranType;
	/** 交易金額 */
	private BigDecimal money;
	/** 交易描述 */
	private String tranDes;
	/** 交易之前金額 */
	private BigDecimal beforeMoney;
	/** 交易之后金額 */
	private BigDecimal afterMoney;
	/** 創建創建人 */
	private Date createDate;
	/** 創建用戶 */
	private String createBy;
	/** 會員信息 */
	private Integer menuId;
	/** 會員賬號 */
	private String menuAccNo;
	/** 門店ID */
	private String branchStoreId;
	/** 門店名 */
	private String branchStoreName;
	/** 发票号 */
	private String invoiceNo;
	/** 发票金额 */
	private BigDecimal invoiceAmount;
	/** 交易金额 */
	private BigDecimal netAmount;
	private String isVaild;
	private Integer foodId;
	private String couponCode;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAccNo(String accNo) 
	{
		this.accNo = accNo;
	}

	public String getAccNo() 
	{
		return accNo;
	}
	public void setTranType(Integer tranType) 
	{
		this.tranType = tranType;
	}

	public Integer getTranType() 
	{
		return tranType;
	}
	public void setMoney(BigDecimal money) 
	{
		this.money = money;
	}

	public BigDecimal getMoney() 
	{
		return money;
	}
	public void setTranDes(String tranDes) 
	{
		this.tranDes = tranDes;
	}

	public String getTranDes() 
	{
		return tranDes;
	}
	public void setBeforeMoney(BigDecimal beforeMoney) 
	{
		this.beforeMoney = beforeMoney;
	}

	public BigDecimal getBeforeMoney() 
	{
		return beforeMoney;
	}
	public void setAfterMoney(BigDecimal afterMoney) 
	{
		this.afterMoney = afterMoney;
	}

	public BigDecimal getAfterMoney() 
	{
		return afterMoney;
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
	public void setMenuId(Integer menuId) 
	{
		this.menuId = menuId;
	}

	public Integer getMenuId() 
	{
		return menuId;
	}
	public void setMenuAccNo(String menuAccNo) 
	{
		this.menuAccNo = menuAccNo;
	}

	public String getMenuAccNo() 
	{
		return menuAccNo;
	}
	public void setBranchStoreId(String branchStoreId) 
	{
		this.branchStoreId = branchStoreId;
	}

	public String getBranchStoreId() 
	{
		return branchStoreId;
	}
	public void setBranchStoreName(String branchStoreName) 
	{
		this.branchStoreName = branchStoreName;
	}

	public String getBranchStoreName() 
	{
		return branchStoreName;
	}
	public void setInvoiceNo(String invoiceNo) 
	{
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceNo() 
	{
		return invoiceNo;
	}
	public void setInvoiceAmount(BigDecimal invoiceAmount) 
	{
		this.invoiceAmount = invoiceAmount;
	}

	public BigDecimal getInvoiceAmount() 
	{
		return invoiceAmount;
	}
	public void setNetAmount(BigDecimal netAmount) 
	{
		this.netAmount = netAmount;
	}

	public BigDecimal getNetAmount() 
	{
		return netAmount;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accNo", getAccNo())
            .append("tranType", getTranType())
            .append("money", getMoney())
            .append("tranDes", getTranDes())
            .append("beforeMoney", getBeforeMoney())
            .append("afterMoney", getAfterMoney())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("menuId", getMenuId())
            .append("menuAccNo", getMenuAccNo())
            .append("branchStoreId", getBranchStoreId())
            .append("branchStoreName", getBranchStoreName())
            .append("invoiceNo", getInvoiceNo())
            .append("invoiceAmount", getInvoiceAmount())
            .append("netAmount", getNetAmount())
            .toString();
    }

	public String getIsVaild() {
		return isVaild;
	}

	public void setIsVaild(String isVaild) {
		this.isVaild = isVaild;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
}
