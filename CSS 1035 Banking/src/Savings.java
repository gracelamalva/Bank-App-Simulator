import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

/** Savings program extends Account while executing transaction for Savings Account
 */

public class Savings extends Account {
	/**
	 * The private final minimum amount of money that must be kept in the savings account or a fee will be incurred
	 */
  private final double min = 300;
  /**The private final fee incurred if account amount is less than 300 
	 */
  private final double minFee = 75;
  /**The protected savings balance that will be changed after a transaction occurs 
	 */
  protected double savingsBalance;
 
  /**The protected savings deposit that will then be added to the balance
	 */
  
  protected double savingsDeposit;
  
  /**
	 The protected savings withdrawal that will then be subtracted from the balance      
	 */


  protected double savingsWithdrawal;
 
  /**
	 Constructor representing name and id extended from Account class
	 @param n name
	 @param i ID Number
	 */
  public Savings(String n, String i) {
	  
	  
	  super(n, i);

  }
  
  /**
	Sets the balance 
	@param sb When method is called, this variable represents the new savings balance
	 */
  public void setSavingsBalance(double sb) {
    savingsBalance = sb;
  }
  /**
	Sets the deposit amount 
	@param sd When method is called, this variable represents the new savings deposit
	 */
  

  public void setSavingsDeposit(double sd) {
    savingsDeposit = sd;
  }
  /**
	Sets the withdrawal amount 
	@param sw When method is called, this variable represents the new savings withdrawal
	 */

  public void setSavingsWithdrawal(double sw) {
    savingsWithdrawal = sw;
  }
  
  /**
	Displays the current balance 
	 */
  
  public void displayCurrentBalance() {
    System.out.println("Your current balance is " + savingsBalance);
  }
  
  /**
   Executes a deposit or withdrawal, depending on user's choice of a number representing each type of account
   <p>
   
   Secure: Handles exception
   */
  public void computeTransaction() {

    Scanner kb = new Scanner(System.in);
    System.out.print("Enter in 1 for deposit or 2 for withdrawal: ");
    int choice2 = kb.nextInt();
    
    try {
      if (choice2 != 1 && choice2 != 2) {
        throw new Exception("Have to type in 1 or 2!");
      }

    } catch (Exception savingsOrWithdrawalException) { //Exception 1

      System.out.println("Must type in a 1 or 2, please try again");
      System.exit(0);

    }
    if (choice2 == 1) {
      System.out.println("Enter amount to deposit: $ ");
      double sd = kb.nextDouble();
      setSavingsDeposit(sd);
      savingsBalance += sd;
      setSavingsBalance(savingsBalance);
      System.out.println("\nThank you for using the bank.");


    } else if (choice2 == 2) {
      System.out.println("Enter amount to withdraw: $ ");
      double amt1 = kb.nextDouble();
      setSavingsWithdrawal(amt1);
      savingsBalance -= amt1;
      setSavingsBalance(savingsBalance);

      if (savingsBalance < min) {
        savingsBalance -= minFee;
        setSavingsBalance(savingsBalance);
        System.out.println("A fee was added");
        System.out.println("\nThank you for using the bank.");
      }

    }
  }
  
  /**
   Overrides extended Account class toString
   @return The full string of account information
   */

  public String toString() {
    String str;
    DecimalFormat df = new DecimalFormat("$###,###,##0.00");
    str = super.toString() + " Account Balance:  " + df.format(savingsBalance);
    return str;
  }
  /**
   *fileAdder adds the the user account transaction to a separate .txt file for documentation purposes
   *<p>
   
   Secure: Ensures documentation because if there is an error, transaction will not show up on customer's end either
   */
 
  public void fileAdder() {

    String fileName = "output.txt";
    PrintWriter outputStream = null;
    try {
      outputStream = new PrintWriter(fileName);

    } catch (FileNotFoundException e) {

      System.out.println("We are experiencing an error, please try again later ");
      System.exit(0);
    }
    outputStream.println(toString());
    outputStream.close();

  }

}
