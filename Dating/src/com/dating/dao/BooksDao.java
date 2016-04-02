package com.dating.dao;

import java.util.List;

import com.dating.entity.Books;
import com.dating.entity.User;

public interface BooksDao extends GenerateDao<Books>{

	List<Books> findAllmsg(String tid, String uid);

}
