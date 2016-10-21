package com.company.utils.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EntityAndMap {

	
	/**
	 * @author lyt
	 * @param obj
	 * @return Map
	 * @description 将obj转化为map
	 */
	public static Map<String, Object> beanToMap(Object obj) {

		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			System.out.println("beanToMap error " + e);
		}

		return map;
	}

	/**
	 * @author lyt
	 * @param Map
	 * @return Object
	 * @description 将map转化为bean
	 */
	public static Object mapToBean(Map<String, Object> map,Object obj) {


		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}
			}

		} catch (Exception e) {
			System.out.println("mapToBean error :" + e);
		}

		return obj;
	}

	
	
	
	
}
