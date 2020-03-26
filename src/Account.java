/**
* <h1>Java Banking Application</h1>
* This program is a simulated bank ATM application that covers 
* withdrawal and deposits of a savings or checking account. 
* <p>
* This program includes a few error checking and exceptions 
* implemented thus far but is far from finished. Errors include not 
* withdrawing more than what is in an account and exceptions include 
* accounting for proper input and not exceeding the withdrawal limit.  
* 
*
* @author  Derick Naraine
* @version 1.4
* @since   2020-02-23 
*/
class Account {

   protected int account;
   protected double balance;

   /**
   * This method is the basic foundation of the bank account.
   * It sets the variables 'account' and 'balance' to become 
   * that of the integer values of 'account_num' and 
   * 'initial_balance' once calculated.
   * @param account Account associated with transaction (deposit/withdrawal)
   * @param balance Balance in USD of the account
   */
   public Account (int account_num, double initial_balance) {
      account = account_num;
      balance = initial_balance;
   }

   /**
   * This method is responsible for deposits which will increase funds 
   * into either the checking or saving account of an individual.
   * @param amount Amount associated to be deposited into account
   */
   public void deposit (double amount) {
      balance += amount;
      System.out.println ("Deposit into account " + account);
      System.out.println ("Amount to Add: +" + amount);
      System.out.println ("Updated Balance: " + balance);
      System.out.println ();
   } 

   /**
   * This method is responsible for withdrawals which will decrease funds 
   * into either the checking or saving account of an individual. Specifies
   * if yes/no if a withdrawal is needed and will do so.
   * @param withdrawal Amount associated to be withdrawn from account
   */
   public boolean withdrawal (double amount) {
      boolean result = false;

      System.out.println ("Withdraw from account " + account);
      System.out.println ("Amount to Withdraw: -" + amount);

      if (amount > balance)
         System.out.println ("Insufficient funds in account.");
      else {
         balance -= amount;
         System.out.println ("Updated Balance: " + balance);
         result = true;
      }
      
      System.out.println();
      return result;
   }
}