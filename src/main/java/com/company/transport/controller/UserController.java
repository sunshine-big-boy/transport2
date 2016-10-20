package com.company.transport.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.transport.pojo.User;
import com.company.transport.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Map login(@RequestBody User user,Map map) throws Exception{
		
		logger.info("调用UserController");
		
		if(user.getUsername() == null||user.getUsername().equals("")){
			throw new Exception("没有传入user");
		}
		
		String returnS = userService.login(user);
		
		map.put("message", returnS);
		map.put("test", "test");
		map.put("user", user);
		
		return map;
		
	}
		
	
	
	@RequestMapping(value="/test",method={RequestMethod.POST})
	public @ResponseBody User test(@RequestBody User user){
		
		logger.info(user.getUsername());
		return user;
		
	}
	
	
	
}
