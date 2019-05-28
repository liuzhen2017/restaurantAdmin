package com.ruoyi.quartz.task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.HttpConstants;
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
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling 
public class CheckVIPJob
{

	@Autowired
	SendEmailUtil emailUtil;
	@Autowired
	SysJobMapper sysJobMapper;
	
	@Autowired
	SysConfigJobMapper configMapper;
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
	@Scheduled(cron = "* 0/30 * * * ?")
    public void cheCkVIP()
    {
        //定时任务查询会员信息,如果快过期了,1.提前5天发邮件,每天发
    	//如果过期了,设置为过期
    	Lock lock =new ReentrantLock();
    	lock.lock();
    	List<Map<String, Object>> listMap =sysJobMapper.selectBysql();
    	Map<String,Object> selectConfig = configMapper.selectByKey(HttpConstants.sendEmail);
        String json = (String)selectConfig.get("config_value");
    	JSONObject jb =JSONObject.parseObject(json);
    	//{"send_title":"尊贵的VIP会员即将到期提醒", "send_content": "尊贵的VIP会员#name#,您的VIP会员将于#invaildDate#失效,请及时充值"}
    	listMap.forEach(m ->{
    		SendEmaill sendEmaill =new SendEmaill();
    		sendEmaill.setSendContent(jb.getString("send_content"));
    		sendEmaill.setTitle(jb.getString("send_title"));
    		sendEmaill.setSendTo(m.get("email").toString());
			try {
				emailUtil.sendEmail(sendEmaill);
				Integer memId= (Integer)m.get("id");
	    		String key ="is_tis";
	    		String value="yes";
	    		sysJobMapper.updateMem(key,value,memId);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	});
    	System.out.println("========查找VIP消費不足的定時任務========");
    	List<Map<String, Object>> queryByLossLeve = sysJobMapper.queryByLossLeve();
    	queryByLossLeve.forEach(m ->{
    		System.out.println("降级会员信息===mem="+JSONObject.toJSONString(m));
    		Integer memId= (Integer)m.get("id");
    		String key ="members_type";
    		String value="0";
    		sysJobMapper.updateMem(key,value,memId);
    		System.out.println("降级会员完毕===mem="+m.get(""));
    	});
    	//解锁
    	lock.unlock();
    	
    }
}
