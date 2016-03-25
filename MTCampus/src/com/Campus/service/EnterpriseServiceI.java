package com.Campus.service;

import com.Campus.entity.Enterprise;
import com.Campus.entity.Student;

import com.Campus.page.PageInfo;

import java.util.List;

public interface EnterpriseServiceI {
	public  List<Enterprise> getAllEnterprise(PageInfo pageInfo)throws Exception;
	
	public Enterprise getEnterpriseById(int id) throws Exception;
	public void update(Enterprise enterprise) throws Exception;
	public List getEnterpriseMaxId() throws Exception;
	public void addEnterprise(Enterprise enterprise) throws Exception;
	public Enterprise enpLogin(String stuname,String pwd) throws Exception;
	public Enterprise enpRug(String name,String email) throws Exception;
}
