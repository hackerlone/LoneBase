package com.Campus.service;
import java.util.List;

import com.Campus.entity.Admin;
import com.Campus.entity.Student;
import com.Campus.page.PageInfo;

public interface AdminServiceI {
	public  List<Admin> getAllAdmin(PageInfo pageInfo)throws Exception;
	 public Admin userLogin(String name,String pwd) throws Exception;
}
