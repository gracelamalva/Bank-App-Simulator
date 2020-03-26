import java.util.*;

/**
* This class is a test program that will attempt to throw an exception if one 
* attempts to withdraw more than $500 USD from their savings account (or from
* their checking account if that was used too). Hard-coded account included
* and based on the user input of what value to withdraw it'll throw an exception
* if its anything more than 500.00. 
*/
public class DailyLimitException extends Exception {

	public static void main(String[] args) throws IllegalArgumentException {
		
		Savings save = new Savings (123456789, 8040.62, 0.02);
	    Scanner input = new Scanner(System.in);
		
        System.out.print("Enter the amount to withdraw from saving account: ");
        double number = input.nextDouble();
        System.out.println();
        
        
	    if (number <= 500.00) {
	    	save.withdrawal(number);
	    }
	    else {
	    	throw new IllegalArgumentException("You cannot withdraw more than $500 per day.");
	    }
	    
	}

}
