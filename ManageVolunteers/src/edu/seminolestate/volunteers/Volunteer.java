package edu.seminolestate.volunteers;

import java.time.LocalDate;

//Bijan Amirzadehasl 06/10/2021

public class Volunteer {

	private String firstName;
	private String lastName;
	private LocalDate startDate;
	private double volunteerHours;
	
	public final static String DEFAULT_FIRST_NAME = "No first name assigned";
	public final static String DEFAULT_LAST_NAME = "No last name assigned"; 
	public final static LocalDate DEFAULT_START_DATE = LocalDate.now();
	public final static double DEFAULT_HOURS = 0;
		
	public Volunteer(String firstName,String lastName, LocalDate start, double hours) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setStartDate(start);
		setVolunteerHours(hours);
		
	}
	
	public Volunteer() {
		this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_START_DATE, DEFAULT_HOURS);
	}
	public Volunteer(String firstName, String lastName) {
		this(firstName, lastName, DEFAULT_START_DATE, DEFAULT_HOURS);
	}
	
	public void setFirstName(String firstName) {
		if (firstName.length() == 0 || firstName == null)
		
			return;
		
		this.firstName = firstName;
		
	}
	
	public void setLastName(String lastName) {
		if (lastName.length() == 0 || lastName == null)
		
			return;
		
		this.lastName = lastName;
		
	}
	
	public void setStartDate(LocalDate startDate) {
		if (startDate == null)
			
			return;
		this.startDate = startDate;
	}
	public void setVolunteerHours (double volunteerHours) {
		this.volunteerHours = volunteerHours;
	}
	
	public String getFirstName() {
		return this.firstName;
		
	}
	
	public String getLastName() {
		return this.lastName;
		
	}
	
	public LocalDate getStartDate() {
		return this.startDate;
		
	}
	public double getVolunteerHours() {
		return this.volunteerHours;
		
	}
	
	public void setStartDate(int newYr,int newMonth, int newDay) {
		if (startDate == null)
			
			return;
		this.startDate = LocalDate.of(newYr, newMonth, newDay);
		
	}
	
	public void updateVolunteerHours(double hours) {
		this.volunteerHours += hours;
	}
	public String toString() {
		return "Volunteer [firstName = " + this.firstName + ", lastName = " + this.lastName + ", startDate = " 
	+ this.startDate + ", volunteerHours = " + this.volunteerHours + "]";
	}
}

