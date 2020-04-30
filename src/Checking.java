/**
 * <h1> BankingApp </h1>
 * The BankingApp project is meant to emulate an ATM experience
 * 
 * Checking is the class that emulates a checking account * 
 * Please see 'www.com/docs'
 * @author CSS 1032 Group 1 - Grace, Roshni, Isaac, Rishi, Derick
 * @version 1.5
 * @since 2020-02-01
 */
public class Checking extends Account implements AccountInterface{
	private double balance = 1000;
	
	public Checking () {
		
	}
	
	public Checking (double b){
		balance = b;
	}
	
	public double getBalance() {
		return this.balance;
	}

	
	public double deposit(double a) {
		return this.balance += a;
	}
	
	public double withdraw (double a) {
		return this.balance -= a;
	}
	
	public void chargeFee() {
		this.balance -=2.95;
	}
	
	public String toString ()
	{
		
		return "Hello, Welcome to your Checking's Account\n"+ userName + "\nYour balance is: " +balance ;
	}


}
