import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Model {
	private  ArrayList<String> stringList;
	ArrayList<ChangeListener> listeners;
	

	public Model(ArrayList<String> list) {
		stringList = list;
		listeners = new ArrayList<ChangeListener>();
	}
	

	public ArrayList<String> getList() {
		return stringList;
	}
	
	
	public void attach(ChangeListener listener) {
		listeners.add(listener);
	}
	

	public void add(String string) {
		stringList.add(string);
		//new change eevents
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	
}