package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.BarAndPie;
import gxa.db.Cloting;
import gxa.db.Customer;
import gxa.db.Employee;
import gxa.servlet.CustomerS;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class CustomerService {
	EntityDao dao;

	public CustomerService() {
		super();
		dao = new EntityDao();
	}
	public List getAllcustomer(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from customer", "select count(*) from customer",new Customer(),pageinfo);
	}
	
	public Customer getCustomerById(String id){
		return (Customer)dao.getOBJById("select * from customer where k_id = " + id, new Customer());
	} 
	
	public String deleteById(String id){
		String sql = "delete from customer where k_id = " + id;
		String msg;
		int rs = dao.dml(sql);
		System.out.println(rs);
		if(rs >= 0){
			msg = "删除成功，共删除了"+rs+"条记录";
		}else{
			msg = "删除失败";
		}
		return  msg;
	}
	//用于添加
		public String add(Customer customer){
		    String msg = "";
			int rs = dao.dml(ProcessSql.processInsert(customer));
			if(rs>=0){
				msg="添加成功，共添加了"+rs+"条记录";
			}else{
				msg="添加失败";	
			}
			return msg;
		}
		public String update(Customer customer){
			 String msg = "";
				int rs = dao.dml(ProcessSql.processUpdate(customer));
				if(rs>0){
					msg="修改成功，共修改加了"+rs+"条记录";
				}else{
					msg="修改失败";	
				}
				return msg;
		}
		public List getBarAndPie(Customer k) {
			String sql="select datepart(MM,[time]) as item,count(*) as no from shop "
					+ "where k_id ="+k.getK_id() + " group by datepart(MM,[time])";
			System.out.println(sql);
			return dao.getAll(
					sql,
					null, new BarAndPie(), null);
	    
		}
}
