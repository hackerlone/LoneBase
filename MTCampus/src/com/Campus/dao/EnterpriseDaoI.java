package com.Campus.dao;

import java.util.List;

import com.Campus.entity.Enterprise;
import com.Campus.entity.Student;

public interface EnterpriseDaoI extends BaseDaoI{
	public List<Enterprise> getAllEnterprise() throws Exception;
	public Enterprise getEnterpriseById(int id) throws Exception;
	public void update(Enterprise enterprise) throws Exception;
	public List getEnterpriseMaxId() throws Exception;
	public void addEnterprise(Enterprise enterprise) throws Exception;
	public Enterprise enpLogin(String stuname,String pwd) throws Exception;
	public Enterprise enpRug(String name,String email) throws Exception;
}
