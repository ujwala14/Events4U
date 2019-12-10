package com.ourevents.dao;
import java.util.List;
import com.ourevents.model.Cast;

public interface CastDao {
	void insertCast(Cast cus);
	List<Cast> getAllCasts();
	List<Cast> getCastByMovie(String mid);
	String getActorIdFromName(String an);
}