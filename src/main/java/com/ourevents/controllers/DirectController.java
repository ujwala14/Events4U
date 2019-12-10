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

import com.ourevents.model.Actor;
import com.ourevents.model.Direct;
import com.ourevents.model.Movie;
import com.ourevents.service.DirectService;
import com.ourevents.service.MovieService;

@Controller
public class DirectController {
	@Autowired
	DirectService directService;
	@Autowired
	MovieService movieService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewDirect", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addDirect", "dir", new Direct());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addDirect/{mid}", method = RequestMethod.POST,params="add")
	public ModelAndView processRequest(@PathVariable("mid") String mid,
			@ModelAttribute("direct") Direct d) {
		d.setMovID(mid);
		String did = d.getDirectID();	//director name actually
		d.setDirectID(directService.getDirectorIdFromName(did));
		directService.insertDirect(d);
		return new ModelAndView("redirect:/addDirect/"+mid);
	}
	
	@RequestMapping(value = "/addDirect/{mid}", method = RequestMethod.POST,params="fin")
	public ModelAndView processRequest2(@PathVariable("mid") String mid,
			@ModelAttribute("direct") Direct d) {
		d.setMovID(mid);
		String did = d.getDirectID();	//director name actually
		d.setDirectID(directService.getDirectorIdFromName(did));
		directService.insertDirect(d);
		List<Movie> movies = movieService.getAllMovies();
		ModelAndView model = new ModelAndView("getMovies");
		model.addObject("movies", movies);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getDirects")
	public ModelAndView getDirects() {
		List<Direct> directs = directService.getAllDirects();
		ModelAndView model = new ModelAndView("getDirects");
		model.addObject("directs", directs);
		return model;
	}

	@RequestMapping("/getDirect/{mid}")
	public ModelAndView getDirectByMovie(@PathVariable("mid") String mid) {
		List<Direct> directs = directService.getDirectByMovie(mid);
		ModelAndView model = new ModelAndView("getDirect");
		model.addObject("directs", directs);
		return model;
	}
}
