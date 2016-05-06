package gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import gxa.entity.Users;
import gxa.page.PageInfo;
import gxa.service.UserServiceI;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserServiceI userServiceI;
	private Users users;
	PageInfo pageInfo;
	public UserServiceI getUserServiceI() {
		return userServiceI;
	}
	public void setUserServiceI(UserServiceI userServiceI) {
		this.userServiceI = userServiceI;
	}
	public Users getUser() {
		return users;
	}
	public void setUser(Users users) {
		this.users = users;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public  String getAllUser() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String offset = request.getParameter("offset");
		pageInfo.setFirstResult(offset);
		if(offset==null){
		pageInfo.setFirstResult("0");
		}
		List<Users> users = userServiceI.getAllUser(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("users", users);
		return "getalluser";
	}
}
