package edu.seminolestate.manageparts;
//Bijan Amirzadehasl 06/24/2021
public class PurchasedPart extends Part {

	private double hCost;
	private double purPrice;
	private String vendor;
	public static final String DEFAULT_VENDOR_NAME = "no vendor name";
	public static final double DEFAULT_PURCHASE_PRICE = 0;
	public static final double DEFAULT_HANDLING_COST = 0;
	
	public PurchasedPart(int ID, String desc, double sellPrice,
			double purPrice, String vend, double hCost)	{
		super(ID, desc, sellPrice);  // call ctor for superclass (Part)
		setPurPrice(DEFAULT_PURCHASE_PRICE);
		setVendor(DEFAULT_VENDOR_NAME);
		sethCost(DEFAULT_HANDLING_COST);
		setPurPrice(purPrice);
		setVendor(vend);
		sethCost(hCost);
		
}
	
	public PurchasedPart(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_PURCHASE_PRICE, DEFAULT_VENDOR_NAME, DEFAULT_HANDLING_COST);
	}
	
	public PurchasedPart(int ID, double hCost, double purPrice, String newVendor ) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, purPrice, newVendor, hCost);
	}
	
	@Override
	public String toString() {
		return "class edu.seminolestate.parts.PurchasedPart [partID = " + getPartID() + ", partDescription = "
	+ getPartDescription() + " partSellPrice = " + getPartSellPrice()
				+ "class edu.seminolestate.parts.PurchasedPart [purchasePrice = " + getPurPrice() + ", vendor = " + getVendor() + ", handlingCost = " + gethCost();
	}

	public double gethCost() {
		return hCost;
	}

	public void sethCost(double hCost) {
		
		if (hCost >= 0)
		this.hCost = hCost;
		
	}

	public double getPurPrice() {

		return purPrice;
	}

	public void setPurPrice(double purPrice) {
		if (purPrice >= 0)
		this.purPrice = purPrice;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		if (vendor != null && vendor.length() > 0)
		this.vendor = vendor;
	}
	
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + getPurPrice() + gethCost();
	}
	
	
}

