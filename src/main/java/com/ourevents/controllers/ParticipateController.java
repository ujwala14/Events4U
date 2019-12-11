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

import com.ourevents.model.Participate;
import com.ourevents.service.ParticipateService;

@Controller
public class ParticipateController {
	@Autowired
	ParticipateService participateService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewParticipate", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addParticipate", "par", new Participate());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewParticipate", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("par") Participate par) {
		participateService.insertParticipate(par);
		List<Participate> participates = participateService.getAllParticipates();
		ModelAndView model = new ModelAndView("getParticipates");
		model.addObject("participates", participates);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getParticipates")
	public ModelAndView getParticipates() {
		List<Participate> participates = participateService.getAllParticipates();
		ModelAndView model = new ModelAndView("getParticiapates");
		model.addObject("participates", participates);
		return model;
	}

}
