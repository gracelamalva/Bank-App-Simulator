/**
* This class extends that of the Account class as the seperate 'Savings' class.
* Within this class, it exhibits all basic functions of a savings account for 
* any bank account such as an interest rate to be calculated and added to the 
* current account balance inside the account.
*/
class Savings extends Account {

   protected double rate;

   /**
   * This method is the basic foundation of the saving account belonging to an
   * individual. It will include all basic information such as account number, 
   * their balance and implement the interest rate to be calculated and added
   * to the account's current balance.
   * @param account_num Account associated with individual
   * @param initial_balance Starting balance of the account to be used during program
   * @param interest_rate Interest rate to be calculated and added to account
   */
   public Savings (int account_num, double initial_balance, double interest_rate) {
      super (account_num, initial_balance);
      rate = interest_rate;
   }  

   /**
   * This method covers the overdraft functionality which will withdraw funds from the 
   * savings account of an individual if needed which is when they attempt to withdraw
   * an amount more than what is in their checking account, the remaining amount will be
   * withdrawn from their saving account.
   * @param add_interest Rate associated to be calculated and added to account
   */
   public void add_interest () {
      balance += balance * rate;
      System.out.println ("Interest Added: " + account);
      System.out.println ("Updated Balance: " + balance);
      System.out.println();
   }
}