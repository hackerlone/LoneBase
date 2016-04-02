package com.dating.dao.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import annotation.Column;
import annotation.Id;

import com.daing.utils.DBManager;
import com.dating.dao.BooksDao;
import com.dating.entity.Books;
import com.dating.entity.User;

public class BooksDaoImpl extends GenerateDaoImpl<Books> implements BooksDao{

	@Override
	public List<Books> findAllmsg(String tid, String uid) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Books> list = null;
			conn = DBManager.getConn();		
			try {
				ps = conn.prepareStatement("select * from Books where t_id='"+tid+"' and u_id='"+uid+"'");
				System.out.println("select * from Books where t_id='"+tid+"and u_id='"+uid+"'");
				rs = ps.executeQuery();
				list = new ArrayList<Books>();
				Field[] fields = Books.class.getDeclaredFields();
				while(rs.next()){
					Books obj = Books.class.newInstance();
					initObject(obj, fields, rs);
					list.add(obj);
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBManager.closeConn(conn);
			}
			return list;
		}
	


	
	 private void initObject(Books user, Field[] fields, ResultSet rs)  
	            throws SQLException, IntrospectionException,  
	            IllegalAccessException, InvocationTargetException {  
	        for (Field field : fields) { 
	        	String propertyName = field.getName();
	            String columnName = "";  
	            if(field.isAnnotationPresent(Id.class)){
	            	columnName = field.getAnnotation(Id.class).value();
	            }else if(field.isAnnotationPresent(Column.class)){
	            	columnName = field.getAnnotation(Column.class).value();
	            }
	            Object paramVal = null;  
	            Class<?> clazzField = field.getType();  
	            if (clazzField == String.class) {  
	                paramVal = rs.getString(columnName);  
	            } else if (clazzField == short.class || clazzField == Short.class) {  
	                paramVal = rs.getShort(columnName);  
	            } else if (clazzField == int.class || clazzField == Integer.class) {  
	                paramVal = rs.getInt(columnName);  
	            } else if (clazzField == long.class || clazzField == Long.class) {  
	                paramVal = rs.getLong(columnName);  
	            } else if (clazzField == float.class || clazzField == Float.class) {  
	                paramVal = rs.getFloat(columnName);  
	            } else if (clazzField == double.class || clazzField == Double.class) {  
	                paramVal = rs.getDouble(columnName);  
	            } else if (clazzField == boolean.class || clazzField == Boolean.class) {  
	                paramVal = rs.getBoolean(columnName);  
	            } else if (clazzField == byte.class || clazzField == Byte.class) {  
	                paramVal = rs.getByte(columnName);  
	            } else if (clazzField == char.class || clazzField == Character.class) {  
	                paramVal = rs.getCharacterStream(columnName);  
	            } else if (clazzField == Date.class) {  
	                paramVal = rs.getTimestamp(columnName);  
	            } else if (clazzField.isArray()) {  
	                paramVal = rs.getString(columnName).split(",");   //ÒÔ¶ººÅ·Ö¸ôµÄ×Ö·û´®  
	            }   
	            PropertyDescriptor pd = new PropertyDescriptor(propertyName,user.getClass());  
	            pd.getWriteMethod().invoke(user, paramVal);  
	        }  
	 }
	
}

	
