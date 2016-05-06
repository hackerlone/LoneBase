package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.Ts;
import gxa.db.Yz;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;






import java.util.List;

public class TsService {
	EntityDao dao;

	public TsService() {
		super();
		dao = new EntityDao();
	}
	public List getAllTs(PageInfo pageinfo){
		//.class表示类型
		return dao.getAll("select * from [ts]","select count(*) from [ts]",new Ts(),pageinfo);
	}
	public Ts getTsById(String id){
		return (Ts)dao.getOBJById("select * from [ts] where ly_id = " + id, new Ts());
	} 
	public String deleteById(String id){
		String sql = "delete from ts where ly_id = " +id;
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
	public String add(Ts ts){
	    String msg = "";
	   // System.out.println("insert into [ts] (o_id,w_id,t_sy) values ('"+ts.getO_id()+"','"+ts.getW_id()+"','"+ts.getT_sy()+"')");
		int rs = dao.dml("insert into [ts] (o_id,w_id,t_sy) values ('"+ts.getO_id()+"','"+ts.getW_id()+"','"+ts.getT_sy()+"')");
		
		if(rs>0){
			msg="添加成功，共添加了"+rs+"条记录";
		}else{
			msg="添加失败";	
		}
		return msg;
	}
	public Integer getNewById(){
		Integer oldId= ((Ts)dao.getOBJById("select top 1 ly_id from ts order by o_id desc", new Ts())).getLy_id();
	   return ProcessSql.processPk(oldId);
	} 
	public String update(Ts ts){
		 String msg = "";
			int rs = dao.dml(ProcessSql.processUpdate(ts));
			if(rs>0){
				msg="修改成功，共修改"+rs+"条记录";
			}else{
				msg="修改失败";	
			}
			return msg;
	}
}
