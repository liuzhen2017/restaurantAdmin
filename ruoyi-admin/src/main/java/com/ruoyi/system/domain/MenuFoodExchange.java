package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 兑换商品表 menu_food_exchange
 * 
 * @author liuzhen
 * @date 2019-03-05
 */
public class MenuFoodExchange extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 菜品ID */
	private Integer menuFoodId;
	/** 菜品名称 */
	private String menuFoodName;
	/** 菜品图片 */
	private String menuFoodPic;
	/** 会员ID */
	private Integer membersId;
	/** 会员姓名 */
	private String menbersName;
	/** 使用积分 */
	private Integer scord;
	/** 创建日期 */
	private Date createDate;
	/** 优惠券编号 */
	private Integer couponId;
	/** 0优惠券  1优惠代码 */
	private Integer couponType;
	/** 生效時間 */
	private String takeEffectDate;
	/** 失效時間 */
	private String invalidDate;
	/** 是否有效 */
	private String isVaild;
	/** 0已領取1已過期2已使用3已刪除 */
	private Integer exchangeStatus;
	/** 編號 */
	private String couponCode;
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
	public void setMenuFoodId(Integer menuFoodId) 
	{
		this.menuFoodId = menuFoodId;
	}

	public Integer getMenuFoodId() 
	{
		return menuFoodId;
	}
	public void setMenuFoodName(String menuFoodName) 
	{
		this.menuFoodName = menuFoodName;
	}

	public String getMenuFoodName() 
	{
		return menuFoodName;
	}
	public void setMenuFoodPic(String menuFoodPic) 
	{
		this.menuFoodPic = menuFoodPic;
	}

	public String getMenuFoodPic() 
	{
		return menuFoodPic;
	}
	public void setMembersId(Integer membersId) 
	{
		this.membersId = membersId;
	}

	public Integer getMembersId() 
	{
		return membersId;
	}
	public void setMenbersName(String menbersName) 
	{
		this.menbersName = menbersName;
	}

	public String getMenbersName() 
	{
		return menbersName;
	}
	public void setScord(Integer scord) 
	{
		this.scord = scord;
	}

	public Integer getScord() 
	{
		return scord;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setCouponId(Integer couponId) 
	{
		this.couponId = couponId;
	}

	public Integer getCouponId() 
	{
		return couponId;
	}
	public void setCouponType(Integer couponType) 
	{
		this.couponType = couponType;
	}

	public Integer getCouponType() 
	{
		return couponType;
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
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
	}
	public void setExchangeStatus(Integer exchangeStatus) 
	{
		this.exchangeStatus = exchangeStatus;
	}

	public Integer getExchangeStatus() 
	{
		return exchangeStatus;
	}
	public void setCouponCode(String couponCode) 
	{
		this.couponCode = couponCode;
	}

	public String getCouponCode() 
	{
		return couponCode;
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
            .append("menuFoodId", getMenuFoodId())
            .append("menuFoodName", getMenuFoodName())
            .append("menuFoodPic", getMenuFoodPic())
            .append("membersId", getMembersId())
            .append("menbersName", getMenbersName())
            .append("scord", getScord())
            .append("createDate", getCreateDate())
            .append("couponId", getCouponId())
            .append("couponType", getCouponType())
            .append("takeEffectDate", getTakeEffectDate())
            .append("invalidDate", getInvalidDate())
            .append("isVaild", getIsVaild())
            .append("exchangeStatus", getExchangeStatus())
            .append("couponCode", getCouponCode())
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
