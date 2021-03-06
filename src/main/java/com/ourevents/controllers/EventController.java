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
import com.ourevents.model.Filter;
import com.ourevents.model.Participate;
import com.ourevents.model.User;
import com.ourevents.service.CateringService;
import com.ourevents.service.EventService;
import com.ourevents.service.PhotographyService;
import com.ourevents.service.VenueService;
import com.ourevents.service.ParticipateService;
import com.ourevents.service.PerformerService;

@Controller
public class EventController {
	@Autowired
	EventService eventService;
	@Autowired
	VenueService venueService;
	@Autowired
	CateringService cateringService;
	@Autowired
	PhotographyService photoService;
	@Autowired
	PerformerService performerService;

    //the welcome page
	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping("/welcomeAdmin")
	public ModelAndView firstPageAdmin() {
		return new ModelAndView("welcomeAdmin");
	}
	
		
    //show the add event form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewEvent", method = RequestMethod.GET)
	public ModelAndView show() {
		List<String> venueNames = venueService.getAllVenueNames();
		List<String> cateringNames = cateringService.getAllCateringNames();
		List<String> photoNames = photoService.getAllPhoNames();
		ModelAndView model= new ModelAndView("addEvent", "eve", new Event());
		model.addObject("venueNames", venueNames);
		model.addObject("cateringNames", cateringNames);
		model.addObject("photoNames", photoNames);
		return model;
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewEvent", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("eve") Event eve) {
		String vn = eve.getVenId();
		eve.setVenId(venueService.getVenueIdFromName(vn));
		String cn = eve.getCaterId();
		if(cn.equals("None"))
			eve.setCaterId("None");
		else
			eve.setCaterId(cateringService.getCateringIdFromName(cn));
		
		String pn = eve.getPhotoId();
		if(pn.equals("None"))
			eve.setPhotoId("None");
		else
			eve.setPhotoId(photoService.getPhoIdFromName(pn));
		
		System.out.println(eve);
		if(eventService.checkClash(eve.getDate(), eve.getVenId(), eve.getStartTime(), eve.getEndTime())) {
			eventService.insertEvent(eve);
			return new ModelAndView("redirect:/addNewParticipate/"+ eve.getEventId());
		}
		else {
			String msg = "Your Event is clashing with another Scheduled event!!!";
			ModelAndView model = new ModelAndView("error");
			model.addObject("errmsg",msg);
			return model;
			
		}

	}

	
	@RequestMapping(value = "/addNewParticipate/{mid}", method = RequestMethod.GET)
	public ModelAndView showP(@PathVariable("mid") String mid) {
		Participate p = new Participate();
		p.setEvenID(mid);
		//System.out.println(c);
		List<String> performers = performerService.getAllPerformerNames();
		ModelAndView model= new ModelAndView("addParticipate", "part", p);
		model.addObject("performers", performers);
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
	
	@RequestMapping("/getOldEvents")
	public ModelAndView getOldEvents() {
		List<Event> events = eventService.getAllOldEvents();
		ModelAndView model = new ModelAndView("getEvents");
		model.addObject("events", events);
		return model;
	}
	
	//show all events saved in db
		@RequestMapping("/user/{uid}/getUserEvents")
		public ModelAndView getUserEvents(@PathVariable("uid") String uid) {
			List<Event> events = eventService.getAllEvents();
			User u = new User();
			u.setEmail(uid);
			ModelAndView model = new ModelAndView("getUserEvents");
			model.addObject("events", events);
			model.addObject("uid", u);
			return model;
		}

		@RequestMapping("/user/{uid}/booked")
		public ModelAndView getUserEventsBooked(@PathVariable("uid") String uid) {
			List<Event> events = eventService.getEventsForUser(uid);
			User u = new User();
			u.setEmail(uid);
			ModelAndView model = new ModelAndView("bookedEvents");
			model.addObject("events", events);
			model.addObject("uid", u);
			return model;
		}
		@RequestMapping("/user/{uid}/attended")
		public ModelAndView getUserEventsAttended(@PathVariable("uid") String uid) {
			List<Event> events = eventService.getOldEventsForUser(uid);
			User u = new User();
			u.setEmail(uid);
			ModelAndView model = new ModelAndView("attendedEvents");
			model.addObject("events", events);
			model.addObject("uid", u);
			return model;
		}
		
	@RequestMapping("/getEventMore/{n}")
	public ModelAndView getEventByName(@PathVariable("n") String n) {
		Event event = eventService.getEventById(n);
		ModelAndView model = new ModelAndView("getEventMore");
		model.addObject("event", event);
		return model;
	}
	
	@RequestMapping(value = "/user/{uid}/getUserFilter", method = RequestMethod.GET)
	public ModelAndView show2(@PathVariable("uid") String uid) {
		User u = new User();
		u.setEmail(uid);
		ModelAndView model = new ModelAndView("filterUserEvents", "fil", new Filter());
		model.addObject("uid",u);
		return model;
	}
	
	@RequestMapping(value = "/user/{uid}/getUserFilter", method = RequestMethod.POST)
	public ModelAndView processRequest2(@ModelAttribute("fil") Filter fil) {
			List<Event> events = eventService.getEventByCategory(fil.getValue());
			System.out.println(events);
			ModelAndView model = new ModelAndView("getEventByCategory");
			model.addObject("events", events);
			return model;
		
	}

}
