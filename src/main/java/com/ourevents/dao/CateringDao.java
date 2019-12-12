package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Catering;
import com.ourevents.model.Venue;

public interface CateringDao {
	void insertCatering(Catering cus);
	List<Catering> getAllCaterings();
	List<String> getAllCateringNames();
	String getCateringIdFromName(String n);
	Catering getCateringById(String n);
}
