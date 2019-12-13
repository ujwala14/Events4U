package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Book;

public interface BookDao {
	void insertBook(Book v);
	List<Book> getAllBooks();
}
