package gxa.dao;

import gxa.page.PageInfo;

import java.util.List;

public interface BaseDaoI {
	public List getPage(String sqlString, final PageInfo pageInfo);
}
