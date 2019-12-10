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

import com.ourevents.model.Actor;
import com.ourevents.service.ActorService;

@Controller
public class ActorController {
	@Autowired
	ActorService actorService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewActor", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addActor", "act", new Actor());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewActor", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("act") Actor act) {
		actorService.insertActor(act);
		List<Actor> actors = actorService.getAllActors();
		ModelAndView model = new ModelAndView("getActors");
		model.addObject("actors", actors);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getActors")
	public ModelAndView getActors() {
		List<Actor> actors = actorService.getAllActors();
		ModelAndView model = new ModelAndView("getActors");
		model.addObject("actors", actors);
		return model;
	}

}
