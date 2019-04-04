package com.ruoyi.util.sms;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

//public class ShortNetAddressUtil {
	import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
	 
	/**
	 * java调用百度短网址api
	 */
	public class ShortNetAddressUtil {
	    public static DefaultHttpClient httpclient;
	    static {
	        httpclient = new DefaultHttpClient();
	        //httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	    }
	 
	    /**
	     * 生成短网址
	     * @param url 长网址
	     */
	    public static String  generateShortUrl(String url) {
	        try {
	            HttpPost httpost = new HttpPost("https://dwz.cn/admin/v2/create");
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("url", url)); // 用户名称
	            httpost.setEntity(new UrlEncodedFormEntity(params,  "utf-8"));
	            httpost.setHeader("token", "5e6100e075e6df7408d6afd95fc0dfa7");
	            HttpResponse response = httpclient.execute(httpost);
	            String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
	            System.out.println(jsonStr);
	            JSONObject object = JSON.parseObject(jsonStr);
	            System.out.println(object.getString("tinyurl"));
	            return object.getString("tinyurl");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error";
	        }
	    }
	 
	    public static void main(String []args){
	        generateShortUrl("http://www.jb51.net/article/51881.htm");
	    }
	}
	    
