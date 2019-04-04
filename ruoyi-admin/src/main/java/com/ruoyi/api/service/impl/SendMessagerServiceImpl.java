package com.ruoyi.api.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ruoyi.api.domain.SendMessager;
import com.ruoyi.api.mapper.SendMessagerMapper;
import com.ruoyi.api.service.ISendMessagerService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.util.sms.SMSDto;
import com.ruoyi.util.sms.SMSUtil;

/**
 * 短信發送記錄 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-25
 */
@Service
public class SendMessagerServiceImpl implements ISendMessagerService 
{
	@Autowired
	private SendMessagerMapper sendMessagerMapper;
	
	
	/*@Value("${sms.content}")
	private String content;
	@Value("${sms.url}")
	String url;
	@Value("${sms.userId}")
	String userId;
	@Value("${sms.UserPassword}")
	String pwd;
	@Value("${sms.MessageType}")
	String messageType;*/
	/**
     * 查询短信發送記錄信息
     * 
     * @param id 短信發送記錄ID
     * @return 短信發送記錄信息
     */
    @Override
	public SendMessager selectSendMessagerById(Integer id)
	{
	    return sendMessagerMapper.selectSendMessagerById(id);
	}
	
	/**
     * 查询短信發送記錄列表
     * 
     * @param sendMessager 短信發送記錄信息
     * @return 短信發送記錄集合
     */
	@Override
	public List<SendMessager> selectSendMessagerList(SendMessager sendMessager)
	{
	    return sendMessagerMapper.selectSendMessagerList(sendMessager);
	}
	
    /**
     * 新增短信發送記錄
     * 
     * @param sendMessager 短信發送記錄信息
     * @return 结果
     */
	@Override
	public AjaxResult sendSMS(String phone)
	{
		/*SendMessager sendMessager =new SendMessager();
		sendMessager.setMessageBody(phone);
		int random =0;
		for(int j = 0; j< 100; j++){
			random =((int)((Math.random()*9+1)*100000));
		}
		String semdContent =content+":" +random;
		AjaxResult result =null;
		SMSDto sms=new SMSDto();
		sms.setMessageBody(semdContent);
		sms.setMessageReceiver(phone);
		try {
			if(StringUtils.isEmpty(sms.getUserID())){
				sms.setUserID(userId);
			}
			if(StringUtils.isEmpty(sms.getUserPassword())){
				sms.setUserPassword(pwd);
			}
			if(StringUtils.isEmpty(sms.getMessageType())){
				sms.setMessageType(messageType);
			}
			result =SMSUtil.sendMsg(sms,url);
			SMSDto dto = (SMSDto) result.get("data");
			sendMessager.setMessageBody(dto.getMessageBody());
			sendMessager.setMessageReceiver(phone);
			sendMessager.setMessageType(dto.getMessageType());
			sendMessager.setReplyAllMsg(dto.getReplyAllMsg());
			sendMessager.setUserId(dto.getUserID());*/
//			sendMessagerMapper.insertSendMessager(sendMessager);
//			return result;
		/*} catch (Exception e) {
			System.out.println("發送短信錯誤");
			return  AjaxResult.error();
		}*/
		return null;
	    
	}
	
}
