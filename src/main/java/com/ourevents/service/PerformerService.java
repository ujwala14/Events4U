package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Performer;

public interface PerformerService {
	void insertPerformer(Performer perf);
	List<Performer> getAllPerformers();
	List<String> getAllPerformerNames();
	String getPerformerIdFromName(String n);
}
