package com.company.transport.dao;

import com.company.transport.pojo.User;

public interface UserDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}