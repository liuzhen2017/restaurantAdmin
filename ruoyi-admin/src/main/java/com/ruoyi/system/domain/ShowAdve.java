package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 首頁廣告表 show_adve
 * 
 * @author liuzhen
 * @date 2019-04-02
 */
public class ShowAdve extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 標題 */
	private String title;
	/** 失效時間 */
	private String invalidDate;
	/** 生效時間 */
	private String takeEffectDate;
	/** 圖片地址 */
	private String picUrl;
	/** 跳轉地址 */
	private String linkUrl;
	/** 是否有效 */
	private String isVaild;
	/** 備用字段1 */
	private String spareField1;
	/** 備用字段2 */
	private String spareField2;
	/** 備用字段3 */
	private String spareField3;
	/** 備用字段4 */
	private String spareField4;
	/** 備用字段5 */
	private String spareField5;
	/** 備用字段6 */
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
	public void setInvalidDate(String invalidDate) 
	{
		this.invalidDate = invalidDate;
	}

	public String getInvalidDate() 
	{
		return invalidDate;
	}
	public void setTakeEffectDate(String takeEffectDate) 
	{
		this.takeEffectDate = takeEffectDate;
	}

	public String getTakeEffectDate() 
	{
		return takeEffectDate;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setLinkUrl(String linkUrl) 
	{
		this.linkUrl = linkUrl;
	}

	public String getLinkUrl() 
	{
		return linkUrl;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
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
            .append("invalidDate", getInvalidDate())
            .append("takeEffectDate", getTakeEffectDate())
            .append("picUrl", getPicUrl())
            .append("linkUrl", getLinkUrl())
            .append("isVaild", getIsVaild())
            .append("spareField1", getSpareField1())
            .append("spareField2", getSpareField2())
            .append("spareField3", getSpareField3())
            .append("spareField4", getSpareField4())
            .append("spareField5", getSpareField5())
            .append("spareField6", getSpareField6())
            .toString();
    }
}
