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

import com.ourevents.dao.EventDao;
import com.ourevents.model.Event;

@Repository
public class EventDaoImpl extends JdbcDaoSupport implements EventDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertEvent(Event e) {
		String sql = "INSERT INTO event VALUES (?,?,?,?,?,?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				e.getEventId(),e.getEventName(),e.getEventType(),
				e.getDate(),e.getStartTime(),e.getEndTime(),
				e.getDesc(),e.getVenId(),e.getCaterId(),e.getPhotoId()
		});
	}
	
	public List<Event> getAllEvents(){
		String sql = "SELECT * FROM event";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Event> result = new ArrayList<Event>();
		for(Map<String, Object> row:rows){
			Event e = new Event();
			e.setEventId((String)row.get("eventId"));
			e.setEventName((String)row.get("eventName"));
			e.setEventType((String)row.get("eventType"));
			e.setDate((String)row.get("date"));
			e.setStartTime((String)row.get("startTime"));
			e.setEndTime((String)row.get("endTime"));
			e.setDesc((String)row.get("desc"));
			e.setVenId((String)row.get("venId"));
			e.setCaterId((String)row.get("caterId"));
			e.setPhotoId((String)row.get("photoId"));
			
//			System.out.println(e);
			result.add(e);
		}
		
		return result;
	}
	


}
