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

import com.ourevents.model.Available;
import com.ourevents.model.Required;
import com.ourevents.model.Available;
import com.ourevents.model.Event;
import com.ourevents.service.AvailableService;
import com.ourevents.service.EventService;

@Controller
public class AvailableController {
	@Autowired
	AvailableService availService;
	@Autowired
	EventService eventService;

    //show the add avail form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewAvailable", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addAvailable", "ava", new Available());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewAvailable/{mid}", method = RequestMethod.POST)
	public ModelAndView processRequest(@PathVariable("mid") String mid,
			@ModelAttribute("avai") Available a) {
		a.setEventId(mid);	
		availService.insertAvailable(a);
		List<Event> events = eventService.getAllEvents();
		ModelAndView model = new ModelAndView("getEvents");
		model.addObject("events", events);
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
	
	@RequestMapping("/getAvailable/{n}")
	public ModelAndView getEventByName(@PathVariable("n") String n) {
		Available avail = availService.getAvailableById(n);
		ModelAndView model = new ModelAndView("getAvailableById");
		model.addObject("avail", avail);
		return model;
	}

	@RequestMapping("/getAvailableAdmin/{n}")
	public ModelAndView getEventByName2(@PathVariable("n") String n) {
		Available avail = availService.getAvailableById(n);
		ModelAndView model = new ModelAndView("getAvailableByIdAdmin");
		model.addObject("avail", avail);
		return model;
	}
}

