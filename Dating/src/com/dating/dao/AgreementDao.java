package com.dating.dao;

import java.util.List;

import com.dating.entity.Agreement;
import com.dating.entity.Books;
import com.dating.entity.User;

public interface AgreementDao extends GenerateDao<Agreement>{

	List<Agreement> findByName(String name);

	List<Agreement> findByTag(String name);

	String saveAgree(Agreement ags);

	Agreement findByCreate(String y_id);

	
}
