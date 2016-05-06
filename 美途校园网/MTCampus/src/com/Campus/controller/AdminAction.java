package com.Campus.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.Campus.entity.Admin;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;
import com.Campus.service.AdminServiceI;
import com.Campus.utils.MD5Code;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private Admin admin;
	private AdminServiceI adminServiceI;
	PageInfo pageInfo;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminServiceI getAdminServiceI() {
		return adminServiceI;
	}
	public void setAdminServiceI(AdminServiceI adminServiceI) {
		this.adminServiceI = adminServiceI;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public String getAllUser() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");		
		if(offset==null){
			offset="0";
		}
		pageInfo.setFirstResult(offset);

		List<Admin> admins = adminServiceI.getAllAdmin(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("admins", admins);
		return "getAlladmin";	
		
	}
//	public String loginOut() throws Exception{
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "loginout";
//	}
	public String userLogin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MD5Code md5 =  new MD5Code();
		String pwd = md5.getMD5ofStr(request.getParameter("pwd"));
		admin = adminServiceI.userLogin(name, pwd);	
		String option = request.getParameter("option");	
		//ÍË³öµÇÂ¼
		if(option=="freesession"||option.equals("freesession")){
			session.invalidate();
			response.sendRedirect("index.jsp");
			return "loginout";
	    }
		if(admin!=null){
			out.println("0");
			session.setAttribute("admins", admin);
		}else{
			out.println("1");
			
		}
		return null;
	}
	

	
	
}
