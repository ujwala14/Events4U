package com.ourevents.model;

import java.sql.Time;

public class Participate {
	String evenID;
	String performID;
	Time start;
	Time end;
	
	public String getEvenID() {
		return evenID;
	}
	
	public void setEvenID(String evenID) {
		this.evenID = evenID;
	}

	public String getPerformID() {
		return performID;
	}

	public void setPerformID(String performID) {
		this.performID = performID;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = Time.valueOf(start);
	}
	
	public void setStart(Time start) {
		this.start = start;
		//this.startTime = startTime;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = Time.valueOf(end);
	}
	
	public void setEnd(Time end) {
		this.end = end;
		//this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Participate [eventID=" + evenID + ", performerID=" + performID + ", start_time=" + start + "end_time=" + end + "]";
	}
}
