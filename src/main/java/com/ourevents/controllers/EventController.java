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


import com.ourevents.model.Event;
import com.ourevents.service.EventService;
import com.ourevents.service.VenueService;

@Controller
public class EventController {
	@Autowired
	EventService eventService;
	@Autowired
	VenueService venueService;

    //the welcome page
	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

    //show the add event form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewEvent", method = RequestMethod.GET)
	public ModelAndView show() {
		List<String> venueNames = venueService.getAllVenueNames();
		ModelAndView model= new ModelAndView("addEvent", "eve", new Event());
		model.addObject("venueNames", venueNames);
		return model;
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewEvent", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("eve") Event eve) {
		String vn = eve.getVenId();
		eve.setVenId(venueService.getVenueIdFromName(vn));
		System.out.println(eve);
		eventService.insertEvent(eve);
		List<Event> events = eventService.getAllEvents();
		ModelAndView model = new ModelAndView("getEvents");
		model.addObject("events", events);
		return model;

	}
	

    //show all events saved in db
	@RequestMapping("/getEvents")
	public ModelAndView getEvents() {
		List<Event> events = eventService.getAllEvents();
		ModelAndView model = new ModelAndView("getEvents");
		model.addObject("events", events);
		return model;
	}


}
