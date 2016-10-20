package com.company.transport.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.company.transport.dao.UserDao;
import com.company.transport.pojo.User;
import com.company.utils.encode.Encode;


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
			return "pass";
		}else{
			return "noPass";
		}
		
	
	}
	
	public String signin(User user){
		
		User user_db = new User();
		user_db = userDao.selectByName(user.getUsername());
		
		if(user_db!=null){
			return "exist";
		}else{
			user.setPassword(Encode.enCodePassword(user.getPassword()));
			user.setLastLogin(new Date());
			userDao.insert(user);
			return "success";
		}
		
	}
	
}
