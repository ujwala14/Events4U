package com.ourevents.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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

import com.ourevents.dao.ParticipateDao;
import com.ourevents.model.Participate;
import com.ourevents.model.Performer;


@Repository
public class ParticipateDaoImpl extends JdbcDaoSupport implements ParticipateDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertParticipate(Participate par) {
		String sql = "INSERT INTO participate VALUES (?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				par.getEvenID(),par.getPerformID() ,par.getStart(),par.getEnd()
		});
	}
	
	public List<Participate> getAllParticipates(){
		String sql = "SELECT * FROM participate";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Participate> result = new ArrayList<Participate>();
		for(Map<String, Object> row:rows){
			Participate par = new Participate();
			par.setEvenID((String)row.get("evenID"));
			par.setPerformID((String)row.get("performID"));
			par.setStart((Time)row.get("start"));
			par.setEnd((Time)row.get("end"));
//			System.out.println(act);
			result.add(par);
		}
		
		return result;
	}
	
	@Override
	public List<Participate> getPartByEvent(String mid) {
		// TODO Auto-generated method stub
		String sql = "SELECT performerName,start,end FROM performer,participate WHERE "
				+ "performerID = performID AND evenID = '"+mid+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Participate> result = new ArrayList<Participate>();
		for(Map<String, Object> row:rows){
			Participate cas = new Participate();
//			cas.setMovID((String)row.get("movID"));
			cas.setPerformID((String)row.get("performerName"));
			cas.setStart((Time)row.get("start"));
			cas.setEnd((Time)row.get("end"));
//			System.out.println(cas);
			result.add(cas);
		}
		
		return result;
	}
	
}
