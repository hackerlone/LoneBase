package com.dating.service;

import java.util.List;

import com.dating.dao.UserDao;
import com.dating.entity.User;

public interface UserService{
	List<User> findAll();
	User findById(Integer id);
	List<User> findByName(String name);
	void save(User user);
	User login(String username, String password);
	List<User> findBySex(String sex);
	void update(User user);
}
