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

import com.ourevents.dao.VenueDao;
import com.ourevents.model.Venue;

@Repository
public class VenueDaoImpl extends JdbcDaoSupport implements VenueDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertVenue(Venue v) {
		String sql = "INSERT INTO venue VALUES (?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				v.getVenueId(),v.getVenueName(),
				v.getAddress(),v.getMaxCapacity()
		});
	}
	
	public List<Venue> getAllVenues(){
		String sql = "SELECT * FROM venue";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Venue> result = new ArrayList<Venue>();
		for(Map<String, Object> row:rows){
			Venue v = new Venue();
			v.setVenueId((String)row.get("venueId"));
			v.setVenueName((String)row.get("venueName"));
			v.setAddress((String)row.get("address"));
			v.setMaxCapacity((int)row.get("maxCapacity"));
			
//			System.out.println(v);
			result.add(v);
		}
		
		return result;
	}
	


}

