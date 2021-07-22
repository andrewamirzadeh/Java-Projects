package edu.seminolestate.vehicle;

import java.time.LocalDate;

//Bijan Amirzadehasl 07/21/2021
public class Truck extends Vehicle {

	private double cargoCapacity;
	private double horsePower;
	private int numberOfAxles;

	public Truck(String vin, double purchasePrice, String make, String model, int modelYear, int mileage,
			double cargoCapacity, double horsePower, int numberOfAxles) throws IllegalVehicleArgumentException {
		setVin(vin);
		setPurchasePrice(purchasePrice);
		setMake(make);
		setModel(model);
		setModelYear(modelYear);
		setMileage(mileage);
		setCargoCapacity(cargoCapacity);
		setHorsePower(horsePower);
		setNumberOfAxles(numberOfAxles);
	}

	public double getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(double cargoCapacity) throws IllegalVehicleArgumentException {

		if (cargoCapacity > 0) {
			this.cargoCapacity = cargoCapacity;
		} else {
			throw new IllegalVehicleArgumentException("Cargo capacity must be greater than 0!");
		}

	}

	public double getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(double horsePower) throws IllegalVehicleArgumentException {

		if (horsePower > 0) {
			this.horsePower = horsePower;
		} else {
			throw new IllegalVehicleArgumentException("Horse power must be greater than 0!");
		}
	}

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	public void setNumberOfAxles(int numberOfAxles) throws IllegalVehicleArgumentException {
		if (numberOfAxles > 0) {
			this.numberOfAxles = numberOfAxles;
		} else {
			throw new IllegalVehicleArgumentException("Number of axles must be greater than 0!!!");
		}

	}

	@Override
	public String toString() {
		return "Truck [vin=" + getVin() + ", purchasePrice=" + getPurchasePrice() + ", make=" + getMake() + ", model="
				+ getModel() + ", modelYear=" + getModelYear() + ", mileage=" + getMileage() + ", cargo capacity="
				+ getCargoCapacity() + ", horse power=" + getHorsePower() + ", number of axles=" + getNumberOfAxles() + "]";
		
		
	}

	public int getVehicleAge() {
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		return currentYear - this.getModelYear();
	}

	@Override
	public double getSaleAmount() {
		final double YEAR_1_RESIDUAL_VALUE = .90; // 100% - 10%
		final double LATER_YEARS_RESIDUAL_VALUE = .96;
		; // 100% - 4%
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
