import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Slider extends JSlider implements ChangeListener{
	private DataModel dataModel;
	
	public Slider(DataModel d) {
		dataModel = d;
		addChangeListener(this);
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		dataModel.update(this.getValue() * 2);
		System.out.println("image magnified by: " + dataModel.getIconWidth());
	}

}