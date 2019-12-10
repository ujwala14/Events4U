package com.ourevents.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourevents.dao.DirectorDao;
import com.ourevents.model.Director;
import com.ourevents.service.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {
	@Autowired
	DirectorDao directorDao;

	public void insertDirector(Director director) {
		directorDao.insertDirector(director);
	}

	public List<Director> getAllDirectors() {
		return directorDao.getAllDirectors();
	}

	@Override
	public List<String> getAllDirectorNames() {
		// TODO Auto-generated method stub
		return directorDao.getAllDirectorNames();
	}
}
