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

import com.ourevents.model.Director;
import com.ourevents.service.DirectorService;

@Controller
public class DirectorController {
	@Autowired
	DirectorService directorService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewDirector", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addDirector", "dir", new Director());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewDirector", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("dir") Director dir) {
		directorService.insertDirector(dir);
		List<Director> directors = directorService.getAllDirectors();
		ModelAndView model = new ModelAndView("getDirectors");
		model.addObject("directors", directors);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getDirectors")
	public ModelAndView getActors() {
		List<Director> directors = directorService.getAllDirectors();
		ModelAndView model = new ModelAndView("getDirectors");
		model.addObject("directors", directors);
		return model;
	}

}
