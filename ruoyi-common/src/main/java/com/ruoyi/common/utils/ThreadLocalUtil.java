package com.ruoyi.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.ruoyi.common.constant.HttpConstants;


/**
 * @author liuzhen
 *  线程变量公共类
 */
public class ThreadLocalUtil {
	// 服务端返回结果的标志
	public static final String SERVICE_CACHE_USER = "menmbers";
	/**
	 * 线程变量
	 */
    public static final ThreadLocal<Map<String, Object>> session = new ThreadLocal<Map<String, Object>>();
    
    private static Map<String, Object> map =null;
    /**
     * 放入set值
     * @param key
     * @param value
     */
    public static void set(String key,Object value){
    	getMap().put(key, value);
    }
    /**
     * 取值
     * @param key
     * @return
     */
    public static Object get(String key){
    	return getMap().get(key);
    }
    /**
     * 保存用户信息
     * @param userInfo
     */
    public static void setUserInfo(Object userInfo){
    	getMap().put(HttpConstants.SERVICE_CACHE_USER,userInfo);
    }
    /**
     * 取用户信息
     * @return
     */
    public static Object getUserInfo(){
    	return  getMap().get(HttpConstants.SERVICE_CACHE_USER) ==null ? null:(Object)session.get().get(HttpConstants.SERVICE_CACHE_USER);
    }    
    public static Map<String, Object> getMap(){
    	if(session.get() ==null) {
    		map =new HashMap<>();
    		session.set(map);
    	}
    	return session.get();
    }
}

