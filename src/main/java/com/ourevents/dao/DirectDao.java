package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Direct;

public interface DirectDao {
	void insertDirect(Direct cus);
	List<Direct> getAllDirects();
	List<Direct> getDirectByMovie(String mid);
	String getDirectorIdFromName(String dn);
}