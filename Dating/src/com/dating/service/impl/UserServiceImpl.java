package com.dating.service.impl;

import java.util.List;

import com.dating.dao.UserDao;
import com.dating.dao.impl.GenerateDaoImpl;
import com.dating.dao.impl.UserDaoImpl;
import com.dating.entity.User;
import com.dating.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
		userDao = new UserDaoImpl();
	}
	public List<User> findAll() {
		return userDao.findAll();
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username,password);
	}
	@Override
	public List<User> findBySex(String sex) {
		// TODO Auto-generated method stub
		return userDao.findBySex(sex);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
}
