package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Performer;

public interface PerformerDao {
	void insertPerformer(Performer cus);
	List<Performer> getAllPerformers();
	List<String> getAllPerformerNames();
	String getPerformerIdFromName(String n);
}