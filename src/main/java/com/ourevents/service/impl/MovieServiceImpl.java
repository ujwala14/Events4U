package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.MovieDao;
import com.ourevents.model.Movie;
import com.ourevents.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	public void insertMovie(Movie movie) {
		movieDao.insertMovie(movie);
	}

	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	@Override
	public Movie getMovieByName(String mn) {
		// TODO Auto-generated method stub
		return movieDao.getMovieByName(mn);
	}

	@Override
	public List<Movie> getMoviesByField(String key,String val) {
		// TODO Auto-generated method stub
		return movieDao.getMoviesByField(key,val);
	}
	
	public List<Movie> getMoviesByField(String key,int val) {
		// TODO Auto-generated method stub
		return movieDao.getMoviesByField(key,val);
	}

	@Override
	public List<Movie> getMoviesByActor(String an) {
		// TODO Auto-generated method stub
		return movieDao.getMoviesByActor(an);
	}

	@Override
	public List<Movie> getMoviesByDirector(String dn) {
		// TODO Auto-generated method stub
		return movieDao.getMoviesByDirector(dn);
	}
}
