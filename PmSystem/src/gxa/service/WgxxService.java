package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wgxx;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class WgxxService implements YzforWgxx, GzryforWgxx  {
	EntityDao dao;
	WgxxforZy wgxxforzy;

	public WgxxService() {
		super();
		dao = new EntityDao();
		wgxxforzy = new ZyService();
	}
	public List getAllWgxx(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from [wgxx]","select count(*) from [wgxx]",new Wgxx(),pageinfo);
	}
	public Wgxx getWgxxById(String id){
		return (Wgxx)dao.getOBJById("select * from [wgxx] where w_id = " + id, new Wgxx());
	} 
	public String getNewById(){
		String oldId= ((Wgxx)dao.getOBJById("select top 1 w_id from wgxx order by w_id desc", new Wgxx())).getW_id();
	   return ProcessSql.processPk(oldId);
	} 
	
	//用于删除
	public String deleteById(String id){
		String sql = "delete from wgxx where w_id = " +id;
		String msg;
		int rs = dao.dml(sql);
		if(rs>0){
			msg="删除成功，共删除了"+rs+"条记录";
		}else{
			msg="删除失败";	
		}
		return msg;
	}
	//用于添加
	public String add(Wgxx wgxx){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(wgxx));
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	
	public String update(Wgxx wgxx){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(wgxx));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
	
	
	public List getAllWgxx() {
		// TODO Auto-generated method stub
		return dao.getAll("select * from wgxx", null,new Wgxx(),null);
	}
	
	public List getzy(){		
		return wgxxforzy.getAllZy();		
	}

}
