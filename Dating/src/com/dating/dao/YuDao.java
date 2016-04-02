package com.dating.dao;

import java.util.List;

import com.dating.entity.User;
import com.dating.entity.Yu;

public interface YuDao extends GenerateDao<Yu>{

	public List<Yu> findById1(String id);

	public List<Yu> findById2(String yu_id, String y_id, String u_id);

	public void save(String yu_id, String y_id, String u_id, String yuData,
			String yuEnddata);

	public List<Yu> findById8(String y_id);

	public List<Yu> findById9(String y_id);
}
