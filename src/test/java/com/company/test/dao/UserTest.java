package com.company.test.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.transport.pojo.User;
import com.company.transport.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class UserTest {

	private static Logger logger = Logger.getLogger(UserTest.class);
	

	@Resource
	private UserService userService;
	
	
	@Test
	public void test1() throws Exception {
		User user = userService.getUserById(1);
		MessageDigest md = MessageDigest.getInstance("MD5");
		Base64 base64 = new Base64();
		
		byte[] b = md.digest(user.getPassword().getBytes("utf-8"));
		
		String md5 = new String(b);
		
		b = base64.encode(b);
		
		String base4  = new String(b);
		
		
		logger.info(user.getPassword());
		logger.info(md5);
		logger.info(base4);
	}
	
	
}
