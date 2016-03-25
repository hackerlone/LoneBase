package com.Campus.service;

import com.Campus.entity.Student;

import com.Campus.page.PageInfo;

import java.util.List;

public interface StudentServiceI {
	public  List<Student> getAllStudent(PageInfo pageInfo)throws Exception;
	public Student getStudentById(int id)throws Exception;
	 public void update(Student student) throws Exception;
	 public List getStudentMaxId() throws Exception;
	 public void addStu(Student students) throws Exception;
	 public Student stuLogin(String stuname,String pwd) throws Exception;
	 public Student stuReg(String name,String email) throws Exception;
}	
