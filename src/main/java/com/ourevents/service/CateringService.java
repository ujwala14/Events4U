package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Catering;

public interface CateringService {
	void insertCatering(Catering cater);
	List<Catering> getAllCaterings();
	List<String> getAllCateringNames();
	String getCateringIdFromName(String n);
}
