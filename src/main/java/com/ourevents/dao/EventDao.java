package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Event;

public interface EventDao {
	void insertEvent(Event e);
	List<Event> getAllEvents();

}