package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Movie;

public interface MovieService {
	void insertMovie(Movie movie);
	List<Movie> getAllMovies();
	Movie getMovieByName(String mn);
	List<Movie> getMoviesByField(String key,String val);
	List<Movie> getMoviesByField(String key,int val);
	List<Movie> getMoviesByActor(String an);
	List<Movie> getMoviesByDirector(String dn);
}
