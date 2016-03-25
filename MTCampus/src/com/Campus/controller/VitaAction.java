package com.Campus.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.reflect.IReflectionWorld;


import com.Campus.entity.Student;
import com.Campus.entity.Vita;
import com.Campus.page.PageInfo;
import com.Campus.service.VitaServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class VitaAction extends ActionSupport{
	private Vita vita;
	private VitaServiceI vitaServiceI;
	PageInfo pageInfo;
	//MS-201508252105
	public VitaAction() { 
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vita getVita() {
		return vita;
	}

	public void setVita(Vita vita) {
		this.vita = vita;
	}

	public VitaServiceI getVitaServiceI() {
		return vitaServiceI;
	}

	public void setVitaServiceI(VitaServiceI vitaServiceI) {
		this.vitaServiceI = vitaServiceI;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getAllVita() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");

		
		if(offset==null){
			offset="0";
		}
		pageInfo.setFirstResult(offset);
		List<Vita> vitas = vitaServiceI.getAllVita(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("vitas", vitas);
		return "getAllvit";	
		
	}
	public String getVitaById() throws Exception{
		   HttpServletRequest request =  ServletActionContext.getRequest();
		   int id = Integer.parseInt(request.getParameter("id"));
		   String option = request.getParameter("option");
		   vita = vitaServiceI.getVitaById(id);
		   if(option.equals("update")){
			   
			   return "update";
		   }
		   return "none";
		   
		  }
	 public String update() throws Exception{
		 HttpServletRequest request =  ServletActionContext.getRequest();
		String face = request.getParameter("JFace");
		
		vita.setJFace(face);
		 vitaServiceI.update(vita);
		 return "updatenew";
	  }
	 

	//取得最大id数+1用于前台自动增加id号
	  public String getVitaMaxId() throws Exception {
		  HttpServletRequest request =  ServletActionContext.getRequest();
		  List<Integer> maxId = vitaServiceI.getVitaMaxId();
		  Integer maxidJId = Integer.valueOf(maxId.get(0))+1;
		 // Integer maxidJId = maxId.size()+1;
		  System.out.println(maxidJId);
		  request.setAttribute("maxidJId", maxidJId);
		  return "";
	  }
	  //添加使用
	  public String addVita() throws Exception{
		  HttpServletRequest request =  ServletActionContext.getRequest();
//		  //封装前台数据

		  Vita vita = new Vita();
		  vita.setJId(Integer.valueOf(request.getParameter("JId")));
		 Student student=new Student();
		 student.setUId(Integer.valueOf(request.getParameter("UId")));
		  vita.setStudent(student);
		
		  vita.setJFace(request.getParameter("JFace"));
		  vita.setJByxx(request.getParameter("JByxx"));
		  vita.setJZy(request.getParameter("JZy"));
		  vita.setJXl(request.getParameter("JXl"));
		  vita.setJGzjl(request.getParameter("JGzjl"));
		  vita.setJDizhi(request.getParameter("JDizhi"));
		  vita.setJJianjie(request.getParameter("JJianjie"));
		//  System.out.println(aa);
//		//  处理日期类型
//		  String ubirthday = request.getParameter("UBirthday").substring(0,10);
//		  vita.setUBirthday(Timestamp.valueOf(ubirthday+" 00:00:00"));	
////		     
		  
		  vitaServiceI.addVita(vita);
		  return "addnow";
	  }
	  public String deleteVita() throws Exception{
		  HttpServletRequest request =  ServletActionContext.getRequest();
		   int id = Integer.parseInt(request.getParameter("id"));
		   String option = request.getParameter("option");
		   vita = vitaServiceI.getVitaById(id);
		   System.out.println(vita);
		   vitaServiceI.delete(vita);
		//   getAllVita();
		  return "deletenew";
	  }
	
		
	
}
