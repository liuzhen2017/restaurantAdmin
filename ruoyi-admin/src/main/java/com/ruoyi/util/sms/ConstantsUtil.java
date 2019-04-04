package com.ruoyi.util.sms;

public class ConstantsUtil {

	
	// 服务端返回成功的标志
	public static final String SERVICE_RESPONSE_SUCCESS_CODE = "00";
	
	// 服务端返回结果的标志
	public static final String SERVICE_RESPONSE_RESULT_FLAG = "01";
	// 服务端返回结果的标志
	public static final String SERVICE_CACHE_USER = "menmbers";
	
	
	public static final String ISVAILD_YES="yes";
	
	
	public static final String ISVAILD_NO ="no";
	
	/**
	 * 普通會員
	 */
	public static final Integer EmmbersType_0=0;
	/**
	 * VIP會員
	 */
	public static final Integer EmmbersType_1=1;
	/**
	 * 通用
	 */
	public static final Integer EmmbersType_2=2;
	/**
	 * 会员折扣
	 */
	public static final String VIPDiscount="VIPDiscount";
	/**
	 *  发送邮箱
	 */
	public static final String sendEmail="sendEmail";
	/**
	 * 发送短信
	 */
	public static final String sendSMSSetting="sendSMSSetting"; 
	/**
	 * 购买VIP价格
	 */
	public static final String  VIPPrice="VIPPrice"; 
	/**
	 * 支付系统前台key
	 */

	public static final String pay_user_web_key="pay_user_web_key"; 
	/**
	 *  支付系统后台key
	 */
	public static final String pay_user_service_key="pay_user_service_key";

}
