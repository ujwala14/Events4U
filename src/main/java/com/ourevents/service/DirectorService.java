package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Director;

public interface DirectorService {
	void insertDirector(Director movie);
	List<Director> getAllDirectors();
	List<String> getAllDirectorNames();
}
