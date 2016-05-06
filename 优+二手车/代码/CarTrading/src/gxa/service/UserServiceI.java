package gxa.service;

import gxa.entity.Users;
import gxa.page.PageInfo;

import java.util.List;

public interface UserServiceI {
	public  List<Users> getAllUser(PageInfo pageInfo)throws Exception  ;
}
