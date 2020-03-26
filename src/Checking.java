/**
* This class extends that of the Account class as the seperate 'Checking' class.
* Within this class, it exhibits all basic functions of a checking account for 
* any bank account. Included within this class is the basic feature of overdrafts
* which serve as a protection for both customer and bank. 
* <p>
* The overdraft function in this class will withdraw any necessary remaining funds
* from the saving's account of the same individual. If there isn't enough funds
* in the saving's account either it'll return an error stating just that.
*/
class Checking extends Account {

   private Savings overdraft;

   /**
   * This method is the basic foundation of the checking account belonging to an
   * individual. It will include all basic information such as account number, 
   * their balance and implement the overdraft protection function.
   * @param account_num Account associated with individual
   * @param initial_balance Starting balance of the account to be used during program
   * @param protection Overdraft safety feature to be included on account
   */
   public Checking (int account_num, double initial_balance, Savings protection) {
      super (account_num, initial_balance);
      overdraft = protection;
   }

   /**
   * This method covers the overdraft functionality. If needed, yes/no, it will trigger
   * the overdraft feature of the account which will withdraw funds from the 
   * savings account of an individual if needed which is when they attempt to withdraw
   * an amount more than what is in their checking account, the remaining amount will be
   * withdrawn from their saving account. 
   * @param withdrawal Yes/no if needed and includes the extra amount associated to be withdrawn
   */
   public boolean withdrawal (double amount) {

      boolean result = false;

      if ( ! super.withdrawal (amount) ) {
         System.out.println ("Using Overdraft Funds. Additional transactions(s) shown below:");
         if ( ! overdraft.withdrawal (amount-balance) )
            System.out.println ("Insufficient Overdraft funds in account.");
         else {
            balance = 0;
            System.out.println ("Updated Balance on account " + account + ": " + balance);
            result = true;
         }
      }
      
      System.out.println ();
      return result;
      
   }
}