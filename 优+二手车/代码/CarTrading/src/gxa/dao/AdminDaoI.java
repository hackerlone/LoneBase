package gxa.dao;

import gxa.entity.Admin;

import java.util.List;

public interface AdminDaoI extends BaseDaoI {
	public List<Admin> getAllAdmin() throws Exception;
}
