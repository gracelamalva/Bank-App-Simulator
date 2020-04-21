
public class BCryptExample 
{
    public static void main(String[] args) 
    {
    	// Generate a hash for the string 'password'
        String originalPassword = "password";;
        String generatedPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        //System.out.println(generatedPasswordHash);
        boolean matched = BCrypt.checkpw(originalPassword, generatedPasswordHash);
        System.out.println("The password 'password' matched hash is - " + matched);
        
        
        // Generate a hash for the string '1234'
        String pin = "1234";
        String generatedPinHash = BCrypt.hashpw(pin, BCrypt.gensalt(12));
        //System.out.println(generatedPinHash); 
        boolean matchedPin = BCrypt.checkpw(pin, generatedPinHash);
        System.out.println("The pin '1234' matched hash is - " + matchedPin);
        
        
        String pinTest = "9999";
        boolean pinTestMatch = BCrypt.checkpw(pinTest, generatedPinHash);
        System.out.println("The pin '9999' doesn't match the hashed pin of '1234' " + "(" + generatedPinHash + ")" + " and is - " + pinTestMatch);
        
    }
}
