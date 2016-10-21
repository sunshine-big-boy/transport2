package com.company.transport.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.transport.pojo.User;
import com.company.transport.service.UserService;
import com.company.utils.bean.EntityAndMap;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Map login(@RequestBody User user,HttpSession session) throws Exception{
		
		Map data = new HashMap();
		
		if(user.getUsername() == null||user.getUsername().equals("")){
			throw new Exception("没有传入user");
		}
		
		logger.info("用户:"+user.getUsername()+",尝试登录系统，时间："+new Date());
		
		String returnS = userService.login(user);
		
		if(returnS.equals("pass")){
			session.setAttribute("user", user);
		}
		
		data.put("message", returnS);
		data.put("url","main.html");
		data.put("user", user);
		
		return data;
		
	}
		
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/register",method={RequestMethod.POST})
	public Map register(@RequestBody Map<String, Object> map){
		
		Map data  = new HashMap();
		
		User user = new User();
		user = (User)EntityAndMap.mapToBean(map, user);
		
		logger.info(user.getUsername());
		
		
		
		String resutrnS = userService.register(user);
		
		data.put("message", resutrnS);
		data.put("user", user);
		
		logger.info("用户:"+user.getUsername()+",尝试注册用户，时间："+new Date());
		
		return data;
	}
	
	
	
}
