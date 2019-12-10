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
import com.ourevents.model.Filter;
import com.ourevents.model.Movie;
import com.ourevents.service.ActorService;
import com.ourevents.service.CastService;
import com.ourevents.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;
	@Autowired
	ActorService actorService;

    //the welcome page
	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewMovie", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addMovie", "mov", new Movie());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewMovie", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("mov") Movie mov) {
		movieService.insertMovie(mov);

		return new ModelAndView("redirect:/addCast/"+mov.getMovieId());

	}
	
	
	@RequestMapping(value = "/addCast/{mid}", method = RequestMethod.GET)
	public ModelAndView show3(@PathVariable("mid") String mid) {
		Cast c = new Cast();
		c.setMovID(mid);
		System.out.println(c);
		List<String> actorNames = actorService.getAllActorNames();
		ModelAndView model= new ModelAndView("addCast", "cast", c);
		model.addObject("actorNames", actorNames);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getMovies")
	public ModelAndView getMovies() {
		List<Movie> movies = movieService.getAllMovies();
		ModelAndView model = new ModelAndView("getMovies");
		model.addObject("movies", movies);
		return model;
	}

	//show movies based on movie name,etc..	
	@RequestMapping(value = "/filterMovies", method = RequestMethod.GET)
	public ModelAndView show2() {
		return new ModelAndView("filterMovies", "fil", new Filter());
	}
	
	@RequestMapping(value = "/filterMovies", method = RequestMethod.POST)
	public ModelAndView processRequest2(@ModelAttribute("fil") Filter fil) {
		String key = fil.getKey();
		if(key.equals("movieName")) {
			String mn = fil.getValue();
			Movie movie = movieService.getMovieByName(mn);
			ModelAndView model = new ModelAndView("getMovieByName");
			model.addObject("movie", movie);
			return model;
		}
		else if(key.equals("lang") || key.equals("type") || key.equals("genre") || 
				key.equals("format")) {
			String val = fil.getValue();
			List<Movie> movies = movieService.getMoviesByField(key,val);
			ModelAndView model = new ModelAndView("getMoviesByField");
			model.addObject("movies", movies);
			return model;
		}else if(key.equals("year") || key.equals("rating")) {
			int val = Integer.parseInt(fil.getValue());
			List<Movie> movies = movieService.getMoviesByField(key,val);
			ModelAndView model = new ModelAndView("getMoviesByField");
			model.addObject("movies", movies);
			return model;
		}
		else if(key.equals("actorName")) {
			String val = fil.getValue();
			List<Movie> movies = movieService.getMoviesByActor(val);
			ModelAndView model = new ModelAndView("getMoviesByField");
			model.addObject("movies", movies);
			return model;
		}
		else if(key.equals("directorName")) {
			String val = fil.getValue();
			List<Movie> movies = movieService.getMoviesByDirector(val);
			ModelAndView model = new ModelAndView("getMoviesByField");
			model.addObject("movies", movies);
			return model;
		}
		return null;
	}
	@RequestMapping("/getMovie/{mn}")
	public ModelAndView getMovieByName(@PathVariable("mn") String mn) {
		Movie movie = movieService.getMovieByName(mn);
		ModelAndView model = new ModelAndView("getMovieByName");
		model.addObject("movie", movie);
		return model;
	}

}
