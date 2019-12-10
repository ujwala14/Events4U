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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ourevents.dao.ActorDao;
import com.ourevents.model.Actor;


@Repository
public class ActorDaoImpl extends JdbcDaoSupport implements ActorDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertActor(Actor act) {
		String sql = "INSERT INTO actor VALUES (?,?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				act.getActorID(), act.getActorName(),act.getDob(),
				act.getActorNationality(),act.getGender(),act.getWikiLink()
		});
	}
	
	public List<Actor> getAllActors(){
		String sql = "SELECT * FROM actor";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Actor> result = new ArrayList<Actor>();
		for(Map<String, Object> row:rows){
			Actor act = new Actor();
			act.setActorID((String)row.get("actorID"));
			act.setActorName((String)row.get("actorName"));
			act.setDob((String)row.get("dob"));
			act.setActorNationality((String)row.get("actorNationality"));
			act.setGender((String)row.get("gender"));
			act.setWikiLink((String)row.get("wikiLink"));
//			System.out.println(act);
			result.add(act);
		}
		
		return result;
	}
	
	@Override
	public List<String> getAllActorNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM actor";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("actorName"));
		}
		
		return result;
		
	}
	
}
