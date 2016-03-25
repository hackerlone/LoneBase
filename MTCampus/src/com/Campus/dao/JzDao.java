package com.Campus.dao;


import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Campus.entity.Job;
import com.Campus.entity.Jz;
import com.Campus.entity.Vita;
public class JzDao extends BaseDaoImp implements JzDaoI {
	
	public void sendVita(Jz jz) throws Exception {
		Session session = this.getSession();
		session.setFlushMode(FlushMode.COMMIT);
		this.getHibernateTemplate().save(jz);
		return;
	}
	
	public Job getJobById(int id) throws Exception {
		Session session = this.getSession();
		Job job = (Job) session.load(Job.class, id);
		return job;
	}
	public Vita getVitaById(int id) throws Exception {
		Session session = this.getSession();
		Vita vita = (Vita) session.load(Vita.class, id);
		return vita;
	}
	public List secjobforvita(int zid) throws Exception {
		return this.getSession().createQuery("From Jz where z_id="+zid).list();
		
	}
	public List secvitaforjob(int jid) throws Exception {
		return this.getSession().createQuery("From Jz where j_id="+jid).list();
		
	}
}
