package com.Campus.dao;

import java.util.List;

import org.hibernate.Session;

import com.Campus.entity.Enterprise;
import com.Campus.entity.Student;

public class EnterpriseDao extends BaseDaoImp implements EnterpriseDaoI {
	public List<Enterprise> getAllEnterprise() throws Exception {
		return this.getSession().createQuery("From Enterprise").list();
	}

	public Enterprise getEnterpriseById(int id) throws Exception {
		Session session = this.getSession();
		Enterprise enterprise = (Enterprise) session.load(Enterprise.class, id);
		return enterprise;
	}

	// »°id≈≈–Ú
	public List getEnterpriseMaxId() throws Exception {
		Session session = this.getSession();
		// ÷ª≤È—Øid
		return session.createSQLQuery(
				"select q_id From Enterprise order by q_id desc").list();
	}

	public void update(Enterprise enterprise) throws Exception {

		this.getHibernateTemplate().update(enterprise);
		return;
	}

	public void addEnterprise(Enterprise enterprise) throws Exception {
		this.getHibernateTemplate().save(enterprise);
		return;

	}
	//µ«¬º
	public Enterprise enpLogin(String stuname,String pwd) throws Exception {
		Session session = this.getSession();
		return  (Enterprise)session.createQuery("" +
			"From Enterprise " +
			"WHERE 1=1 AND " +
			"(q_name='"+stuname+"' or q_email ='"+stuname+"') " +
					"and q_pwd = '"+pwd+"'").uniqueResult();
	
	}
	public Enterprise enpRug(String name,String email) throws Exception {
		Session session = this.getSession();
		return  (Enterprise)session.createQuery("" +
				"From Enterprise " +
				"WHERE 1=1 AND " +
				"(u_name='"+name+"' or u_email ='"+email+"') ").uniqueResult();
	
	}

}
