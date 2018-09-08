/**
 * AccountSystem that simulates the management of accounts, to be used by bankSyste
 * @author Konstantin
 *
 */

public class AccountSystem
{
// one account per customer
// bank of A accounts:
	int balance;
	
	/**
	 * standard constructor - assigns $40 to every account
	 */
	public AccountSystem() {
		balance = 40;
		
	}
	
	/**
	 * verify function to check if account has enough money to withdraw by withdrawAmt
	 * @param withdrawAmt amount user would like to deduct from balance 
	 * @return returns true is withdrawAmt is less than or equal to balance, returns false otherwise
	 */
	public boolean checkBalance(int withdrawAmt)
	{
		if(withdrawAmt <= balance) 
			return true;
		
		else
			return false;
			
	}
	
	/**
	 * changes balance to reflect deduction 
	 * @param withdrawAmt amount to subtract from balance 
	 */
	public void withdraw(int withdrawAmt)
	{
			balance = balance - withdrawAmt;

	}
	
	/**
	 * gets the current balance
	 * @return returns the current balance
	 */
	public int getBalance() {
		return balance;
	}
	
}