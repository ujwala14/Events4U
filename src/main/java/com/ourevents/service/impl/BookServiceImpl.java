package com.ourevents.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.BookDao;
import com.ourevents.model.Book;
import com.ourevents.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;

	public void insertBook(Book v) {
		bookDao.insertBook(v);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
}
