package edu.seminolestate.volunteers;

import java.time.LocalDate;

public class ManageVolunteer {

	public static void main(String[] args) {
		
		Volunteer v1 = new Volunteer("John","Doe", LocalDate.of(1900, 12, 2), 89);
		System.out.print("Volunteer 1\n" + v1.toString());
		Volunteer v2 = new Volunteer();
		System.out.print("\n\nVounter 2\n" + v2.toString());
		Volunteer v3 = new Volunteer("Sally", "Johnson");
		System.out.print("\n\nVolunter 3\n" + v3.toString());
		
		v1.updateVolunteerHours(65.5);
		v1.setStartDate(2018, 4, 3);
		System.out.print("\n\n Volunteer1\n" + v1.toString());
	
	}

}
