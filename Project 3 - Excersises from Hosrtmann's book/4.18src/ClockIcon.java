import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;

public class ClockIcon implements Icon{
	
	final double HOURHAND = 120.0;
	final double MINUTEHAND = 170.0;
	final double SECONDHAND = 180.0;
	private double hour;
	private double min;
	private double sec;

	//converts string tArray into useful parts of tArray array
	//tArray array then split up accordingly
	public ClockIcon(String currentTime) {
		String[] tArray = currentTime.split(":");
		hour = Double.parseDouble(tArray[0]);
		min = Double.parseDouble(tArray[1]);
		sec = Double.parseDouble(tArray[2]);
	}
	
	public void parseTime(String currentTime) {
		String[] tArray = currentTime.split(":");
		hour = Double.parseDouble(tArray[0]);
		min = Double.parseDouble(tArray[1]);
		sec = Double.parseDouble(tArray[2]);
	}

	//had to include even though useless
	public int getIconWidth() {
		return (int) SECONDHAND+20;
	}

	public int getIconHeight() {
		return (int) SECONDHAND+20;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(300, 300, 500, 500);
		g2.draw(circle);

		Line2D.Double sech = new Line2D.Double(300, 300, 300 + SECONDHAND * Math.sin(Math.PI * (double) sec / 30), 300 - SECONDHAND * Math.cos(Math.PI * (double) sec / 30));
		Line2D.Double hourh = new Line2D.Double(300, 300, 300 + HOURHAND * Math.sin(Math.PI * (double) hour / 6), 300 - HOURHAND * Math.cos(Math.PI * (double) hour / 6));
		Line2D.Double minh = new Line2D.Double(300, 300, 300 + MINUTEHAND * Math.sin(Math.PI * (double) min / 30), 300 - MINUTEHAND * Math.cos(Math.PI * (double) min / 30));
		g2.draw(hourh);
		g2.draw(minh);
		g2.draw(sech);
	}
	
}