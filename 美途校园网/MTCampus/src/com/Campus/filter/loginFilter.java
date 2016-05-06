package com.Campus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Campus.entity.Admin;
import com.Campus.entity.Enterprise;
import com.Campus.entity.Student;

public class loginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//filter的过滤方法，如果配置为/*则所有的url请求执行之前先执行这个filter过滤方法
		//如果检查到session存放有内容，则放行
		String url = request.getRequestURL().toString();
		String context = request.getContextPath();
	
//		System.out.println(request.getSession().getAttribute("name"));
		HttpSession session=request.getSession();
		Student stu = new Student();
		Enterprise ent = new Enterprise();
		Admin admin = new Admin();
		stu=(Student) session.getAttribute("students");
		ent= (Enterprise) session.getAttribute("enterprise");
		admin= (Admin) session.getAttribute("admins");
		if(checkUrl(url)||stu!=null||ent!=null||admin!=null){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) resp).sendRedirect("index.jsp");
		}
	}
   public boolean checkUrl(String url){
	   //数组中存放的是不需要检查就直接放行的url
	   //一旦提交的url能够在数组中找到，说明直接放行
	   String urls[] ={
			   "index.jsp",
			   "login.html",
			   "images",
			   "My97DatePicker",
			   "utils",
			   "stu_stuLogin",
			   "qy_enpLogin",
			   "user_userLogin",
			   "/js",
			   "/css",	
			   "/style",
			  "/index",
			  "stu_getStudentMaxId",
			  "qy_getEnterpriseMaxId",
			  "stu_stuReg",
			  "stu_addStu",
			  "qy_addEnterprise",
			  "qy_enpRug"
			  
	   };
	   for(int i=0;i<urls.length;i++){
		   int index = url.indexOf((urls[i]));
		   if( index >= 0){
			   return true;
		   }
	   }
	   return false;
   }
	
	public void init(FilterConfig arg0) throws ServletException {
		

	}
	/*
	 * 
	 * 
	 * */
	
	

}
