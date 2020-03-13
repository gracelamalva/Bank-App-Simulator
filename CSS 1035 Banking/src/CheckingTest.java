import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckingTest {

	@Test
	void test() {
		System.out.println ("Checking Account Withdrawal Test");
		System.out.println ();
		Checking check = new Checking ("hi", "1244446");
	
		check.computeTransaction();
	}

}