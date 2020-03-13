/**
	 Account Class is the parent class for Banking Application
	 
	 @author Roshni Shukla
	 */

public abstract class Account {
	/**
	 The private name of the user trying to access their account
	<p>
	 * Secure: They are private variables
	 */

  private String name;
  /**
	 The private idNumber of the user trying to access their account
	 */
  private String idNumber;



  /**
 * Constructor representing name and id number
 @param n name
 @param i ID Number
 */
  public Account(String n, String i) {


    name = n;
    idNumber = i;
  }
  /**
   * Prints name and id number
   * @return name and id
   * <p>
   *secure: User must have ID number to access their account information
   */

  
  public String toString() {


    String str;

    str = "Name:  " + name + "\nID Number:  " + idNumber;
    return str;
  }

  /**
	 * Method will be present in checking and savings subclasses 
	 * <p>
	 * Adds Deposit amount or subtracts Withdrawal amount
	 */

  public abstract void computeTransaction();
  /**
	 * Method will be present in checking and savings subclasses
	 * <p>
	 Displays Checking or Savings balance
	 */

  
  public abstract void displayCurrentBalance();

}




