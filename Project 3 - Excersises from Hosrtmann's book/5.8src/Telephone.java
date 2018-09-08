import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Telephone
{
   public Telephone()
   {

      numberOfPhones = numberOfPhones + 1;
      JPanel speakerPanel = new JPanel();
      speakerPanel.setLayout(new BorderLayout());
      speakerPanel.add(new JLabel("Speaker:"),BorderLayout.NORTH);
      		speakerField = new JTextArea(10, 25);
      		//SCROLL BAR FUNCTIONALITY 
      		JScrollPane speakerScroller = new JScrollPane(speakerField);
      		speakerScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      		speakerPanel.add(speakerScroller,BorderLayout.CENTER);

      String keyLabels = "123456789*0#";
      JPanel keyPanel = new JPanel();
      keyPanel.setLayout(new GridLayout(4, 3));
      for (int i = 0; i < keyLabels.length(); i++)
      {
         final String label = keyLabels.substring(i, i + 1);
         JButton keyButton = new JButton(label);
         keyPanel.add(keyButton);
         keyButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  connect.dial(label);
               }
            });
      }

      final JTextArea microphoneField = new JTextArea(10, 25);
      //ADDED PANE FOR MICROPHONE FIELD
      JScrollPane microphoneScroller = new JScrollPane(microphoneField);
      microphoneScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
      JButton speechButton = new JButton("Send speech");
      speechButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.record(microphoneField.getText());
               microphoneField.setText("");
            }
         });

      JButton hangupButton = new JButton("Hangup");
      hangupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.hangup();
            }
         });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(speechButton);
      buttonPanel.add(hangupButton);

      JPanel microphonePanel = new JPanel();
      microphonePanel.setLayout(new BorderLayout());
      microphonePanel.add(new JLabel("Microphone:"),
         BorderLayout.NORTH);
      
      //DELETED MICROPHONE FIELD AND ADDED MMICROPHONE SCROLLER
      microphonePanel.add(microphoneScroller,BorderLayout.CENTER);
      microphonePanel.add(buttonPanel,
         BorderLayout.SOUTH);

      final JFrame frame = new JFrame();

      frame.add(speakerPanel,
         BorderLayout.NORTH);
      frame.add(keyPanel,
         BorderLayout.CENTER);
      frame.add(microphonePanel,
         BorderLayout.SOUTH);

      // Replace the default close operation with a window event listener.
      frame.addWindowListener(new
         WindowAdapter()
         {
            public void windowClosing(WindowEvent event)
            {
               if (numberOfPhones == 1)
                  System.exit(0);
               else
               {
                  numberOfPhones = numberOfPhones - 1;
                  frame.dispose();
               }
            }
         });

      frame.pack();
      frame.setVisible(true);
   }

   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }

   private JTextArea speakerField;
   private Connection connect;
   private static int numberOfPhones = 0;
}