package com.ourevents.service.impl;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.EventDao;
import com.ourevents.model.Event;
import com.ourevents.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventDao eventDao;

	public void insertEvent(Event event) {
		eventDao.insertEvent(event);
	}

	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public Event getEventById(String n) {
		// TODO Auto-generated method stub
		return eventDao.getEventById(n);
	}

	@Override
	public List<Event> getAllOldEvents() {
		// TODO Auto-generated method stub
		return eventDao.getAllOldEvents();
	}

	@Override
	public boolean checkClash(Date d,String v, Time s, Time e) {
		// TODO Auto-generated method stub
		LocalTime newstart = s.toLocalTime();
		LocalTime newend = e.toLocalTime();
		
		List<Event> events = getAllEvents();
		
		for(int i=0 ; i<events.size() ; i++) {
			
			if(events.get(i).getDate().compareTo(d)==0 && events.get(i).getVenId().equals(v)) {
				LocalTime oldstart = events.get(i).getStartTime().toLocalTime();
				LocalTime oldend = events.get(i).getEndTime().toLocalTime();
				if(newstart.compareTo(oldstart) > 0 && newstart.compareTo(oldend) < 0) 
					return false;
				else if(newend.compareTo(oldstart) > 0 && newend.compareTo(oldend) < 0)
					return false;
			}
		}
			return true;
	}

	@Override
	public List<Event> getEventsForUser(String uid) {
		// TODO Auto-generated method stub
		return eventDao.getEventsForUser(uid);
	}

	@Override
	public List<Event> getOldEventsForUser(String uid) {
		// TODO Auto-generated method stub
		return eventDao.getOldEventsForUser(uid);
	}
	
	@Override
	public List<Event> getEventByCategory(String n) {
		// TODO Auto-generated method stub
		return eventDao.getEventByCategory(n);
	}
}
