package gxa.dao;

import gxa.entity.Users;

import java.util.List;

public interface UserDaoI extends BaseDaoI {
	public List<Users> getAllUser() throws Exception;
}
