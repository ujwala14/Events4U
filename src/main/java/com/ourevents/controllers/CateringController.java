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

import com.ourevents.model.Catering;
import com.ourevents.service.CateringService;

@Controller
public class CateringController {
	@Autowired
	CateringService cateringService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewCatering", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addCatering", "cat", new Catering());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewCatering", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("cat") Catering cat) {
		cateringService.insertCatering(cat);
		List<Catering> caterings = cateringService.getAllCaterings();
		ModelAndView model = new ModelAndView("getCaterings");
		model.addObject("caterings", caterings);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getCaterings")
	public ModelAndView getCaterings() {
		List<Catering> caterings = cateringService.getAllCaterings();
		ModelAndView model = new ModelAndView("getCaterings");
		model.addObject("caterings", caterings);
		return model;
	}

}
