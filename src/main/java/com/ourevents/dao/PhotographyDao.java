package com.ourevents.dao;

import java.util.List;

import com.ourevents.model.Photography;

public interface PhotographyDao {
	void insertPhotography(Photography cus);
	List<Photography> getAllPhotographys();
}
