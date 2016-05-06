package gxa.service;

import java.util.List;

import gxa.dao.UserDaoI;
import gxa.entity.Users;
import gxa.page.PageInfo;

public class UserService implements UserServiceI {
	private UserDaoI userDaoI;

	public UserDaoI getUserDaoI() {
		return userDaoI;
	}

	public void setUserDaoI(UserDaoI userDaoI) {
		this.userDaoI = userDaoI;
	}
	public  List<Users> getAllUser(PageInfo pageInfo) throws Exception{
		 return userDaoI.getPage("From Users", pageInfo);
	}

}
