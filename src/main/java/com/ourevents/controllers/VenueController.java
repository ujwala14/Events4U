package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Venue;
import com.ourevents.service.VenueService;

@Controller
public class VenueController {
	@Autowired
	VenueService venueService;

    //show the add venue form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewVenue", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addVenue", "ven", new Venue());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewVenue", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("ven") Venue ven) {
		venueService.insertVenue(ven);
		List<Venue> venues = venueService.getAllVenues();
		ModelAndView model = new ModelAndView("getVenues");
		model.addObject("venues", venues);
		return model;

	}
	

    //show all venues saved in db
	@RequestMapping("/getVenues")
	public ModelAndView getVenues() {
		List<Venue> venues = venueService.getAllVenues();
		ModelAndView model = new ModelAndView("getVenues");
		model.addObject("venues", venues);
		return model;
	}


}

