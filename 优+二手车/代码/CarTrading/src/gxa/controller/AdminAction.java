package gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import gxa.entity.Admin;
import gxa.page.PageInfo;
import gxa.service.AdminServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private AdminServiceI adminServiceI;
	private Admin admin;
	PageInfo pageInfo;
	public AdminServiceI getAdminServiceI() {
		return adminServiceI;
	}
	public void setAdminServiceI(AdminServiceI adminServiceI) {
		this.adminServiceI = adminServiceI;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public  String getAllAdmin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		pageInfo.setFirstResult(offset);
		if(offset==null){
		pageInfo.setFirstResult("0");
		}
		List<Admin> admins = adminServiceI.getAllAdmin(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("admins", admins);
		return "getallsuc";
	}
}
