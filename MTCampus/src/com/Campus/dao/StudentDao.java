package com.Campus.dao;


import com.Campus.dao.BaseDaoImp;
import com.Campus.dao.StudentDaoI;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
public class StudentDao extends BaseDaoImp implements StudentDaoI {
	public List<Student> getAllStudent() throws Exception {
		return this.getSession().createQuery("From Student").list();
		
	}
	public Student getStudentById(int id) throws Exception {
		Session session = this.getSession();
		Student student = (Student) session.load(Student.class, id);
		return student;
	}
	//È¡idÅÅÐò
	public List getStudentMaxId() throws Exception {
		Session session = this.getSession();
		//Ö»²éÑ¯id
		return session.createSQLQuery("select u_id From Student order by u_id desc").list();
	}
	
	public void update(Student student) throws Exception {
        this.getHibernateTemplate().update(student);
		return;
	}
	//×¢²á Ìí¼Ó
	public void addStu(Student student) throws Exception {
		this.getHibernateTemplate().save(student);
		return;
	}
	//µÇÂ¼
	public Student stuLogin(String stuname,String pwd) throws Exception {
		Session session = this.getSession();
		return  (Student)session.createQuery("" +
			"From Student " +
			"WHERE 1=1 AND " +
			"(u_name='"+stuname+"' or u_email ='"+stuname+"') " +
					"and u_pwd = '"+pwd+"'").uniqueResult();
	
	}
	public Student stuReg(String name,String email) throws Exception {
		Session session = this.getSession();
		return  (Student)session.createQuery("" +
				"From Student " +
				"WHERE 1=1 AND " +
				"(u_name='"+name+"' or u_email ='"+email+"') ").uniqueResult();
		
	}
	
	
	
}
