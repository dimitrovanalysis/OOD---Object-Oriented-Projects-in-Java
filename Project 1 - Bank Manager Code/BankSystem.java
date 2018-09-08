/**
 * 
 * @author Konstantin
 *BankSystem simulation class with methods to validate and verify information from ATMsystem
 */

public class BankSystem extends AccountSystem{
	
	AccountSystem a;
	
	/**
	 * constructor initiating account system for current atm transaction
	 */
	public BankSystem() {
		a = new AccountSystem();	
	}
	
	/**
	 * function that verifies given password
	 * @param givenPass user-input password from ATMSystem
	 * @return returns true if password is correct, false if not
	 */
	public boolean verifyPass(String givenPass)
	{
		
			if(givenPass.equals("mypassword"))
				return true;
		
			else
				return false;
	}
	
	/**
	 * verifies if account has enough money for transaction. 
	 * @param withdrawAmt user given amount to withdraw
	 * @return returns true if account has enough money to withdraw withdrawAmt,
	 * returns false if not.
	 */
	public boolean verifyBalance(int withdrawAmt)
	{
		if (a.checkBalance(withdrawAmt) == false )
			return false;
		else
			return true;
	}
	
	/**
	 * withdraw function that subtracts passed withdrawAmt from account
	 * @param withdrawAmt user passed amount that they would like to withdraw from their account
	 */
	public void getWithdraw(int withdrawAmt) {
		a.withdraw(withdrawAmt); 
		System.out.println("$" + withdrawAmt + " is withdrawn from your account. The remaining balance of this account is $" 
				+ a.getBalance() );
		
	}
	
	
}