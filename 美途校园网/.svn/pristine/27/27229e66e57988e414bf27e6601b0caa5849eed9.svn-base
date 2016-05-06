package com.Campus.dao;


import java.util.List;

import org.hibernate.Session;

import com.Campus.entity.Vita;
public class VitaDao extends BaseDaoImp implements VitaDaoI {
	public List<Vita> getAllVita() throws Exception {
		return this.getSession().createQuery("From Vita").list();
	}
	public Vita getVitaById(int id) throws Exception {
		Session session = this.getSession();
		Vita vita = (Vita) session.load(Vita.class, id);
		return vita;
	}
	//»°id≈≈–Ú
	public List getVitaMaxId() throws Exception {
		Session session = this.getSession();
		//÷ª≤È—Øid
		return session.createSQLQuery("select j_id From Vita order by j_id desc").list();
	}
	public void update(Vita vita) throws Exception {
		
        this.getHibernateTemplate().update(vita);
		return;
	}
	public void addVita(Vita vita) throws Exception {
		this.getHibernateTemplate().save(vita);
	
		return;
	}
	public Vita deleteVita(int id) throws Exception {
		Session session = this.getSession();
		Vita vita = (Vita) session.load(Vita.class, id);
		return vita;
	}
	public void delete(Vita vita) throws Exception{
		this.getHibernateTemplate().delete(vita);
		return ;
	}
	
}
