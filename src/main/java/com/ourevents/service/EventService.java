package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Event;

public interface EventService {
	void insertEvent(Event e);
	List<Event> getAllEvents();

}
