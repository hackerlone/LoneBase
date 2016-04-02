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
import com.dating.dao.YuDao;
import com.dating.entity.Yu;

public class YuDaoImpl extends GenerateDaoImpl<Yu> implements YuDao{

	public List<Yu> findById1(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Yu> list = null;
		conn = DBManager.getConn();		
		try {

			ps = conn.prepareStatement("select  *, count(distinct yu_id) from Yu where yu_id='"+id+"' group by yu_id");
			System.out.println("select * from User where u_sex='"+id+"'");
			rs = ps.executeQuery();
			list = new ArrayList<Yu>();
			Field[] fields = Yu.class.getDeclaredFields();
			while(rs.next()){
				Yu obj = Yu.class.newInstance();
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
	public List<Yu> findById8(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Yu> list = null;
		conn = DBManager.getConn();		
		try {
			
			ps = conn.prepareStatement("select  * from Yu where y_id='"+id+"'");
			System.out.println("select  * from Yu where y_id='"+id+"'");
			rs = ps.executeQuery();
			list = new ArrayList<Yu>();
			Field[] fields = Yu.class.getDeclaredFields();
			while(rs.next()){
				Yu obj = Yu.class.newInstance();
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
	public List<Yu> findById9(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Yu> list = null;
		conn = DBManager.getConn();		
		try {
			
			ps = conn.prepareStatement("select  * from Yu where u_id='"+id+"'");
			System.out.println("select  * from Yu where u_id='"+id+"'");
			rs = ps.executeQuery();
			list = new ArrayList<Yu>();
			Field[] fields = Yu.class.getDeclaredFields();
			while(rs.next()){
				Yu obj = Yu.class.newInstance();
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


	
	 private void initObject(Yu user, Field[] fields, ResultSet rs)  
	            throws SQLException, IntrospectionException,  
	            IllegalAccessException, InvocationTargetException {  
	        for (Field field : fields) { 
	        	String propertyName = field.getName();
	            String columnName = "";  
	          if(field.isAnnotationPresent(Column.class)){
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



	@Override
	public List<Yu> findById2(String yu_id, String y_id, String u_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Yu> list = null;
		conn = DBManager.getConn();		
		try {

			ps = conn.prepareStatement("select *  from Yu where yu_id='"+yu_id+"' and y_id='"+y_id+"' and u_id='"+u_id+"'");
			rs = ps.executeQuery();
			list = new ArrayList<Yu>();
			Field[] fields = Yu.class.getDeclaredFields();
			while(rs.next()){
				Yu obj = Yu.class.newInstance();
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
	public void save(String yu_id, String y_id, String u_id, String yuData,
			String yuEnddata) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		conn = DBManager.getConn();	
		try {

			ps = conn.prepareStatement("insert into yu(yu_id,y_id,u_id,yu_data,yu_enddata)"
					+ " values('"+yu_id+"','"+y_id+"','"+u_id+"','"+yuData+"','"+yuEnddata+"')");
			
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.closeConn(conn);
		}
	}


	
}

	
