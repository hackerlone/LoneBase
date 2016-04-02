package com.dating.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.dating.entity.User;

public interface GenerateDao<T> {
//	根据传入的不同的T，进行对应的表的增删改查
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(Object id);
	public List<T> findAll();	
}
