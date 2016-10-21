package com.company.utils.encode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class Encode {

	private static Logger logger = Logger.getLogger(Encode.class);
	
	public static String enCodePassword(String password){
		
		
		MessageDigest md ;
		Base64 base64 = new Base64();
		String enCode_password ="";
		
		try {
			md = MessageDigest.getInstance("MD5");
			enCode_password = new String(base64.encode(md.digest(password.getBytes("UTF-8"))));
			
		} catch (NoSuchAlgorithmException e1) {
			logger.equals("密码校验报错，请检查后台程序！------1");
			e1.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			logger.equals("密码校验报错，请检查后台程序！------2");
			e.printStackTrace();
		}
		
		return enCode_password;
		
	}
	
		
	
	
}
