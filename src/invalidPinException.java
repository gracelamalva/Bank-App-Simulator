
public class invalidPinException extends Exception {

	public String pin;
	
	public invalidPinException (String pin) {
		super("InvalidPinException occured with pin: " + pin);
		System.out.print("Please try again: " );
	}
}