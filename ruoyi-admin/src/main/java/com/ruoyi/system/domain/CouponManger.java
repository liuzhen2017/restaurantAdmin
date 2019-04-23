package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 优惠券管理表 coupon_manger
 * 
 * @author liuzhen
 * @date 2019-04-23
 */
public class CouponManger extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/**  */
	private String title;
	/** 0优惠券,1优惠代码 */
	private Integer types;
	/** 01满减,02打折, */
	private Integer rulesType;
	/** 比如,满一百减20  ,20%的折扣 */
	private Double couponValues;
	/** 有效时间 */
	private String effectiveTimeBegin;
	/** 失效时间 */
	private String effectiveTimeEnd;
	/** 数量 */
	private Integer num;
	/** 会员类型0普通1VIP */
	private Integer membersType;
	/** 是否有小0无效1有效 */
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
	private Integer status;
	/** 使用説明 */
	private String instructions;
	/**  */
	private String couponCode;
	/** 未發放數量 */
	private Integer noGrantNum;
	/** 图片地址 */
	private String picUrl;
	/** 优惠规则,1价值 ,2折扣 */
	private Integer couponRole;
	/**  */
	private String explanation;
	/** 餐牌代码 */
	private String spareField1;
	/**  */
	private String spareField2;
	/**  */
	private String spareField3;
	/**  */
	private String spareField4;
	/**  */
	private String spareField5;
	/**  */
	private String spareField6;

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
	public void setNoGrantNum(Integer noGrantNum) 
	{
		this.noGrantNum = noGrantNum;
	}

	public Integer getNoGrantNum() 
	{
		return noGrantNum;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setCouponRole(Integer couponRole) 
	{
		this.couponRole = couponRole;
	}

	public Integer getCouponRole() 
	{
		return couponRole;
	}
	public void setExplanation(String explanation) 
	{
		this.explanation = explanation;
	}

	public String getExplanation() 
	{
		return explanation;
	}
	public void setSpareField1(String spareField1) 
	{
		this.spareField1 = spareField1;
	}

	public String getSpareField1() 
	{
		return spareField1;
	}
	public void setSpareField2(String spareField2) 
	{
		this.spareField2 = spareField2;
	}

	public String getSpareField2() 
	{
		return spareField2;
	}
	public void setSpareField3(String spareField3) 
	{
		this.spareField3 = spareField3;
	}

	public String getSpareField3() 
	{
		return spareField3;
	}
	public void setSpareField4(String spareField4) 
	{
		this.spareField4 = spareField4;
	}

	public String getSpareField4() 
	{
		return spareField4;
	}
	public void setSpareField5(String spareField5) 
	{
		this.spareField5 = spareField5;
	}

	public String getSpareField5() 
	{
		return spareField5;
	}
	public void setSpareField6(String spareField6) 
	{
		this.spareField6 = spareField6;
	}

	public String getSpareField6() 
	{
		return spareField6;
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
            .append("picUrl", getPicUrl())
            .append("couponRole", getCouponRole())
            .append("explanation", getExplanation())
            .append("spareField1", getSpareField1())
            .append("spareField2", getSpareField2())
            .append("spareField3", getSpareField3())
            .append("spareField4", getSpareField4())
            .append("spareField5", getSpareField5())
            .append("spareField6", getSpareField6())
            .toString();
    }
}
