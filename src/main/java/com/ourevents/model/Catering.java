package com.ourevents.model;

public class Catering {
	
	String catID;
	String catName;
	String catContNo;
	
	public String getCatID() {
		return catID;
	}
	public void setCatID(String catID) {
		this.catID = catID;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatContNo() {
		return catContNo;
	}
	public void setCatContNo(String catContNo) {
		this.catContNo = catContNo;
	}
	
	@Override
	public String toString() {
		return "Catering [catererID=" + catID + ", catererName=" + catName + ", caterer ContactNo=" + catContNo + "]";
	}
}
