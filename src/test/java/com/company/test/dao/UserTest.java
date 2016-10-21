package com.company.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.transport.pojo.User;
import com.company.transport.service.UserService;
import com.company.utils.encode.Encode;
import com.company.utils.formatdate.DateFormat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class UserTest {

	private static Logger logger = Logger.getLogger(UserTest.class);
	

	@Resource
	private UserService userService;
	
	
//	@Test
//	public void test1() throws Exception {
//		
//		User user = new User();
//		user.setUsername("111");
//		user.setPassword("111");
//		
//		logger.info(Encode.enCodePassword("111"));
//		logger.info(userService.login(user));
//	}
	
	
	
	@Test
	public void test2() throws ParseException {
		
		
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date ret  = yyyyMMdd.parse(yyyyMMdd.format(new Date()));
		
		logger.info(ret);
	}
	
}
