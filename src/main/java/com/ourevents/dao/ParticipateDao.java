package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Participate;

public interface ParticipateDao {
	void insertParticipate(Participate cus);
	List<Participate> getAllParticipates();
}