package com.ruoyi.quartz.task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.quartz.domain.SysConfigJob;
import com.ruoyi.quartz.mapper.SysConfigJobMapper;
import com.ruoyi.quartz.mapper.SysJobMapper;
import com.ruoyi.quartz.po.SendEmaill;
import com.ruoyi.quartz.util.SendEmailUtil;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("CheckVIP")
public class CheckVIP
{

	@Autowired
	SendEmailUtil emailUtil;
	@Autowired
	SysJobMapper sysJobMapper;
	
	@Autowired
	SysConfigJobMapper configMapper;
    public void cheCkVIP()
    {
        //定时任务查询会员信息,如果快过期了,1.提前5天发邮件,每天发
    	//如果过期了,设置为过期
    	Lock lock =new ReentrantLock();
    	lock.lock();
    	List<Map<String, Object>> listMap =sysJobMapper.selectBysql();
    	SysConfigJob selectByKey = configMapper.selectByKey("invaildTisContent");
    	JSONObject jb =JSONObject.parseObject(selectByKey.getConfigValue());
    	//{"send_title":"尊贵的VIP会员即将到期提醒", "send_content": "尊贵的VIP会员#name#,您的VIP会员将于#invaildDate#失效,请及时充值"}
    	listMap.forEach(m ->{
    		SendEmaill sendEmaill =new SendEmaill();
    		sendEmaill.setSendContent(jb.getString("send_content"));
    		sendEmaill.setTitle(jb.getString("send_title"));
    		sendEmaill.setSendTo(m.get("email").toString());
			try {
				emailUtil.sendEmail(sendEmaill);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	});
    	//解锁
    	lock.unlock();
    	
    }
}
