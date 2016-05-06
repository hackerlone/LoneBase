package com.Campus.convert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class TimestampConvert extends StrutsTypeConverter {
	public Object convertFromString(Map context, String[] values, Class clazz) {
		// TODO Auto-generated method stub
		String newstr = values[0].substring(0,10);
		return Timestamp.valueOf(newstr + " 00:00:00");
	}

	public String convertToString(Map context, Object obj) {
		Timestamp birthday = (Timestamp)obj;
		//System.out.println(birthday);
		DateFormat df = new 
		SimpleDateFormat("YYYY-MM-dd");
		return  df.format(birthday.getTime());
		
	}

}
