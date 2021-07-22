//Bijan Amirzadehasl 06/24/2021
package edu.seminolestate.manageparts;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class ManageParts {
	
    private static Scanner keyboard; 
	private static final int ADD_PURCHASED_PART = 1;
	private static final int ADD_MANUFACTURED_PART = 2;
	private static final int LIST_ONE_PART = 3;
	private static final int LIST_ALL_PARTS = 4;
	private static final int EXIT = 5;
	
	public static ArrayList<Part> parts = new ArrayList<>();
	
	public static void main(String [] args)	{
				
		keyboard = new Scanner(System.in); 
	   int partID;
	   String partDescription;
	   double partSellPrice;
	   double laborCost;//cost to make part 
	   double materialCost;//amount of material in product
	   double purchasePrice; //what does this part cost to buy?
	   String vendor;  //who do we buy this part from?
	   double handlingCost; //shipping and handling costs when we buy it
	   	
	   int userChoice = 0; //main loop control variable
	   
	    while (userChoice != EXIT)	{
			userChoice = getUserChoice();
			
			switch (userChoice)
			{
				case ADD_PURCHASED_PART:
					
					partID = getUniquePartId(parts);
					partDescription = getString("Enter a description");
					partSellPrice = getDouble("Enter a sell price");
					purchasePrice = getDouble("Enter a purchase price");
					handlingCost = getDouble("Enter the handling cost");
					vendor = getString("Enter the vendor name");
					
					PurchasedPart pp = 
							new PurchasedPart(partID, partDescription, partSellPrice, purchasePrice, vendor, handlingCost);
					parts.add(pp);
					System.out.println(parts);
					break;
					
				case ADD_MANUFACTURED_PART:
					
					partID = getUniquePartId(parts);
					partDescription = getString("Enter a description: ");
					partSellPrice = getDouble("Enter a sell price: ");
					laborCost = getDouble("Enter the labor cost: ");
					materialCost = getDouble("Enter the material cost: ");
					
					ManufacturedPart pp1 = 
							new ManufacturedPart(partID, partDescription, partSellPrice, laborCost, materialCost);
					parts.add(pp1);
					System.out.println(parts);
					break;
					
				case LIST_ONE_PART: 
					if (parts.size() <= 0) {
						System.out.print("There are currently no parts in the inventory.\n");					
						}
					else
					displayOnePart(parts);
					
					break;
				
				case LIST_ALL_PARTS:
					if (parts.size() <= 0) {
						System.out.print("There are currently no parts in the inventory.\n");
					}
					else 
						System.out.println(parts.toString());
					
					break;
				case EXIT:
					/*
					 * End the application if the user enters menu option 5. Display an ending message
					 *  "Thanks for using the parts manager!". 
					 */
					System.out.println("Thanks for using the parts manager!");
					keyboard.close();
					break;
			}
		} //end while
	} // end main
		
		public static void displayOnePart(ArrayList<Part> parts) {
		NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
		int searchID = getInteger("Enter a part ID");
		boolean isFound = false;
		//Search the ArrayList for a 'part' with an ID that matches 
		//the ID entered by the user
		for (Part part : parts) {
			if (part.getPartID() == searchID){
				System.out.println(part +
						"\nPart cost:" + currFormatter.format(part.getTotalCost()));
				isFound = true;//update loop control variable so loop will stop
			}
		}
		if (! isFound){
			System.out.println(searchID + " was not found");
		}
	}
	
		
		public static int getUniquePartId(ArrayList<Part> parts){
			int userInt=0;
			String userValue;
			do {
				System.out.println("Enter parts ID ");
				userValue = keyboard.nextLine();
				userInt = Integer.parseInt(userValue);
				if (userInt <= 0 || !checkID(userInt, parts)) {
					System.out.println("Value must be greater than 0 AND not a repeated part number. Please reenter.");
				}
			} while (userInt <= 0 || !checkID(userInt, parts));

			return userInt;
		}
		
		public static  String getString(String prompt){

			System.out.println(prompt);
			String	userValue = keyboard.nextLine();
			
			return userValue;
		}

	public static double getDouble(String prompt){
		double userDouble = 0;
		do {
			System.out.println(prompt);
			String userValue = keyboard.nextLine();
			userDouble =  Double.parseDouble(userValue);
			if (userDouble < 0) {
				System.out.println("Value must be >= 0. Please reenter.");
			}
		} while (userDouble < 0);
		
		return userDouble;
	}

	public static int getInteger(String prompt){
		int userInt = 0;
		do {
			System.out.println(prompt);
			String userValue = keyboard.nextLine();
			userInt = Integer.parseInt(userValue);
			if (userInt <= 0) {
				System.out.println("Value must be > 0. Please reenter.");
			}
		} while (userInt <= 0);

		return userInt;
	}
//		
		public static int getUserChoice()
		{
			int userResponse = 0;
			
			
			String userInput;
			do 
			{
				
				System.out.println("Enter your choice: ");
				System.out.println(ADD_PURCHASED_PART + ". Create Purchased Part ");
				System.out.println(ADD_MANUFACTURED_PART + ". Create Manufactured Part");
				System.out.println(LIST_ONE_PART + ". List a part");
				System.out.println(LIST_ALL_PARTS + ". List all parts");
				System.out.println(EXIT + ". Exit");
				userInput = keyboard.nextLine();
				//userInput = keyboard.nextInt();
				if (userInput == null || userInput.equals("")) {
					return 99;
				}
	userResponse = Integer.parseInt(userInput);
				//userResponse = userInput;
				if (userResponse < ADD_PURCHASED_PART || userResponse > EXIT){
					System.out.println("Invalid value. Enter a value " + ADD_PURCHASED_PART + " - " + EXIT);
				}
			} while (userResponse < ADD_PURCHASED_PART || userResponse > EXIT);
			return userResponse;
		}
		
		public static boolean checkID(int partID, ArrayList<Part>parts) {
			
			for (int i = 0; i < parts.size(); i++) {
				if (parts.get(i).getPartID() == partID) {
				
				return false;
			}
				
			
			}
			return true;
			
			}
		}
	
		
	
