package gxa.dao;

import gxa.web.page.PageInfo;

import java.util.List;

public class EntityDao {
	Conn conn;

	public EntityDao() {
		super();
		conn = new Conn();
	}
	
	
		 public List getAll(String sql,String sql2,Object obj,PageInfo pageinfo){
			 return conn.getAll(sql,sql2,obj,pageinfo);
	}

		 //DML操作，包含增删改
		 public int dml(String sql){
			 return conn.excuteDML(sql);
		 }
		 public Object getOBJById(String sql,Object objExample){
				return conn.getOBJById(sql, objExample);
			}
}
