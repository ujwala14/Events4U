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

import com.ourevents.dao.CastDao;
import com.ourevents.model.Cast;


@Repository
public class CastDaoImpl extends JdbcDaoSupport implements CastDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertCast(Cast cas) {
		String sql = "INSERT INTO cast VALUES (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				cas.getMovID(),cas.getActID(),cas.getRole()
		});
	}
	
	public List<Cast> getAllCasts(){
		String sql = "SELECT * FROM cast";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Cast> result = new ArrayList<Cast>();
		for(Map<String, Object> row:rows){
			Cast cas = new Cast();
			cas.setMovID((String)row.get("movID"));
			cas.setActID((String)row.get("actID"));
			cas.setRole((String)row.get("role"));
//			System.out.println(cas);
			result.add(cas);
		}
		
		return result;
	}
	@Override
	public List<Cast> getCastByMovie(String mid) {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM cast WHERE movID = '"+mid+"'";
		String sql = "SELECT actorName,role FROM cast,actor WHERE "
				+ "actorID = actID AND movID = '"+mid+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Cast> result = new ArrayList<Cast>();
		for(Map<String, Object> row:rows){
			Cast cas = new Cast();
//			cas.setMovID((String)row.get("movID"));
			cas.setActID((String)row.get("actorName"));
			cas.setRole((String)row.get("role"));
//			System.out.println(cas);
			result.add(cas);
		}
		
		return result;
	}
	@Override
	public String getActorIdFromName(String an) {
		// TODO Auto-generated method stub
		String sql = "SELECT actorID FROM actor WHERE actorName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{an}, String.class);
	}
	
}
