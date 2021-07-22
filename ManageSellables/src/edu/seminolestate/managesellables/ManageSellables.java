package edu.seminolestate.managesellables;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;
import edu.seminolestate.sellable.Sellable;
import edu.seminolestate.stock.IllegalStockArgumentException;
import edu.seminolestate.stock.Stock;
import edu.seminolestate.stock.*;
import edu.seminolestate.vehicle.*;
//Bijan Amirzadehasl 07/21/2021

public class ManageSellables {
	
	
	
	private static Scanner keyboard = new Scanner(System.in);
	
	private static final int ADD_STOCK = 1;
	private static final int ADD_TRUCK = 2;
	private static final int ADD_AUTOMOBILE = 3;
	private static final int DISPLAY_ALL_SALES = 4;
	private static final int EXIT = 5;
	
	static ArrayList<Sellable> sellableItems = new ArrayList<Sellable>();
	
	
	
	public static void main(String[] args) {
		
		int response;
	do {
		response = menu();
		switch (response) {
		case ADD_STOCK:
			Sellable stock = null;
			try {
				stock = new Stock(
						getString("Enter the certificate number: "), 
						getDouble("Enter the number of shares: "), 
						getDouble("Enter the per share price: "),
						getDate("Enter the date purchased (like 6/23/2016): "),
						getDate("Enter the date sold (like 6/23/2016): ") );
				sellableItems.add(stock);
			} catch (IllegalStockArgumentException e) {
				System.out.println(e.getMessage());
			}

			break;

		case ADD_TRUCK:
			Sellable truck = null;
			try {
				truck = new Truck(
						getString("Enter the VIN number:"),
						getDouble("Enter the purchase price: "),
						getString("Enter the make:"),
						getString("Enter the model: "),
						getModelYear("Enter the model year: "),
						getInt("Enter the mileage: "),
						getDouble("Enter the cargo capacity: "),
						getDouble("Enter the horse power: "),
						getInt("Enter the number of Axels: ") );
				sellableItems.add(truck);
				} catch (IllegalVehicleArgumentException e) {
					System.out.println(e.getMessage());
				}

			break;
			
			
		case ADD_AUTOMOBILE:
			
			Sellable auto = null;
			try {
				auto = new Automobile(
						getString("Enter the VIN number:"),
						getDouble("Enter the purchase price: "),
						getString("Enter the make:"),
						getString("Enter the model: "),
						getModelYear("Enter the model year: "),
						getInt("Enter the mileage: "),
						getInt("Enter the number of seats: ") );
				sellableItems.add(auto);
				} catch (IllegalVehicleArgumentException e) {
					System.out.println(e.getMessage());
				}
			break;
			
			
			
		case DISPLAY_ALL_SALES:
			if (sellableItems.isEmpty()) {
				System.out.print("Sellable items are empty.\n");
			} else
				for (int i = 0; i < sellableItems.size(); i++) {
					System.out.print(sellableItems.get(i) + "\n");
				
						System.out.printf("The sale amount is: $%.2f\n", sellableItems.get(i).getSaleAmount());
					
					
				}
			
			
	
			System.out.print("\n"); 

			break;
			
			
		case EXIT:

			System.out.println("Thanks for using my Sellable Items program!!!");
		}
	} while (response != EXIT);
	}
	
	public static int menu() {

		int userResponse = 0;
		do {
			try {
				System.out.println("1. Add a Stock. \n2. Add a Truck. \n3. Add an Autombile. \n4. Display all sales. \n5. Exit");
				userResponse = keyboard.nextInt();
				keyboard.nextLine();
				if (userResponse < 1 || userResponse > 5) {
					System.out.println("Enter a value of 1 to 5.");
				}
			} catch (Exception E) {
				System.out.println("Please enter a valid value.\n");
			}

		} while (userResponse < 1 || userResponse > 5);

		return userResponse;

	}
	private static int getModelYear(String prompt) {
		int r;
		do {

			System.out.print(prompt);
			r = keyboard.nextInt();
			if (r < 1900) {
				System.out.print("The model year must be newer than 1900. Re-enter value.\n");
			}

		} while (r < 1900);
		return r;
	}


	private static int getInt(String prompt) {
		int r;
		do {

			System.out.print(prompt);
			r = keyboard.nextInt();
			keyboard.nextLine();
			if (r <= 0) {
				System.out.print("The value entered must be greater than 0. Re-enter value.\n");
			}

		} while (r <= 0);
		return r;
	}


	private static double getDouble(String prompt) {
		
		String userValue = null;
		double validDouble = 0;
		boolean isValidDouble = false;
		do {
			System.out.println(prompt);
			try{
				userValue = keyboard.nextLine();
				validDouble = Double.parseDouble(userValue);
				isValidDouble = true;
			} catch (NumberFormatException e) {
				System.out.println("Enter only decimal numbers");
			}
		} while (! isValidDouble);
		
		return validDouble;
	}


	private static LocalDate getDate(String string) {
		String userInput;
		LocalDate date = null;
		do {
			System.out.print(string);
			userInput = keyboard.nextLine();
			// if (userInput == null || userInput.length() < 1) {
			// System.out.print("Enter a valid date.");
			// }
			try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
				date = LocalDate.parse(userInput, format);
			} catch (DateTimeParseException e) {
				System.out.println("Enter a valid date like 03/03/2012\n");
			}
		} while (date == null);

		return date;
	}

	private static String getString(String prompt) {
		String r;
		do {
			System.out.print(prompt);

			r = keyboard.nextLine();
			if (r == null || r.length() < 1) {
				System.out.print("The name can not be null or less than 1. Re-enter value.\n");
			}

		} while (r == null || r.length() < 1);
		return r;
		
	}
	
}



