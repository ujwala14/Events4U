package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Photography;

public interface PhotographyService {
	void insertPhotography(Photography photo);
	List<Photography> getAllPhotographys();
	List<String> getAllPhoNames();
	String getPhoIdFromName(String n);
}
