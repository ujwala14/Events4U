package com.ourevents.service;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.ourevents.model.Event;

public interface EventService {
	void insertEvent(Event e);
	List<Event> getAllEvents();
	Event getEventById(String n);
	List<Event> getAllOldEvents();
	boolean checkClash(Date d,String v,Time s,Time e);
	List<Event> getEventsForUser(String uid);
	List<Event> getOldEventsForUser(String uid);
	List<Event> getEventByCategory(String n);
}
