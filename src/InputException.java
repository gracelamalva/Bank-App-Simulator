import java.util.*;

/**
* This class is a test program that builds upon the 'DailyLimitException' class file.
* Basically what happens is within a do/while loop, depending on the user's input it'll
* check if it's a valid input that can be entered. In this case, if it's a value that's
* not a numerical value then it will not work. For example, if a user attempts to withdraw
* a value of 'text' instead of a number it'll throw an exception.
*/
public class InputException extends Exception {

	public static void main(String[] args) throws IllegalArgumentException {

		Savings save = new Savings (123456789, 8040.62, 0.02);
		Scanner input = new Scanner(System.in);
	    boolean continueInput = true;
	    
	    do {
	        try {       	
	        	System.out.print("Enter the amount to withdraw from saving account: ");
	            double number = input.nextDouble();
	            System.out.println();
	            
	    	    if (number <= 500.00) {
	    	    	save.withdrawal(number);
	    	    }
	    	    else {
	    	    	throw new IllegalArgumentException("You cannot withdraw more than $500 per day.");
	    	    }
	            
	            continueInput = false;
	            
	        }
	        
	        catch (InputMismatchException ex) {
	        	System.out.println("Try again. (" + "Incorrect input - please enter a numerical value.)");
	        	System.out.println();
	        	input.nextLine(); // discard input 
	        	
	        }
	        
	    } while (continueInput);
	    
	}

}
