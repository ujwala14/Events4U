package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Photography;
import com.ourevents.model.Photography;
import com.ourevents.service.PhotographyService;

@Controller
public class PhotographyController {
	@Autowired
	PhotographyService photographyService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewPhotography", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addPhotography", "pho", new Photography());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewPhotography", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("pho") Photography pho) {
		photographyService.insertPhotography(pho);
		List<Photography> photographys = photographyService.getAllPhotographys();
		ModelAndView model = new ModelAndView("getPhotographys");
		model.addObject("photographys", photographys);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getPhotographys")
	public ModelAndView getPhotographys() {
		List<Photography> photographys = photographyService.getAllPhotographys();
		ModelAndView model = new ModelAndView("getPhotographys");
		model.addObject("photographys", photographys);
		return model;
	}
	
	@RequestMapping("/getPhotography/{n}")
	public ModelAndView getEventByName(@PathVariable("n") String n) {
		Photography photography = photographyService.getPhotographyById(n);
		ModelAndView model = new ModelAndView("getPhotographyById");
		model.addObject("photography", photography);
		return model;
	}

}
