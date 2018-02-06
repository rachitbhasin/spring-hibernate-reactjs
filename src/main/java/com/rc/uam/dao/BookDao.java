package com.rc.uam.dao;

import java.util.List;

import com.rc.uam.model.Book;

public interface BookDao {

   long save(Book book);
   Book get(long id);
   List<Book> list();
   void update(long id, Book book);
   void delete(long id);
}
