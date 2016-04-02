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
import com.dating.dao.AgreementDao;
import com.dating.dao.BooksDao;
import com.dating.entity.Agreement;
import com.dating.entity.Books;
import com.dating.entity.User;

public class AgreementDaoImpl extends GenerateDaoImpl<Agreement> implements AgreementDao{


	
	@Override
	public List<Agreement> findByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Agreement> list = null;
		conn = DBManager.getConn();		
		try {

			ps = conn.prepareStatement("select *  from agreement where y_name like'%"+name+"%' or y_area like '%"+name+"%'");
			System.out.println("select *  from agreement where y_name like'%"+name+"%' or y_area like '%"+name+"%'");
			rs = ps.executeQuery();
			list = new ArrayList<Agreement>();
			Field[] fields = Agreement.class.getDeclaredFields();
			while(rs.next()){
				Agreement obj = Agreement.class.newInstance();
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
	public List<Agreement> findByTag(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Agreement> list = null;
		conn = DBManager.getConn();		
		try {
			
			ps = conn.prepareStatement("select *  from agreement where y_fs='"+name+"'");
			rs = ps.executeQuery();
			list = new ArrayList<Agreement>();
			Field[] fields = Agreement.class.getDeclaredFields();
			while(rs.next()){
				Agreement obj = Agreement.class.newInstance();
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

	
	 private void initObject(Agreement user, Field[] fields, ResultSet rs)  
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
	@Override
	public String saveAgree(Agreement ags) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String maxId = null;
		conn = DBManager.getConn();		
		String tableName = "agreement";
		StringBuilder placeHolders = new StringBuilder(); //Õ¼Î»·û
		StringBuilder fieldNames = new StringBuilder();//×Ö¶ÎÃû
		List<Object> values = new ArrayList<Object>();//×Ö¶ÎÖµ
		Field[] fields = Agreement.class.getDeclaredFields();	
		for(Field field:fields){
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), Agreement.class);
				if(field.isAnnotationPresent(Id.class)){
				}else if(field.isAnnotationPresent(Column.class)){
					fieldNames.append(field.getAnnotation(Column.class).value()).append(",");
					values.add(pd.getReadMethod().invoke(ags));
					placeHolders.append("?").append(",");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fieldNames.deleteCharAt(fieldNames.length()-1);  
		placeHolders.deleteCharAt(placeHolders.length()-1);  
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(tableName).append("(")
		.append(fieldNames.toString()).append(") values (").append(placeHolders)
		.append(")");
		try {
			ps = conn.prepareStatement(sql.toString());
			setParameter(values, ps);
			ps.execute();
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
			while (rs.next()) {		
				maxId = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.closeConn(conn);
		}
		
			return maxId;
		
	}
	@Override
	public Agreement findByCreate(String y_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Agreement obj = null;
		conn = DBManager.getConn();		
		try {
			ps = conn.prepareStatement("select * from Agreement where y_id ='"+y_id+"'");
			rs = ps.executeQuery();
			Field[] fields = Agreement.class.getDeclaredFields();
			while (rs.next()) {
				obj = Agreement.class.newInstance();
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
	
}

	
