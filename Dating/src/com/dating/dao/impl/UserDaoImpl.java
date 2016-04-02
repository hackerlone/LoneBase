package com.dating.dao.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import com.dating.dao.UserDao;
import com.dating.entity.User;

public class UserDaoImpl extends GenerateDaoImpl<User> implements UserDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<User> findByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		conn = DBManager.getConn();		
		try {
			ps = conn.prepareStatement("select * from User where u_name like'%"+name+"%' or u_email like '%"+name+"%'");
			rs = ps.executeQuery();
			list = new ArrayList<User>();
			Field[] fields = User.class.getDeclaredFields();
			while(rs.next()){
//				System.out.println(rs.getString("z_name"));
				User obj = User.class.newInstance();
//				System.out.println("0000"+rs.getString("z_name"));
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
	public List<User> findBySex(String sex) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		conn = DBManager.getConn();		
		try {
			ps = conn.prepareStatement("select * from User where u_sex='"+sex+"'");
			System.out.println("select * from User where u_sex='"+sex+"'");
			rs = ps.executeQuery();
			list = new ArrayList<User>();
			Field[] fields = User.class.getDeclaredFields();
			while(rs.next()){
				User obj = User.class.newInstance();
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
	
	@Override
	public User login(String username, String password) {
		User obj = null;
		conn = DBManager.getConn();		
		try {
			ps = conn.prepareStatement("select * from User where 1=1 and (u_name ='"+username+"' or u_email = '"+username+"') and u_pwd = '"+password+"'");
			System.out.println("select * from User where 1=1 and (u_name ='"+username+"' or u_email = '"+username+"') and u_pwd = '"+password+"'");
			rs = ps.executeQuery();
			Field[] fields = User.class.getDeclaredFields();
			while (rs.next()) {
				obj = User.class.newInstance();
				initObject(obj, fields, rs);	
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
		return obj;
	}	
	
	
	
	
	 private void initObject(User user, Field[] fields, ResultSet rs)  
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
