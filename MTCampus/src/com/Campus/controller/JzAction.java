package com.Campus.controller;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.reflect.IReflectionWorld;


import com.Campus.dao.JobDao;
import com.Campus.dao.VitaDao;
import com.Campus.entity.Job;
import com.Campus.entity.Jz;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;
import com.Campus.service.JzServiceI;
import com.Campus.service.VitaServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class JzAction extends ActionSupport{
	private Jz jz;
	private JzServiceI jzServiceI;
	private Job job;
	private Vita vita;
	
	
	public Vita getVita() {
		return vita;
	}


	public void setVita(Vita vita) {
		this.vita = vita;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public JzServiceI getJzServiceI() {
		return jzServiceI;
	}


	public void setJzServiceI(JzServiceI jzServiceI) {
		this.jzServiceI = jzServiceI;
	}


	public Jz getJz() {
		return jz;
	}


	public void setJz(Jz jz) {
		this.jz = jz;
	}


	//Í¶µÝ
	  public String sendVita() throws Exception{
		  HttpServletRequest request =  ServletActionContext.getRequest();
		  Integer Jid = Integer.valueOf(request.getParameter("jobs.ZId"));
		  Integer Vid = Integer.valueOf(request.getParameter("vita.Vid"));
		  String option = request.getParameter("option");
		  Jz jz = new Jz();
		  Job job = jzServiceI.getJobById(Jid);			 
		  Vita vita = jzServiceI.getVitaById(Vid);
		  Timestamp TDate = new Timestamp(System.currentTimeMillis());
		  jz.setJob(job);
		  jz.setVita(vita);
		  jz.setTDate(TDate);
		  jzServiceI.sendVita(jz);
		  
			 return "sendsuc";
		  } 	
	  public String secjobforvita() throws Exception{
		  HttpServletRequest request =  ServletActionContext.getRequest();
		  job = jzServiceI.getJobById(jz.getJob().getZId());		
		  Integer Zid = job.getZId();
		  String option = request.getParameter("option");		  		  		  
		  List vitass = jzServiceI.secjobforvita(Zid);
		  List jzs = jzServiceI.secjobforvita(Zid);
		  request.setAttribute("jzss", jzs);
		  request.setAttribute("vitass", vitass);				  
		 
			 return null;
		  }
	  public String secvitaforjob() throws Exception{
		  System.out.println("222");
		  HttpServletRequest request =  ServletActionContext.getRequest();
		  vita = jzServiceI.getVitaById(jz.getVita().getJId());		
		  Integer Jid = vita.getJId();
		  String option = request.getParameter("option");		  		  		  
		  List jobss = jzServiceI.secvitaforjob(Jid);
		  System.out.println(jobss);
		  request.setAttribute("jobss", jobss);				  
			 return null;
		  } 
	
}
