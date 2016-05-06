package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Wgxx;
import gxa.db.Zy;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class ZyService  implements  WgxxforZy {
	EntityDao dao;
	public ZyService() {
		super();
		dao = new EntityDao();
	}
	public List getAllZy(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from [zy]","select count(*) from [zy]",new Zy(),pageinfo);
	}
	public Zy getZyById(String id){
		return (Zy)dao.getOBJById("select * from [zy] where zy_id = " + id, new Zy());
	} 
	public String getNewById(){
		String oldId= ((Zy)dao.getOBJById("select top 1 zy_id from zy order by zy_id desc", new Zy())).getZy_id();
	   return ProcessSql.processPk(oldId);
	} 
	//外键
	public List getAllZy() {
		// TODO Auto-generated method stub
		return dao.getAll("select * from zy", null,new Zy(),null);
	}
	public String deleteById(String id){
		String sql = "delete from zy where zy_id = " +id;
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
	public String add(Zy zy){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(zy));
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Zy zy){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(zy));
			if(rs>0){
				msg="修改成功，共修改"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}

}
