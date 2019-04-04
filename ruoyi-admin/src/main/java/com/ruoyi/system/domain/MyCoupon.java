package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;

/**
 * 我的优惠券表 my_coupon
 * 
 * @author liuzhen
 * @date 2019-02-17
 */
public class MyCoupon extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	@Excel(name="序號")
	private Integer id;
	/** 优惠券标题 */
	@Excel(name="標題")
	private String title;
	/** 优惠券ID */
	private Integer couponId;
	/** 会员ID */
	@Excel(name="擁有會員")
	private Integer membersId;
	/** 会员类型 */
	@Excel(name="標題")
	private Integer membersType;
	/** 优惠券类型 */
	@Excel( name = "目標會員",readConverterExp="0=普通會員,1=VIP會員,2=通用")
	private Integer couponType;
	/** 优惠券有效日期 */
	@Excel( name = "優惠券有效期")
	private String effectiveTimeBegin;
	/** 优惠券失效日期 */
	@Excel( name = "優惠券失效期")
	private String effectiveTimeEnd;
	/** 领取日期 */
	@Excel( name = "領取日期")
	private Date createDate;
	/** 是否有效 */
	@Excel( name = "是否有效",readConverterExp="yes=有效,no=無效")
	private String isVaild;
	/** 狀態0,未發放,1已發放,未領取,2,已過期 3.已經使用 */
	@Excel( name = "優惠券狀態",readConverterExp="0=未發放,1=已發放,2=未領取,3=已領取,4=已使用,5.已過期")
	private Integer status;
	/** 使用说明 */
	@Excel( name = "使用説明")
	private String instructions;
	@Excel( name = "説明")
	private String explanation;
	/** 優惠代碼 */
	@Excel( name = "優惠代碼")
	private String couponCode;
	/** 優惠值 */
	@Excel( name = "優惠值")
	private Double couponValues;
	private String picUrl;
	@Excel( name = "折扣類型",readConverterExp="0=等值,1=折扣")
	private Integer couponRole;
	/** 备用字段 */
	private String spareField1;
	/** 备用字段 */
	private String spareField2;
	/** 备用字段 */
	private String spareField3;
	/** 备用字段 */
	private String spareField4;
	/** 备用字段 */
	private String spareField5;
	/** 备用字段 */
	private String spareField6;
	/** 备用字段 */
	private String spareField7;
	/** 备用字段 */
	private String spareField8;
	/** 备用字段 */
	private String spareField9;
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
	public void setCouponId(Integer couponId) 
	{
		this.couponId = couponId;
	}

	public Integer getCouponId() 
	{
		return couponId;
	}
	public void setMembersId(Integer membersId) 
	{
		this.membersId = membersId;
	}

	public Integer getMembersId() 
	{
		return membersId;
	}
	public void setMembersType(Integer membersType) 
	{
		this.membersType = membersType;
	}

	public Integer getMembersType() 
	{
		return membersType;
	}
	public void setCouponType(Integer couponType) 
	{
		this.couponType = couponType;
	}

	public Integer getCouponType() 
	{
		return couponType;
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
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setInstructions(String instructions) 
	{
		this.instructions = instructions;
	}

	public String getInstructions() 
	{
		return instructions;
	}
	public void setCouponCode(String couponCode) 
	{
		this.couponCode = couponCode;
	}

	public String getCouponCode() 
	{
		return couponCode;
	}
	public void setCouponValues(Double couponValues) 
	{
		this.couponValues = couponValues;
	}

	public Double getCouponValues() 
	{
		return couponValues;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("couponId", getCouponId())
            .append("membersId", getMembersId())
            .append("membersType", getMembersType())
            .append("couponType", getCouponType())
            .append("effectiveTimeBegin", getEffectiveTimeBegin())
            .append("effectiveTimeEnd", getEffectiveTimeEnd())
            .append("createDate", getCreateDate())
            .append("isVaild", getIsVaild())
            .append("status", getStatus())
            .append("instructions", getInstructions())
            .append("couponCode", getCouponCode())
            .append("couponValues", getCouponValues())
            .toString();
    }

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getSpareField1() {
		return spareField1;
	}

	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}

	public String getSpareField2() {
		return spareField2;
	}

	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}

	public String getSpareField3() {
		return spareField3;
	}

	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}

	public String getSpareField4() {
		return spareField4;
	}

	public void setSpareField4(String spareField4) {
		this.spareField4 = spareField4;
	}

	public String getSpareField5() {
		return spareField5;
	}

	public void setSpareField5(String spareField5) {
		this.spareField5 = spareField5;
	}

	public String getSpareField6() {
		return spareField6;
	}

	public void setSpareField6(String spareField6) {
		this.spareField6 = spareField6;
	}

	public String getSpareField7() {
		return spareField7;
	}

	public void setSpareField7(String spareField7) {
		this.spareField7 = spareField7;
	}

	public String getSpareField8() {
		return spareField8;
	}

	public void setSpareField8(String spareField8) {
		this.spareField8 = spareField8;
	}

	public String getSpareField9() {
		return spareField9;
	}

	public void setSpareField9(String spareField9) {
		this.spareField9 = spareField9;
	}
}
