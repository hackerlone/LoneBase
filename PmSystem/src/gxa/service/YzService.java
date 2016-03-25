package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.BarAndPie;
import gxa.db.Yz;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class YzService implements WysfforYz{
	EntityDao dao;
	YzforWgxx yzforwgxx;
	//SuppliersforCloting suppliersforCloting;
	public YzService() {
		super();
		//suppliersforCloting=new Supplierservice();
		dao = new EntityDao();
		yzforwgxx = new WgxxService();
				
	}
		public List getAllYz(PageInfo pageinfo){
			//.class表示类型
			return dao.getAll("select * from [yz]","select count(*) from [yz]",new Yz(),pageinfo);
		}
		
		public List getYz(String name,PageInfo pageinfo){
			//.class表示类型
			return dao.getAll("select * from [yz] where o_xm='"+name+"'","select count(*) from [yz] ",new Yz(),pageinfo);
		}
	
	public Yz getYzById(String id){
		return (Yz)dao.getOBJById("select * from [yz] where o_id = " + id, new Yz());
	} 
	//用于删除
	public String deleteById(String id){
		String sql = "delete from yz where o_id = " +id;
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
	public String add(Yz yz){
	    String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(yz));
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public String update(Yz yz){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(yz));
			if(rs>0){
				msg="修改成功，共修改加了"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
	public String getNewById(){
		String oldId= ((Yz)dao.getOBJById("select top 1 o_id from yz order by o_id desc", new Yz())).getO_id();
	   return ProcessSql.processPk(oldId);
	} 
	
	
	public List getBarAndPie(Yz e) {
		String sql="select name 'item',isnull(no,0) 'no' from (select * from comment c"+
" where  pid = 1 and datepart(MM,getdate()) >= name) t1 left join "+
"(select datepart(MM,[sh_time]) 'item',"+
"count(*) 'no' from wysf"+
" where o_id = '"+e.getO_id()+
"' group by datepart(MM,[sh_time])"+
") t2"+
" on t2.item = t1.name";
		System.out.println(sql);
		return dao.getAll(
				sql,
				null, new BarAndPie(), null);
    
	}
	
	
	//外键
public List getwgxx(){		
		return yzforwgxx.getAllWgxx();		
	}
public List getAllYz() {
	// TODO Auto-generated method stub
	return dao.getAll("select * from [yz]", null,new Yz(),null);
}
}
