package com.ruoyi.util.sms;


/**
 * 短信接口 url :https://smsc.xgate.com.hk/smshub/sendsms
 * 
 * @author Administrator
 *
 */
public class SMSDto {
	/**
	 * 用戶ID
	 */
	
	public String UserID;
	/**
	 * 用戶密碼
	 */
	
	private String UserPassword;
	/**
	 * 消息類型
	 */
	private String MessageType = "TEXT";
	/**
	 * 短信編碼
	 */
	private String MessageLanguage = "UTF8";
	/**
	 * 接受電話
	 */
	private String MessageReceiver;
	/**
	 * 發送内容
	 */
	private String MessageBody;
	
	/**
	 * 發送返回MSG
	 */
	private String replyMSG;
	public String getReplyMSG() {
		return replyMSG;
	}

	public void setReplyMSG(String replyMSG) {
		this.replyMSG = replyMSG;
	}

	public String getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}

	/**
	 * 發送返回code
	 */
	private String replyCode;
	/**
	 * 發送返回所有信息
	 */
	private String replyAllMsg;
	public String getReplyAllMsg() {
		return replyAllMsg;
	}

	public void setReplyAllMsg(String replyAllMsg) {
		this.replyAllMsg = replyAllMsg;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getMessageLanguage() {
		return MessageLanguage;
	}

	public void setMessageLanguage(String messageLanguage) {
		MessageLanguage = messageLanguage;
	}

	public String getMessageReceiver() {
		return MessageReceiver;
	}

	public void setMessageReceiver(String messageReceiver) {
		MessageReceiver = messageReceiver;
	}

	public String getMessageBody() {
		return MessageBody;
	}

	public void setMessageBody(String messageBody) {
		MessageBody = messageBody;
	}

}
