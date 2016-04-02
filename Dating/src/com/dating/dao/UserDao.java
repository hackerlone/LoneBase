package com.dating.dao;

import java.util.List;

import com.dating.entity.User;

public interface UserDao extends GenerateDao<User>{

	public List<User> findByName(String name);

	public User login(String username, String password);

	public List<User> findBySex(String sex);

}
