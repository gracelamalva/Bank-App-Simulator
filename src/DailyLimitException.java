
public class DailyLimitException extends Exception {

	public int dailyLimit = 3;
	
	public DailyLimitException () {
		super("Daily Limit Exception occured ");
		System.out.print("Please try again: " );
	}
}