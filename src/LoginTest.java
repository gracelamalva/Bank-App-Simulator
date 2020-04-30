import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {
	
	String verifyInput = "$2a$12$.hUzNzZQR/inSb5nBpLAgeP60q4Y0TZ7RASb6soJf4SlDUJ.5Zo96";
	String userInput = "1234";

	@Test
	void test() {
		
		boolean pinMatch = BCrypt.checkpw(userInput, verifyInput);
		if (pinMatch){
			assertTrue(true);
		}
		else {
			fail("Input does not match.");
		}
	}
}
