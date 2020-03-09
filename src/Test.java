/**
 * <h1> BankingApp </h1>
 * The BankingApp project is meant to emulate an ATM experience
 * 
 * Test is the class we will be using to launch the application
 * 
 * Please see 'www.com/docs'
 * @author Grace LaMalva
 * @version 1.3
 * @since 2020-02-01
 */

import java.util.Scanner;
public class Test {
	static Scanner kb = new Scanner (System.in);
	
	public static void main (String [] args) {		
		sequence();	
	}
	
	/**
	 * This method is the main ATM sequence
	 * @exception InvalidChoiceException on choice input error
	 * @see InvalidChoiceException
	 */
	public static void sequence () {

	Account a = new Account();
		
		while (a.dailyLimit >0)
		{
			a.enterPin();
		
			System.out.print("Welcome to Grace's ATM\nThis ATM charges a $2.95 usage fee");
			//System.out.println("Please enter your 4-digit pin to proceed:");
			System.out.println("Would you like to access your:\n1. Checkings\n2. Savings\nEnter the number of your selection");
			int choice = kb.nextInt();
			
		try {
			if (choice == 1) {
			checkingsSequence();
		}
		else if (choice == 2) {
			savingsSequence();
		}
		else{
			throw new InvalidChoiceException("You have to select either 1 or 2");
		}
					
		a.dailyLimit--;
			
		} catch (InvalidChoiceException e)	{
			System.out.println(e.getMessage());
			sequence();
		}
		
		if(a.dailyLimit == 0)
		{
			//a.dailyLimitFlag = true;
			System.out.println("You have reached your daily limit please leave!");
			System.exit(0);
		}
		
		
		System.out.println("Would you like to make another transaction?\n1. Yes\n2. No");
		choice = kb.nextInt();
		try {
		if (choice == 1 )
		{
			//a.dailyLimit--;
			sequence();
		}
		else if (choice == 2)
		{
			System.exit(0);
		}
		else 
		{
			throw new InvalidChoiceException("You must select choice 1 or 2");
		}
		} catch (InvalidChoiceException e)
		{
			e.getMessage();
			if (choice == 1 || choice == 2)
			{
				//a.dailyLimit--;
				sequence();
			}
			
		}
		
		}
	}
		
	public static void checkingsSequence() {
		Checking c = new Checking ();
		System.out.println(c);
		System.out.println("Would you like to:\n1. Deposit\n2. Withdraw\nEnter the number of your selection");
		int choice = kb.nextInt();
		try {
		if (choice == 1) {
			System.out.println("Enter the amount: ");
			double amount = kb.nextDouble();
			c.deposit(amount);
			c.chargeFee();
			System.out.println("Your new balance is: " + c.getBalance());	
		}
		if (choice == 2) {
			System.out.println("Enter the amount: ");
			double amount = kb.nextDouble();
			c.withdraw(amount);
			c.chargeFee();
			System.out.println("Your new balance is: " + c.getBalance());	
			
		}
		else {
			throw new InvalidChoiceException("You must select 1 or 2");
		}
		}catch (InvalidChoiceException e) {
			System.out.println(e);
			e.getMessage();
			checkingsSequence();
		}
	
	}
	
	
	public static void savingsSequence() {
		Savings s = new Savings ();
		System.out.println(s);
		System.out.println("Would you like to:\n1. Deposit\n2. Withdraw\nEnter the number of your selection");
		int choice = kb.nextInt();
		try {
		if (choice == 1) {
			System.out.println("Enter the amount: ");
			double amount = kb.nextDouble();
			s.deposit(amount);
			s.chargeFee();
			System.out.println("Your new balance is: " + s.getBalance());
		}
		if (choice == 2) {
			System.out.println("Enter the amount: ");
			double amount = kb.nextDouble();
			s.withdraw(amount);
			s.chargeFee();
			System.out.println("Your new balance is: " + s.getBalance());	
		}
		else
		{
			throw new InvalidChoiceException("You must select 1 or 2");
		}
		}catch (InvalidChoiceException e) {
			System.out.println(e);
			e.getMessage();
			savingsSequence();
		}
		
	}
		

}
