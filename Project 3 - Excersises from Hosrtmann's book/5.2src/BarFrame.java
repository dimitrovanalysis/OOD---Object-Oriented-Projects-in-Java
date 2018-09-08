import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * SOLUTION COPIED FROM PUBLISHER - MODIFIED FOR ASSIGNMENT PURPOSES
  A class that implements an Observer object that displays a barchart view of
  a data model.
*/
public class BarFrame extends JFrame implements ChangeListener, MouseListener
{	
   public BarFrame(DataModel dataModel)
   {
      this.dataModel = dataModel;
      a = dataModel.getData();
      maxValue = 0;

      setLocation(0,200);
      setLayout(new BorderLayout());

      Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }
         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.red);

            double max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
              maxValue = max;
            }

            double barHeight = getIconHeight() / a.size();

            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();

               double barLength = getIconWidth() * value / max;

               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
      };

      add(new JLabel(barIcon));
      addMouseListener(this);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   public void stateChanged(ChangeEvent e)
   {
      a = dataModel.getData();
      repaint();
   }

   private ArrayList<Double> a;
   private DataModel dataModel;
   private double maxValue;

   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 200;

      //NEEDED TO BE LISTED FROM INTERFACE
   	@Override
   	public void mouseClicked(MouseEvent e) {

   	}
   	
   	@Override
   	public void mouseEntered(MouseEvent e) {

   	}
   	
   	@Override
   	public void mouseExited(MouseEvent e) {

   	}
   	
   	@Override
   	public void mouseReleased(MouseEvent e) {
   		
   	}
   	
   	@Override
   	public void mousePressed(MouseEvent e) {
   		System.out.println("The position is: " + e.getX());
   		System.out.println(e.getY());
   		int point = (e.getY() - 30) / (ICON_HEIGHT / a.size());
   		double valueDoub = maxValue * ((double) e.getX() / ICON_WIDTH);
   		System.out.println("location is: " + point + "   value is: " + valueDoub);
   		dataModel.update(point, valueDoub);
   	}
   	

   }