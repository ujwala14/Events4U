package com.ourevents.service;

import java.util.List;

import com.ourevents.model.Venue;

public interface VenueService {
	void insertVenue(Venue v);
	List<Venue> getAllVenues();
}
