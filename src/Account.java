import java.util.Random;

/**
 * Class for accounts that holds an accounts fName, password, and balance. 
 * Right now the password will not be implemented. 
 * 
 * @author Mariel
 *
 */
/**
 * @author Mariel
 *
 */
public class Account {

	private String fName;
	private String lName;
	private String un;
	private int pw;
	private String secret;
	private boolean admin;
	private double balance;
	private String currency;
	
	/**
	 * Creates an empty Acount.
	 */
	public Account() {
		this.fName = "";
		this.lName = "";
		this.un = "";
		this.pw = 0;
		this.secret = "";
		this.balance = 0;
		this.currency = "";
	}
	
	/**
	 * Creates and sets an accounts settings
	 * @param fN The first name of the user
	 * @param lN The last name of the user
	 * @param user The user name of the user
	 * @param pass The password entered of the user
	 */
	public Account(String fN, String lN, String user, String pass) {		
		admin = false;
		this.fName = fN;
		this.lName = lN;
		this.balance = 0.0;
		this.un = user;
		this.secret = generateSecret();
		this.pw = (pass + secret).hashCode();
		this.currency = "us";
	}
	
	
	/**
	 * Generates the salt or the secret for the hashed password.
	 * @return The generated salt.
	 */
	private static String generateSecret() {
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
		String generated = "";
		
		for(int i = 0; i < 5; i++) {
			generated = generated + alphabet.charAt(r.nextInt(alphabet.length()));
		}
		
		return generated;
		
	}
	
	/**
	 * Gets the users first name
	 * @return The first name
	 */
	public String getfName() {
		return fName;
	}
	
	/**
	 * Sets the users first name
	 * @param fName The first name being set.
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	/**
	 * Gets the users last name
	 * @return The last name
	 */
	public String getlName() {
		return lName;
	}
	
	/**
	 * Sets the users last name
	 * @param lName The last name being set.
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * Gets the users username
	 * @return The username
	 */
	public String getUn() {
		return un;
	}

	/**
	 * Sets the users username
	 * @param un The username being set.
	 */
	public void setUn(String un) {
		this.un = un;
	}

	/**
	 * Gets the secret salt
	 * @return The secret salt
	 */
	public String getSecret() {
		return this.secret;
	}

	/**
	 * Sets the secret salt
	 * @param secret The secret salt being set.
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Checks if the user is an admin
	 * @return True if the user is an admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * Sets the user as an admin
	 * @param admin The authorization of the user
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Gets the balance of the suer
	 * @return The balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Sets the balance of the user
	 * @param balance the balance being set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the hashed password
	 * @return the hashed password
	 */
	public int getPw() {
		return this.pw;
	}

	/**
	 * Sets the hashed password
	 * @param pw
	 */
	public void setPw(int pw) {
		this.pw = pw;
	}

	/**
	 * Gets the currency of the person
	 * @return
	 */
	public String getCurrency() {
		return currency;
	}

	
	/**
	 * The currency being set
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
