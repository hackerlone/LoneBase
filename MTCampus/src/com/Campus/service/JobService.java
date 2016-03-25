package com.Campus.service;

import com.Campus.page.PageInfo;

import java.util.Iterator;
import java.util.List;
import com.Campus.entity.Job;
import com.Campus.entity.Job;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.dao.JobDaoI;
import com.Campus.dao.JobDaoI;
import com.Campus.entity.Job;



public class JobService implements JobServiceI {
	private JobDaoI jobDaoI;

	public JobDaoI getJobDaoI() {
		return jobDaoI;
	}

	public void setJobDaoI(JobDaoI jobDaoI) {
		this.jobDaoI = jobDaoI;
	}
	
	
	public  List<Job> getAllJob(PageInfo pageInfo)throws Exception{
		 return jobDaoI.getPage("from Job", pageInfo);
	 }
	 public Job getJobById(int id)throws Exception{
		  return jobDaoI.getJobById(id);
	  }
	 public void update(Job job) throws Exception{
			jobDaoI.update(job);
		}
	 
	 public List getJobMaxId() throws Exception {
		 return jobDaoI.getJobMaxId();
	 }
	 public void addJob(Job job) throws Exception{
		 jobDaoI.addJob(job);
	 }
	 public Job deleteJob(int id) throws Exception{
			return jobDaoI.deleteJob(id);
		 }
		 public void delete(Job job) throws Exception{
			 jobDaoI.delete(job);
		 }
		 public Iterator selcJob(String hql) throws Exception {
				// TODO Auto-generated method stub
				return  jobDaoI.selcJob(hql);
			}
		 
		 public Iterator selcJname(String hql1) throws Exception {
			 // TODO Auto-generated method stub
			 return  jobDaoI.selcJname(hql1);
		 }

}
