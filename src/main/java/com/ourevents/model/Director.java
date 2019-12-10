package com.ourevents.model;

public class Director {
	String directorID;
	String directorName;
	String dob;
	String directorNationality;
	String gender;
	String wikiLink;
	
	public String getDirectorID() {
		return directorID;
	}

	public void setDirectorID(String directorID) {
		this.directorID = directorID;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getDirectorNationality() {
		return directorNationality;
	}

	public void setDirectorNationality(String directorNationality) {
		this.directorNationality = directorNationality;
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
		return "Actor [actorID=" + directorID + ", actorName=" + directorName  + "Date of Birth=" + dob + "Nationality=" + directorNationality + "Gender=" + gender + "]";
	}
}
