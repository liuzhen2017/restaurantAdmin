package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 餐牌表 menu_food
 * 
 * @author liuzhen
 * @date 2019-03-05
 */
public class MenuFood extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 标题 */
	private String title;
	/** 描述 */
	private String describes;
	/** 图片地址 */
	private String picUrl;
	/** 类型 */
	private Integer typess;
	/** 类型名称 */
	private String typeName;
	/** 价格 */
	private Double price;
	/** 兑换积分 */
	private Double exchangePointsScord;
	/** 是否是热门 */
	private String isHot;
	/** 是否有效 */
	private String isValid;
	/**  */
	private Date createDate;
	/** 是否售罄 */
	private String isSellOut;
	/** 门店ID */
	private Integer branchStoreId;
	/** 是否是兑换菜品 */
	private String isExchange;
	/** 生效日期 */
	private String takeEffectDate;
	/** 失效日期 */
	private String invalidDate;
	/** 兑换后有效天数,day */
	private Integer effectiveDay;
	/** 總數 */
	private Integer totalNums;
	/** 已使用 */
	private Integer usedNums;
	/** 名称 */
	private String name;
	/** 优惠条件.1升级VIP赠送 */
	private Integer rulesType;
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
	public void setDescribes(String describes) 
	{
		this.describes = describes;
	}

	public String getDescribes() 
	{
		return describes;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setTypess(Integer typess) 
	{
		this.typess = typess;
	}

	public Integer getTypess() 
	{
		return typess;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setPrice(Double price) 
	{
		this.price = price;
	}

	public Double getPrice() 
	{
		return price;
	}
	public void setExchangePointsScord(Double exchangePointsScord) 
	{
		this.exchangePointsScord = exchangePointsScord;
	}

	public Double getExchangePointsScord() 
	{
		return exchangePointsScord;
	}
	public void setIsHot(String isHot) 
	{
		this.isHot = isHot;
	}

	public String getIsHot() 
	{
		return isHot;
	}
	public void setIsValid(String isValid) 
	{
		this.isValid = isValid;
	}

	public String getIsValid() 
	{
		return isValid;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setIsSellOut(String isSellOut) 
	{
		this.isSellOut = isSellOut;
	}

	public String getIsSellOut() 
	{
		return isSellOut;
	}
	public void setBranchStoreId(Integer branchStoreId) 
	{
		this.branchStoreId = branchStoreId;
	}

	public Integer getBranchStoreId() 
	{
		return branchStoreId;
	}
	public void setIsExchange(String isExchange) 
	{
		this.isExchange = isExchange;
	}

	public String getIsExchange() 
	{
		return isExchange;
	}
	public void setTakeEffectDate(String takeEffectDate) 
	{
		this.takeEffectDate = takeEffectDate;
	}

	public String getTakeEffectDate() 
	{
		return takeEffectDate;
	}
	public void setInvalidDate(String invalidDate) 
	{
		this.invalidDate = invalidDate;
	}

	public String getInvalidDate() 
	{
		return invalidDate;
	}
	public void setEffectiveDay(Integer effectiveDay) 
	{
		this.effectiveDay = effectiveDay;
	}

	public Integer getEffectiveDay() 
	{
		return effectiveDay;
	}
	public void setTotalNums(Integer totalNums) 
	{
		this.totalNums = totalNums;
	}

	public Integer getTotalNums() 
	{
		return totalNums;
	}
	public void setUsedNums(Integer usedNums) 
	{
		this.usedNums = usedNums;
	}

	public Integer getUsedNums() 
	{
		return usedNums;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setRulesType(Integer rulesType) 
	{
		this.rulesType = rulesType;
	}

	public Integer getRulesType() 
	{
		return rulesType;
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
	public void setSpareField7(String spareField7) 
	{
		this.spareField7 = spareField7;
	}

	public String getSpareField7() 
	{
		return spareField7;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("describes", getDescribes())
            .append("picUrl", getPicUrl())
            .append("typess", getTypess())
            .append("typeName", getTypeName())
            .append("price", getPrice())
            .append("exchangePointsScord", getExchangePointsScord())
            .append("isHot", getIsHot())
            .append("isValid", getIsValid())
            .append("createDate", getCreateDate())
            .append("isSellOut", getIsSellOut())
            .append("branchStoreId", getBranchStoreId())
            .append("isExchange", getIsExchange())
            .append("takeEffectDate", getTakeEffectDate())
            .append("invalidDate", getInvalidDate())
            .append("effectiveDay", getEffectiveDay())
            .append("totalNums", getTotalNums())
            .append("usedNums", getUsedNums())
            .append("name", getName())
            .append("rulesType", getRulesType())
            .append("spareField1", getSpareField1())
            .append("spareField2", getSpareField2())
            .append("spareField3", getSpareField3())
            .append("spareField4", getSpareField4())
            .append("spareField5", getSpareField5())
            .append("spareField6", getSpareField6())
            .append("spareField7", getSpareField7())
            .toString();
    }
}
