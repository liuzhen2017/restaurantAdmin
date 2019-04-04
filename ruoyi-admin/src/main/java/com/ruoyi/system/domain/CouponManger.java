package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;

/**
 * 优惠券管理表 coupon_manger
 * 
 * @author liuzhen
 * @date 2019-02-17
 */
public class CouponManger extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Excel(name="序號")
	private Integer id;
	/**  */
	@Excel(name="標題")
	private String title;
	/** 0优惠券,1优惠代码 */
	@Excel(readConverterExp="0=優惠券,1=優惠代碼", name = "優惠券類型")
	private Integer types;
	/** 01满减,02打折, */
	@Excel(readConverterExp="1=注册赠送,3=購買VIP", name = "優惠條件")
	private Integer rulesType;
	@Excel( name = "折扣值")
	private Double couponValues;
	/** 有效时间 */
	@Excel( name = "有效時間")
	private String effectiveTimeBegin;
	/** 失效时间 */
	@Excel( name = "失效時間")
	private String effectiveTimeEnd;
	/** 数量 */
	@Excel( name = "優惠券 數量")
	private Integer num;
	/** 会员类型0普通1VIP */
	@Excel( name = "目標會員",readConverterExp="0=普通會員,1=VIP會員,2=通用")
	private Integer membersType;
	/** 是否有小0无效1有效 */
	@Excel( name = "是否有效",readConverterExp="yes=有效,no=無效")
	private String isVaild;
	/** 创建时间 */
	private Date createDate;
	/** 创建用户 */
	private String createBy;
	/**  */
	private Date updateDate;
	/**  */
	private String updateBy;
	/** 狀態0,未發放,1已發放,未領取,2,已過期 3.已經使用 */
	@Excel( name = "優惠券狀態",readConverterExp="0=未發放,1=已發放,2=未領取,3=已領取,4=已使用,5.已過期")
	private Integer status;
	/** 使用説明 */
	@Excel( name = "使用説明")
	private String instructions;
	private String explanation;
	@Excel( name = "優惠券代碼")
	private String couponCode;
	@Excel( name = "未發放數量")
	private Integer noGrantNum;
	private String picUrl;
	@Excel( name = "折扣類型",readConverterExp="0=等值,1=折扣")
	private Integer couponRole;
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
	public void setTypes(Integer types) 
	{
		this.types = types;
	}

	public Integer getTypes() 
	{
		return types;
	}
	public void setRulesType(Integer rulesType) 
	{
		this.rulesType = rulesType;
	}

	public Integer getRulesType() 
	{
		return rulesType;
	}
	public void setCouponValues(Double couponValues) 
	{
		this.couponValues = couponValues;
	}

	public Double getCouponValues() 
	{
		return couponValues;
	}
	public void setEffectiveTimeBegin(String effectiveTimeBegin) 
	{
		this.effectiveTimeBegin = effectiveTimeBegin;
	}

	public String getEffectiveTimeBegin() 
	{
		return effectiveTimeBegin;
	}
	public void setEffectiveTimeEnd(String effectiveTimeEnd) 
	{
		this.effectiveTimeEnd = effectiveTimeEnd;
	}

	public String getEffectiveTimeEnd() 
	{
		return effectiveTimeEnd;
	}
	public void setNum(Integer num) 
	{
		this.num = num;
	}

	public Integer getNum() 
	{
		return num;
	}
	public void setMembersType(Integer membersType) 
	{
		this.membersType = membersType;
	}

	public Integer getMembersType() 
	{
		return membersType;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
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
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setCouponCode(String couponCode) 
	{
		this.couponCode = couponCode;
	}

	public String getCouponCode() 
	{
		return couponCode;
	}
	public void setNoGrantNum(Integer noGrantNum) 
	{
		this.noGrantNum = noGrantNum;
	}

	public Integer getNoGrantNum() 
	{
		return noGrantNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("types", getTypes())
            .append("rulesType", getRulesType())
            .append("couponValues", getCouponValues())
            .append("effectiveTimeBegin", getEffectiveTimeBegin())
            .append("effectiveTimeEnd", getEffectiveTimeEnd())
            .append("num", getNum())
            .append("membersType", getMembersType())
            .append("isVaild", getIsVaild())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .append("status", getStatus())
            .append("instructions", getInstructions())
            .append("couponCode", getCouponCode())
            .append("noGrantNum", getNoGrantNum())
            .toString();
    }

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getCouponRole() {
		return couponRole;
	}

	public void setCouponRole(Integer couponRole) {
		this.couponRole = couponRole;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
