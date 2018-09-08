import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel {
	private int Wicon;
	ArrayList<ChangeListener> listener;
	
	public DataModel(int width) {
		Wicon = width;
		listener = new ArrayList<ChangeListener>();
	}
	
	 public void attach(ChangeListener c)
	 {
	    listener.add(c);
	 }
	 
	 public int getIconWidth() {
		 return Wicon;
	 }
	 
	 public ChangeListener changeListener() {
		 return listener.get(0);
	 }
	 
	 public void update(int width) {
		 Wicon = width;
		 for (int i = 0; i < listener.size(); i++)
	      {
	         listener.get(i).stateChanged(new ChangeEvent(this));
	      }
	 }

}