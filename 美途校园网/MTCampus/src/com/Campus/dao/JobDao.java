package com.Campus.dao;


import com.Campus.dao.BaseDaoImp;
import com.Campus.dao.JobDaoI;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Campus.entity.HibernateSessionFactory;
import com.Campus.entity.Job;
import com.Campus.entity.Job;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
public class JobDao extends BaseDaoImp implements JobDaoI {
	public List<Job> getAllJob() throws Exception {
		return this.getSession().createQuery("From Job").list();
	}
	public Job getJobById(int id) throws Exception {
		Session session = this.getSession();
		Job job = (Job) session.load(Job.class, id);
		return job;
	}
	//取id排序
	public List getJobMaxId() throws Exception {
		Session session = this.getSession();
		//只查询id
		return session.createSQLQuery("select z_id From Job order by z_id desc").list();
	}
	
	public void update(Job job) throws Exception {
        this.getHibernateTemplate().update(job);
		return;
	}

//注册添加
	public void addJob(Job job) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(job);
		return;
	}
	
	
	public Job deleteJob(int id) throws Exception {
		Session session = this.getSession();
		Job job = (Job) session.load(Job.class, id);
		return job;
	}
	public void delete(Job job) throws Exception{
		this.getHibernateTemplate().delete(job);
		return ;
	}
	
	 public Iterator selcJob(String hql) throws Exception {
			Session session = (Session) HibernateSessionFactory.getSession();
			//Transaction tx = session.beginTransaction(); 
			return session.createSQLQuery(hql)
			.addScalar("z_id",Hibernate.BIG_INTEGER)
			.addScalar("q_id",Hibernate.BIG_INTEGER)
			.addScalar("z_name",Hibernate.STRING) 
			.addScalar("z_date",Hibernate.DATE) 
			.addScalar("z_area",Hibernate.STRING) 
			.addScalar("z_renshu",Hibernate.STRING) 
			.addScalar("z_zhineng",Hibernate.STRING) 
			.addScalar("z_miaoshu",Hibernate.STRING) 
			.addScalar("z_xinzi",Hibernate.STRING) 
			.addScalar("z_xl",Hibernate.STRING).list().iterator(); 
//			session.close();
		}
	 public Iterator selcJname(String hql1) throws Exception {
		 Session session = (Session) HibernateSessionFactory.getSession();
		 //Transaction tx = session.beginTransaction(); 
		 return session.createSQLQuery(hql1)
		 .addScalar("z_name",Hibernate.STRING).list().iterator(); 
//			session.close();
	 }
	
	}
	
	


