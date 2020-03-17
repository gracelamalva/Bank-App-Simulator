import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.*;

public class BankingTester {
  /**
   * Tester class
   <p>
   Secure Coding 3: Exceptions handled properly
   <p>
   Secure Coding 4: Rudimentary authentication with Username and Password
   <p>
   Secure Coding 5: Input Validation (do while loop)
   
*/
  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    System.out.print("Please enter your name:  ");
    String name = kb.nextLine();
    System.out.println("Welcome to the bank, " + name);

    System.out.print("Please enter your id number: ");
    String idNumber = kb.next();
    try {
      if (idNumber.length() != 6) {
        throw new Exception("idNumber must be 6 characters");
      }


    } catch (Exception characterLengthException) { // exception 2

      System.out.println("ID number must be 6 characters, please start over and try again");
      System.exit(0);
    }
    
    /* 
if (idNumber.length()!=7) {
System.out.println("Incorrect format, please try again"); System.exit(0); }

*/

    int type;
    
	do { //INPUT VALIDATION
		 System.out.println("Please enter 1 for checking or 2 for savings: ");
	    while (!kb.hasNextInt()) {
	        System.out.println("That's not a number");
	        kb.next(); 
	        System.exit(0);
	    }
	    type = kb.nextInt();
	} while (type!=1 && type!=2);
	
	 
	 


    
    if (type == 1) {

      Checking c1 = new Checking(name, idNumber);
      c1.displayCurrentBalance();
      c1.computeTransaction();
      c1.fileAdder();
      System.out.println(c1);
    
    } else if (type == 2) {

      Savings s1 = new Savings(name, idNumber);
      s1.displayCurrentBalance();
      s1.computeTransaction();
      s1.fileAdder();
      System.out.println(s1);
      
    }
  }
}