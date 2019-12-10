package com.ourevents.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ourevents.dao.MovieDao;
import com.ourevents.model.Movie;

@Repository
public class MovieDaoImpl extends JdbcDaoSupport implements MovieDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertMovie(Movie mov) {
		String sql = "INSERT INTO movie VALUES (?,?,?,?,?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				mov.getMovieId(), mov.getMovieName(),mov.getLang(),mov.getYear(),
				mov.getType(),mov.getFormat(),mov.getGenre(),mov.getRuntime(),
				mov.getRating()
		});
	}
	
	public List<Movie> getAllMovies(){
		String sql = "SELECT * FROM movie";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Movie> result = new ArrayList<Movie>();
		for(Map<String, Object> row:rows){
			Movie mov = new Movie();
			mov.setMovieId((String)row.get("movieId"));
			mov.setMovieName((String)row.get("movieName"));
			mov.setLang((String)row.get("lang"));
			mov.setYear((int)row.get("year"));
			mov.setType((String)row.get("type"));
			mov.setFormat((String)row.get("format"));
			mov.setGenre((String)row.get("genre"));
			mov.setRuntime((int)row.get("runtime"));
			mov.setRating((int)row.get("rating"));
//			System.out.println(mov);
			result.add(mov);
		}
		
		return result;
	}
	
	public Movie getMovieByName(String mn){
		String sql = "SELECT * FROM movie where movieName = ?";
		try {
			Movie movie = (Movie)getJdbcTemplate().queryForObject(sql, new Object[]{mn}, 
					new RowMapper<Movie>(){
				@Override
				public Movie mapRow(ResultSet rs, int rwNumber) throws SQLException {
					Movie mov = new Movie();
					mov.setMovieId((String)rs.getString("movieId"));
					mov.setMovieName((String)rs.getString("movieName"));
					mov.setLang((String)rs.getString("lang"));
					mov.setYear((int)rs.getInt("year"));
					mov.setType((String)rs.getString("type"));
					mov.setFormat((String)rs.getString("format"));
					mov.setGenre((String)rs.getString("genre"));
					mov.setRuntime((int)rs.getInt("runtime"));
					mov.setRating((int)rs.getInt("rating"));
					System.out.println(mov);
					return mov;
				}
			});	
			return movie;
		}catch(Exception e) {
			return null;
		}
	}
	

	public List<Movie> getMoviesByField(String key,String val){
		String sql = "SELECT * FROM movie where "+key+" = '"+val+"'";
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Movie> result = new ArrayList<Movie>();
			for(Map<String, Object> row:rows){
				Movie mov = new Movie();
				mov.setMovieId((String)row.get("movieId"));
				mov.setMovieName((String)row.get("movieName"));
				mov.setLang((String)row.get("lang"));
				mov.setYear((int)row.get("year"));
				mov.setType((String)row.get("type"));
				mov.setFormat((String)row.get("format"));
				mov.setGenre((String)row.get("genre"));
				mov.setRuntime((int)row.get("runtime"));
				mov.setRating((int)row.get("rating"));
	//			System.out.println(mov);
				result.add(mov);
			}
			
			return result;
		}
		catch(Exception e) {
			return null;
		}
			
	}

	@Override
	public List<Movie> getMoviesByField(String key, int val) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie where "+key+" = "+val+"";
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Movie> result = new ArrayList<Movie>();
			for(Map<String, Object> row:rows){
				Movie mov = new Movie();
				mov.setMovieId((String)row.get("movieId"));
				mov.setMovieName((String)row.get("movieName"));
				mov.setLang((String)row.get("lang"));
				mov.setYear((int)row.get("year"));
				mov.setType((String)row.get("type"));
				mov.setFormat((String)row.get("format"));
				mov.setGenre((String)row.get("genre"));
				mov.setRuntime((int)row.get("runtime"));
				mov.setRating((int)row.get("rating"));
	//			System.out.println(mov);
				result.add(mov);
			}
			
			return result;
		}
		catch(Exception e) {
			return null;
		}
	}
	@Override
	public List<Movie> getMoviesByActor(String an) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie WHERE movieId IN (SELECT movID FROM cast "
				+ "WHERE actID IN (SELECT actorID FROM actor WHERE actorName = '"+an+"'))";
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Movie> result = new ArrayList<Movie>();
			for(Map<String, Object> row:rows){
				Movie mov = new Movie();
				mov.setMovieId((String)row.get("movieId"));
				mov.setMovieName((String)row.get("movieName"));
				mov.setLang((String)row.get("lang"));
				mov.setYear((int)row.get("year"));
				mov.setType((String)row.get("type"));
				mov.setFormat((String)row.get("format"));
				mov.setGenre((String)row.get("genre"));
				mov.setRuntime((int)row.get("runtime"));
				mov.setRating((int)row.get("rating"));
	//			System.out.println(mov);
				result.add(mov);
			}
			
			return result;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Movie> getMoviesByDirector(String dn) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie WHERE movieId IN (SELECT movID FROM direct "
				+ "WHERE directID IN (SELECT directorID FROM director"
				+ " WHERE directorName = '"+dn+"'))";
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Movie> result = new ArrayList<Movie>();
			for(Map<String, Object> row:rows){
				Movie mov = new Movie();
				mov.setMovieId((String)row.get("movieId"));
				mov.setMovieName((String)row.get("movieName"));
				mov.setLang((String)row.get("lang"));
				mov.setYear((int)row.get("year"));
				mov.setType((String)row.get("type"));
				mov.setFormat((String)row.get("format"));
				mov.setGenre((String)row.get("genre"));
				mov.setRuntime((int)row.get("runtime"));
				mov.setRating((int)row.get("rating"));
	//			System.out.println(mov);
				result.add(mov);
			}
			
			return result;
		}
		catch(Exception e) {
			return null;
		}
	}


}
