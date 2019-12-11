package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Available;
import com.ourevents.service.AvailableService;

@Controller
public class AvailableController {
	@Autowired
	AvailableService availService;

    //show the add avail form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewAvailable", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addAvailable", "ava", new Available());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewAvailable", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("ava") Available ava) {
		availService.insertAvailable(ava);
		List<Available> avails = availService.getAllAvailables();
		ModelAndView model = new ModelAndView("getAvailables");
		model.addObject("avails", avails);
		return model;

	}
	

    //show all avails saved in db
	@RequestMapping("/getAvailables")
	public ModelAndView getAvailables() {
		List<Available> avails = availService.getAllAvailables();
		ModelAndView model = new ModelAndView("getAvailables");
		model.addObject("avails", avails);
		return model;
	}


}

