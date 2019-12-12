package com.ourevents.dao;

import java.util.List;
import com.ourevents.model.Required;

public interface RequiredDao {
	void insertRequired(Required cus);
	List<Required> getAllRequireds();
	List<Required> getReqByEvent(String mid);
}
