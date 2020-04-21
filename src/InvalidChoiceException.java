
public class InvalidChoiceException extends Exception{

	public InvalidChoiceException (String c) {
		super("Invalid Choice Exception occured ");
		System.out.print("Please try again: " );
	}
}
