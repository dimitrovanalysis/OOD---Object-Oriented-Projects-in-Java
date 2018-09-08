/**
 * class that simulates a cashcard management system
 * @author Konstantin
 *
 */

public class CashCard{
	int expDate;
	String bankID;
	
	/**
	 * constructor that sets expiration date depending on specific account
	 * @param cardNum user card inserted to ATM- used to retrieve account info
	 */
	public CashCard(String cardNum) {		
		if (cardNum.equals("A11"))
			expDate = 21518;
		else if(cardNum.equals("A12"))
			expDate = 31518;
		else if(cardNum.equals("B111"))
			expDate = 21518;
		else if(cardNum.equals("B122"))
			expDate = 31518;
		else if(cardNum.equals("B133"))
			expDate = 41518;
		
		bankID =cardNum.substring(0,1);
	}
	
	/**
	 * gets the bankID
	 * @return returns the current bankID for the card
	 */
	public String getBankID() {
		return bankID;
	}
	
	/**
	 * gets the expiration date
	 * @return returns the current expiration date for the card
	 */
	public int getExpDate() {
		return expDate;
	}
	
}