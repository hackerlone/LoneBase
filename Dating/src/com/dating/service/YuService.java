package com.dating.service;

import java.util.List;

import com.dating.entity.Agreement;
import com.dating.entity.Books;
import com.dating.entity.Yu;

public interface YuService{

	List<Yu> findAll();
//	List<Agreement> findAllmsg(String tid,String uid);

	List<Yu> findById1(String yuid);

	List<Yu> findById2(String yu_id, String y_id, String u_id);

	void save(String yu_id, String y_id, String u_id, String yuData,
			String yuEnddata);
//	void save(Agreement books);

	List<Yu> findById8(String y_id);

	List<Yu> findById9(String y_id);
}
