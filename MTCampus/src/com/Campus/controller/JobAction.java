package com.Campus.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.omg.CORBA.Request;

import com.Campus.dao.VitaDao;
import com.Campus.entity.Enterprise;
import com.Campus.entity.HibernateSessionFactory;
import com.Campus.entity.Job;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;
import com.Campus.service.JobServiceI;
import com.Campus.service.VitaServiceI;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport{
	private Job job;
	private JobServiceI jobServiceI;
	private VitaDao vitaDao;
	PageInfo pageInfo;
	
	
	
	
	public VitaDao getVitaDao() {
		return vitaDao;
	}
	public void setVitaDao(VitaDao vitaDao) {
		this.vitaDao = vitaDao;
	}
	public JobAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public JobServiceI getJobServiceI() {
		return jobServiceI;
	}
	public void setJobServiceI(JobServiceI jobServiceI) {
		this.jobServiceI = jobServiceI;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getAllJob() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		
		if(offset==null){
			offset="0";
		}
		pageInfo.setFirstResult(offset);
		List<Job> jobs = jobServiceI.getAllJob(pageInfo);
		Timestamp data1 = new Timestamp(System.currentTimeMillis());
		List<Integer> ages = new ArrayList<Integer>();
//		for(Job stu:jobs){
//		  Timestamp data = stu.getUBirthday();
//		  int a = (data1.getYear()-data.getYear());
//		  ages.add(a);
//		}
//		System.out.println(ages.get(2));
//		jobs.add(age);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("jobs", jobs);
		
		request.setAttribute("ages", ages);
		return "getAlljob";	
		
	}
	
	 public String getJobById() throws Exception{
		   HttpServletRequest request =  ServletActionContext.getRequest();
		   int id = Integer.parseInt(request.getParameter("id"));
		   String option = request.getParameter("option");
		   job = jobServiceI.getJobById(id);
		   if(option.equals("update")){
			   return "update";
		   }
		   if(option.equals("sec")){
			   return "sec";
		   }
		   return "none";
		   
		  }
		  
		  public String update() throws Exception{
			
				jobServiceI.update(job);
				 return "updatenew";
		  }
		  //取得最大id数+1用于前台自动增加id号
		  public String getJobMaxId() throws Exception {
			  HttpServletRequest request =  ServletActionContext.getRequest();
			  List<Integer> maxId = jobServiceI.getJobMaxId();
			  Integer maxid = Integer.valueOf(maxId.get(0))+1;
			  request.setAttribute("maxidJId", maxid);
			  
			  return "";
		  }
		  //添加注册使用
		  public String addJob() throws Exception{
			  HttpServletRequest request =  ServletActionContext.getRequest();
//			  //封装前台数据
//			  List<Job> job = new ArrayList<Job>();
			  Job job = new Job();
		      job.setZId(Integer.valueOf(request.getParameter("ZId")));
		      //级联企业id
		      Enterprise enterprise = new Enterprise();		  
		      enterprise.setQId(Integer.valueOf(request.getParameter("QId")));
		      job.setEnterprise(enterprise);
	
		      job.setZName(request.getParameter("ZName"));
	  		  job.setZArea(request.getParameter("ZArea"));
	  		  job.setZRenshu(request.getParameter("ZRenshu"));
	  		  job.setZZhineng(request.getParameter("ZZhineng"));
	  		  job.setZMiaoshu(request.getParameter("ZMiaoshu"));
	  		  job.setZXinzi(request.getParameter("ZXinzi"));
	  	      job.setZXinzi(request.getParameter("ZXl"));
			//  处理日期类型
			  String zbdate= request.getParameter("ZDate").substring(0,10);
			  job.setZDate(Timestamp.valueOf(zbdate+" 00:00:00"));	
			  
			  jobServiceI.addJob(job);
			  return "addnow";
		  }
		  public String deleteJob() throws Exception{
			  HttpServletRequest request =  ServletActionContext.getRequest();
			   int id = Integer.parseInt(request.getParameter("id"));
			   String option = request.getParameter("option");
			   job = jobServiceI.getJobById(id);
			   System.out.println(job);
			   jobServiceI.delete(job);
			//   getAllVita();
			  return "deletenew";
		  }
		  
	  
		  
	
}
