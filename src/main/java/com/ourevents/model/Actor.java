package com.ourevents.model;

public class Actor {
	String actorID;
	String actorName;
	String dob;
	String actorNationality;
	String gender;
	String wikiLink;
	
	public String getActorID() {
		return actorID;
	}
	public void setActorID(String actorID) {
		this.actorID = actorID;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getActorNationality() {
		return actorNationality;
	}
	public void setActorNationality(String actorNationality) {
		this.actorNationality = actorNationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWikiLink() {
		return wikiLink;
	}
	public void setWikiLink(String wikiLink) {
		this.wikiLink = wikiLink;
	}
	
	@Override
	public String toString() {
		return "Actor [actorID=" + actorID + ", actorName=" + actorName  + "Date of Birth=" + dob + "Nationality=" + actorNationality + "Gender=" + gender + "]";
	}
}
