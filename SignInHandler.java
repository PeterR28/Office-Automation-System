
/*
 * Author: Peter Rooney 
 * Date: 03/04/24
 * Description: This class deals with users signing in. First, it checks the account type. Next, 
 * it checks if the username and password match any stored in the Office, and if it doesn’t 
 * find any, it throws an error.
 */
public class SignInHandler 
{

		public Actor.Role checkAccountType(String username, String password) {
	 
			 Actor.Role accountType = Office.getInstance().checkAccountType(username, password);
			 return accountType;
			
	        //if no user name or password then return nulll 
	    }

	    public void incorrectLoginError()
	    {
	    	System.out.println("wrong user name and password");
	    }  
}
