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
import com.ourevents.model.Participate;
import com.ourevents.model.Required;
import com.ourevents.service.ParticipateService;
import com.ourevents.service.PerformerService;
import com.ourevents.service.EquipmentService;

@Controller
public class ParticipateController {
	@Autowired
	ParticipateService participateService;
	@Autowired
	PerformerService performService;
	@Autowired
	EquipmentService equipmentService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewParticipate", method = RequestMethod.GET)
	public ModelAndView show() {
		List<String> performers = performService.getAllPerformerNames();
		ModelAndView model= new ModelAndView("addParticipate", "part", new Participate());
		model.addObject("performers", performers);
		return model;
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewParticipate/{mid}", method = RequestMethod.POST,params="add")
	public ModelAndView processRequest(@PathVariable("mid") String mid,
			@ModelAttribute("part") Participate p) {
		p.setEvenID(mid);	
		String aid = p.getPerformID();	//actor name actually
		p.setPerformID(performService.getPerformerIdFromName(aid));
		participateService.insertParticipate(p);
		return new ModelAndView("redirect:/addNewParticipate/"+mid);
	}
	
	@RequestMapping(value = "/addNewParticipate/{mid}", method = RequestMethod.POST,params="fin")
	public ModelAndView processRequest2(@PathVariable("mid") String mid,
			@ModelAttribute("part") Participate p) {
		p.setEvenID(mid);	
		String aid = p.getPerformID();	//actor name actually
		p.setPerformID(performService.getPerformerIdFromName(aid));
		participateService.insertParticipate(p);
		return new ModelAndView("redirect:/addNewRequired/"+ p.getEvenID());
	}
	
	@RequestMapping(value = "/addNewRequired/{mid}", method = RequestMethod.GET)
	public ModelAndView showP(@PathVariable("mid") String mid) {
		Required r = new Required();
		r.setEvenID(mid);
		//System.out.println(c);
		List<String> equipments = equipmentService.getAllEquipmentNames();
		ModelAndView model= new ModelAndView("addRequired", "req", r);
		model.addObject("equipments", equipments);
		return model;
	}
	
    //show all movies saved in db
	@RequestMapping("/getParticipates")
	public ModelAndView getParticipates() {
		List<Participate> participates = participateService.getAllParticipates();
		ModelAndView model = new ModelAndView("getParticipates");
		model.addObject("participates", participates);
		return model;
	}

}
