package com.Campus.dao;


import java.util.List;

import com.Campus.entity.Model;
public class ModelDao extends BaseDaoImp implements ModelDaoI {
	public List<Model> getAllModel() throws Exception {
		return this.getSession().createQuery("From Model").list();
	}

}
