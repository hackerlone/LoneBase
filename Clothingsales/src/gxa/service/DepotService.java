package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Customer;
import gxa.db.Depot;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;
public class DepotService implements DepotforEmployee {
	static EntityDao dao;

	public DepotService() {
		super();
		dao = new EntityDao();
	}
	public List getAllDepot(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from depot", "select count(*) from depot ",new Depot(),pageinfo);
	}
	public Depot getDepotById(String id){
		return (Depot)dao.getOBJById("select * from depot where d_id = " + id, new Depot());
	} 

	public List getAllDepot(){
		//.class表示类型
		return dao.getAll("select * from depot", null,new Depot(),null);
	}

	
	public static String deleteById(String id){
		String sql = "delete from depot where d_id = " + id;
		String msg;
		int rs = dao.dml(sql);
		if(rs >= 0){
			msg = "删除成功，共删除了"+rs+"条记录";
		}else{
			msg = "删除失败";
		}
		return  msg;
	}
	//用于添加
	public String add(Depot depot){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(depot));
		if(rs>=0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Depot depot){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(depot));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
}

