package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Movie;

public interface MovieDao {
	void insertMovie(Movie cus);
	List<Movie> getAllMovies();
	Movie getMovieByName(String mn);
	List<Movie> getMoviesByField(String key,String val);
	List<Movie> getMoviesByField(String key,int val);
	List<Movie> getMoviesByActor(String an);
	List<Movie> getMoviesByDirector(String dn);
}