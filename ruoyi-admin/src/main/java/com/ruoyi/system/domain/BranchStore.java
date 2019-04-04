package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 分店管理表 branch_store
 * 
 * @author liuzhen
 * @date 2019-03-18
 */
public class BranchStore extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 店名 */
	private String storeName;
	/** 地址 */
	private String address;
	/** 电话 */
	private String phone;
	/** 负责人 */
	private String mangerMan;
	/** 负责人电话 */
	private String mangerManTel;
	/** 店长 */
	private String shopkeeper;
	/** 成立日期 */
	private String createDate;
	/** 有效日期开始 */
	private String effectiveBegin;
	/** 有效日期结束 */
	private String effectiveEnd;
	/** 开始营业日期 */
	private String businessBegin;
	/** 结束营业日期 */
	private String businessEnd;
	/** 是否有效,Y or N */
	private String isVaild;
	/** 创建人 */
	private String createBy;
	/** 圖片 */
	private String picUrl;
	/** 区域 */
	private String region;
	/** 区域ID */
	private Integer regionId;
	/** 谷歌地址 */
	private String googleUrl;
	/** 区域名称 */
	private String regionName;
	/** 店编号 */
	private Integer storeNo;
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
	public void setStoreName(String storeName) 
	{
		this.storeName = storeName;
	}

	public String getStoreName() 
	{
		return storeName;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setMangerMan(String mangerMan) 
	{
		this.mangerMan = mangerMan;
	}

	public String getMangerMan() 
	{
		return mangerMan;
	}
	public void setMangerManTel(String mangerManTel) 
	{
		this.mangerManTel = mangerManTel;
	}

	public String getMangerManTel() 
	{
		return mangerManTel;
	}
	public void setShopkeeper(String shopkeeper) 
	{
		this.shopkeeper = shopkeeper;
	}

	public String getShopkeeper() 
	{
		return shopkeeper;
	}
	public void setCreateDate(String createDate) 
	{
		this.createDate = createDate;
	}

	public String getCreateDate() 
	{
		return createDate;
	}
	public void setEffectiveBegin(String effectiveBegin) 
	{
		this.effectiveBegin = effectiveBegin;
	}

	public String getEffectiveBegin() 
	{
		return effectiveBegin;
	}
	public void setEffectiveEnd(String effectiveEnd) 
	{
		this.effectiveEnd = effectiveEnd;
	}

	public String getEffectiveEnd() 
	{
		return effectiveEnd;
	}
	public void setBusinessBegin(String businessBegin) 
	{
		this.businessBegin = businessBegin;
	}

	public String getBusinessBegin() 
	{
		return businessBegin;
	}
	public void setBusinessEnd(String businessEnd) 
	{
		this.businessEnd = businessEnd;
	}

	public String getBusinessEnd() 
	{
		return businessEnd;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setRegion(String region) 
	{
		this.region = region;
	}

	public String getRegion() 
	{
		return region;
	}
	public void setRegionId(Integer regionId) 
	{
		this.regionId = regionId;
	}

	public Integer getRegionId() 
	{
		return regionId;
	}
	public void setGoogleUrl(String googleUrl) 
	{
		this.googleUrl = googleUrl;
	}

	public String getGoogleUrl() 
	{
		return googleUrl;
	}
	public void setRegionName(String regionName) 
	{
		this.regionName = regionName;
	}

	public String getRegionName() 
	{
		return regionName;
	}
	public void setStoreNo(Integer storeNo) 
	{
		this.storeNo = storeNo;
	}

	public Integer getStoreNo() 
	{
		return storeNo;
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
	public void setSpareField8(String spareField8) 
	{
		this.spareField8 = spareField8;
	}

	public String getSpareField8() 
	{
		return spareField8;
	}
	public void setSpareField9(String spareField9) 
	{
		this.spareField9 = spareField9;
	}

	public String getSpareField9() 
	{
		return spareField9;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storeName", getStoreName())
            .append("address", getAddress())
            .append("phone", getPhone())
            .append("mangerMan", getMangerMan())
            .append("mangerManTel", getMangerManTel())
            .append("shopkeeper", getShopkeeper())
            .append("createDate", getCreateDate())
            .append("effectiveBegin", getEffectiveBegin())
            .append("effectiveEnd", getEffectiveEnd())
            .append("businessBegin", getBusinessBegin())
            .append("businessEnd", getBusinessEnd())
            .append("isVaild", getIsVaild())
            .append("createBy", getCreateBy())
            .append("picUrl", getPicUrl())
            .append("region", getRegion())
            .append("regionId", getRegionId())
            .append("googleUrl", getGoogleUrl())
            .append("regionName", getRegionName())
            .append("storeNo", getStoreNo())
            .append("spareField1", getSpareField1())
            .append("spareField2", getSpareField2())
            .append("spareField3", getSpareField3())
            .append("spareField4", getSpareField4())
            .append("spareField5", getSpareField5())
            .append("spareField6", getSpareField6())
            .append("spareField7", getSpareField7())
            .append("spareField8", getSpareField8())
            .append("spareField9", getSpareField9())
            .toString();
    }
}
