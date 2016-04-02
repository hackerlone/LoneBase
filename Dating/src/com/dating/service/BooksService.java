package com.dating.service;

import java.util.List;

import com.dating.entity.Books;

public interface BooksService{
	List<Books> findAllmsg(String tid,String uid);

	void save(Books books);
}
