package com.ourevents.dao.impl;
import java.sql.Date;
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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ourevents.dao.EventDao;
import com.ourevents.model.Event;
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
				e.getDescription(),e.getVenId(),e.getCaterId(),e.getPhotoId()
		});
	}
	
	public List<Event> getAllEvents(){
		String sql = "SELECT * FROM event Where date > CURRENT_DATE or "
				+ "(date = CURRENT_DATE and startTime > CURRENT_TIME) "
				+ "ORDER BY date,startTime,endTime";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Event> result = new ArrayList<Event>();
		for(Map<String, Object> row:rows){
			Event e = new Event();
			e.setEventId((String)row.get("eventId"));
			e.setEventName((String)row.get("eventName"));
			e.setEventType((String)row.get("eventType"));
			e.setDate((Date)row.get("date"));
			e.setStartTime((Time)row.get("startTime"));
			e.setEndTime((Time)row.get("endTime"));
			e.setDescription((String)row.get("description"));
			e.setVenId((String)row.get("venId"));
			e.setCaterId((String)row.get("caterId"));
			e.setPhotoId((String)row.get("photoId"));
			
			System.out.println(e);
			result.add(e);
		}
		
		return result;
	}

	@Override
	public List<Event> getAllOldEvents() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM event Where date < CURRENT_DATE or "
				+ "(date = CURRENT_DATE and endTime < CURRENT_TIME) "
				+ "ORDER BY date DESC,endTime DESC,startTime DESC";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Event> result = new ArrayList<Event>();
		for(Map<String, Object> row:rows){
			Event e = new Event();
			e.setEventId((String)row.get("eventId"));
			e.setEventName((String)row.get("eventName"));
			e.setEventType((String)row.get("eventType"));
			e.setDate((Date)row.get("date"));
			e.setStartTime((Time)row.get("startTime"));
			e.setEndTime((Time)row.get("endTime"));
			e.setDescription((String)row.get("description"));
			e.setVenId((String)row.get("venId"));
			e.setCaterId((String)row.get("caterId"));
			e.setPhotoId((String)row.get("photoId"));
			
			System.out.println(e);
			result.add(e);
		}
		
		return result;
	}
	
	@Override
	public Event getEventById(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM event where eventId= ?";
		try {
			Event event = (Event)getJdbcTemplate().queryForObject(sql, new Object[]{n}, 
					new RowMapper<Event>(){
				@Override
				public Event mapRow(ResultSet rs, int rwNumber) throws SQLException {
					Event e = new Event();
					e.setEventId((String)rs.getString("eventId"));
					e.setEventName((String)rs.getString("eventName"));
					e.setEventType((String)rs.getString("eventType"));
					e.setDate((Date)rs.getDate("date"));
					e.setStartTime((Time)rs.getTime("startTime"));
					e.setEndTime((Time)rs.getTime("endTime"));
					e.setDescription((String)rs.getString("description"));
					e.setVenId((String)rs.getString("venId"));
					e.setCaterId((String)rs.getString("caterId"));
					e.setPhotoId((String)rs.getString("photoId"));
					
					return e;
				}
			});	
			return event;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Event> getEventsForUser(String uid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM event e,book b Where "
				+ "(date > CURRENT_DATE or (date = CURRENT_DATE and startTime > CURRENT_TIME))"
				+ " and e.eventId = b.eventId and b.userEmail = '"+ uid
						+ "' ORDER BY date,startTime,endTime";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Event> result = new ArrayList<Event>();
		for(Map<String, Object> row:rows){
			Event e = new Event();
			e.setEventId((String)row.get("eventId"));
			e.setEventName((String)row.get("eventName"));
			e.setEventType((String)row.get("eventType"));
			e.setDate((Date)row.get("date"));
			e.setStartTime((Time)row.get("startTime"));
			e.setEndTime((Time)row.get("endTime"));
			e.setDescription((String)row.get("description"));
			e.setVenId((String)row.get("venId"));
			
			//no. of seats:)
			e.setCaterId(String.valueOf(row.get("noSeats")));
			e.setPhotoId((String)row.get("photoId"));
			
			System.out.println(e);
			result.add(e);
		}
		
		return result;
	}

	@Override
	public List<Event> getOldEventsForUser(String uid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM event e,book b Where "
				+ "(date < CURRENT_DATE or (date = CURRENT_DATE and endTime < CURRENT_TIME))"
				+ " and e.eventId = b.eventId and b.userEmail = '"+ uid
						+ "' ORDER BY date DESC,endTime DESC ,startTime DESC";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Event> result = new ArrayList<Event>();
		for(Map<String, Object> row:rows){
			Event e = new Event();
			e.setEventId((String)row.get("eventId"));
			e.setEventName((String)row.get("eventName"));
			e.setEventType((String)row.get("eventType"));
			e.setDate((Date)row.get("date"));
			e.setStartTime((Time)row.get("startTime"));
			e.setEndTime((Time)row.get("endTime"));
			e.setDescription((String)row.get("description"));
			e.setVenId((String)row.get("venId"));
			
			//e.setPhotoId((String)row.get("photoId"));
			//no of seats also there
			e.setCaterId(String.valueOf(row.get("noSeats")));
			System.out.println(e);
			result.add(e);
		}
		
		return result;
	}

	
	@Override
	public List<Event> getEventByCategory(String n) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		System.out.println(n);
			String sql = "SELECT * FROM event Where (date > CURRENT_DATE or "
					+ "(date = CURRENT_DATE and startTime > CURRENT_TIME)) and eventType = '"+n+"'"
					+ " ORDER BY date,startTime,endTime";
				List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
				
				List<Event> result = new ArrayList<Event>();
				for(Map<String, Object> row:rows){
					Event e = new Event();
					e.setEventId((String)row.get("eventId"));
					e.setEventName((String)row.get("eventName"));
					e.setEventType((String)row.get("eventType"));
					e.setDate((Date)row.get("date"));
					e.setStartTime((Time)row.get("startTime"));
					e.setEndTime((Time)row.get("endTime"));
					e.setDescription((String)row.get("description"));
					e.setVenId((String)row.get("venId"));
					e.setCaterId((String)row.get("caterId"));
					e.setPhotoId((String)row.get("photoId"));
					
					result.add(e);
			}
				System.out.println(result);
			return result;
	}
}
