package com.ruoyi.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.base.BaseEntity;

/**
 * 积分记录表 score_his
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
public class ScoreHis extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 会员ID */
	private Integer membersId;
	/** 会员名稱 */
	private String membersName;
	/** 旧积分 */
	private Integer olbScore;
	/** 新积分 */
	private Integer newScore;
	/** 描述 */
	private String describes;
	/** 创建日期 */
	private Date createdDate;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setMembersId(Integer membersId) 
	{
		this.membersId = membersId;
	}

	public Integer getMembersId() 
	{
		return membersId;
	}
	public void setMembersName(String membersName) 
	{
		this.membersName = membersName;
	}

	public String getMembersName() 
	{
		return membersName;
	}
	public void setOlbScore(Integer olbScore) 
	{
		this.olbScore = olbScore;
	}

	public Integer getOlbScore() 
	{
		return olbScore;
	}
	public void setNewScore(Integer newScore) 
	{
		this.newScore = newScore;
	}

	public Integer getNewScore() 
	{
		return newScore;
	}
	public void setDescribes(String describes) 
	{
		this.describes = describes;
	}

	public String getDescribes() 
	{
		return describes;
	}
	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() 
	{
		return createdDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("membersId", getMembersId())
            .append("membersName", getMembersName())
            .append("olbScore", getOlbScore())
            .append("newScore", getNewScore())
            .append("describes", getDescribes())
            .append("createdDate", getCreatedDate())
            .toString();
    }
}
