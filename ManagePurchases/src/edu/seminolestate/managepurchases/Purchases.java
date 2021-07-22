package edu.seminolestate.managepurchases;
//Bijan Amirzadehasl 07/07/2021

import java.time.LocalDate;
public class Purchases {

	private String productName;
	private String storeName;
	private LocalDate purchaseDate;
	private double cost;
	
	public Purchases(String newProduct,
			String newStore, LocalDate newDate, 
			double newCost ) throws IllegalPurchaseArgumentException {
		setProductName(newProduct);
		setStoreName(newStore);
		setPurchaseDate(newDate);
		setCost(newCost);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName)
			throws IllegalPurchaseArgumentException {
		if (productName == null || productName.length() < 1) {
			throw new 
			IllegalPurchaseArgumentException("Product name cannot be null or empty.");
		}
		else
			this.productName = productName;
	}
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName)
			throws IllegalPurchaseArgumentException {
		if (storeName != null && storeName.length() > 0) {
			this.storeName = storeName;
		}
		else {
			throw new IllegalPurchaseArgumentException("Store name cannot be null.");
		}
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate)
			throws IllegalPurchaseArgumentException {
		if (purchaseDate != null)
			this.purchaseDate = purchaseDate;
		else
			throw new IllegalPurchaseArgumentException("Purchase date cannot be null.");
		
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) 
			throws IllegalPurchaseArgumentException {
		if(cost >= 0) {
		this.cost = cost;
		}
		else {
			throw new IllegalPurchaseArgumentException("Cost must be greater than zero.");
		}
		
		
	}
	
	public String toString() {
		return "class edu.seminolestate.managepurchases.Purchase [productName=" + this.productName +
				", storeName=" + this.storeName + ", purchaseDate=" + this.purchaseDate + ", cost=" + this.cost + "\n"  ;
		
	}
}
