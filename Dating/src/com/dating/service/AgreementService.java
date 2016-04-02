package com.dating.service;

import java.util.List;

import com.dating.entity.Agreement;
import com.dating.entity.Books;

public interface AgreementService{

	List<Agreement> findAll();
//	List<Agreement> findAllmsg(String tid,String uid);

	Agreement findById(String yid);

	void update(Agreement agreement);

	List<Agreement> findByName(String name);

	List<Agreement> findByTag(String name);

	String saveAgree(Agreement ags);

	Agreement findByCreate(String y_id);


}
