package com.ourevents.service;

import java.util.List;

import com.ourevents.model.Required;

public interface RequiredService {
	void insertRequired(Required requ);
	List<Required> getAllRequireds();
}
