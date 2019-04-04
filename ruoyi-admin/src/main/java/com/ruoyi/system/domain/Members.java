package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 会员管理表 members
 * 
 * @author liuzhen
 * @date 2019-03-05
 */
public class Members extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 邮箱 */
	private String email;
	/** 密码 */
	private String pwd;
	/** 姓名 */
	private String name;
	/** 地区 */
	private String region;
	/** 性别 */
	private Integer sex;
	/** 生日 */
	private String birthday;
	/** 积分 */
	private Integer score;
	/** 是否有效 */
	private String isVaild;
	/** 创建日期 */
	private String createDate;
	/** 會員類型 */
	private Integer membersType;
	/** 升級時間 */
	private String upgradeDate;
	/** 會員有效期 */
	private String vipDate;
	/**  */
	private String salt;
	/**  */
	private String phone;
	/** 会员编号 */
	private String code;
	/** 用户是否勾选了推送 */
	private String isSend;
	/** 是否推送了消息 */
	private String isTis;
	
	//额外追加的字段
	private String couponId;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	public String getPwd() 
	{
		return pwd;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setRegion(String region) 
	{
		this.region = region;
	}

	public String getRegion() 
	{
		return region;
	}
	public void setSex(Integer sex) 
	{
		this.sex = sex;
	}

	public Integer getSex() 
	{
		return sex;
	}
	public void setBirthday(String birthday) 
	{
		this.birthday = birthday;
	}

	public String getBirthday() 
	{
		return birthday;
	}
	public void setScore(Integer score) 
	{
		this.score = score;
	}

	public Integer getScore() 
	{
		return score;
	}
	public void setIsVaild(String isVaild) 
	{
		this.isVaild = isVaild;
	}

	public String getIsVaild() 
	{
		return isVaild;
	}
	public void setCreateDate(String createDate) 
	{
		this.createDate = createDate;
	}

	public String getCreateDate() 
	{
		return createDate;
	}
	public void setMembersType(Integer membersType) 
	{
		this.membersType = membersType;
	}

	public Integer getMembersType() 
	{
		return membersType;
	}
	public void setUpgradeDate(String upgradeDate) 
	{
		this.upgradeDate = upgradeDate;
	}

	public String getUpgradeDate() 
	{
		return upgradeDate;
	}
	public void setVipDate(String vipDate) 
	{
		this.vipDate = vipDate;
	}

	public String getVipDate() 
	{
		return vipDate;
	}
	public void setSalt(String salt) 
	{
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	public void setIsSend(String isSend) 
	{
		this.isSend = isSend;
	}

	public String getIsSend() 
	{
		return isSend;
	}
	public void setIsTis(String isTis) 
	{
		this.isTis = isTis;
	}

	public String getIsTis() 
	{
		return isTis;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("email", getEmail())
            .append("pwd", getPwd())
            .append("name", getName())
            .append("region", getRegion())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("score", getScore())
            .append("isVaild", getIsVaild())
            .append("createDate", getCreateDate())
            .append("membersType", getMembersType())
            .append("upgradeDate", getUpgradeDate())
            .append("vipDate", getVipDate())
            .append("salt", getSalt())
            .append("phone", getPhone())
            .append("code", getCode())
            .append("isSend", getIsSend())
            .append("isTis", getIsTis())
            .toString();
    }

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
