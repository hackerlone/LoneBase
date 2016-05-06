package com.Campus.dao;

import java.util.List;

import com.Campus.entity.Student;

public interface StudentDaoI extends BaseDaoI{
	public List<Student> getAllStudent() throws Exception;
	public Student getStudentById(int id) throws Exception;
	public void update(Student student) throws Exception;
	public List getStudentMaxId() throws Exception;
	public void addStu(Student students) throws Exception;
	public Student stuLogin(String stuname,String pwd) throws Exception;
	public Student stuReg(String name,String email) throws Exception;
}
