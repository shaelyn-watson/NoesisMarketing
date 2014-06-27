package com.noesis.app.webinarProject;

import java.util.HashMap;
import java.util.Map;

public class WebinarUser {
	
	public String firstName;
	public String lastName;
	public String email;
	public String sfdcID;
	
	//map webinarID to userUniqueWebinarID
	Map<String, String> web2UserID = new HashMap<String, String>();
	
	//HashMPap<webinarData, webinarPoll>
	//Map<WebinarData, WebinarPoll> = new HashMap<WebinarData, WebinarPoll>();
	
	public WebinarUser(String first, String last, String e, String sID) {
		this.firstName = first;
		this.lastName = last;
		this.email = e;
		this.sfdcID = sID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSfdcID() {
		return sfdcID;
	}

	public void setSfdcID(String sfdcID) {
		this.sfdcID = sfdcID;
	}

}
