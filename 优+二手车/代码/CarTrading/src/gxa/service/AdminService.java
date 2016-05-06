package gxa.service;

import java.util.List;

import gxa.dao.AdminDaoI;
import gxa.entity.Admin;
import gxa.page.PageInfo;

public class AdminService implements AdminServiceI {
	private AdminDaoI adminDaoI;

	public AdminDaoI getAdminDaoI() {
		return adminDaoI;
	}

	public void setAdminDaoI(AdminDaoI adminDaoI) {
		this.adminDaoI = adminDaoI;
	}
	public  List<Admin> getAllAdmin(PageInfo pageInfo) throws Exception{
		 return adminDaoI.getPage("From Admin", pageInfo);
	}

}
