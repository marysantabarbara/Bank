import java.util.Scanner;
import java.util.LinkedList;

/**
 * ICS 355 - Assignment 1
 * 
 * @author Mary Santabarbara
 *
 */
public class Bank {
	
	private static LinkedList Accounts = new LinkedList();

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String response;
		
		do {
			menu();
			System.out.print(">");
			response = scan.nextLine();
			response = response.toLowerCase();
			
			if(!checkResponse(response)) {
				System.out.println("I am sorry, " + response + " is not a proper menu selection. "
						+ "Please re-enter the proper menu selection.");
				
				System.out.println("\nPress enter to continue.");
				scan.nextLine();
			}
			else {
				callMenu(response);
				if(!response.equals("exit")){
					System.out.println("\nPress enter to continue.");
					scan.nextLine();
				}
			}
			
		} while(!response.equals("exit"));
		
		scan.close();
		System.out.println("\nGood bye!");
	}
	
	private static void menu() {
		System.out.println("\n******************************************************\n"
						+ "\t\t\tMAIN MENU"
						+ "\n******************************************************\n"
						+ "Please type menu item in ALL CAPS then press enter.\n"
						+ "\n\tCREAT \t\tTo Create Account"
						+ "\n\tMANAG \t\tTo Manage Account"
						+ "\n\tMAINT \t\tTo Convert currency"
						+ "\n\tEXIT \t\tTo Exit this prompt \n"
						+ "\n******************************************************\n");
	}
	
	/**
	 * This checks if the response exists as an option. 
	 * @param r The response to be in check
	 * @return true If the response is a valid menu option
	 * 		   false If the response is not a valide option
	 */
	private static boolean checkResponse(String r) {
		String response = r;
		boolean exist;
		
		switch(response) {
		case "exit": exist = true; break;
		case "creat": exist = true; break;
		case "manag": exist = true; break;
		case "maint": exist = true; break;
			default:  exist = false; break;
		}
		
		return exist;
	}
	
	private static void callMenu(String r) {
		switch(r) {
		case "exit": break;
		case "creat": create(); break;
		case "manag": manage(); break;
		case "maint": maint(); break;
			default:  System.out.println("Something went wrong."
					+ " Please re-enter the menu selection.");
		}
	}
	
	private static void create() {
		Scanner scan = new Scanner(System.in);
		String firstName = "";
		String lastName = "";
		String validResponse = "";
		boolean valid = true;
		
		do {
			
			System.out.println("What is your first name?");
			System.out.print(">");
			firstName =scan.nextLine();
			
			System.out.println("What is your last name?");
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
	
		Account newAccount = new Account();
		newAccount.setfName(firstName.trim());
		newAccount.setlName(lastName.trim());
		newAccount.setBalance(0.0);
		
		boolean success = Accounts.add(newAccount);
		
		if(success) {
			System.out.println("Successfully created an account.");	
		} else {
			System.out.println("Failure occured while creating an account.");	
		}

		
	}
	
	private static void manage() {
		Scanner scan = new Scanner(System.in);
		String validSelection = "";
		boolean valid = false;
		String firstName = "";
		String lastName = "";
		String validResponse = "";
		
			do {
			
			System.out.println("What is your first name?");
			System.out.print(">");
			firstName =scan.nextLine();
			
			System.out.println("What is your last name?");
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
			default: System.out.println("Please enter a Y or a N, for yes or no");
			}
			
			
		}while(!valid);	
		
		Account acct = findAccount(firstName, lastName);
		
		if (acct == null) {
			System.out.println("You're account does not exist. Please make an account.");
		}
		else {
			do { 
				System.out.println("\n******************************************************\n"
					+ "*Please type menu item in ALL CAPS then press enter.\n*"
					+ "\n*\tADD \t\tTo Add a balance to your Account"
					+ "\n*\tWITH \t\tTo Withdraw from your Account"
					+ "\n*\tSEE \t\tTo see your current balance"
					+ "*\n******************************************************\n");
				
				System.out.print(">");
				validSelection = scan.nextLine();
			
				switch(validSelection.toLowerCase()) {
				case "add": addBalance(acct); valid = true; break;
				case "with": withdrawBalance(acct); valid = true; break;
				case "see": seeBalance(acct);  valid = true; break;
				default: valid = false; System.out.println("Please enter a menu item."); break;
				}
			
			}while(!valid);
		}	
		
	}
	
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
	
	private static void seeBalance(Account a) {
		Account tempAccount = a;
		if(!Accounts.isEmpty()) {
			System.out.println(tempAccount.getBalance());
		}
		else {
			System.out.println("No such account exists. Please create an account first.");
		}
	}
	
	private static Account findAccount(String fName, String lName) {
		Object returnValue = null;
		String first = fName.toLowerCase();
		String last = lName.toLowerCase();
		Account tempAccount;
		
		for(int i = 0; i < Accounts.size();) {
			tempAccount = (Account) Accounts.get(i);
			
			String tempFirst = (tempAccount.getfName()).toLowerCase();
			String tempLast = (tempAccount.getlName()).toLowerCase();
			
			
			if(tempFirst.equals(first) && tempLast.equals(last)) {
				returnValue = tempAccount;
			}
			else {
				returnValue = null;
			}
			++i;
		}
		return (Account) returnValue;
	}
	
	private static void  maint() {
		Scanner scan = new Scanner(System.in);
		boolean loopCatch = true;
		double amount = 0;
		double amountConvert = 0;
		String difCurrency = "";
		
		System.out.println("\nEnter the amount to be converted in US dollars. Then press enter.");
		do {
			try {
				System.out.print(">");
				amount = scan.nextDouble();
				loopCatch = false;
			} catch (Exception e) {
				System.out.println("Please enter a number");
				scan.nextLine();
				loopCatch = true;
			}
		} while(loopCatch);
		
		System.out.println("\nWhat currency do you want to see?"
				+ "\n\tUK Pound"
				+ "\n\tYen");
		
		do {
			try {
				System.out.print(">");
				difCurrency = scan.nextLine();	
				
				switch(difCurrency.toLowerCase()) {
				case "uk pound": amountConvert = convertUK(amount); difCurrency = "UK Pound"; loopCatch = false; break;
				case "yen": amountConvert = convertYen(amount); difCurrency = "Yen"; loopCatch = false; break;
				default: System.out.println("Please enter one of the selections above.");loopCatch = true;
				}
				
			} catch (Exception e) {
				System.out.println("\nPlease enter one of the currencies listed.");
				loopCatch = true;
			}
			
		} while(loopCatch);
		
		System.out.println("The amount " + amount + " in US Dollars, is " + amountConvert + " in " + difCurrency);
		
	}
	
	private static double convertUK(double amt) {
		return amt * 0.76;
	}
	
	private static double convertYen(double amt) {
		return amt * 112.26;
	}

}
