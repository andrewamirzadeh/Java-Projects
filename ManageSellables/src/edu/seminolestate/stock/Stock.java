 package edu.seminolestate.stock;
import edu.seminolestate.sellable.*;
import java.time.LocalDate;

import edu.seminolestate.sellable.Sellable;
//Bijan Amirzadehasl 07/21/2021
public class Stock implements Sellable{

	private String certificateNumber; 
	private double numberOfShares;
	private double pricePerShare;
	private LocalDate datePurchased;
	private LocalDate dateSold;
	
	public Stock(String certificateNumber, double pricePerShare, double numberOfShares,
			LocalDate datePurchased, LocalDate dateSold) throws IllegalStockArgumentException
	{
		setCertificateNumber(certificateNumber);
		setPricePerShare(pricePerShare);
		setNumberOfShares(numberOfShares);
		setDatePurchased(datePurchased);
		setDateSold(dateSold);
		
	}
	
	
	
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) throws  IllegalStockArgumentException {
		if (certificateNumber != null && certificateNumber.length() > 0)
		{
			this.certificateNumber = certificateNumber;
		}
		else
		{
			throw new IllegalStockArgumentException("Certificate number can not be null or empty. :(");
		}
		
	}
	public double getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(double numberOfShares) throws IllegalStockArgumentException {
		if (numberOfShares > 0) 
		{
			this.numberOfShares = numberOfShares;
		}
		else
		{
			throw new IllegalStockArgumentException("The number of shares must be greater than 0!!!");
		}
		
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) throws IllegalStockArgumentException {
		if (pricePerShare > 0)
		{
			this.pricePerShare = pricePerShare;
		}
		else
		{
			throw new IllegalStockArgumentException("The price per share must be greater than 0!!!");
		}
		
	}
	public LocalDate getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(LocalDate datePurchased) throws IllegalStockArgumentException {
		if (datePurchased != null)
		{
			this.datePurchased = datePurchased;
		}
		else
		{
			throw new IllegalStockArgumentException("It must be a correct date!!!");
		}
		
	}
	public LocalDate getDateSold() {
		return dateSold;
	}
	public void setDateSold(LocalDate dateSold) throws IllegalStockArgumentException {
		if (dateSold != null)
		{
			this.dateSold = dateSold;
		}
		else
		{
			throw new IllegalStockArgumentException("It must be a correct date!!!");
		}
	}
	
	public String toString()
	{
		return "Stock [certificateNumber=" + certificateNumber + ", shares=" + numberOfShares + ", pricePerShare="
				+ pricePerShare + ", datePurchased=" + datePurchased + ", dateSold=" + dateSold + "]";
	}



	@Override
	public double getSaleAmount() {
		// TODO Auto-generated method stub
		return numberOfShares * pricePerShare; 
	}
}
