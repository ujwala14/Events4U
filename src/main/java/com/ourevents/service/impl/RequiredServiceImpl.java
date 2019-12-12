package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.RequiredDao;
import com.ourevents.model.Required;
import com.ourevents.service.RequiredService;

@Service
public class RequiredServiceImpl implements RequiredService {
	@Autowired
	RequiredDao requiredDao;

	public void insertRequired(Required required) {
		requiredDao.insertRequired(required);
	}

	public List<Required> getAllRequireds() {
		return requiredDao.getAllRequireds();
	}

	@Override
	public List<Required> getReqByEvent(String mid) {
		// TODO Auto-generated method stub
		return requiredDao.getReqByEvent(mid);
	}
}
