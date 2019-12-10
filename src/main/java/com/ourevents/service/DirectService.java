package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Direct;

public interface DirectService {
	void insertDirect(Direct direct);
	List<Direct> getAllDirects();
	List<Direct> getDirectByMovie(String mid);
	String getDirectorIdFromName(String dn);
}
