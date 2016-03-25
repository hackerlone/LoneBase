package com.Campus.dao;
import java.util.List;

import org.hibernate.Session;

import com.Campus.entity.Admin;
import com.Campus.entity.Student;
import com.Campus.dao.AdminDaoI;

public class AdminDao extends BaseDaoImp implements AdminDaoI {
	public List<Admin> getAllAdmin() throws Exception {
		return this.getSession().createQuery("From Admin").list();
	}
	//µÇÂ¼
	public Admin userLogin(String name,String pwd) throws Exception {
		
		Session session = this.getSession();
		return  (Admin)session.createQuery("" +
			"From Admin " +
			"WHERE 1=1 AND " +
			"(a_name='"+name+"' or a_emalil ='"+name+"') " +
					"and a_pwd = '"+pwd+"'").uniqueResult();
	
	}
	
	
}
