package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 區域類型表 branch_store_region
 * 
 * @author liuzhen
 * @date 2019-02-24
 */
public class BranchStoreRegion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序号 */
	private Integer id;
	/** 名称 */
	private String name;
	/** 图片地址 */
	private String picUrl;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("picUrl", getPicUrl())
            .toString();
    }
}
