package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Available;

public interface AvailableDao {
	void insertAvailable(Available a);
	List<Available> getAllAvailables();
}
