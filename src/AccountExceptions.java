
public class AccountExceptions extends Exception {

	public String pin;
	
	AccountExceptions(String p) {
		pin =p;
		
	}
	  public String toString(){ 
			return ("My AccountException Occurred: "+ pin) ;
	}
}





