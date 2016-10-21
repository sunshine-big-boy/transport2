package com.company.transport.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.company.transport.dao.UserDao;
import com.company.transport.pojo.User;
import com.company.utils.encode.Encode;
import com.company.utils.formatdate.DateFormat;


@Service("userService")
public class UserService implements baseService {


	@Resource
	private UserDao userDao;
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(UserService.class);

	public String login(User user){
		
		User user_db = new User();
		user_db = userDao.selectByName(user.getUsername());
		String password_db = "";
		
		if(user_db == null){
			return "none";
		}else{
			password_db = user_db.getPassword();
		}
		
		//密码使用base64 和md5 加密
		String password = Encode.enCodePassword(user.getPassword());
		
		if(password.equals(password_db)){
			//密码通过，说明登录成功，回写表的last_login数据
			user_db.setLastLogin(DateFormat.formatToyyyyMMdd(new Date()));
			userDao.updateLastLoginById(user_db);
			return "pass";
		}else{
			return "noPass";
		}
		
	
	}
	
	public String register(User user){
		
		User user_db = new User();
		user_db = userDao.selectByName(user.getUsername());
		
		if(user_db!=null){
			return "exist";
			
		}else{
			user.setPassword(Encode.enCodePassword(user.getPassword()));
			user.setLastLogin(DateFormat.formatToyyyyMMdd(new Date()));
			userDao.insert(user);
			return "success";
		}
		
	}
	
}
