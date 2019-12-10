package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Participate;

public interface ParticipateService {
	void insertParticipate(Participate part);
	List<Participate> getAllParticipates();
}
