import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WithdrawTest {
	
	double balance = 1000;
	double amount = 200;
	//Account a = new Account ();
	Savings s = new Savings (balance);
	
	@Test
	void withdrawTest() {
		double test = s.withdraw(amount);
		assertEquals(test, 800);
	}

}
