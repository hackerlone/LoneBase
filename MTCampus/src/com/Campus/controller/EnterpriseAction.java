package com.Campus.controller;

import com.Campus.page.PageInfo;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import com.Campus.entity.Enterprise;
import com.Campus.entity.Job;
import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.service.EnterpriseServiceI;
import com.Campus.utils.MD5Code;
import com.opensymphony.xwork2.ActionSupport;

public class EnterpriseAction extends ActionSupport {
	private Enterprise enterprise;
	private EnterpriseServiceI enterpriseServiceI;
	PageInfo pageInfo;
	private String option;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public EnterpriseAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public EnterpriseServiceI getEnterpriseServiceI() {
		return enterpriseServiceI;
	}

	public void setEnterpriseServiceI(EnterpriseServiceI enterpriseServiceI) {
		this.enterpriseServiceI = enterpriseServiceI;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getAllEnterprise() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");

		if (offset == null) {
			offset = "0";

		}
		pageInfo.setFirstResult(offset);
		List<Enterprise> enterprises = enterpriseServiceI
				.getAllEnterprise(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("enterprises", enterprises);
		return "getAllqy";

	}

	public String getEnterpriseById() throws Exception {
	
		HttpServletRequest request =  ServletActionContext.getRequest();
	  enterprise = enterpriseServiceI.getEnterpriseById(enterprise.getQId());
		   if(option.equals("update")){
			   List<Job> job = enterprise.getJobs();
			   System.out.println("888aa"+job.size());
			   ServletActionContext.getRequest().setAttribute("jobs", job);
			   return "update";
		   }
		   if(option.equals("addJob")){
			   ServletActionContext.getRequest().setAttribute("enterprise", enterprise);
			   return "";
		   }if(option.equals("updata")){
			   return "updata";
		   }
		   return "none";
	}

	public String update() throws Exception {
	     enterpriseServiceI.update(enterprise);
		return "updatenew";
	}

	// 取得最大id数+1用于前台自动增加id号
	public String getEnterpriseMaxId() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Integer> maxId = enterpriseServiceI.getEnterpriseMaxId();
		Integer maxidQId = Integer.valueOf(maxId.get(0))+1;
		request.setAttribute("maxidQId", maxidQId);
		out.println(maxidQId.toString());
		return null;
	}

	// 添加使用
	public String addEnterprise() throws Exception {
		System.out.println("=============");
		HttpServletRequest request = ServletActionContext.getRequest();
		// //封装前台数据
		Enterprise enterprise = new Enterprise();
		enterprise.setQId(Integer.valueOf(request.getParameter("QId")));
		enterprise.setQName(request.getParameter("QName"));
		System.out.println(enterprise.getQId()+"   "+enterprise.getQName());
		enterprise.setQXingzhi(request.getParameter("QXingzhi"));
		System.out.println("00000");
		enterprise.setQGuimo(request.getParameter("QGuimo"));
		enterprise.setQArea(request.getParameter("QArea"));
		enterprise.setQYoubian(request.getParameter("QYoubian"));
		enterprise.setQEmail(request.getParameter("QEmail"));
		enterprise.setQPhone(request.getParameter("QPhone"));
		enterprise.setQMiaoshu(request.getParameter("QMiaoshu"));

		//处理MD5加密
		MD5Code md5 =  new MD5Code();
		enterprise.setQPwd(md5.getMD5ofStr(request.getParameter("QPwd")));
		// // 处理日期类型
		String qdate = request.getParameter("QDate").substring(0,10);
		System.out.println(qdate);
		enterprise.setQDate(Timestamp.valueOf(qdate+" 00:00:00"));
		// //

		enterpriseServiceI.addEnterprise(enterprise);
		return "addnow";
	}
	public String enpLogin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();			
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();			
		String option = request.getParameter("option");
		
		
		String stuname = request.getParameter("email");
		MD5Code md5 =  new MD5Code();
		String pwd = md5.getMD5ofStr(request.getParameter("password"));
		enterprise = enterpriseServiceI.enpLogin(stuname, pwd);
		if(option=="freesession"||option.equals("freesession")){
			session.invalidate();
			out.println("3");
	}
		if(enterprise!=null){
			out.println("0");
			System.out.println("0");
			session.setAttribute("enterprise", enterprise);
		}else{
			out.println("1");
			System.out.println("1");
		}
		
//		System.out.println(session.getAttribute(students.));
		return null;
		
	} 
	public String enpRug() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取前台数据
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		System.out.println(email+"000"+name);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Enterprise enterprise = new Enterprise();
		enterprise = enterpriseServiceI.enpRug(name, email);
		if(enterprise==null){
			out.println(1);
		}else if(enterprise!=null){
			out.println(0);
		}
		return null;
		
		
		
	}
}
