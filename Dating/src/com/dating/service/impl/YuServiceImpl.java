package com.dating.service.impl;

import java.util.List;

import com.dating.dao.YuDao;
import com.dating.dao.impl.YuDaoImpl;
import com.dating.entity.Yu;
import com.dating.service.YuService;


public class YuServiceImpl implements YuService{
	private YuDao yuDao;
	public YuServiceImpl() {
		super();
		yuDao = new YuDaoImpl();
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Yu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Yu> findById1(String yuid) {
		// TODO Auto-generated method stub
		return yuDao.findById1(yuid);
	}
	@Override
	public List<Yu> findById2(String yu_id, String y_id, String u_id) {
		return yuDao.findById2(yu_id,y_id,u_id);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(String yu_id, String y_id, String u_id, String yuData,
			String yuEnddata) {
		yuDao.save(yu_id,y_id,u_id,yuData,yuEnddata);
		
	}
	@Override
	public List<Yu> findById8(String y_id) {
		// TODO Auto-generated method stub
		return yuDao.findById8(y_id);
	}
	@Override
	public List<Yu> findById9(String y_id) {
		// TODO Auto-generated method stub
		return yuDao.findById9(y_id);
	}

}
