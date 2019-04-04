package com.ruoyi.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 短信發送記錄表 send_messager
 * 
 * @author liuzhen
 * @date 2019-01-25
 */
public class SendMessager extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序號 */
	private Integer id;
	/** 賬號 */
	private String userId;
	/** 消息類型 */
	private String messageType;
	/** 短信編碼 */
	private String messageLanguage;
	/** 接受電話 */
	private String messageReceiver;
	/** 發送内容 */
	private String messageBody;
	/** 發送返回MSG */
	private String replyMsg;
	/** 發送返回code */
	private String replyCode;
	/** 發送時間 */
	private Date createDate;
	/** 發送返回所有信息 */
	private String replyAllMsg;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setMessageType(String messageType) 
	{
		this.messageType = messageType;
	}

	public String getMessageType() 
	{
		return messageType;
	}
	public void setMessageLanguage(String messageLanguage) 
	{
		this.messageLanguage = messageLanguage;
	}

	public String getMessageLanguage() 
	{
		return messageLanguage;
	}
	public void setMessageReceiver(String messageReceiver) 
	{
		this.messageReceiver = messageReceiver;
	}

	public String getMessageReceiver() 
	{
		return messageReceiver;
	}
	public void setMessageBody(String messageBody) 
	{
		this.messageBody = messageBody;
	}

	public String getMessageBody() 
	{
		return messageBody;
	}
	public void setReplyMsg(String replyMsg) 
	{
		this.replyMsg = replyMsg;
	}

	public String getReplyMsg() 
	{
		return replyMsg;
	}
	public void setReplyCode(String replyCode) 
	{
		this.replyCode = replyCode;
	}

	public String getReplyCode() 
	{
		return replyCode;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setReplyAllMsg(String replyAllMsg) 
	{
		this.replyAllMsg = replyAllMsg;
	}

	public String getReplyAllMsg() 
	{
		return replyAllMsg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("messageType", getMessageType())
            .append("messageLanguage", getMessageLanguage())
            .append("messageReceiver", getMessageReceiver())
            .append("messageBody", getMessageBody())
            .append("replyMsg", getReplyMsg())
            .append("replyCode", getReplyCode())
            .append("createDate", getCreateDate())
            .append("replyAllMsg", getReplyAllMsg())
            .toString();
    }
}
