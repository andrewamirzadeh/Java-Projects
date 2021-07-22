package edu.seminolestate.managepurchases;
//Bijan Amirzadehasl 07/07/2021

public class IllegalPurchaseArgumentException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//creating two constructors
	public IllegalPurchaseArgumentException(){
		super("Invalid values sent to method");
	}
	public IllegalPurchaseArgumentException(String msg){
		super(msg);
	}
}
