package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Available;
import com.ourevents.model.Catering;

public interface AvailableDao {
	void insertAvailable(Available a);
	List<Available> getAllAvailables();
	Available getAvailableById(String n);
	void reduceSeats(String eid,int seats);
}
