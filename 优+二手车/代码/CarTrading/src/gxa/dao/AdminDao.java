package gxa.dao;

import gxa.entity.Admin;
import gxa.page.PageInfo;

import java.util.List;

public class AdminDao extends BaseDaoImp implements AdminDaoI{
	public List<Admin> getAllAdmin() throws Exception{
		return this.getSession().createQuery("From Admin").list();
	
	}


}
