package com.dating.service.impl;

import java.util.List;

import com.dating.dao.BooksDao;
import com.dating.dao.impl.BooksDaoImpl;
import com.dating.dao.impl.GenerateDaoImpl;
import com.dating.entity.Books;
import com.dating.service.BooksService;

public class BooksServiceImpl implements BooksService{
	private BooksDao booksDao;
	
	public BooksServiceImpl() {
		super();
		booksDao = new BooksDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Books> findAllmsg(String tid, String uid) {
		// TODO Auto-generated method stub
		return booksDao.findAllmsg(tid, uid);
	}

	@Override
	public void save(Books books) {
		// TODO Auto-generated method stub
		booksDao.save(books);
	}

	


}
