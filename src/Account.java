import java.util.Scanner;

public class Account {

	protected boolean verified = false;
	
	protected int dailyLimit = 3;
	
	//protected boolean dailyLimitFlag = false;
	protected String userName;
	protected String pin = "1111";
	protected int loginAttempts = 2;
	
	public Account () {
		this.userName = "default";
	
	}
	
	public Account (String u, String p) {
		
	}
	
	public void setPin(String p) {
		this.pin = p;
	}
	
	public String getPin() {
		return this.pin;
	}
	
	/**
	 * This method initializes the sequence for the user to enter the pin
	 * allowing for further interaction with the system
	 * @exception InvalidPinException
	 * @see InvalidPinException
	 */
	public void enterPin () {
		Scanner kb = new Scanner (System.in);
		boolean verified = false;
		Account a = new Account();
		
		while(!verified) {
			System.out.println("Enter your 4-digit pin: "); //1111 default
			String pin = kb.nextLine();
		try {
			if (pin.equals(a.getPin())){
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
	
	public String toString () {
		return "Pin" + this.pin;
	}
	
	/*public boolean verifyAccount() {
		
		//throw new invalidPinNonIntegerException ("Invalid Pin only integers!");
		try {
			System.out.print("Attempting to verify acccount: ");
			throw new AccountExceptions("Error message in account");
		} catch (AccountExceptions e) {
			System.out.println("This is inside catch");
			System.out.println(e.getMessage());
		}
		
		return verified = false;
	}
	*/
	

}
