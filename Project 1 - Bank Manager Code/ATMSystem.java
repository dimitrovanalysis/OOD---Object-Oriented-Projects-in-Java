/**
 * hw #1 solution
 * @author Konstantin
 * standard version and copyright
 * ATM system simulation with communication between ATM and Bank
 */
import java.util.Scanner;
public class ATMSystem extends BankSystem
{	
	/**
	 * main function for ATM system- user and program communication menu
	 */
	public static void main(String[] args)
	{
	final int MAX = 50;
	Scanner input = new Scanner(System.in);
	Scanner inputNum = new Scanner(System.in);
	BankSystem b = new BankSystem();
	String atmChosen, cardNum, password, bankid;
	int expDate, withdrawAmt;
	String q = "yes" , e = "yes";
	
	System.out.println("States of two Banks \n");
	System.out.println("Assume all accounts have $40 preloaded");
	System.out.println("BankofA (two customers)");
	System.out.println("Anderson with Cash Card A11 (bankid: A, account number (#11), expires on 2/15/18, password: mypassword");
	System.out.println("Abe with Cash Card A12 (bankid: A, account number (#12), expires on 3/15/18, password: mypassword \n");
	System.out.println("BankofB (three customers)");
	System.out.println("Berny with Cash Card B111 (bankid: B, account number (#111), expires on 2/15/18, password: mypassword");
	System.out.println("Bob with Cash Card B122 (bankid: B, account number (#122), expires on 3/15/18, password: mypassword");
	System.out.println("Bill with Cash Card B133 (bankid: B, account number (#133), expires on 4/15/18, password: mypassword \n \n");
	System.out.println("States of four ATMs (2 for each Bank)");
	System.out.println("ATM1_A: (ATM1 from BankofA)");
	System.out.println("The maximum amount of cash a card can withdraw per day: $50");
	System.out.println("ATM2_A: (ATM2 from BankofA)");
	System.out.println("The maximum amount of cash a card can withdraw per day: $50");
	System.out.println("ATM1_B: (ATM1 from BankofB)");
	System.out.println("The maximum amount of cash a card can withdraw per day: $50");
	System.out.println("ATM2_B: (ATM2 from BankofB)");
	System.out.println("The maximum amount of cash a card can withdraw per day: $50 \n \n");

while (q.equals("yes")) 
{
	e = "yes";	
	while(e.equals("yes")){
		System.out.println("Enter your choice of ATM");
		atmChosen = input.nextLine();
		
		System.out.println("Enter your card");
		cardNum = input.nextLine();
		CashCard c = new CashCard(cardNum);
		bankid = c.getBankID();
		expDate = c.getExpDate();
		
		//validate card - by bankid and expDate
		if(!bankid.equals(atmChosen.substring(5)) ) 
		{
			System.out.println("This card is not supported by this ATM");
			
		}
		
		else if(expDate< 21618)
		{
			System.out.println("This card is expired and returned to you.");
			
		}
		else 
		{
			System.out.println("This card is Accepted. Please enter your password");
			break;
		}
	}
			
			while(e.equals("yes")) 
			{
			password = input.nextLine();
		
			//validate password - send to bank
		
				if(b.verifyPass(password) == false)
					System.out.println("This is a wrong password. Enter your password.");
		
				else {
					System.out.println("Authorization is accepted.");
					break;
				}	
			}	
		
		while(e.equals("yes")) 
		{
			System.out.println("Start your transaction by entering the amount to withdraw.");
			withdrawAmt = inputNum.nextInt();
			if(withdrawAmt > MAX)
			{
				System.out.println("This amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount or quit.");			
			}
			
			else if (b.verifyBalance(withdrawAmt) == false)
			{
				//pass withdrawAmt to bank to determine if current balance can afford this withdraw
					System.out.print("The amount exceeds the current balance. Enter another amount or type 'q' to quit.");
			}
			
			else {
				b.getWithdraw(withdrawAmt);
			}
			
			System.out.print("Do you have any more transactions? (type: yes/no)");
			e = input.nextLine();
				
		}
		System.out.print("would you like to keep running this program? (type: yes/no)");
		q = input.nextLine();
		
}
		
		input.close();	
		inputNum.close();
}
	
}	