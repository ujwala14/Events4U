package com.ourevents.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.User;
import com.ourevents.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

    //show the add user form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("register", "u", new User());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("u") User u) {
		userService.insertUser(u);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView show2() {
		return new ModelAndView("login", "u", new User());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processRequest2(@ModelAttribute("u") User u) {
		String email = u.getEmail();
		String pwd = u.getPwd();
		if(email.equals("admin") && pwd.equals("admin123"))
			return new ModelAndView("redirect:/welcomeAdmin");
		else {
			User user = userService.getUserAfterLogin(email, pwd);
			if(user != null)
			{
				return new ModelAndView("redirect:/");
			}
			else
				return new ModelAndView("redirect:/login");
		}
	}
}
