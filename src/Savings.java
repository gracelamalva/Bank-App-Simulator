/**
 * <h1> BankingApp </h1>
 * The BankingApp project is meant to emulate an ATM experience
 * 
 * Savings is the class that emulates a savings account
 * 
 * Please see 'www.com/docs'
 * @author Grace LaMalva
 * @version 1.3
 * @since 2020-02-01
 */
public class Savings extends Account{
	private double balance = 5000;
	
	public Savings () {
		
	}
	
	public Savings (double b){
		balance = b;
	}
	
	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param a the amount to be deposited
	 * @return the balance of the user after the deposit
	 */
	public double deposit(double a) {
		return this.balance += a;
	}
	
	/**
	 * 
	 * @param a the amount to be withdrew
	 * @return the balance of the user after the withdrawal
	 */
	public double withdraw (double a) {
		return this.balance -= a;
	}
	
	/**
	 * This method charges the standard fee for usage to the current account.
	 */
	public void chargeFee() {
		this.balance -=2.95;
	}
	
	public String toString ()
	{
		
		return "Hello, Welcome to your Saving's Account\n"+ userName + "\nYour balance is: " +balance ;
	}
	
}
