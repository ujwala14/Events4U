package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.ParticipateDao;
import com.ourevents.model.Participate;
import com.ourevents.service.ParticipateService;

@Service
public class ParticipateServiceImpl implements ParticipateService {
	@Autowired
	ParticipateDao participateDao;

	public void insertParticipate(Participate participate) {
		participateDao.insertParticipate(participate);
	}

	public List<Participate> getAllParticipates() {
		return participateDao.getAllParticipates();
	}

}
