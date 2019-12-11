package com.ourevents.model;

import java.sql.Date;
import java.sql.Time;

public class Event {
	String eventId;
	String eventName;
    String eventType;
    Date date;
    Time startTime,endTime;
    String description;
    String venId,caterId,photoId;
    
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = Time.valueOf(startTime);
		//this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = Time.valueOf(endTime);
		//this.endTime = endTime;
	}
	
	//these are not regular setter - only used in getEvents
	public void setStartTime(Time start) {
		//this.startTime = Time.valueOf(startTime);
		this.startTime = start;
	}
	public void setEndTime(Time end) {
		//this.endTime = Time.valueOf(endTime);
		this.endTime = end;
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventType=" + eventType + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description + ", venId="
				+ venId + ", caterId=" + caterId + ", photoId=" + photoId + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCaterId() {
		return caterId;
	}
	public void setCaterId(String caterId) {
		this.caterId = caterId;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getVenId() {
		return venId;
	}
	public void setVenId(String venueId) {
		this.venId = venueId;
	}
	

}
