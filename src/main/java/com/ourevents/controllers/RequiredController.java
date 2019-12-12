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

import com.ourevents.model.Required;
import com.ourevents.model.Available;
import com.ourevents.service.RequiredService;
import com.ourevents.service.EquipmentService;

@Controller
public class RequiredController {
	@Autowired
	RequiredService requiredService;
	@Autowired
	EquipmentService equipmentService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewRequired", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addRequired", "req", new Required());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewRequired/{mid}", method = RequestMethod.POST,params="add")
	public ModelAndView processRequest(@PathVariable("mid") String mid,
			@ModelAttribute("req") Required r) {
		r.setEvenID(mid);	
		String aid = r.getEquipID();	//actor name actually
		r.setEquipID(equipmentService.getEquipmentIdFromName(aid));
		requiredService.insertRequired(r);
		return new ModelAndView("redirect:/addNewRequired/"+mid);
	}
	
	@RequestMapping(value = "/addNewRequired/{mid}", method = RequestMethod.POST,params="fin")
	public ModelAndView processRequest2(@PathVariable("mid") String mid,
			@ModelAttribute("req") Required r) {
		r.setEvenID(mid);	
		String aid = r.getEquipID();	//actor name actually
		r.setEquipID(equipmentService.getEquipmentIdFromName(aid));
		requiredService.insertRequired(r);
		return new ModelAndView("redirect:/addNewAvailable/"+ r.getEvenID());
	}
	
	@RequestMapping(value = "/addNewAvailable/{mid}", method = RequestMethod.GET)
	public ModelAndView showP(@PathVariable("mid") String mid) {
		Available a = new Available();
		a.setEventId(mid);
		//System.out.println(c);
		ModelAndView model= new ModelAndView("addAvailable", "avai", a);
		return model;
	}
	
    //show all movies saved in db
	@RequestMapping("/getRequireds")
	public ModelAndView getRequireds() {
		List<Required> requireds = requiredService.getAllRequireds();
		ModelAndView model = new ModelAndView("getRequireds");
		model.addObject("requireds", requireds);
		return model;
	}

	@RequestMapping("/getRequired/{mid}")
	public ModelAndView getCastByMovie(@PathVariable("mid") String mid) {
		List<Required> reqs = requiredService.getReqByEvent(mid);
		ModelAndView model = new ModelAndView("getRequiredById");
		model.addObject("reqs", reqs);
		return model;
	}
}
