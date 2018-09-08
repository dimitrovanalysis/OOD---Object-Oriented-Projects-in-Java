import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextFrame extends JFrame implements ChangeListener
{

   public TextFrame(DataModel d)
   {
      dataModel = d;

      final Container contentPane = this.getContentPane();
      setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

      a = dataModel.getData();
      fieldList = new JTextField[a.size()];
      ActionListener l = new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            JTextField c = (JTextField) e.getSource();
            int i = 0;
            int count = fieldList.length;
            while (i < count && fieldList[i] != c)
               i++;

            String text = c.getText().trim();

            try
            {
               double value = Double.parseDouble(text);
               dataModel.update(i, value);
            }
            catch (Exception exc)
            {
               c.setText("Error");
            }
         }
      };

      final int FIELD_WIDTH = 11;
      for (int i = 0; i < a.size(); i++)
      {
         JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
         textField.addActionListener(l);
         add(textField);
         fieldList[i] = textField;
      }

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   
   ArrayList<Double> a;
   DataModel dataModel;
   JTextField[] fieldList;
   
   	@Override
   	public void stateChanged(ChangeEvent e) {
   		a = dataModel.getData();
   		for (int i = 0; i < a.size(); i++) {
   			//gets value and sets it as string
   			fieldList[i].setText(a.get(i).toString());
   		}
   	}
}