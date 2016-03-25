package com.Campus.service;

import java.util.List;

import com.Campus.dao.EnterpriseDaoI;
import com.Campus.entity.Enterprise;
import com.Campus.entity.Student;
import com.Campus.page.PageInfo;
import com.Campus.entity.Enterprise;



public class EnterpriseService implements EnterpriseServiceI {
	private EnterpriseDaoI enterpriseDaoI;

	public EnterpriseDaoI getEnterpriseDaoI() {
		return enterpriseDaoI;
	}

	public void setEnterpriseDaoI(EnterpriseDaoI enterpriseDaoI) {
		this.enterpriseDaoI = enterpriseDaoI;
	}
	
	
	public  List<Enterprise> getAllEnterprise(PageInfo pageInfo)throws Exception{
		 return enterpriseDaoI.getPage("From Enterprise", pageInfo);
	 }
	 public Enterprise getEnterpriseById(int id)throws Exception{
		  return enterpriseDaoI.getEnterpriseById(id);
	  }
	 public void update(Enterprise enterprise) throws Exception{
		 enterpriseDaoI.update(enterprise);
	 }
	 public List getEnterpriseMaxId() throws Exception {
		 return enterpriseDaoI.getEnterpriseMaxId();
	 }
	 public void addEnterprise(Enterprise enterprise) throws Exception{
		 enterpriseDaoI.addEnterprise(enterprise);
	 }
	 public Enterprise enpLogin(String stuname,String pwd) throws Exception {
			return enterpriseDaoI.enpLogin(stuname, pwd);	
			}
	 public Enterprise enpRug(String name,String email) throws Exception {
		 return enterpriseDaoI.enpRug(name, email);	
	 }
}