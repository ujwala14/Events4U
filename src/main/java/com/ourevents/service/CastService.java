package com.ourevents.service;
import java.util.List;

import com.ourevents.model.Cast;

public interface CastService {
	void insertCast(Cast cast);
	List<Cast> getAllCasts();
	List<Cast> getCastByMovie(String mid);
	String getActorIdFromName(String an);
}
