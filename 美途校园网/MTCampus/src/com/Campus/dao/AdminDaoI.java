package com.Campus.dao;

import java.util.List;

import com.Campus.entity.Admin;
import com.Campus.entity.Student;


public interface AdminDaoI extends BaseDaoI{
	public List<Admin> getAllAdmin() throws Exception;
	public Admin userLogin(String name,String pwd) throws Exception;
}
