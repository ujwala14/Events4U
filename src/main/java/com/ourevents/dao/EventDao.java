package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Event;
import com.ourevents.model.Venue;

public interface EventDao {
	void insertEvent(Event e);
	List<Event> getAllEvents();
	Event getEventById(String n);
}