/**
* This class is a test program that will run through all programmed
* functions and features of this current ATM application. Checks will
* include testing a deposit and withdrawal from the specified/hardcoded
* saving and checking account found below. 
*/
public class TestBank {

	public static void main(String[] args) {
		
	    Savings save = new Savings (123456789, 8040.62, 0.02);
	    Checking check = new Checking (987654321, 100.00, save);

	    save.deposit (98.76);
	    save.withdrawal (867.54);
	    check.withdrawal (320.18);
	    check.deposit(50.55);

	}

}