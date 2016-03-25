package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Cloting;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class ClotingService {
	EntityDao dao;
	SuppliersforCloting suppliersforCloting;
	

	
	public ClotingService() {
		super();
		suppliersforCloting=new Supplierservice();
		dao = new EntityDao();
	
	}
	public List getAllCloting(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from cloting", "select count(*) from cloting",new Cloting(),pageinfo);
	}
	public Cloting getClotingById(String id){
		return (Cloting)dao.getOBJById("select * from Cloting where f_id = " + id, new Cloting());
	} 
	public String getNewById(){
		String oldId= ((Cloting)dao.getOBJById("select top 1 f_id from cloting order by f_id desc", new Cloting())).getF_id();
	   return ProcessSql.processPk(oldId);
	} 
	//删除
	public String deleteById(String id){
		String sql="delete from cloting where f_id="+id;
		String msg;
		int rs=dao.dml(sql);
		if(rs>=0){
			msg="删除成功！共删除"+rs+"条记录";
			
		}else{
			msg="删除失败!";
		}
		return msg;
	}
	
	//添加
	
	public String add(Cloting cloting){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(cloting));
		if(rs>=0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Cloting cloting){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(cloting));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
	public List getsuppliers(){
		
		return suppliersforCloting.getAllsupplier();
		
	}
}


