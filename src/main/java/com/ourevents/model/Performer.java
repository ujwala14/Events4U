package com.ourevents.model;

public class Performer {
	
	String performerID;
	String performerName;
	String category;
	String phoneNo;
	String socialMedia;
	String email;
	
	public String getPerformerID() {
		return performerID;
	}

	public void setPerformerID(String performerID) {
		this.performerID = performerID;
	}

	public String getPerformerName() {
		return performerName;
	}

	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Performer [performerID=" + performerID + ", performerName=" + performerName  + "category=" + category + "PhoneNo=" + phoneNo + "socialMedia=" + socialMedia +"email=" + email + "]";
	}
}
