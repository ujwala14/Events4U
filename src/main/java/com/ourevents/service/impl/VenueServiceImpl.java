package com.ourevents.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ourevents.dao.VenueDao;
import com.ourevents.model.Venue;
import com.ourevents.service.VenueService;

public class VenueServiceImpl implements VenueService {
	@Autowired
	VenueDao venueDao;

	public void insertVenue(Venue v) {
		venueDao.insertVenue(v);
	}

	public List<Venue> getAllVenues() {
		return venueDao.getAllVenues();
	}

}
