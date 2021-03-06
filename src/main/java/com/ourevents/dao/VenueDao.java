package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Venue;

public interface VenueDao {
	void insertVenue(Venue v);
	List<Venue> getAllVenues();
	List<String> getAllVenueNames();
	String getVenueIdFromName(String n);
	Venue getVenueById(String n);
}
