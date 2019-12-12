package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Performer;
import com.ourevents.model.Required;

public interface PerformerDao {
	void insertPerformer(Performer cus);
	List<Performer> getAllPerformers();
	List<String> getAllPerformerNames();
	String getPerformerIdFromName(String n);
	
}