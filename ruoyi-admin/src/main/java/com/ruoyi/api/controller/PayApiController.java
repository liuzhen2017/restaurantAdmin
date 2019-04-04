/*package com.ruoyi.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.base.AjaxResult;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
@RequestMapping("/api/payApi/")
public class PayApiController {
	@Value("${stripePay.secret_key}")
	String secretKey;

	
	 * 查询短信發送記錄列表
	 
	@PostMapping("payment")
	@ResponseBody
	public AjaxResult payment(String email, String tokenId, int ammount) {

		Stripe.apiKey = secretKey;

		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", ammount);
		chargeParams.put("currency", "usd");
		chargeParams.put("description", "購買會員");
		chargeParams.put("source", tokenId);
		try {
			
			Charge charge = Charge.create(chargeParams);
			if(charge.getStatus().equals("succeeded")){
				return AjaxResult.success("支付成功!感謝您的購買!");				
			}else{
				return AjaxResult.error("支付失敗！請重試,Code="+charge.getStatus());	
			}
		} catch (StripeException e) {
			e.printStackTrace();
			return AjaxResult.error("支付失敗！請重試");
		}
	}

	public static void main(String[] args) {
//		new PayApiController().stripePay("29@qq.com,", "sssss", 1000);
	}
}
*/