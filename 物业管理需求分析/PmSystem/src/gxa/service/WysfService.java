package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wysf;
import gxa.db.Yz;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class WysfService {
	EntityDao dao;
	WysfforYz wysfforyz;
	public WysfService() {
		super();
		wysfforyz = new YzService();
		dao = new EntityDao();
	}
	public List getAllYz(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from [wysf]","select count(*) from [wysf]",new Wysf(),pageinfo);
	}
	public Wysf getWysfById(String id){
		return (Wysf)dao.getOBJById("select * from [wysf] where sh_id = " + id, new Wysf());
	}
	public String getNewById(){
		String oldId= ((Wysf)dao.getOBJById("select top 1 sh_id from wysf order by sh_id desc", new Wysf())).getSh_id();
	   return ProcessSql.processPk(oldId);
	} 
	//用于删除
	public String deleteById(String id){
		String sql = "delete from wysf where sh_id = " +id;
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
	public String add(Wysf wysf){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(wysf));
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Wysf wysf){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(wysf));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
	public List getwysf(){		
		return wysfforyz.getAllYz();		
	}

}