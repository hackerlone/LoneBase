package com.Campus.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.omg.CORBA.Request;

import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;
import com.Campus.service.StudentServiceI;
import com.Campus.utils.MD5Code;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

public class StudentAction extends ActionSupport{
	private Student student;
	private StudentServiceI studentServiceI;
	PageInfo pageInfo;
	private String option;	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public StudentAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentServiceI getStudentServiceI() {
		return studentServiceI;
	}
	public void setStudentServiceI(StudentServiceI studentServiceI) {
		this.studentServiceI = studentServiceI;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getAllStudent() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		
		if(offset==null){
			offset="0";
		}
		pageInfo.setFirstResult(offset);
//		HashMap<String,List> students = new HashMap<String,List>();
		List<Student> students = studentServiceI.getAllStudent(pageInfo);
		Timestamp data1 = new Timestamp(System.currentTimeMillis());
		List<Integer> ages = new ArrayList<Integer>();
		for(Student stu:students){
		  Timestamp data = stu.getUBirthday();
		  int a = (data1.getYear()-data.getYear());
		  ages.add(a);
		}
//		System.out.println(ages.get(2));
//		students.add(age);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("students", students);
		request.setAttribute("ages", ages);
		return "getAllstu";	
		
	}
	
	 public String getStudentById() throws Exception{
		   HttpServletRequest request =  ServletActionContext.getRequest();
		   student = studentServiceI.getStudentById(student.getUId());
		  // System.out.println("111"+getOption());
		   ServletActionContext.getRequest().setAttribute("student", student);
		   if(option.equals("update")){
			  
			   ServletActionContext.getRequest().setAttribute("student", student);
			   List<Vita> vita = student.getVitas();
			   ServletActionContext.getRequest().setAttribute("vitas", vita);
			   return "update";
		   }
		   if(option.equals("addVita")){
			   ServletActionContext.getRequest().setAttribute("student", student);
			   return "";
		   }
		   if(option.equals("updata")){
			   ServletActionContext.getRequest().setAttribute("student", student);
			   return "uptata";
		   }
		   return "none";
		   
		  }
		  
		  public String update() throws Exception{
			  HttpServletRequest request =  ServletActionContext.getRequest();
			  //如果头像被修改
			  if(!"".equals(request.getParameter("touxiang"))){			 
				  student.setUTouxiang(request.getParameter("touxiang").toString());				
			  }
				//MD5Code md5 =  new MD5Code();
			 student.setUPwd(student.getUPwd());			  
			 studentServiceI.update(student);				
			 return "updatenow";
		  }
		  //取得最大id数+1用于前台自动增加id号
		  public String getStudentMaxId() throws Exception {
			  
			  HttpServletRequest request =  ServletActionContext.getRequest();
			  HttpServletResponse response = ServletActionContext.getResponse();
			  PrintWriter out = response.getWriter();
			  List<Integer> maxId = studentServiceI.getStudentMaxId();
			  Integer maxid = Integer.valueOf(maxId.get(0))+1;
			  request.setAttribute("maxid", maxid);
			  out.println(maxid.toString());
			  System.out.println(maxid);
			  return null;
		  }
		  //添加注册使用
		  public String addStu() throws Exception{
			  System.out.println("============");
			  HttpServletRequest request =  ServletActionContext.getRequest();
//			  //封装前台数据
//			  List<Student> student = new ArrayList<Student>();
			  Student student = new Student();
			  student.setUId(Integer.valueOf(request.getParameter("UId")));
			  
			  student.setUName(request.getParameter("UName"));
			  student.setUSex(request.getParameter("USex"));
			  student.setUEmail(request.getParameter("UEmail"));
			  student.setUPhone(request.getParameter("UPhone"));
			  
			  
			 System.out.println(request.getParameter("USex"));
			 System.out.println(request.getParameter("UName"));
			 System.out.println(request.getParameter("UEmail"));
			
			  //处理MD5加密
				MD5Code md5 =  new MD5Code();
				student.setUPwd(md5.getMD5ofStr(request.getParameter("UPwd")));
				
			//  处理日期类型
			  String ubirthday = request.getParameter("UBirthday").substring(0,10);
			  student.setUBirthday(Timestamp.valueOf(ubirthday+" 00:00:00"));	

			  studentServiceI.addStu(student);
			  return "addnow";
		  }
		public String stuLogin() throws Exception{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();			
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();			
			String option = request.getParameter("option");		
			String stuname = request.getParameter("email");
			MD5Code md5 =  new MD5Code();
			String pwd = md5.getMD5ofStr(request.getParameter("password"));
			student = studentServiceI.stuLogin(stuname, pwd);
			if(option=="freesession"||option.equals("freesession")){
				session.invalidate();
				out.println("3");
		}
			if(student!=null){
				out.println("0");
				session.setAttribute("students", student);
			}else{
				out.println("1");
			}

			return null;			
		}
		public String stuReg() throws Exception{
			
			HttpServletRequest request = ServletActionContext.getRequest();
			//获取前台数据
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			System.out.println(email+"010"+name);
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			Student student=new Student();
			student = studentServiceI.stuReg(name, email);
//			System.out.println(student);
			if(student!=null){
				out.println(1);
			}else{
				out.println(0);
			}
			return null;
			
			
			
		}
		
	
}
