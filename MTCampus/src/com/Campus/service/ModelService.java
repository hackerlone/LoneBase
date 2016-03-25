package com.Campus.service;

import com.Campus.page.PageInfo;

import java.util.List;
import com.Campus.entity.Model;
import com.Campus.dao.ModelDaoI;
import com.Campus.entity.Model;



public class ModelService implements ModelServiceI {
	private ModelDaoI modelDaoI;

	public ModelDaoI getModelDaoI() {
		return modelDaoI;
	}

	public void setModelDaoI(ModelDaoI modelDaoI) {
		this.modelDaoI = modelDaoI;
	}
	
	
	public  List<Model> getAllModel(PageInfo pageInfo)throws Exception{
		 return modelDaoI.getPage("From Model", pageInfo);
	 }
	

}
