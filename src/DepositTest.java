import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositTest {

		double balance = 1000;
		double amount = 200;
		//Account a = new Account ();
		Savings s = new Savings (balance);
		
		@Test
		void depositTest() {
			double test = s.deposit(amount);
			assertEquals(test, 1200);
		}
		
	}



