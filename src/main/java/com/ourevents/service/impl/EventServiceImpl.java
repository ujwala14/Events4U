package com.ourevents.service.impl;
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


}
