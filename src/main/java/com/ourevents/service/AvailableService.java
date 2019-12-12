package com.ourevents.service;

import java.util.List;

import com.ourevents.model.Available;

public interface AvailableService {
	void insertAvailable(Available a);
	List<Available> getAllAvailables();
	Available getAvailableById(String n);
}
