package edu.seminolestate.managepurchases;
//Bijan Amirzadehasl 07/08/2021
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * AUTHOR:	
 * DATE:	
 * PURPOSE:	Enable the user to track purchases made at a store.
 */
public class ManagePurchases {
	/*
	 * The data must be written to a relative file location using the file name
	 * purchases.txt. Make this file name a class constant and use the constant in
	 * your code wherever necessary (instead of purchases.txt).
	 */
	private static final String FILE_NAME = "purchases.txt";
	// Create an ArrayList to store Purchase objects.
	private static ArrayList<Purchases> purchases;

	private static Scanner keyboard = new Scanner(System.in);
	private static final int ADD_PURCHASE = 1;
	private static final int DISPLAY_ALL_PURCHASES = 2;
	private static final int EXIT = 3;

	public static void main(String[] args) {
		purchases = new ArrayList<Purchases>();
		File file = new File(FILE_NAME);

		/*
		 * When the application first starts check to see if the purchases.txt file
		 * exists. If it does, read each piece of data for an object, create the
		 * Purchase object, and store the Purchase object into the ArrayList. If the
		 * file doesn't exist just continue with an empty ArrayList.
		 */
		int response;
		do {
			response = menu();
			switch (response) {
			case ADD_PURCHASE:
				String pName = getString("Enter the product name.");

				String sName = getString("Enter the store name.");

				LocalDate date = getDate();

				double pCost = getDouble("Enter the cost.");
				
				try {
					purchases.add(new Purchases(pName, sName, date, pCost));
				} catch (IllegalPurchaseArgumentException e) {
					System.out.print("One of the values entered was incorrect.");
				}
				

				/*
				 * When the user chooses menu option 1, prompt for a product name, a store name,
				 * purchase date, and a cost. Edit these values such that: the product name
				 * cannot have a length less than one; the store name cannot have a length less
				 * than one; the purchase date cannot be null; the cost cannot be less than
				 * zero. Edits are done in the 'get' methods called from this method. Values are
				 * not returned until valid. If the data is valid, create a Purchase object and
				 * store it in the ArrayList.
				 */

				break;
			case DISPLAY_ALL_PURCHASES:
				if (purchases.isEmpty()) {
					System.out.print("Purchases are empty.");
				} else
					for (int i = 0; i < purchases.size(); i++) {
						System.out.print(purchases.get(i));
					}

				break;
			case EXIT:
				/*
				 * When the user chooses menu option 3, check to see if the ArrayList has any
				 * Purchase objects in it. If it does, write the data from each object to a text
				 * file. Then display the message "Thank you for using the Purchase Tracker" and
				 * end the application.
				 */
				if (purchases.size() > 0) {
					writeFileFromArrayList();
				}

				System.out.println("Thanks for using the purchases manager.");
			}
		} while (response != EXIT);
	}

	/*
	 * Remember to write the Purchase data as text data to the file. I recommend the
	 * following to write the data. For each Purchase object in the ArrayList, -
	 * call the get method for the product name and write this as a line to the
	 * file; - call the get method for store name and write this as a line to the
	 * file; - call the get method for the purchase date, convert it to a string and
	 * write this as a line to the file; - call the get method for the cost, convert
	 * this to a String, and write this as a line to the file. In this design, each
	 * object will create four lines of text data in the output file.
	 */
	public static void writeFileFromArrayList() {
		try {

			File nFile = new File("purchases.txt");
			FileWriter fOutput = new FileWriter(nFile, true);
			//if (nFile.exists()) {
			//	System.out.println("File already exists");
		//	}

		//	else
				for (int i = 0; i < purchases.size(); i++) {

					fOutput.write(purchases.get(i).getProductName());
					fOutput.write ("\n");
					fOutput.write(purchases.get(i).getStoreName());
					fOutput.write ("\n");
					DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
					String Date = purchases.get(i).getPurchaseDate().format(format);
					fOutput.write(Date);
					fOutput.write ("\n");
					String Cost = Double.toString(purchases.get(i).getCost());
					fOutput.write(Cost);
					fOutput.write ("\n");

				}
				fOutput.close();
		} catch (IOException e) {
			System.out.print("An error occurred!");
		}
	}

	/*
	 * java.io.File file = new Java.io.File("purchases.txt"); if (file.exists()) {
	 * System.out.println("File already exists") }
	 * 
	 * java.io.PrintWrite output = new java.io.PrintWriter(file)
	 * 
	 * output.print("") output.print("") out
	 */
	/*
	 * To read the file I recommend the following. Each set of four lines in the
	 * file are required to create a Purchase object. As long as the file has more
	 * data to read, - read a line and consider this the product name; - read the
	 * next line and consider this the store name; - read the next line and consider
	 * this the purchase date; convert this string version of the purchase date to a
	 * LocalDate object; - read the next line and consider this the cost; convert
	 * this String to a double. Use these four pieces of data to instantiate a
	 * Purchase object. Put the Purchase object into the ArrayList. Continue
	 * processing the next four lines of data from the file, if any.
	 */
	public static void loadArrayListFromFile() {
		try {
			File bFile = new File("purchases.txt");
			if (bFile.exists())
				;
			{

				Scanner input = new Scanner(bFile);
				while (input.hasNext()) {
					try {
						String productName = input.next();
						String storeName = input.next();
						String purchaseDate = input.next();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("mm/dd/yyyy");
						LocalDate date = LocalDate.parse(purchaseDate, format);
						String cost = input.next();
						double dCost = Double.parseDouble(cost);
						purchases.add(new Purchases(productName, storeName, date, dCost));

						System.out.println(productName + " " + storeName + " " + purchaseDate + " " + cost);
					} catch (IllegalPurchaseArgumentException e) {
						System.out.print("Invalid input of arguments." + e.getLocalizedMessage());
					}

				}
			}
		} catch (IOException e) {

		}

	}

	/*
	 * Display a menu that has choices for: 1 - Add a purchase; 2 - Display all
	 * purchases; 3 - Exit. Display an error message and repeat the menu if some
	 * other value is entered. Catch an exception if letters instead of numbers are
	 * entered.
	 */
	public static int menu() {

		int userResponse = 0;
		do {
			try {
				System.out.println("1. Add a purchase. \n2. Display all purchases. \n3. Exit.");
				userResponse = keyboard.nextInt();
				keyboard.nextLine();
				if (userResponse < 1 || userResponse > 3) {
					System.out.println("Enter a value of 1 to 3.");
				}
			} catch (Exception E) {
				System.out.println("Please enter a valid value.");
			}

		} while (userResponse < 1 || userResponse > 3);

		return userResponse;

	}

	/*
	 * This method gets a line of text from user and converts it to a LocalDate
	 * object. The LocalDate object is then returned to whatever method asked for
	 * it. This method will keep looping and asking for a valid date until it gets
	 * one!
	 */
	public static LocalDate getDate() {
		String userInput;
		LocalDate date = null;
		do {
			System.out.print("Enter a date");
			userInput = keyboard.nextLine();
			// if (userInput == null || userInput.length() < 1) {
			// System.out.print("Enter a valid date.");
			// }
			try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
				date = LocalDate.parse(userInput, format);
			} catch (DateTimeParseException e) {
				System.out.println("Enter a valid date like 03/03/2012");
			}
		} while (date == null);

		return date;
	}

	/*
	 * This method gets a line of text from user (a String object). The only edits
	 * are for null or empty input. Null can't be generated from keyboard input
	 * (hard code a test) but an empty string can be generated by just hitting the
	 * ENTER key w/o entering any data. This method will keep looping and asking for
	 * a valid String until it gets one!
	 */
	public static String getString(String prompt) {

		String r;
		do {
			System.out.print(prompt);

			r = keyboard.nextLine();
			if (r == null || r.length() < 1) {
				System.out.print("Product name can not be null or less than 1. Re-enter value.");
			}

		} while (r == null || r.length() < 1);
		return r;
	}

	/*
	 * This method gets a line of text from user (a String object) and converts it
	 * to a double. The only edits are numeric characters must be entered and the
	 * converted value must be > 0. This method will keep looping and asking for a
	 * valid double until it gets one!
	 */
	public static double getDouble(String prompt) {

		double r;
		do {

			System.out.print(prompt);
			r = keyboard.nextDouble();
			if (r <= 0) {
				System.out.print("Product cost must be greater than 0. Re-enter value.");
			}

		} while (r <= 0);
		return r;

	}
}
