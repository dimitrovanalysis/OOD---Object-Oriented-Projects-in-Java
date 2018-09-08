import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

enum MONTHS
{
	Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}
enum DAYS
{
	Sun, Mon, Tue, Wed, Thur, Fri, Sat ;
}
/**
 * simulation of console calendar system that takes user created events and modifies them
 * accordingly
 * @author Konstantin
 */
public class MyCalendar{
	GregorianCalendar today = new GregorianCalendar();
	Event eventDates;

	/**
	 * basic constructor initializing event class
	 * to manage events
	 */
	public MyCalendar() {
		 eventDates = new Event();
	}
	
	/**
	 * checks if the given user created event has a time conflict
	 * @param date user input date in (MM/DD/YYYY)
	 * @param startingTime starting time of event in military time
	 * @param endingTime ending time of event in military time
	 * @return true if no conflict of time, else false for conflict
	 */
	public boolean checkEvent(String date, String startingTime, String endingTime){

		if(eventDates.checkEvents(date, startingTime, endingTime) == true) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 * creates a string of user input event appending name,date,starting time,ending time
	 * @param name user input title of event
	 * @param date user input date of event (MM/DD/YYYY)
	 * @param startingTime user input starting time
	 * @param endingTime user input ending time
	 */
	public void createEvent(String name, String date, String startingTime, String endingTime){
		String event = date + " " + startingTime + " " + endingTime + " " + name;
		
		eventDates.addEvent(event);
	}
	
	/**
	 * takes current events listed and displays them in order
	 */
	public void viewEvents() {
		eventDates.displayEvents();
	}
	
	/**
	 * displays events listed on specified date
	 * @param date user input date (MM/DD/YYYY)
	 */
	public void viewEventsByDate(String date) {
		System.out.println("Events listed on date: " + date);
		eventDates.displayEventsByDate(date);
	}
	
	/**
	 * deletes all events from given date
	 * @param date user input date (MM/DD/YYYY)
	 */
	//deletes all events on a given date
	public void deleteAll(String date) {
		eventDates.deleteEvent(date);
	}
	
	/**
	 * deletes event with specified string name
	 * @param name user input name of event
	 */
	public void deleteByName(String name) {
		eventDates.deleteSpecificEvent(name);
	}
	
	/**
	 * load function that takes events from Events.txt file and adds them to event list
	 * @throws IOException
	 */
	public void load() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("Events.txt"));
		String str;	
				
			while((str = in.readLine()) != null) {
			eventDates.addEvent(str);
			}

	}
	
	/**
	 * print function that takes the date c and displays the current date in [] 
	 * and the event dates in {}
	 * @param c given date/calendar information
	 */
	public void printCalendar(Calendar c)
	{   
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();

	   System.out.format("%14s%7s", arrayOfMonths[c.get(Calendar.MONTH)], c.get(Calendar.YEAR) + "\n" );
	   System.out.format("%4s%4s%4s%4s%4s%4s%5s", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" + "\n" );
	   
	   Calendar first = (Calendar) c.clone();
	   first.set(Calendar.DAY_OF_MONTH, first.getActualMinimum(Calendar.DAY_OF_MONTH));
	   //first now contains thursday the first (for march)
	  
	   int maxDaysInMonth = first.getActualMaximum(Calendar.DAY_OF_MONTH);
	   // maxDaysInMonth contains max days for any month (31 for march)
	   
	   //use first.get(Calendar.DAY_OF_WEEK) to figure out how many white
	   //spaces you'll need when printing the first week of the calendar
	   //place all dates into an array
	   int[] dates = new int[32];
	   for (int i = 0; i <= maxDaysInMonth; i++)
		   dates[i] =  i+1;
	   //print out white spaces for first day in calendar
	   for(int i = 0; i <= first.get(Calendar.DAY_OF_WEEK); i++)
	   {
		   System.out.print("   ");
	   }
	   
	   for(int i = 1; i <= maxDaysInMonth; i++ )
	   {
		   int[] arrayDates = eventDates.getArrayEventDates(c.get(Calendar.MONTH));

		   if(i == arrayDates[i]  )
			   System.out.print("{");
		   
		   if(i == c.get(Calendar.DATE) && c.get(Calendar.MONTH) == today.get(Calendar.MONTH))
			   System.out.print("[");
		   
		   System.out.print("  "+ i);
		   
		   if(i ==c.get(Calendar.DATE) && c.get(Calendar.MONTH) == today.get(Calendar.MONTH))
			   System.out.print("]");
		   
		   if(i == arrayDates[i] )
			   System.out.print("}");
		   
		   if(i<10)
			   System.out.print(" ");
		   
		   if((i+ first.get(Calendar.DAY_OF_WEEK)) %7 == 1|| (i == maxDaysInMonth))
				   System.out.println();
	   }
	}
	

		
	
		
}
