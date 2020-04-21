import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * <h1> BankingApp </h1>
 * The BankingApp project is meant to emulate an ATM experience
 * 
 * Account defines the features of a user account
 * 
 * Please see 'www.com/docs'
 * @author Grace LaMalva
 * @version 1.3
 * @since 2020-02-01
 */
public class Account {

	protected boolean verified = false;
	
	protected int dailyLimit = 3;
	
	protected String userName;
	protected int loginAttempts = 2;
	
	public Account () {
		this.userName = "Team 1 Shared Account";
	
	}
	
	public Account (String u, String p) {
		
	}
	
	/**
	 * This method initializes the sequence for the user to enter the pin
	 * allowing for further interaction with the system
	 * @throws FileNotFoundException 
	 * @exception InvalidPinException
	 * @see InvalidPinException
	 */
	public void enterPin () throws FileNotFoundException {
		Scanner kb = new Scanner (System.in);
		boolean verified = false;
		Account a = new Account();
		
        List<String> list = new ArrayList<String>();
        list.add("$2a$12$.hUzNzZQR/inSb5nBpLAgeP60q4Y0TZ7RASb6soJf4SlDUJ.5Zo96");
        
        String origPin = list.get(0);
		
		while(!verified) {
			System.out.println("Enter your 4-digit pin: ");
			String pin = kb.nextLine();
		try {
	        boolean pinMatch = BCrypt.checkpw(pin, origPin);
			if (pinMatch){
				verified = true;
				this.verified = verified;
			}
			else if (pin.length() != 4) {
				loginAttempts--;
				throw new invalidPinException("The pin must be a length of 4");
			} 
			else if (pin.isEmpty()) {
				loginAttempts--;
				throw new invalidPinException("The pin cannot be empty");
			}
			else if (!pin.matches("^[0-9]*$")) {
				loginAttempts--;
				throw new invalidPinException("The pin cannot contain characters");
			}
			else if (pin.contains("-")) {
				loginAttempts--;
				throw new invalidPinException("The pin can't be negative");
			}
			else {
				System.out.println("Incorrect pin, you have: " + loginAttempts + " login attempts left");
				if (loginAttempts == 0)
				{
					System.exit(0);
				}
				loginAttempts--;
			}
			}catch (invalidPinException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	public int getDailyLimit() {
		return this.dailyLimit;
	}
	
	public void decrementDailyLimit() {
		this.dailyLimit--;
	}	

}
