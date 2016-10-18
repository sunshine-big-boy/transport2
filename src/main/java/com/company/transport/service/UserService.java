package com.company.transport.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.company.transport.dao.UserDao;
import com.company.transport.pojo.User;


@Service("userService")
public class UserService implements baseService {


	@Resource
	private UserDao userDao;

	public User getUserById(int id){
		return userDao.selectByPrimaryKey(id);
	}
	
}
