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

import com.ourevents.model.Cast;
import com.ourevents.service.CastService;
import com.ourevents.model.Direct;
import com.ourevents.service.DirectService;
import com.ourevents.service.DirectorService;

@Controller
public class CastController {
	@Autowired
	CastService castService;
	@Autowired
	DirectorService directorService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewCast", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addCast", "cas", new Cast());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addCast/{mid}", method = RequestMethod.POST,params="add")
	public ModelAndView processRequest(@PathVariable("mid") String mid,
			@ModelAttribute("cast") Cast c) {
		c.setMovID(mid);	
		String aid = c.getActID();	//actor name actually
		c.setActID(castService.getActorIdFromName(aid));
		castService.insertCast(c);
		return new ModelAndView("redirect:/addCast/"+mid);
	}
	
	@RequestMapping(value = "/addCast/{mid}", method = RequestMethod.POST,params="fin")
	public ModelAndView processRequest2(@PathVariable("mid") String mid,
			@ModelAttribute("cast") Cast c) {
		c.setMovID(mid);	
		String aid = c.getActID();	//actor name actually
		c.setActID(castService.getActorIdFromName(aid));
		castService.insertCast(c);
		
		return new ModelAndView("redirect:/addDirect/"+mid);
	}

    //show all movies saved in db
	@RequestMapping(value = "/addDirect/{mid}", method = RequestMethod.GET)
	public ModelAndView show3(@PathVariable("mid") String mid) {
		Direct d = new Direct();
		d.setMovID(mid);
		System.out.println(d);
		List<String> directorNames = directorService.getAllDirectorNames();
		ModelAndView model= new ModelAndView("addDirect", "direct", d);
		model.addObject("directorNames", directorNames);
		return model;
	}
	@RequestMapping("/getCast/{mid}")
	public ModelAndView getCastByMovie(@PathVariable("mid") String mid) {
		List<Cast> casts = castService.getCastByMovie(mid);
		ModelAndView model = new ModelAndView("getCast");
		model.addObject("casts", casts);
		return model;
	}
}
