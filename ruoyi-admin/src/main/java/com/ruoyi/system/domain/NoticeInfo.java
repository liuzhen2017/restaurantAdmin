package com.ruoyi.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 通知表 notice_info
 * 
 * @author liuzhen
 * @date 2019-02-15
 */
public class NoticeInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 標題 */
	private String title;
	/** 内容 */
	private String content;
	/** 來源表 */
	private String resourceTable;
	/** 來源表ID */
	private Integer resourceId;
	/** 會員ID */
	private Integer memId;
	/** 創建時間 */
	private Date createDate;
	/** 查看時間 */
	private Date seeDate;
	/** 是否查看 */
	private String isSee;
	private String picUrl;

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
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setResourceTable(String resourceTable) 
	{
		this.resourceTable = resourceTable;
	}

	public String getResourceTable() 
	{
		return resourceTable;
	}
	public void setResourceId(Integer resourceId) 
	{
		this.resourceId = resourceId;
	}

	public Integer getResourceId() 
	{
		return resourceId;
	}
	public void setMemId(Integer memId) 
	{
		this.memId = memId;
	}

	public Integer getMemId() 
	{
		return memId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setSeeDate(Date seeDate) 
	{
		this.seeDate = seeDate;
	}

	public Date getSeeDate() 
	{
		return seeDate;
	}
	public void setIsSee(String isSee) 
	{
		this.isSee = isSee;
	}

	public String getIsSee() 
	{
		return isSee;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("resourceTable", getResourceTable())
            .append("resourceId", getResourceId())
            .append("memId", getMemId())
            .append("createDate", getCreateDate())
            .append("seeDate", getSeeDate())
            .append("isSee", getIsSee())
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
