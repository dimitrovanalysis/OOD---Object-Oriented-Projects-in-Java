import java.awt.*;
import javax.swing.*;

/**
 * AUTHOR PROVIDED SOME CLASSES - MODIFIED OTHERS FOR USE OF THIS ASSIGNMENT
   An icon that contains a moveable shape.
   @author Text Book Sample
*/
public class ShapeIcon implements Icon
{
	   private int width;
	   private int height;
	   private CarShape shape;
	   
   public ShapeIcon(CarShape shape,int width, int height)
   {
      this.shape = shape;
      this.width = width;
      this.height = height;
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }
}
