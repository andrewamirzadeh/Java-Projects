package edu.seminolestate.vehicle;
//Bijan Amirzadehasl 07/21/2021

import edu.seminolestate.sellable.Sellable;

public abstract class Vehicle implements Sellable {

	private String vin;
	private double purchasePrice;
	private String make;
	private String model;
	private int modelYear;
	private int mileage;
	
	
	//only one constructor in directions but this is needed to make it work
	public Vehicle() {
		super();
	}
	
	public Vehicle(String vin, double purchasePrice, String make, String model, int modelYear, int mileage) throws IllegalVehicleArgumentException
	{
		super();
		setVin(vin);
		setPurchasePrice(purchasePrice);
		setMake(make);
		setModel(model);
		setModelYear(modelYear);
		setMileage(mileage);
	}
	
	
	
	
	
	
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) throws IllegalVehicleArgumentException {
		if (vin != null && vin.length() > 0)
		{
			this.vin = vin;
		}
		else 
		{
			throw new IllegalVehicleArgumentException("The Vin can not be null and must be atleast one character!!!");
		}
		
		
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) throws IllegalVehicleArgumentException {
		
		if (purchasePrice > 0)
		{
			this.purchasePrice = purchasePrice;
		}
		else 
		{
			throw new IllegalVehicleArgumentException("The purchase price must be greater than zero!!!");
		}
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) throws IllegalVehicleArgumentException {
		
		if (make != null && make.length() > 0)
		{
			this.make = make;
		}
		else
		{
			throw new IllegalVehicleArgumentException("The make can not be null and must be atleast one character!!!");
		}
		
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) throws IllegalVehicleArgumentException {
		
		if (model != null && model.length() > 0)
		{
			this.model = model;
		}
		else
		{
			throw new IllegalVehicleArgumentException("The model can not be null and must be atleast one character!!!");
		}
		
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) throws IllegalVehicleArgumentException {
		if (modelYear > 0)
		{
			this.modelYear = modelYear;
		}
		
		else
		{
			throw new IllegalVehicleArgumentException("The model year must be greater than 1900!!!");
		}
		
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) throws IllegalVehicleArgumentException {
		if (mileage > 0) 
		{
			this.mileage = mileage;
		}
		else 
		{
			throw new IllegalVehicleArgumentException("The mileage must be greater than zero!!!");
		}
		
	}
	
	
	
	@Override
	public String toString() {
		
		
		return "Vehicle [vin=" + vin + ", purchasePrice=" + purchasePrice + ", make=" + make + ", model=" + model
				+ ", modelYear=" + modelYear + ", mileage=" + mileage + "]";
		
	}
	
	
	
	
}
