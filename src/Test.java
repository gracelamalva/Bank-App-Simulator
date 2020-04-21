/**
 * <h1> BankingApp </h1>
 * The BankingApp project is meant to emulate an ATM experience
 * 
 * Test is the class we will be using to launch the application
 * 
 * Please see 'www.com/docs'
 * @author Grace LaMalva
 * @version 1.5
 * @since 2020-02-01
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
public class Test {
	static Scanner kb = new Scanner (System.in);
	
	public static void main (String [] args) throws FileNotFoundException {		
		sequence();	
	}
	
	public static void sequence () throws FileNotFoundException {

	Account a = new Account();
			
			a.enterPin();
		
			System.out.print("Welcome to Team 1's ATM\nThis ATM charges a $2.95 usage fee");
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
			
		} catch (InvalidChoiceException e)	{
			System.out.println(e.getMessage());
			sequence();
		}
		
	}
		
	public static void checkingsSequence() {
		Checking c = new Checking ();
		System.out.println(c);
		System.out.println("Would you like to:\n1. Deposit\n2. Withdraw\nEnter the number of your selection");
		int choice = kb.nextInt();
		try {
		if (choice == 1) {
			c.deposit(validateAmount());
			c.chargeFee();
			System.out.println("Your new balance is: " + c.getBalance());	
		}
		else if (choice == 2) {
			
			c.withdraw(validateAmount());
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
			s.deposit(validateAmount());
			s.chargeFee();
			System.out.println("Your new balance is: " + s.getBalance());
		}
		else if (choice == 2) {
			s.withdraw(validateAmount());
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
	/**
	 * This method demonstrates the principle of input validation to ensure the user enters a double amount.
	 * @author gracelamalva
	 * @version 1.4
	 * @return the validated double amount to be deposited or withdrawn
	 */
	private static double validateAmount() {
        Scanner kb = new Scanner(System.in);
        double amount;
            System.out.print("Please enter an amount: ");
            while (!kb.hasNextDouble()) {
                String input = kb.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            amount = kb.nextDouble();
        System.out.printf("You have entered a valid amount");
        return amount;
    }
		
}
