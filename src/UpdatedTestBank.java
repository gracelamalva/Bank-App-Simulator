import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class UpdatedTestBank {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		Savings save = new Savings (123456789, 8040.62, 0.02);
		
		Scanner input = new Scanner(System.in);
		
		int menuChoice;
		
	    System.out.println("Banking Application Saving's Account Options");
	    System.out.println("============================================\n");
	    System.out.println("    1. Deposit Funds");
	    System.out.println("    2. Withdraw Funds");
	    System.out.println("    3. Exit ATM\n");
	    System.out.println("============================================\n");

        do {
        	
    	    System.out.print("Please select a menu option: ");
            
        	while (!input.hasNextInt()) {
            	
            	String menuInput = input.next();
                System.out.printf("\"%s\" is not a valid option. Please try again.\n", menuInput);
                System.out.print("Please select a menu option: ");
            
            }
            
        	menuChoice = input.nextInt();

    	    switch (menuChoice) {
    	    
    	    // Deposit test
    	    case 1:
    	    	System.out.println("\nDepositing Funds into Saving's Account");
    	    	System.out.println("----------------------------------------\n");
    	    	System.out.print("How much would you like to deposit into your saving's account? - ");
	            double depositAmt = input.nextDouble();
	            
	            System.out.println("\nTransaction completed, please review your receipt.");
	            System.out.println("Thank you for your service. Exiting application ...");
	            
	    		PrintStream depositOut = new PrintStream("deposit-receipt.txt", "UTF-8");
	    		System.setOut(depositOut);
	    		System.out.println("██████╗  █████╗ ███╗   ██╗██╗  ██╗     █████╗ ██████╗ ██████╗");
	    		System.out.println("██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝    ██╔══██╗██╔══██╗██╔══██╗");
	    		System.out.println("██████╔╝███████║██╔██╗ ██║█████╔╝     ███████║██████╔╝██████╔╝");
	    		System.out.println("██╔══██╗██╔══██║██║╚██╗██║██╔═██╗     ██╔══██║██╔═══╝ ██╔═══╝");
	    		System.out.println("██████╔╝██║  ██║██║ ╚████║██║  ██╗    ██║  ██║██║     ██║");
	    		System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚═╝     ╚═╝");
	    		System.out.println("");
	    		save.deposit(depositAmt);

    	    	break;
    	    
    	    // Withdrawal Test
    	    case 2:
    	    	System.out.println("\nWithdrawing Funds from Saving's Account");
    	    	System.out.println("----------------------------------------\n");
    	    	System.out.print("How much would you like to withdraw from your saving's account? - ");
	            double withdrawAmt = input.nextDouble();
	            
	            System.out.println("\nTransaction completed, please review your receipt.");
	            System.out.println("Thank you for your service. Exiting application ...");
	            
	    		PrintStream withdrawOut = new PrintStream("withdraw-receipt.txt", "UTF-8");
	    		System.setOut(withdrawOut);
	    		System.out.println("██████╗  █████╗ ███╗   ██╗██╗  ██╗     █████╗ ██████╗ ██████╗");
	    		System.out.println("██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝    ██╔══██╗██╔══██╗██╔══██╗");
	    		System.out.println("██████╔╝███████║██╔██╗ ██║█████╔╝     ███████║██████╔╝██████╔╝");
	    		System.out.println("██╔══██╗██╔══██║██║╚██╗██║██╔═██╗     ██╔══██║██╔═══╝ ██╔═══╝");
	    		System.out.println("██████╔╝██║  ██║██║ ╚████║██║  ██╗    ██║  ██║██║     ██║");
	    		System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚═╝     ╚═╝");
	    		System.out.println("");
	    		save.withdrawal(withdrawAmt);
	            
    	    	break;
    	    
    	    // Exit Application
    	    case 3:
    	    	System.out.println("\nThank you for your service. Exiting Application ...");
    	    	break;
    	    
    	    // Default action - invalid selection/choice
    	    default:
    	      System.out.println("Invalid selection. Please restart the ATM application.");
    	    
    	    }
        
        } while (menuChoice < 0);
		
	}

}
