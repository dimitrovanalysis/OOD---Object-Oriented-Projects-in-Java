import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**DISCLAIMER
 * I DO NOT OWN THIS CODE, I MODIFIED THE CARSHAPPE TRANSLATE METHOD
 * FOR MY OWN PURPOSES 
 * 
   This program implements an animation that moves
   a plane shape.
*/
public class AnimationTester
{
   /**
      Construct a frame and animate a plane in it.
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final MoveableShape shape
         = new CarShape(0, 0, CAR_WIDTH);

      final ShapeIcon icon = new ShapeIcon(shape,
         ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 10;
      // milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               shape.translate(1, 0);
               label.repaint();
            }
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}