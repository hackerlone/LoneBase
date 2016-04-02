package com.dating.service.impl;

import java.util.List;

import com.dating.dao.AgreementDao;
import com.dating.dao.impl.AgreementDaoImpl;
import com.dating.dao.impl.BooksDaoImpl;
import com.dating.entity.Agreement;
import com.dating.entity.Books;
import com.dating.entity.Yu;
import com.dating.service.AgreementService;
import com.dating.service.BooksService;

public class AgreementServiceImpl implements AgreementService{
	private AgreementDao agreementDao;
	
	
	public AgreementServiceImpl() {
		super();
		agreementDao = new AgreementDaoImpl();
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Agreement> findAll() {
		// TODO Auto-generated method stub
		return agreementDao.findAll();
	}


	@Override
	public Agreement findById(String yid) {
		// TODO Auto-generated method stub
		return agreementDao.findById(yid);
	}


	@Override
	public void update(Agreement agreement) {
		agreementDao.update(agreement);
		
	}


	@Override
	public List<Agreement> findByName(String name) {
		// TODO Auto-generated method stub
		return agreementDao.findByName(name);
	}


	@Override
	public List<Agreement> findByTag(String name) {
		// TODO Auto-generated method stub
		return agreementDao.findByTag(name);
	}


	@Override
	public String saveAgree(Agreement ags) {
		// TODO Auto-generated method stub
		return agreementDao.saveAgree(ags);
	}


	@Override
	public Agreement findByCreate(String y_id) {
		// TODO Auto-generated method stub
		return agreementDao.findByCreate(y_id);
	}

}
