package com.Campus.service;

import com.Campus.entity.Model;

import com.Campus.page.PageInfo;

import java.util.List;

public interface ModelServiceI {
	public  List<Model> getAllModel(PageInfo pageInfo)throws Exception;
	 
}
