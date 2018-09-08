import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * Tester class for MyCalendar implementation of a console calendar system
 * @author Konstantin
 *
 */
public class MyCalendarTester extends MyCalendar {

	/**
	 * main function takes user input depending on given main menu choices
	 */
	public static void main(String[] args) throws IOException {

		GregorianCalendar cal = new GregorianCalendar(); // capture today
		Scanner sc = new Scanner(System.in);
		
		MyCalendar EventManager = new MyCalendar();
	
		EventManager.printCalendar(cal);
		System.out.println("THIS IS THE FIRST RUN - LOAD YOUR EVENTS FIRST");
		System.out.println("press any key to continue, or q to quit");
		
		while(!sc.nextLine().equals("q")) {
			System.out.println("Select one of the following options: ");
			System.out.println("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
			String answer = sc.nextLine();
			
			//c = create
			if(answer.equals("c")) {
				System.out.println("Please enter a Title: ");
				String title = sc.nextLine();
				System.out.println("Please enter a date (MM/DD/YYYY): ");
				String date = sc.nextLine();
				System.out.println("Please enter a starting time: ");
				String startingTime = sc.nextLine();
				System.out.println("Please enter an ending time (optional)");
				String endingTime = sc.nextLine();
				
				if(EventManager.checkEvent(date, startingTime, endingTime) == true)
				{
					EventManager.createEvent(title, date, startingTime, endingTime);
			    }
				else
					System.out.println("Time conflict; event not added. ");
			}	
			
			if(answer.equals("l")) {
				EventManager.load();
			}
			// e = event list
			if(answer.equals("e")) {
				EventManager.viewEvents();
			}
			
			if(answer.equals("d")) {
				System.out.println("Please enter a specific date (MM/DD/YYY)");
				String date = sc.nextLine();
				System.out.println("Would you like to delete all events or a selected event? (a/s)");
				String answer2 = sc.nextLine();
				
				if (answer2.equals("a")) {
					EventManager.deleteAll(date);
				}
				
				if (answer2.equals("s")) {
					System.out.println("Please enter the exact name of the specific event you would like to delete: ");
					String name = sc.nextLine();
					EventManager.deleteByName(name);
				}
				
			}
			
			if(answer.equals("g")) {
				System.out.println("Enter the date you would like to view");
				String date = sc.nextLine();
				EventManager.viewEventsByDate(date);
			}
			
			if(answer.equals("v")) {
				System.out.println("Day view or Month view? (d/m): ");
				String answer3 = sc.nextLine();
				
				if(answer3.equals("d")) {
					//System.out.println("Enter the current date in (MM/DD/YYYY)");
					//String date=sc.nextLine();
					SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
					String newDate1 = format2.format(cal.getTime());
					EventManager.viewEventsByDate(newDate1);
					System.out.println("press p for previous day, n for next day, or any for main menu :");
					String answer5 = sc.nextLine();
					
					while(answer5.equals("p") || answer5.equals("n")) {
						
						
						if(answer5.equals("p"))
						{
							cal.add(Calendar.DATE, -1);
							SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
							String newDate = format1.format(cal.getTime());
							EventManager.viewEventsByDate(newDate);
						}
					
						if(answer5.equals("n"))
						{
							cal.add(Calendar.DATE, 1);
							SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
							String newDate = format1.format(cal.getTime());
							EventManager.viewEventsByDate(newDate);
						}
						
						System.out.println("press p for previous day, n for next day, or any for main menu: ");
						answer5 = sc.nextLine();
					}
				}
				
				else if(answer3.equals("m")) {
					EventManager.printCalendar(cal);
					System.out.println("press p for previous month, n for next month, or any for main menu :");
					String answer4 = sc.nextLine();
					
					while(answer4.equals("p") || answer4.equals("n")) {
						
					
						if(answer4.equals("p"))
						{
							cal.add(Calendar.MONTH, -1);
							EventManager.printCalendar(cal);
						}
					
						if(answer4.equals("n"))
						{
							cal.add(Calendar.MONTH, 1);
							EventManager.printCalendar(cal);
						}
						
						System.out.println("press p for previous month, n for next month, or m for main menu: ");
						answer4 = sc.nextLine();
					}	
				}
			}
			
		}
		
	}
	
	

}