import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SavingsTest {

	@Test
	void test() {
		System.out.println ("Savings Account Deposit Test");
		System.out.println ();
		Savings save = new Savings ("hi", "1244446");
	
		save.computeTransaction();
		save.displayCurrentBalance();
	}

}