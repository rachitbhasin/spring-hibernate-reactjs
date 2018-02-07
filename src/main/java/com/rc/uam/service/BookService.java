package com.rc.uam.service;

import java.util.List;

import com.rc.uam.model.Book;

/**
 * @author Rachit Bhasin
 *
 */
public interface BookService {
	long save(Book book);
	Book get(long id);
	List<Book> list();
	void update(long id, Book book);
	void delete(long id);
}
