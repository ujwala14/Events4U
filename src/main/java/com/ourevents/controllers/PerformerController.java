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

import com.ourevents.model.Performer;
import com.ourevents.service.PerformerService;

@Controller
public class PerformerController {
	@Autowired
	PerformerService peformerService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewPerformer", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addPerformer", "per", new Performer());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewPerformer", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("per") Performer per) {
		peformerService.insertPerformer(per);
		List<Performer> performers = peformerService.getAllPerformers();
		ModelAndView model = new ModelAndView("getPerformers");
		model.addObject("performers", performers);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getPerformers")
	public ModelAndView getPerformers() {
		List<Performer> performers = peformerService.getAllPerformers();
		ModelAndView model = new ModelAndView("getPerformers");
		model.addObject("performers", performers);
		return model;
	}

}
