package gxa.dao;

import gxa.web.page.PageInfo;

import java.sql.ResultSet;
import java.util.List;

public class EntityDao {
	Conn conn;

	public EntityDao() {
		super();
		conn = new Conn();
	}
	 //分页查询
	public List getAll(String sql,String sql2,Object obj,PageInfo pageinfo){
		 return conn.getAll(sql,sql2,obj,pageinfo);	
	}
	//dml操作，包含增删改
	public int dml(String sql){
		return conn.excuteDML(sql);
	}
	public Object getOBJById(String sql,Object objExample){
		return conn.getOBJById(sql, objExample);
	}
	public ResultSet check(String sql){
		return conn.checkUser(sql);
	}

}
