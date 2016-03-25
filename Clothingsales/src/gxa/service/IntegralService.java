package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Employee;
import gxa.db.Integral;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;
public class IntegralService {
	static EntityDao dao;

	public IntegralService() {
		super();
		dao = new EntityDao();
	}
	public static List getAllIntegral(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from Integral", "select count(*) from Integral ",new Integral(),pageinfo);
	}

	public Integral getIntegralById(String id){
		return (Integral)dao.getOBJById("select * from Integral where i_id = " + id, new Integral());
	} 


	public static String deleteById(String id){
		String sql = "delete from Integral where i_id = " + id;
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
		public String add(Integral integral){
		    String msg = "";
			int rs = dao.dml(ProcessSql.processInsert(integral));
			if(rs>=0){
				msg="添加成功，共添加了"+rs+"条记录";
			}else{
				msg="添加失败";	
			}
			return msg;
		}
		public String update(Integral integral){
			 String msg = "";
				int rs = dao.dml(ProcessSql.processUpdate(integral));
				if(rs>0){
					msg="修改成功，共修改加了"+rs+"条记录";
				}else{
					msg="修改失败";	
				}
				return msg;
		}
}
