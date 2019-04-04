/**
 * 
 */
package com.ruoyi.util.sms;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * @author liuzhen
 *
 */
public class AESUtil {
	public static String pwd ="G5OT9NlaVnNU6g3z";
    /**
     * AES解密
     * @param content   密文
     * @param keyBytes  秘钥
     * @param iv        偏移量
     * @return          
     */
    public static String AES_CBC_Decrypt(String content){  
          
        try{  
        	content = content.replaceAll(" ", "+");
        	byte[] decryptBaseData=Base64.decodeBase64(content.getBytes("utf-8"));
            SecretKeySpec key = new SecretKeySpec(pwd.getBytes(), "AES");
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");  
            cipher.init(Cipher.DECRYPT_MODE, key);  
            byte[] result=cipher.doFinal(decryptBaseData);  
            return new String(result);  
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }  
        return null;  
    } 	
    /**
	 * AES加密
	 * @param content  明文
	 * @param keyBytes 秘钥
	 * @param iv      偏移量
	 * @return   
	 */
    public static String AES_CBC_Encrypt(String content){  
          
        try{ 
            SecretKeySpec key = new SecretKeySpec(pwd.getBytes(), "AES");
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");  
            cipher.init(Cipher.ENCRYPT_MODE, key);  
            byte[] result=cipher.doFinal(content.getBytes()); 
            return new String(Base64.encodeBase64(result),"UTF-8");
        }catch (Exception e) {  
            System.out.println("exception:"+e.toString());  
        }   
        return null;  
    }
    
    public static void main(String[] args) {
    	String info="CIs9wzASU03LkPp58In0uTb8rmxU2X2y5IxvFhX+AmU=";
// 	brandId=100&shopCode=SHOP001&invoiceNo=000-003553&invoiceAmount=1250&netAmound=1150&pax=3&orderType=1&paymentMethod=2&itemCodeQuantity=FOOD001%3A2%2CFOOD342%3A4%2CFOOD323%3A2&transactionDatetime=201504151759
    	String test = AES_CBC_Encrypt("100");
    	System.out.println(test);
    	System.out.println(AES_CBC_Decrypt(test));
    	/*try {
    		info=info.replace("http://www.storellet.com/a/qrCode/s=","").replace("&brandId=100","");
    		System.out.println(info);
			System.out.println(AES_CBC_Decrypt(info));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
