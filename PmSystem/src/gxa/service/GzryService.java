package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Gzry;
import gxa.db.Wgxx;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class GzryService {
	EntityDao dao;
	GzryforWgxx gzryforwgxx;
	public GzryService() {
		super();
		dao = new EntityDao();
		gzryforwgxx = new WgxxService();
	}
	public List getAllGzry(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from [gzry]","select count(*) from [gzry]",new Gzry(),pageinfo);
	}
	public Gzry getGzryById(String id){
		return (Gzry)dao.getOBJById("select * from [gzry] where gz_bianhao = " + id, new Gzry());
	}
	public String getNewById(){
		String oldId= ((Gzry)dao.getOBJById("select top 1 gz_bianhao from gzry order by gz_bianhao desc", new Gzry())).getGz_bianhao();
	   return ProcessSql.processPk(oldId);
	} 
	//用于删除
	public String deleteById(String id){
		String sql = "delete from gzry where gz_bianhao = " +id;
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
	public String add(Gzry gzry){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(gzry));
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Gzry gzry){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(gzry));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
	public List getwgxx(){		
		return gzryforwgxx.getAllWgxx();		
	}
}