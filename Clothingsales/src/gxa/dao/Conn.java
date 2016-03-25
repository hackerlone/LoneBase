package gxa.dao;


import gxa.web.page.PageInfo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Conn {
 
	private final String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Clothingsales";
	private final String UNAME = "sa";
	private final String UPWD = "123";
	
	private Connection connection;
	private PreparedStatement prep;
	//构造方法，初始化数据库连接，只执行一次
	public Conn() {
	   try {
		Class.forName(DriverName);//1.加载驱动
		connection = DriverManager.getConnection(URL,UNAME,UPWD);//2.创建连接
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}
	//查询所有,参数1为传入的SQL语句，参数2为返回的对象集合中，对象的类型,(为类的类型)
    public List getAll(String sql,String sql2,Object objExample,PageInfo pageinfo){
       if(sql2!=null){
    	int count =  getRecordsCount(sql2);//先求出总记录数
        pageinfo.setItemCount(String.valueOf(count));//将总记录数保存到pageinfo对象
       }
    	List list = new ArrayList();//空的对象集合
    	try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//3.填写SQL语句
			//设置取多少条记录
			ResultSet rs=null;
			if(pageinfo!=null){
			st.setMaxRows(Integer.parseInt(pageinfo.getFirstResult())+
					Integer.parseInt(pageinfo.getMaxResults()));
			 rs = st.executeQuery(sql);//4.执行SQL
			//System.out.println(pageinfo.getFirstResult());
			
			rs.absolute(Integer.parseInt(pageinfo.getFirstResult()));
			}else{
				 rs = st.executeQuery(sql);
			}
			
            //rs.setFetchSize(Integer.parseInt(pageinfo.getMaxResults()));
            //将普通结果集转换为动态对象结果集
			ResultSetDynaClass rsds = new ResultSetDynaClass(rs);

			//转为链式结果集
			Iterator rows = rsds.iterator();
			
			while(rows.hasNext()){
				//根据类型创建一个该类型新的对象
				Object obj = objExample.getClass().newInstance();
				//将动态数据结果集的一行，转换为一个动态对象
				DynaBean row = (DynaBean)rows.next();
				//将动态对象的属性全部对应的存入指定对象
				BeanUtils.copyProperties(obj, row); 
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return list;
    }
    //获得某张表的总记录数
    public int getRecordsCount(String sql){
    	 int count = 0;
    	try {
			prep = connection.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			if(rs.next()){
			 count = rs.getInt(1);//由于该统计记录数的查询只会返回一个整数
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return count;
    }
    
    //查询单个
    public Object getOBJById(String sql,Object objExample){
    
        
        	try {
    			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//3.填写SQL语句
    			//设置取多少条记录
    			ResultSet rs=null;
    			
    			 rs = st.executeQuery(sql);//4.执行SQL
    			
    				 rs = st.executeQuery(sql);
    			ResultSetDynaClass rsds = new ResultSetDynaClass(rs);

    			//转为链式结果集
    			Iterator rows = rsds.iterator();
    			
    			while(rows.hasNext()){
    				//根据类型创建一个该类型新的对象
    				Object obj = objExample.getClass().newInstance();
    				//将动态数据结果集的一行，转换为一个动态对象
    				DynaBean row = (DynaBean)rows.next();
    				//将动态对象的属性全部对应的存入指定对象
    				BeanUtils.copyProperties(obj, row); 
    		        return obj;
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (InvocationTargetException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	return null;
    	
    }
    public int excuteDML(String sql){
    	int rs=0;
    	try {
			prep = connection.prepareStatement(sql);
			rs=prep.executeUpdate();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//3.填写SQL语句
 
    	return rs;
    }


	
}
