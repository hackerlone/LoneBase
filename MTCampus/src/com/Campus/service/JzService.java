package com.Campus.service;

import java.util.List;

import com.Campus.dao.JzDaoI;
import com.Campus.dao.VitaDaoI;
import com.Campus.entity.Job;
import com.Campus.entity.Jz;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;



public class JzService implements JzServiceI {
	private JzDaoI jzDaoI;

	
	 public JzDaoI getJzDaoI() {
		return jzDaoI;
	}


	public void setJzDaoI(JzDaoI jzDaoI) {
		this.jzDaoI = jzDaoI;
	}


	public void sendVita(Jz jz) throws Exception{
		 jzDaoI.sendVita(jz);
	 }
	public Job getJobById(int id)throws Exception{
		  return jzDaoI.getJobById(id);
	  }
	public Vita getVitaById(int id)throws Exception{
		  return jzDaoI.getVitaById(id);
	  }
	public List secjobforvita(int zid) throws Exception{
		return jzDaoI.secjobforvita(zid);
	}
	public List secvitaforjob(int jid) throws Exception{
		return jzDaoI.secvitaforjob(jid);
	}
}
