package com.company.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.company.transport.pojo.User;
import com.company.utils.bean.EntityAndMap;

/**
 * 当把Person类作为BeanUtilTest的内部类时，程序出错<br>
 * java.lang.NoSuchMethodException: Property '**' has no setter method<br>
 * 本质：内部类 和 单独文件中的类的区别 <br>
 * BeanUtils.populate方法的限制：<br>
 * The class must be public, and provide a public constructor that accepts no
 * arguments. <br>
 * This allows tools and applications to dynamically create new instances of
 * your bean, <br>
 * without necessarily knowing what Java class name will be used ahead of time
 */
public class BeanUtilTest {
	
	
	private static Logger logger = Logger.getLogger(BeanUtilTest.class);
    
    
    @Test
    public void test1(){
    	//测试map  to  bean 
    	Map map = new HashMap();
    	map.put("username","1");
    	map.put("password2","1");
    	
    	User user  = new User();
    	
    	user = (User) EntityAndMap.mapToBean(map,user);
    	
    	logger.info("test():"+user.getUsername());
    }
    
    
    @Test
    public void test2(){
    	
    	Map map = new HashMap();
    	User user  = new User();
    	user.setUsername("2");
    	map = EntityAndMap.beanToMap(user);
    	logger.info("test2():"+map.get("username"));
    }
	
}
