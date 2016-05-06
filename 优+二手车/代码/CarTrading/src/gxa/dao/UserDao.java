package gxa.dao;

import gxa.entity.Users;
import gxa.page.PageInfo;

import java.util.List;

public class UserDao extends BaseDaoImp implements UserDaoI{
	public List<Users> getAllUser() throws Exception{
		return this.getSession().createQuery("From Users").list();
	
	}


}
