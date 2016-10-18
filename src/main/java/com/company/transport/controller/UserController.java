package com.company.transport.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.transport.pojo.User;
import com.company.transport.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userTest")
	public String getUserById(HttpServletRequest request , Model model){
		
		int userId = 1;
		
		User user  = userService.getUserById(userId);
		
		model.addAttribute("user",user);
		
		return "UserTest";
	
	}
	
	
}
