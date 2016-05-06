package gxa.service;

import gxa.entity.Admin;
import gxa.page.PageInfo;

import java.util.List;

public interface AdminServiceI {
	public  List<Admin> getAllAdmin(PageInfo pageInfo)throws Exception  ;
}
