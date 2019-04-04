package com.ruoyi.quartz.util;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.HttpConstants;
import com.ruoyi.quartz.domain.SysConfigJob;
import com.ruoyi.quartz.mapper.SysConfigJobMapper;
import com.ruoyi.quartz.po.SendEmaill;
@Service
public class SendEmailUtil {
	
	@Resource
    SysConfigJobMapper configMapper;    
    public  void sendEmail(SendEmaill sendEmaill) throws Exception{
    	//1、连接邮件服务器的参数配置
         Properties props = new Properties();
         //设置用户的认证方式
         props.setProperty("mail.smtp.auth", "true");
         //设置传输协议
         props.setProperty("mail.transport.protocol", "smtp");
		//设置发件人的SMTP服务器地址
         SysConfigJob config  =new SysConfigJob();
         config.setConfigKey(HttpConstants.sendEmail);
         SysConfigJob selectConfig = configMapper.selectConfig(config);
         String json = selectConfig.getConfigValue();
         
//         {"send_title":"找回密碼郵件", "send_content": "請點擊以下鏈接進行驗證,有效期為兩個小時", "senderAccount": "294442437@qq.com", "senderPassword": "lfnevylvbsjxcagb", "smtpHost": "smtp.qq.com", "retrieve_url": "http://localhost:8082/api/members/checkTokenEmail.do"}
         JSONObject jsonObject =JSONObject.parseObject(json);
         props.setProperty("mail.smtp.host", jsonObject.getString("smtpHost"));
         //2、创建定义整个应用程序所需的环境信息的 Session 对象
         Session session = Session.getInstance(props);
         //设置调试信息在控制台打印出来
         session.setDebug(true);
         //3、创建邮件的实例对象
         Message msg = getMimeMessage(session,sendEmaill,jsonObject.getString("senderAccount"));
         //4、根据session对象获取邮件传输对象Transport
         Transport transport = session.getTransport();
         //设置发件人的账户名和密码
         transport.connect(jsonObject.getString("senderAccount"),jsonObject.getString("senderPassword"));
         //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
         transport.sendMessage(msg,msg.getAllRecipients());
          
          
         //5、关闭邮件连接
         transport.close();
     }
    /**
     * 获得创建一封邮件的实例对象
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
	public  MimeMessage getMimeMessage(Session session,SendEmaill sendEmaill,String senderAccount) throws Exception{
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(senderAccount));
        msg.setRecipients(MimeMessage.RecipientType.TO,getAddress(sendEmaill.getSendTo()));
        //设置邮件主题
        msg.setSubject(sendEmaill.getTitle(),"UTF-8");
        //设置邮件正文
        msg.setContent(sendEmaill.getSendContent(), "text/html;charset=UTF-8");
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());
         
        return msg;
    }
    public static  InternetAddress[]  getAddress(String email){

    	//多个接收账号
    	         InternetAddress[] address=null;
    	         try {
    	             List<InternetAddress> list = new ArrayList<InternetAddress>();
    	             String []median=email.split(";");//对输入的多个邮件进行逗号分割
    	             for(int i=0;i<median.length;i++){
    	            	 if(StringUtils.isEmpty(median[i])) continue;
    	                 list.add(new InternetAddress(median[i]));
    	             }
    	             address =(InternetAddress[])list.toArray(new InternetAddress[list.size()]);
    	            
    	        } catch (AddressException e) {
    	            e.printStackTrace();
    	        }
    	         return address;
    	     }


}
