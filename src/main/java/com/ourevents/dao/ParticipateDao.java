package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Participate;
import com.ourevents.model.Performer;

public interface ParticipateDao {
	void insertParticipate(Participate cus);
	List<Participate> getAllParticipates();
	List<Participate> getPartByEvent(String mid);
}