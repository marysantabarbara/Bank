/**
 * Class for accounts that holds an accounts fName, password, and balance. 
 * Right now the password will not be implemented. 
 * 
 * @author Mariel
 *
 */
public class Account {

	private static String fName;
	private static String lName;
	private static double balance;
	
	public Account() {
		fName = "";
		lName = "";
		balance = 0;
	}
	
	public Account(String fN, String lN, double bal) {
		fName = fN;
		lName = lN;
		balance = bal;
	}
	
	public String getfName() {
		return fName;
	}
	
	public static void setfName(String fName) {
		Account.fName = fName;
	}
	
	public static String getlName() {
		return lName;
	}
	
	public static void setlName(String lName) {
		Account.lName = lName;
	}
	
	public static double getBalance() {
		return balance;
	}
	
	public static void setBalance(double balance) {
		Account.balance = balance;
	}
	
}
