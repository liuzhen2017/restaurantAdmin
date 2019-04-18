package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 餐牌類型表 menu_food_type
 * 
 * @author liuzhen
 * @date 2019-04-12
 */
public class MenuFoodType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 類型名稱 */
	private String typeName;
	/** 排序 */
	private Integer orderBy;
	/** 圖片 */
	private String picUrl;
	/** 描述 */
	private String describes;
	/** 是否有效 */
	private String isVaild;
	/** 餐牌類型1為普通，2為贈送 */
	private String menuFoodType;
	/**  */
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
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setOrderBy(Integer orderBy) 
	{
		this.orderBy = orderBy;
	}

	public Integer getOrderBy() 
	{
		return orderBy;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setDescribes(String describes) 
	{
		this.describes = describes;
	}

	public String getDescribes() 
	{
		return describes;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
	}
	public void setMenuFoodType(String menuFoodType) 
	{
		this.menuFoodType = menuFoodType;
	}

	public String getMenuFoodType() 
	{
		return menuFoodType;
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
            .append("typeName", getTypeName())
            .append("orderBy", getOrderBy())
            .append("picUrl", getPicUrl())
            .append("describes", getDescribes())
            .append("isVaild", getIsVaild())
            .append("menuFoodType", getMenuFoodType())
            .append("spareField1", getSpareField1())
            .append("spareField2", getSpareField2())
            .append("spareField3", getSpareField3())
            .append("spareField4", getSpareField4())
            .append("spareField5", getSpareField5())
            .append("spareField6", getSpareField6())
            .toString();
    }
}
