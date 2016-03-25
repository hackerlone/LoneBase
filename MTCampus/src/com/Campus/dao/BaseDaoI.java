package com.Campus.dao;

import com.Campus.page.PageInfo;

import java.util.List;

public interface BaseDaoI {
	public List getPage(String sqlString, final PageInfo pageInfo);
}
