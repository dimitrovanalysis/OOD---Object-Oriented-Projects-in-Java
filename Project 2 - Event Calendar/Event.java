import java.util.ArrayList;
import java.util.Collections;

/**
 * event class that manages an arraylist of event data
 * @author Konstantin
 *
 */
public class Event{
	private int count = 0;
	private ArrayList<String> eventData;
	
	/**
	 * constructor that initializes an arraylist to hold event data
	 */
	public Event()
	{
		eventData = new ArrayList<String>();
	}

	/**
	 * add event function that adds the given event to the instance array list
	 * @param event the given string representation of the event
	 */
	public void addEvent(String event)
	{	
		eventData.add(event);
		count++;
	}
	
	/**
	 * function that checks whether or not the given event has a conflict with other
	 * listed events
	 * @param date user input date
	 * @param startingTime user input starting time of event
	 * @param endingTime user input ending time of event
	 * @return returns true if no conflict, and false if conflict
	 */
	public boolean checkEvents(String date, String startingTime, String endingTime) {
		if(eventData.size() > 0)
		{
			for(int i = 0; i<= eventData.size()-1; i++)
			{	
				if(eventData.get(i).substring(11, 16).equals(startingTime)) {
					return false;
				}
			}
			return true;
		}
		else return true;
	}

	/**
	 * displays the current events held by the instance array list
	 */
	public void displayEvents() {
		Collections.sort(eventData);
		for(int i = 0; i<=eventData.size()-1; i++) {
			System.out.println(eventData.get(i));
		}
	}

	/**
	 * displays current events held by instance array list 
	 * on a specific date
	 * @param date user input date to view event of.
	 */
	public void displayEventsByDate(String date) {
		boolean firstTime = true;
		for(int i = 0; i<=eventData.size()-1; i++) {
			if(eventData.get(i).substring(6,10).equals(date.substring(6, 10))) {
				if (firstTime) {
					System.out.println(date.substring(6, 10));
					firstTime = false;
				}
				if(eventData.get(i).substring(0, 2).equals(date.substring(0,2))) {
					if(eventData.get(i).substring(3, 5).equals(date.substring(3,5))) {
						System.out.println(eventData.get(i));
					}
				}
			}
		}
	}
	
	/**
	 * provides an array of event dates to be used to determine where to print {} 
	 * by myCalendar's print function
	 * @param specifiedMonth user specified  current viewing month
	 * @return returns an array of event dates for the specific month asked for 
	 */
 	public int[] getArrayEventDates(int specifiedMonth) {
 		
 		int[] datesForEvent = new int[35];

 		for(int i = 0; i <= eventData.size()-1; i++)
 		{
 			String stringMonth = eventData.get(i).substring(0, 2); 
			int intMonth = Integer.parseInt(stringMonth);
 			if(intMonth-1 == specifiedMonth) {
 				String stringDate = eventData.get(i).substring(3, 5); 
 				int intDate = Integer.parseInt(stringDate);
 				datesForEvent[intDate] = intDate;
 			}
 		}
 		return datesForEvent;
 	}

 	/**
 	 * delete function that removes an event using a given date
 	 * @param date user input date of deletion
 	 */
	public void deleteEvent(String date) {
		for (int i = 0; i <= eventData.size()-1; i++){
			if(eventData.get(i).substring(0, 10).equals(date)) {
				eventData.remove(i);
			}
		}
	}
	
	/**
	 * delete function that only deletes an event with a specific name
	 * @param name user input value used for deletion
	 */
	public void deleteSpecificEvent(String name) {
		for (int i = 0; i <= eventData.size()-1; i++){
			if(eventData.get(i).substring(23).equals(name)){
				eventData.remove(i);
			}
		}
	}
	

}