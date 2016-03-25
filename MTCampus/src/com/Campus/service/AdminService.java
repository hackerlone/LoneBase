package com.Campus.service;

import java.util.List;

import com.Campus.dao.AdminDaoI;
import com.Campus.entity.Admin;
import com.Campus.entity.Student;
import com.Campus.page.PageInfo;




public class AdminService implements AdminServiceI {
	private AdminDaoI adminDaoI;
	
	public AdminDaoI getAdminDaoI() {
		return adminDaoI;
	}

	public void setAdminDaoI(AdminDaoI adminDaoI) {
		this.adminDaoI = adminDaoI;
	}

	
	public  List<Admin> getAllAdmin(PageInfo pageInfo)throws Exception{
		 return adminDaoI.getPage("From Admin", pageInfo);
	 }
	public Admin userLogin(String name,String pwd) throws Exception {
		return adminDaoI.userLogin(name, pwd);	
		}
//	 public Student getStudentById(int id)throws Exception{
//		  return adminDaoI.getStudentById(id);
//	  }

}
