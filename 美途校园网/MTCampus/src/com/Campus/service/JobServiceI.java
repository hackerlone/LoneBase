package com.Campus.service;

import com.Campus.entity.Job;
import com.Campus.entity.Job;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;

import com.Campus.page.PageInfo;

import java.util.Iterator;
import java.util.List;

public interface JobServiceI {
	public  List<Job> getAllJob(PageInfo pageInfo)throws Exception;
	public Job getJobById(int id)throws Exception;
	 public void update(Job job) throws Exception;
	 public List getJobMaxId() throws Exception;
	 public void addJob(Job jobs) throws Exception;
	 public Job deleteJob(int id) throws Exception;
	public void delete(Job job) throws Exception;
	 public Iterator selcJob(String hql) throws Exception;
	 public Iterator selcJname(String hql1) throws Exception;

	

	 
}
