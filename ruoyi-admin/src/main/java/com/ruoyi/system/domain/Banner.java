package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 首頁banner表 banner
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
public class Banner extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 標題 */
	private String title;
	/** 描述 */
	private String describes;
	/** 圖片 */
	private String picUrl;
	/** 排序 */
	private Integer orderBy;
	/** 是否有效 */
	private String isVaild;
	/**  */
	private String effectiveTimeBegin;
	/**  */
	private String effectiveTimeEnd;

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
	public void setOrderBy(Integer orderBy) 
	{
		this.orderBy = orderBy;
	}

	public Integer getOrderBy() 
	{
		return orderBy;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("describes", getDescribes())
            .append("picUrl", getPicUrl())
            .append("orderBy", getOrderBy())
            .append("isVaild", getIsVaild())
            .append("effectiveTimeBegin", getEffectiveTimeBegin())
            .append("effectiveTimeEnd", getEffectiveTimeEnd())
            .toString();
    }
}
