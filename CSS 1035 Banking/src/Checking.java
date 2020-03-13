import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
/** Checking program extends Account while executing transaction for Checking Account
*/

public class Checking extends Account {

	 /**
	 The private final fee that is incurred if balance is less than the amount to be withdrawn
	 
	 <p>
	 Secure Coding 1: This variable is private and final to lessen chance of alteration
	 */

  private final double overdraftFee = 300;
  /**
	 The protected checking balance that will be changed after a transaction occurs 
	 <p>
	 Secure Coding: final variables prevent accidental overwriting
	 */

  private double checkingBalance;
  /**
	 The protected savings deposit amount that will then be added to the balance
	 */
  private double checkingDeposit;
  /**
	 The protected savings withdrawal amount that will then be subtracted from the balance
	 */
  private double checkingWithdrawal;
  /**
	 Constructor representing name and id extended from Account class
	  @param n name
	 @param i ID Number
	 */

  public Checking(String n, String i) {
    super(n, i);
   

  }
  /**
 	Sets the balance 
 	@param cb When method is called, this variable represents the new checking balance
 	 */
  public void setCheckingBalance(double cb) {
    checkingBalance = cb;
  }
  /**
	Sets the deposit amount 
	@param cd When method is called, this variable represents the new checking deposit
	 */

  public void setCheckingDeposit(double cd) {
    checkingDeposit = cd;
  }
  /**
	Sets the withdraw amount 
	@param cw When method is called, this variable represents the new checking withdrawal
	 */
  public void setCheckingWithdrawal(double cw) {
    checkingWithdrawal = cw;
  }
  /**
	Displays the current balance 
	 */
  
  public void displayCurrentBalance() {
    System.out.println("Your current balance is : " + checkingBalance);
  }
  /**
   * computeTransaction will execute a deposit or withdrawal, depending on user's choice of a number representing each type of account
   */
  
  public void computeTransaction() {

    Scanner kb = new Scanner(System.in);
    System.out.print("Enter in 1 for deposit or 2 for withdrawal: ");
    int choice2 = kb.nextInt();
    
    if (choice2 == 1) {
      System.out.println("Enter amount to deposit: $ ");
      double amt = kb.nextDouble();
      setCheckingDeposit(amt);
      checkingBalance += amt;
      setCheckingBalance(checkingBalance);
      System.out.println("\nThank you for using the bank.");

    
    }  else if (choice2 == 2) {
      System.out.println("Enter amount to withdraw: $ ");
      double amt1 = kb.nextDouble();
      setCheckingWithdrawal(amt1);
      if (amt1 > checkingBalance) {
        checkingBalance = checkingBalance - amt1 - overdraftFee;
        System.out.println("A fee of $300 was added");
        setCheckingBalance(checkingBalance);

      } else {
        checkingBalance -= amt1;
        setCheckingBalance(checkingBalance);
      }
      System.out.println("\nThank you for using the bank.");
      
    } else {
      System.out.println("Error, please start over and pick the number 1 or 2");

    }
  }
  /**
   *toString overrides extended Account class toString
   @return The full string of account information
   */

  public String toString() {
    String str;
    DecimalFormat df = new DecimalFormat("$###,###,##0.00");
    str = super.toString() + " Account Balance:  " + df.format(checkingBalance);
    return str;
  }
 
  /**
   *fileAdder adds the the user account transaction to a separate .txt file for documentation purposes
   *<p>
   *Secure Coding 2: Separate file for documentation
   */
 
  public void fileAdder() {

    String fileName = "output.txt";//.txt must be there
    PrintWriter outputStream = null;//starts empty, we will add to it
    
    try {
      outputStream = new PrintWriter(fileName);//output.txt created 
    
    } catch (FileNotFoundException e) {

      System.out.println("We are experiencing an error, please try again later ");
      System.exit(0);
    }

    outputStream.println(toString());
    outputStream.close();
  }

}
