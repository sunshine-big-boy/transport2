package com.company.utils.formatdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	
	
	/**
	 * @author lyt
	 * @param date
	 * @return date
	 * @description 将date类型转化为标准yyyy-MM-dd HH:mm:ss，并以date格式返回
	 */
	public static Date formatToyyyyMMdd(Date date){
		
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date ret = null;
		
		try {
			ret = yyyyMMdd.parse(yyyyMMdd.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
}
