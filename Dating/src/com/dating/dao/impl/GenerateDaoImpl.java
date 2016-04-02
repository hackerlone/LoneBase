package com.dating.dao.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import annotation.Bean;
import annotation.Column;
import annotation.Id;

import com.daing.utils.DBManager;
import com.dating.dao.GenerateDao;

public class GenerateDaoImpl<T> implements GenerateDao<T> {

	private final Class<T> clazz;
	public GenerateDaoImpl(){
		clazz = (Class<T>)((ParameterizedType)getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	public void delete(T entity) {
		String tableName = getTableName(clazz);
		Field[] fields = clazz.getDeclaredFields();  
		String idFieldName = "";  
		Object idValue=null;
        boolean flag = false;  
        for (Field field : fields) {  
            if(field.isAnnotationPresent(Id.class)) {  
            	PropertyDescriptor pd;
				try {
					pd = new PropertyDescriptor(field.getName(), clazz);
					idFieldName = field.getAnnotation(Id.class).value();
		            idValue=pd.getReadMethod().invoke(entity);
		            flag = true;
		            break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }  
        }     
        Connection conn = null;
        String sql = "delete from " + tableName + " where " + idFieldName + "=?";  
        PreparedStatement ps;
		try {
			conn = DBManager.getConn();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, idValue); 
		    ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.closeConn(conn);
		}	
	}
	public List<T> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = null;
		conn = DBManager.getConn();		
		String tableName = getTableName(clazz);
		try {
			ps = conn.prepareStatement("select * from "+tableName);
			System.out.println("select * from "+tableName);
			
			rs = ps.executeQuery();
			list = new ArrayList<T>();
			String[] colNames = getColNames(rs);
			Method[] ms = clazz.getMethods();
			Field[] fields = clazz.getDeclaredFields();
			while(rs.next()){
//				System.out.println(rs.getString("z_name"));
				T obj = clazz.newInstance();
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

	public T findById(Object id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T obj = null;
		conn = DBManager.getConn();		
		String tableName = getTableName(clazz);
		try {
			Field[] fields = clazz.getDeclaredFields();
			String idColumn = "";
			for(Field field:fields){
				if(field.isAnnotationPresent(Id.class)){
					idColumn = field.getAnnotation(Id.class).value();
				}
			}
			ps = conn.prepareStatement("select * from "+tableName+" where "+idColumn+" ='"+id+"'");
			rs = ps.executeQuery();
			String[] colNames = getColNames(rs);
			Method[] ms = clazz.getMethods();
			while(rs.next()){
				obj = clazz.newInstance();
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

	public void save(T entity) {

		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBManager.getConn();		

		String tableName = getTableName(clazz);
		StringBuilder placeHolders = new StringBuilder(); //占位符
		StringBuilder fieldNames = new StringBuilder();//字段名
		List<Object> values = new ArrayList<Object>();//字段值

		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field:fields){
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				if(field.isAnnotationPresent(Id.class)){
				}else if(field.isAnnotationPresent(Column.class)){
					fieldNames.append(field.getAnnotation(Column.class).value()).append(",");
					values.add(pd.getReadMethod().invoke(entity));
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.closeConn(conn);
		}
	}

	public void update(T entity) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBManager.getConn();		

		String tableName = getTableName(clazz);
		
		 List<Object> fieldNames = new ArrayList<Object>();  //字段名  
	     List<Object> fieldValues = new ArrayList<Object>(); //字段值  
	     List<String> placeholders = new ArrayList<String>();//占位符  
		
	     Field[] fields = clazz.getDeclaredFields();  

		String idFieldName = "";  
        Object idFieldValue = "";  
		
		for(Field field:fields){
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				if(field.isAnnotationPresent(Id.class)){
					idFieldName = field.getAnnotation(Id.class).value();  
	                idFieldValue = pd.getReadMethod().invoke(entity); 
				}else if(field.isAnnotationPresent(Column.class)){
					fieldNames.add(field.getAnnotation(Column.class).value());  
	                fieldValues.add(pd.getReadMethod().invoke(entity));  
	                placeholders.add("?");  
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		fieldNames.add(idFieldName);  
        fieldValues.add(idFieldValue);  
        placeholders.add("?");  
		
        StringBuilder sql = new StringBuilder("");  
        sql.append("update ").append(tableName).append(" set ");  
        int index = fieldNames.size() - 1;  
        for (int i = 0; i < index; i++) {  
            sql.append(fieldNames.get(i)).append("=").append(placeholders.get(i)).append(",");  
        }  
        sql.deleteCharAt(sql.length()-1).append(" where ").append(fieldNames.get(index)).append("=").append("?");  
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql.toString());
			setParameter(fieldValues, ps);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.closeConn(conn);
		}
	}
	
    private String getTableName(Class clazz) {  
    	Bean b = (Bean) clazz.getAnnotation(Bean.class);
    	String v = b.value();
    	return v;
    }  

	private static String[] getColNames(ResultSet rs) throws Exception{
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		String[] colNames = new String[count];
		for(int i=0;i<count;i++){
			colNames[i] = rsmd.getColumnLabel(i+1);
		}
		return colNames;
	}
	
	public void setParameter(List<Object> values,PreparedStatement ps) throws SQLException{
		for(int i=1;i<=values.size();i++){
			Object fieldValue = values.get(i-1);
			if(fieldValue != null){
				Class clazzValue = fieldValue.getClass();
				if(clazzValue == String.class){
					ps.setString(i, (String)fieldValue);
				} else if (clazzValue == boolean.class || clazzValue == Boolean.class) {  
	                ps.setBoolean(i, (Boolean)fieldValue);  
	            } else if (clazzValue == byte.class || clazzValue == Byte.class) {  
	                ps.setByte(i, (Byte)fieldValue);  
	            } else if (clazzValue == char.class || clazzValue == Character.class) {  
	                ps.setObject(i, fieldValue,Types.CHAR);  
	            } else if (clazzValue == Date.class) {  
	                ps.setTimestamp(i, new Timestamp(((Date) fieldValue).getTime()));  
	            } else if (clazzValue.isArray()) {  
	                Object[] arrayValue = (Object[]) fieldValue;  
	                StringBuffer sb = new StringBuffer();  
	                for (int j = 0; j < arrayValue.length; j++) {  
	                    sb.append(arrayValue[j]).append("、");  
	                }  
	                ps.setString(i, sb.deleteCharAt(sb.length()-1).toString());  
	            } else {  
	                ps.setObject(i, fieldValue, Types.NUMERIC);  
	            }  
			}else{
				ps.setObject(i, null);
			}	
		}
	}

    private void initObject(T t, Field[] fields, ResultSet rs)  
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
                paramVal = rs.getString(columnName).split(",");   //以逗号分隔的字符串  
            }   
            PropertyDescriptor pd = new PropertyDescriptor(propertyName,t.getClass());  
            pd.getWriteMethod().invoke(t, paramVal);  
        }  
    }
    
    
    public static void updateHead(String fileName,String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBManager.getConn();		
			try {	
				ps = conn.prepareStatement("update user set u_head='"+fileName+"' where u_id='"+id+"'");
				System.out.println("update user set u_head='"+fileName+"' where u_id='"+id+"'");
				ps.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

