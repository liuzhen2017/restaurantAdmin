package com.ruoyi.quartz.po;

public class SendEmaill {
	/**
	 * 發送者
	 */
	private String sendFrom;
	/**
	 * 接收方
	 */
	private String sendTo;
	/**
	 * 郵件類型
	 */
	private String sendType;
	/**
	 * 發送內容
	 */
	private String sendContent;
	/**
	 * 發送標題
	 */
	private String title;
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSendFrom() {
		return sendFrom;
	}
	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getTitle() {
		return title;
	}
	
}
