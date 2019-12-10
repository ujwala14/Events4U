package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Director;

public interface DirectorDao {
	void insertDirector(Director cus);
	List<Director> getAllDirectors();
	List<String> getAllDirectorNames();
}