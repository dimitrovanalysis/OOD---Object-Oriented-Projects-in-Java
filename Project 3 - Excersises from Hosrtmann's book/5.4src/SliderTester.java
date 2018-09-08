import java.awt.*;

import javax.swing.*;


public class SliderTester {
	public static void main(String args[]) {
		// set frame 
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(2, 1));
		//set model
		DataModel model = new DataModel(50);
		
		CarShape shape = new CarShape(0, 0, 105, model);
		ShapeIcon icon = new ShapeIcon(shape, 450, 105);
		SliderLabel label = new SliderLabel(icon);
		//create slider
		Slider slider = new Slider(model);
		//attach to model
		model.attach(shape);
		model.attach(label);
		//add to frame
		frame.add(label);
		frame.add(slider);
		//gen close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
}