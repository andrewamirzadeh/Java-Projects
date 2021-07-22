package edu.seminolestate.stock;
//Bijan Amirzadehasl 07/21/2021
public class IllegalStockArgumentException extends Exception {
	
	public IllegalStockArgumentException() {
		super ("Illegal argument for Stock method.");
	}
	
	public IllegalStockArgumentException(String message) {
		super(message);
	}
}
