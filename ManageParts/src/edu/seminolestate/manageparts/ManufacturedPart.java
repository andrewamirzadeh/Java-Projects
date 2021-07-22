package edu.seminolestate.manageparts;
//Bijan Amirzadehasl 06/24/2021
public class ManufacturedPart extends Part {
	
	private double laborCost;
	private double materialCost;
	public static final double DEFAULT_LABOR_COST = 0;
	public static final double DEFAULT_MATERIAL_COST = 0;
	
	
	public ManufacturedPart(int id, String desc, double sellPrice,  //for superclass object
			double lCost, double mCost) { //for this object
		super(id, desc, sellPrice);  // call ctor for superclass (Part)
		this.laborCost = DEFAULT_LABOR_COST;
		this.materialCost = DEFAULT_MATERIAL_COST;
		this.setLaborCost(lCost);
		this.setMaterialCost(mCost);
	}
	
	public ManufacturedPart(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_LABOR_COST, DEFAULT_MATERIAL_COST);
	}
	
	public ManufacturedPart(int ID, double newLaborCost, double newMaterialCost) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, newLaborCost, newMaterialCost);
	}

	@Override
	public String toString() {
		return "class edu.seminolestate.parts.ManufacturedPart [partID = " + getPartID() + ", partDescription = "
	+ getPartDescription() + " partSellPrice = " + getPartSellPrice()
				+ "class edu.seminolestate.parts.ManufacturedPart [laborCost = " + getLaborCost() + ", materialCost = " + getMaterialCost();
	}

	public double getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(double laborCost) {
		if (laborCost >= 0)
		this.laborCost = laborCost;
	}

	public double getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(double materialCost) {
		if (materialCost >= 0)
		this.materialCost = materialCost;
	}
	
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + getLaborCost() + getMaterialCost();
		
	}
	
	
}
