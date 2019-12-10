package com.ourevents.model;

public class Cast {
	String movID;
	String actID;
	String Role;
	public String getMovID() {
		return movID;
	}
	public void setMovID(String movID) {
		this.movID = movID;
	}
	public String getActID() {
		return actID;
	}
	public void setActID(String actID) {
		this.actID = actID;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "Cast [movID=" + movID + ", actID=" + actID + ", Role=" + Role + "]";
	}
}
