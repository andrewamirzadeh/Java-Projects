package edu.seminolestate.vehicle;
//Bijan Amirzadehasl 07/21/2021
public class IllegalVehicleArgumentException extends Exception {

	public IllegalVehicleArgumentException() {
		super ("Illegal argument for vehicle method.");
	}
	
	public IllegalVehicleArgumentException(String message) {
		super(message);
	}
	
}
