package edu.seminolestate.vehicle;

import java.time.LocalDate;

//Bijan Amirzadehasl 07/21/2021
public class Automobile extends Vehicle {

	
	private int numberOfSeats;
	
	public Automobile(String vin, double purchasePrice, String make, String model, 
			int modelYear, int mileage, int seating) throws IllegalVehicleArgumentException
	{
		setVin(vin);
		setPurchasePrice(purchasePrice);
		setMake(make);
		setModel(model);
		setModelYear(modelYear);
		setMileage(mileage);
		setNumberOfSeats(seating);
	}
	
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}  



	public void setNumberOfSeats(int numberOfSeats) throws IllegalVehicleArgumentException {
		if(numberOfSeats > 0) 
		{
			this.numberOfSeats = numberOfSeats;
		}
		else
		{
			throw new IllegalVehicleArgumentException("Number of seats must be greater than 0!!!");
		}
		
	}
	
	@Override
	public String toString() {
		return "Automobile [vin=" + getVin() + ", purchasePrice=" + getPurchasePrice() + ", make=" + getMake() + ", model="
				+ getModel() + ", modelYear=" + getModelYear() + ", mileage=" + getMileage() + ", number of seats="
				+ getNumberOfSeats() + "]";
		
		
	}


	public int getVehicleAge() {
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		return currentYear - this.getModelYear();
	}

	@Override
	public double getSaleAmount() {
		final double YEAR_1_RESIDUAL_VALUE = .85; // 100% - 15%
		final double LATER_YEARS_RESIDUAL_VALUE = .91;
		; // 100% - 9%
		int vehicleAge = getVehicleAge();
		double currentYearPrice = 0;
		;
		double purchasePrice = this.getPurchasePrice();
		// 15 percent of its value in its first year of ownership and
		// 10 percent per year after until it hits 0.
		if (vehicleAge <= 1)
			return purchasePrice * YEAR_1_RESIDUAL_VALUE;
		else {
			currentYearPrice = purchasePrice * YEAR_1_RESIDUAL_VALUE;
			for (int ctr = 0; ctr < vehicleAge; ctr++) {
				currentYearPrice = currentYearPrice * LATER_YEARS_RESIDUAL_VALUE;

			}
			return currentYearPrice;

		}
	}
}
