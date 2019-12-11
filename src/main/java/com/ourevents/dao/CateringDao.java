package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Catering;

public interface CateringDao {
	void insertCatering(Catering cus);
	List<Catering> getAllCaterings();
}
