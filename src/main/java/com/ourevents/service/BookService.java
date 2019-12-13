package com.ourevents.service;

import java.util.List;

import com.ourevents.model.Book;

public interface BookService {
	void insertBook(Book v);
	List<Book> getAllBooks();
}
