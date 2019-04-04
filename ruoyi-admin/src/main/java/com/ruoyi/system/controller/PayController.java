package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.system.service.IMyCouponService;

/**
 * 第三方支付
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Controller
@RequestMapping("/system/pay/")
public class PayController {
	 private String prefix = "system/pay";
		
		@Autowired
		private IMyCouponService myCouponService;
		
		@RequiresPermissions("system:myCoupon:view")
		@GetMapping()
		public String pay()
		{
		    return prefix + "/pay";
		}
}
