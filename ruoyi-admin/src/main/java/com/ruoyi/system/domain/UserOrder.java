package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 訂單表 order
 * 
 * @author liuzhen
 * @date 2019-01-31
 */
public class UserOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 交易渠道 */
	private String payChannel;
	/** 購買VIP會員 */
	private String orderDesc;
	/** 交易唯一碼,交易渠道返回 */
	private String token;
	/** 支付賬號 */
	private String email;
	/** 貨幣央視 */
	private String currency;
	/** 交易金額 */
	private BigDecimal ammount;
	/** 交易用戶ID */
	private String tranUser;
	/** 交易用戶名稱 */
	private String tranUserName;
	/** 交易用戶電話 */
	private String tranUserPhone;
	/** 交易狀態，交易渠道返回 */
	private String tranStatus;
	/** 交易結果返回 */
	private String tranMsg;
	/** 創建時間 */
	private Date createDate;
	/** 創建人 */
	private String createBy;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setPayChannel(String payChannel) 
	{
		this.payChannel = payChannel;
	}

	public String getPayChannel() 
	{
		return payChannel;
	}
	public void setOrderDesc(String orderDesc) 
	{
		this.orderDesc = orderDesc;
	}

	public String getOrderDesc() 
	{
		return orderDesc;
	}
	public void setToken(String token) 
	{
		this.token = token;
	}

	public String getToken() 
	{
		return token;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setCurrency(String currency) 
	{
		this.currency = currency;
	}

	public String getCurrency() 
	{
		return currency;
	}
	public void setAmmount(BigDecimal ammount) 
	{
		this.ammount = ammount;
	}

	public BigDecimal getAmmount() 
	{
		return ammount;
	}
	public void setTranUser(String tranUser) 
	{
		this.tranUser = tranUser;
	}

	public String getTranUser() 
	{
		return tranUser;
	}
	public void setTranUserName(String tranUserName) 
	{
		this.tranUserName = tranUserName;
	}

	public String getTranUserName() 
	{
		return tranUserName;
	}
	public void setTranUserPhone(String tranUserPhone) 
	{
		this.tranUserPhone = tranUserPhone;
	}

	public String getTranUserPhone() 
	{
		return tranUserPhone;
	}
	public void setTranStatus(String tranStatus) 
	{
		this.tranStatus = tranStatus;
	}

	public String getTranStatus() 
	{
		return tranStatus;
	}
	public void setTranMsg(String tranMsg) 
	{
		this.tranMsg = tranMsg;
	}

	public String getTranMsg() 
	{
		return tranMsg;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("payChannel", getPayChannel())
            .append("orderDesc", getOrderDesc())
            .append("token", getToken())
            .append("email", getEmail())
            .append("currency", getCurrency())
            .append("ammount", getAmmount())
            .append("tranUser", getTranUser())
            .append("tranUserName", getTranUserName())
            .append("tranUserPhone", getTranUserPhone())
            .append("tranStatus", getTranStatus())
            .append("tranMsg", getTranMsg())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .toString();
    }
}
