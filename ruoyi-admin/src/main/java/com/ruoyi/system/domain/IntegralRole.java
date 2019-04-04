package com.ruoyi.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 积分规则表 integral_role
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public class IntegralRole extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/**  */
	private String title;
	/**  */
	private String descs;
	/** 1,普通用户2,VIP会员,为空则都可以 */
	private Integer menmType;
	/**  */
	private String beginTime;
	/**  */
	private String endTime;
	/** 优先级,同时只会有一条生效,越大越好 */
	private Integer priority;
	/**  */
	private Date createDate;
	/**  */
	private String createBy;
	/**  */
	private Date updateDate;
	/**  */
	private String updateBy;
	/** 是否有效 */
	private String isValid;
	/** 1.消費積分 2.活動積分 */
	private Integer integralType;
	/** 金額 */
	private Double amount;
	/** 積分，注意，是 金額   * 積分值 */
	private double scoreValue;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setDescs(String descs) 
	{
		this.descs = descs;
	}

	public String getDescs() 
	{
		return descs;
	}
	public void setMenmType(Integer menmType) 
	{
		this.menmType = menmType;
	}

	public Integer getMenmType() 
	{
		return menmType;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPriority(Integer priority) 
	{
		this.priority = priority;
	}

	public Integer getPriority() 
	{
		return priority;
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
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setIsValid(String isValid) 
	{
		this.isValid = isValid;
	}

	public String getIsValid() 
	{
		return isValid;
	}
	public void setIntegralType(Integer integralType) 
	{
		this.integralType = integralType;
	}

	public Integer getIntegralType() 
	{
		return integralType;
	}
	public void setAmount(Double amount) 
	{
		this.amount = amount;
	}

	public Double getAmount() 
	{
		return amount;
	}
	public void setScoreValue(double scoreValue) 
	{
		this.scoreValue = scoreValue;
	}

	public double getScoreValue() 
	{
		return scoreValue;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("descs", getDescs())
            .append("menmType", getMenmType())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("priority", getPriority())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .append("isValid", getIsValid())
            .append("integralType", getIntegralType())
            .append("amount", getAmount())
            .append("scoreValue", getScoreValue())
            .toString();
    }
}
