package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Book;
import com.ourevents.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

    //show the add book form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/book/{uid}/{eid}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("eid") String eid,
			@PathVariable("uid") String uid) {
		Book b = new Book();
		b.setEventId(eid);
		b.setUserEmail(uid);
		return new ModelAndView("book", "boo", b);
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/book/{uid}/{eid}", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("boo") Book boo,
			@PathVariable("eid") String eid,@PathVariable("uid") String uid) {
		boo.setEventId(eid);
		boo.setUserEmail(uid);
		bookService.insertBook(boo);
		return new ModelAndView("welcomeUser");

	}
	

    //show all books saved in db
	@RequestMapping("/getBooks")
	public ModelAndView getBooks() {
		List<Book> books = bookService.getAllBooks();
		ModelAndView model = new ModelAndView("getBooks");
		model.addObject("books", books);
		return model;
	}

}

