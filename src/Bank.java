import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * ICS 355 - Assignment 2
 * 
 * @author Mary Santabarbara
 *
 */
public class Bank {
	
	private static LinkedList<Account> Accounts = new LinkedList<Account>();
	private static String FILENAME = "accountsList.txt";

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String response;
		String loginresponse;
		Account loggedAccount = null;
		
		//Import file and add to linked list
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Log in and confirm user name and password.
		do {
			printLoginMenu();
			loginresponse = scan.nextLine();
			loginresponse = loginresponse.toLowerCase();
			
			if(!loginresponse.equals("exit")) {
				loggedAccount = login(loginresponse);
				
				System.out.println("");
				if(loggedAccount != null) {
					loginresponse = "exit";
				}

				//System.out.println("Login resposne = " + loginresponse);
				//System.out.println("Logged Account = " + loggedAccount.getUn());
			}
			
		}while(!loginresponse.equals("exit"));
		
		if(loggedAccount != null){
			do {
				if(loggedAccount.isAdmin()) {
					printAdminMenu();
				}
				else {
					printMenu();
				}
				
				response = scan.nextLine();
				response = response.toLowerCase();
				
				if(!checkMenuResponse(response)) {
					System.out.println("I am sorry, " + response + " is not a proper menu selection. "
							+ "Please re-enter the proper menu selection.");
					
					System.out.println("\nPress enter to continue.");
					scan.nextLine();
				}
				else {
					callMenuOption(response, loggedAccount);
					if(!response.equals("exit")){
						System.out.println("\nPress enter to continue.");
						scan.nextLine();
					}
				}
				
			} while(!response.equals("exit"));
			
			System.out.println("\nGood bye!");
		}
		else {
			System.out.println("\nGood bye!");
		}
				
		scan.close();
		
		try {
			writeFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints out the Log In menu.
	 */
	private static void printLoginMenu() {
		System.out.println("\n******************************************************\n"
				+ "\t\tWelcome to MS Bank"
				+ "\n******************************************************\n"
				+ "Please login by typing your username then press enter\n"
				+ "\t or type exit and enter to exit"
				+ "\n******************************************************\n");

		System.out.print(">");
	}
	/**
	 * Prints out Main menu for regular users.
	 */
	private static void printMenu() {
		System.out.println("\n******************************************************\n"
						+ "\t\t\tMAIN MENU"
						+ "\n******************************************************\n"
						+ "Please type menu item in ALL CAPS then press enter.\n"
						+ "\n\tADD \t\tTo Add balance to your account"
						+ "\n\tWITH \t\tTo Withdraw from your account"
						+ "\n\tTRANS \t\tTo transfer balance to another account"
						+ "\n\tSEE \t\tTo see your current balance"
						//+ "\n\tCONV \t\tTo convert your balance to other currency"
						+ "\n\tEXIT \t\tTo Exit this prompt \n"
						+ "\n******************************************************\n");

		System.out.print(">");
	}
	
	/**
	 * Prints out the Main menu for admin users.
	 */
	private static void printAdminMenu() {
		System.out.println("\n******************************************************\n"
						+ "\t\t\tMAIN MENU"
						+ "\n******************************************************\n"
						+ "Please type menu item in ALL CAPS then press enter.\n"
						+ "\n\tCREAT \t\tTo Add an Account"
						+ "\n\tREM \t\tTo Remove an Account"
						+ "\n\tEXIT \t\tTo Exit this prompt \n"
						+ "\n******************************************************\n");

		System.out.print(">");
	}
	
	/**
	 * This checks if the response exists as an option. 
	 * @param r The response to be in check
	 * @return true If the response is a valid menu option
	 * 		   false If the response is not a valid option
	 */
	private static boolean checkMenuResponse(String r) {
		String response = r;
		boolean exist;
		
		switch(response) {
		case "exit": exist = true; break;
		case "add": exist = true; break;
		case "with": exist = true; break;
		case "trans": exist = true;break;
		case "see": exist = true; break;
		//case "conv": exist = true; break;
		case "creat": exist = true; break;
		case "rem": exist = true;break;
			default:  exist = false; break;
		}
		
		return exist;
	}
		
	/**
	 * Checks the string and calls the matching menu option.
	 * @param r
	 */
	private static void callMenuOption(String response, Account acc) {
		switch(response) {
		case "exit": break;
		case "add": addBalance(acc); break;
		case "with": withdrawBalance(acc); break;
		case "trans": transferBalance(acc); break;
		case "see": seeBalance(acc); break;
		//case "conv": convertBalance(acc); break;
		case "creat": addUser(); break;
		case "rem": removeUser();break;
			default:  System.out.println("Something went wrong."
					+ " Please re-enter the menu selection.");
		}
	}
	
	/**
	 * Create a new user.
	 */
	private static void addUser() {
		Scanner scan = new Scanner(System.in);
		String firstName = "";
		String lastName = "";
		String username = "";
		String pass = "";
		String pass2 = " ";
		String validResponse = "";
		boolean valid = false;
		
		do {
			
			System.out.println("What is the first name?");
			System.out.print(">");
			firstName =scan.nextLine();
			
			System.out.println("What is the last name?");
			System.out.print(">");
			lastName =scan.nextLine();
			
			System.out.println("Is the name writen below correct?\n"
					+ firstName + " " + lastName
					+ "\n\n Enter Y for Yes or N for No");
			System.out.print(">");
			validResponse = scan.nextLine();
			
			switch(validResponse.toLowerCase()) {
			case "y": valid = true; break;
			case "n": valid = false; break;
			default: valid = false; System.out.println("Please enter a Y or a N, for yes or no"); break;
			}
			
		}while(!valid);
		
		valid = false;
		validResponse = "";
		
		do {
			
			System.out.println("Please set the username");
			System.out.print(">");
			username =scan.nextLine();
			
			System.out.println("Is the username writen below correct?\n"
					+ username
					+ "\n\n Enter Y for Yes or N for No");
			System.out.print(">");
			validResponse = scan.nextLine();
			
			switch(validResponse.toLowerCase()) {
			case "y": valid = true; break;
			case "n": valid = false; break;
			default: valid = false; System.out.println("Please enter a Y or a N, for yes or no"); break;
			}
			
		}while(!valid);
	
		do {
			
			System.out.println("Please type the password");
			System.out.print(">");
			pass =scan.nextLine();
			
			System.out.println("Please re-type the password");
			System.out.print(">");
			pass2 =scan.nextLine();

			if(!pass.equals(pass2)) {
				System.out.println("You're passwords did not match. Please try again.");
				System.out.println(pass + "," + pass2 + ".");
			}	
			
		}while(!pass.equals(pass2));
		
		username = username.toLowerCase();
		
		Account newAccount = new Account(firstName, lastName, username, pass);
		
		boolean success = Accounts.add(newAccount);
		
		if(success) {
			System.out.println("Successfully created an account.");	
		} else {
			System.out.println("Failure occured while creating an account.");	
		}

	}
	
	/**
	 * Removes a chosen user by username.
	 */
	private static void removeUser() {
		Scanner scan = new Scanner(System.in);
		String accountUN;
		Account current;
		boolean found = false;
		
		System.out.println("Which user should be removed?");
		System.out.print(">");
		
		accountUN = scan.nextLine();
		
		for(int i = 0; i < Accounts.size(); i++) {
			current = Accounts.get(i);
			
			if(current.getUn().equals(accountUN)) {
				Accounts.remove(i);
				found = true;
			}
		}
		
		if(found) {
			System.out.println("Removed " + accountUN);
		}
		else {
			System.out.println("Did not find the username " + accountUN);
		}
	}
		
	/**
	 * Adds a balance to the account.
	 * @param a The account to modify
	 */
	private static void addBalance(Account a) {
		Scanner scan = new Scanner(System.in);
		Account temp = a;
		double balance = 0;
		boolean valid = false;
		
		if(!Accounts.isEmpty()) {			
			do {
				System.out.println("How much do you want to add to your account?");
				try {
					System.out.print(">");
					balance = scan.nextDouble();
					valid = true;					
				}catch (Exception e) {
					System.out.println("Please enter a amount in numbers.");
				}
				scan.nextLine();
			}while(!valid);

			temp.setBalance(temp.getBalance() + balance);
			
			System.out.println("You're new balance is " + temp.getBalance());
			
		}
		else {
			System.out.println("No such account exists. Please create an account first.");
		}
		
	}
	
	/**
	 * Withdraws a balance from an Account
	 * @param a The account to modify
	 */
	private static void withdrawBalance(Account a) {
		Scanner scan = new Scanner(System.in);
		Account temp = a;
		double balance = 0;
		boolean valid = false;
		
		if(!Accounts.isEmpty()) {
			do {
				System.out.println("How much do you want to withdraw from your account?");
				try {
					System.out.print(">");
					balance = scan.nextDouble();
					valid = true;					
				}catch (Exception e) {
					System.out.println("Please enter a amount in numbers.");
					
				}
				scan.nextLine();
			}while(!valid);

			temp.setBalance(temp.getBalance() - balance);
			
			System.out.println("You're new balance is " + temp.getBalance());
			
		}
		else {
			System.out.println("No such account exists. Please create an account first.");
		}
		
	}
	
	
	/**
	 * Transfer a balance from the account to another users account.
	 * @param acc The account giving away the money.
	 */
	private static void transferBalance(Account acc) {
		Scanner scan = new Scanner(System.in);
		String accountUN;
		double amount = 0.0;
		Account current, foundAccount = null;
		boolean found = false;
		
		System.out.println("Which user do you want to transfer money to?");
		System.out.print(">");
		
		accountUN = scan.nextLine();
		
		for(int i = 0; i < Accounts.size(); i++) {
			current = Accounts.get(i);
			
			if(current.getUn().equals(accountUN)) {
				foundAccount = current;
				found = true;
			}
		}
		
		if(found) {
			System.out.println("How much do you want to transfer to account?");
			try {
				System.out.print(">");
				amount = scan.nextDouble();			
			}catch (Exception e) {
				System.out.println("Please enter a amount in numbers.");
			}
			scan.nextLine();
			
			foundAccount.setBalance(foundAccount.getBalance() + amount);
			acc.setBalance(acc.getBalance() - amount);
			
			System.out.println("Your new balance is " + acc.getBalance());
			System.out.println("The user " + accountUN +"'s new balance is " + foundAccount.getBalance());
			
		}
		else {
			System.out.println("Did not find the username " + accountUN);
		}
	}
	/**
	 * Look at the current balance of the account
	 * @param a The account to view.
	 */
	private static void seeBalance(Account a) {
		Account tempAccount = a;
		if(!Accounts.isEmpty()) {
			System.out.println("Your current balance is " + tempAccount.getBalance());
		}
		else {
			System.out.println("No such account exists. Please create an account first.");
		}
	}
	
	/**
	 * Converts the accounts balance to a new currency.
	 * @param a The account to change balance.
	 */
	private static void convertBalance(Account a) {
		Account account = a;
		Scanner scan = new Scanner(System.in);
		String newCurr = "";
		boolean valid = false;
		
		do {
			System.out.println("Which currency do you convert your balance to?\n"
					+ "UK\t or \t Yen\n"
					+ "Please type one of the options.");
			newCurr = scan.nextLine();
	
			switch(newCurr.toLowerCase()) {
			case "uk" : valid = true; break;
			case "yen": valid = true; break;
			default: valid = false; System.out.println("Please enter one of the three options"); break;
			}
		
		} while(!valid);
		
		if(a.getCurrency().equals(newCurr)) {
			System.out.println("You already have " + newCurr + " set as your currency");
		}
		else {
			switch(newCurr.toLowerCase()) {
			case "uk" : a.setBalance(convertUK(a.getBalance())); a.setCurrency("uk"); break;
			case "yen": a.setBalance(convertYen(a.getBalance()));a.setCurrency("yen"); break;
			default: valid = false; System.out.println("Please enter one of the three options"); break;
			}
		}
		System.out.println("Your balance is now " + a.getBalance() + ".");
	}
	
	/**
	 * Conversion from US dollars to UK dollars.
	 * @param amt The amount in US dollars to be converted 
	 * @return The converted amount in UK dollars
	 */
	private static double convertUK(double amt) {
		return amt * 0.76;
	}
	
	
	/**
	 * Conversion from US dollars to Yen
	 * @param amt The ammount in US dollars to be converted
	 * @return The converted amount in Yen
	 */
	private static double convertYen(double amt) {
		return amt * 112.26;
	}
	
	/**
	 * Read the text file and make a linked list.
	 * @return 
	 * @throws IOException 
	 */
	private static void readFile() throws IOException {
		File accountsList = new File("accountsList.txt");
		Scanner reader = new Scanner( accountsList );
		Account newAccount = null;

		
		while(reader.hasNextLine()) {
			newAccount = new Account();

			newAccount.setAdmin(reader.nextBoolean()); //1
			reader.nextLine(); 
			newAccount.setfName(reader.nextLine()); //2
			newAccount.setlName(reader.nextLine()); //3
			newAccount.setUn(reader.nextLine()); //4
			newAccount.setPw(reader.nextInt());
			reader.nextLine(); //5
			newAccount.setSecret(reader.nextLine());//6
			newAccount.setBalance(reader.nextDouble());//7
			//newAccount.setCurrency(reader.nextLine());//8
			reader.nextLine(); //takes away line after balance
			reader.nextLine(); //takes away break between accounts
			
			Accounts.add(newAccount);
			
			/** Debug section
			if(success) {
				System.out.println("Successfully created an account.");	
			} else {
				System.out.println("Failure occured while creating an account.");	
			}
			 */
			newAccount = null;
		}		
				
	}
	
	/**
	 * @throws FileNotFoundException
	 */
	private static void writeFile() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(FILENAME);
		Account current = null;
		
		for(int i = 0; i < Accounts.size(); i++) {
			current = Accounts.get(i);
			
			writer.println(current.isAdmin());
			writer.println(current.getfName());
			writer.println(current.getlName());
			writer.println(current.getUn());
			writer.println(current.getPw());
			writer.println(current.getSecret());
			writer.println(current.getBalance());
			//writer.println(current.getCurrency());
			writer.println();
			
		}		
		writer.close();
	}
	
	/**
	 * @param username
	 * @return
	 */
	private static Account login(String un) {
		Account current;
		String username = un.toLowerCase();
		
		for(int i = 0; i < Accounts.size(); i++) {
			current = Accounts.get(i);
			
			if(current.getUn().equals(username)){
				if(validatePass(current)) {
					return current;
				}
				else {
					System.out.println("You've reached your maximum password tries. Please contact your bank admin to help you.");
					return null;
				}
			}			
		}
		
		System.out.println("Username not found.");
		return null;
	}

	/**
	 * @param ac
	 */
	private static boolean validatePass(Account ac) {
		Scanner scan = new Scanner(System.in);
		String pass;
		int hashedPass;
		int maxTries = 3;
		
		for(int passwordCount = 0; passwordCount < maxTries; passwordCount++) {
			System.out.println("\n******************************************************\n"
					+ "\t\tWelcome " + ac.getUn()
					+ "\n******************************************************\n"
					+ "\tType your password\n"
					+ "\n******************************************************\n");
			System.out.print(">");
			pass= scan.nextLine();
			
			//System.out.println("Password:" + pass);
			//System.out.println("Account password: " + ac.getPw());
			
			hashedPass = (pass + ac.getSecret()).hashCode();
			
			if(hashedPass == ac.getPw()) {
				return true;
			}
		}	
		
		return false;
		
	}
}
