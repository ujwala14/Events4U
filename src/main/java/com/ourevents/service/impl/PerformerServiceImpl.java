package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.PerformerDao;
import com.ourevents.model.Performer;
import com.ourevents.service.PerformerService;

@Service
public class PerformerServiceImpl implements PerformerService {
	@Autowired
	PerformerDao performerDao;

	public void insertPerformer(Performer performer) {
		performerDao.insertPerformer(performer);
	}

	public List<Performer> getAllPerformers() {
		return performerDao.getAllPerformers();
	}

	@Override
	public List<String> getAllPerformerNames() {
		// TODO Auto-generated method stub
		return performerDao.getAllPerformerNames();
	}

	@Override
	public String getPerformerIdFromName(String n) {
		// TODO Auto-generated method stub
		return performerDao.getPerformerIdFromName(n);
	}

}
