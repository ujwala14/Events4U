package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Required;
import com.ourevents.service.RequiredService;

@Controller
public class RequiredController {
	@Autowired
	RequiredService requiredService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewRequired", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addRequired", "req", new Required());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewRequired", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("req") Required req) {
		requiredService.insertRequired(req);
		List<Required> requireds = requiredService.getAllRequireds();
		ModelAndView model = new ModelAndView("getRequireds");
		model.addObject("requireds", requireds);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getRequireds")
	public ModelAndView getRequireds() {
		List<Required> requireds = requiredService.getAllRequireds();
		ModelAndView model = new ModelAndView("getRequireds");
		model.addObject("requireds", requireds);
		return model;
	}

}
