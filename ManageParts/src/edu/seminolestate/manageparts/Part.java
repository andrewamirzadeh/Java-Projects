package edu.seminolestate.manageparts;
//Bijan Amirzadehasl 06/24/2021
public class Part {

	private int ID;
	private String partDescription;
	private double partSellPrice;
	public static final int DEFAULT_ID = 0;
	public static final String DEFAULT_DESCRIPTION = "no part description";
	public static final double DEFAULT_SELL_PRICE = 0;
	
	
	Part (int ID, String desc, double newSellPrice){
		setPartID(DEFAULT_ID);
		setPartDescription(DEFAULT_DESCRIPTION);
		setPartSellPrice(DEFAULT_SELL_PRICE);
		setPartID(ID);
		setPartDescription(desc);
		setPartSellPrice(newSellPrice);
	}
	
	
	//1c
	Part(int ID){
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE);
	}
	 
	//1d
	@Override
	public String toString() {
		return "Part[partID = " + this.ID + " ,  partDescription = " + this.partDescription +  ", partSellPrice = " + this.partSellPrice;
	}
	
	//getters
	
	public double getPartID() {
		return this.ID;
	}
	//1 f
	public double getTotalCost() {
		return 0;
	}
	
	public String getPartDescription() {
		return this.partDescription;
	}
	
	public double getPartSellPrice() {
		return this.partSellPrice;
	}
	
	//setters
	public void setPartID (int newPartID) {
		if (newPartID >= 0 )
			ID = newPartID;
	
	}
	public void setPartDescription(String newDesc) {
		if (newDesc != null && newDesc.length() > 0)
			partDescription = newDesc;
		
	}
	
	public void setPartSellPrice(double newSellPrice) {
		if (newSellPrice >= 0)
			partSellPrice = newSellPrice;
		
	}
	
}
