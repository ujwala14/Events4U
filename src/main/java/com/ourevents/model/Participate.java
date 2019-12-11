package com.ourevents.model;

public class Participate {
	String evenID;
	String performID;
	String start;
	String end;
	
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Participate [eventID=" + evenID + ", performerID=" + performID + ", start_time=" + start + "end_time=" + end + "]";
	}
}
