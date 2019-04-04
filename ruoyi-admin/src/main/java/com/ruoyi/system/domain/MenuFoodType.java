package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 餐牌類型表 menu_food_type
 * 
 * @author liuzhen
 * @date 2019-02-21
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeName", getTypeName())
            .append("orderBy", getOrderBy())
            .append("describes", getDescribes())
            .append("isVaild", getIsVaild())
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
}
