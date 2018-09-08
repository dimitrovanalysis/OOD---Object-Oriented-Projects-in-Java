import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;


@SuppressWarnings("serial")
public class MVCFrame extends JFrame implements ChangeListener{
	
	private Model model;
	private ArrayList<String> list = new ArrayList<String>();
	JTextArea textArea;
	

	public MVCFrame(Model m) {
		//STANDARD FIELD CREATION
		model = m;
		list = model.getList();
		textArea = new JTextArea(20, 40);
		setLayout(new BorderLayout());
		JButton btn = new JButton("ADD");
		setTitle("mvc cs151");
		final JTextField textField = new JTextField();
		JScrollPane textAreaScroller = new JScrollPane(textArea);
		textAreaScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		
		//ANONYMOUS CLASS USING BTN
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.add(textField.getText());
				textField.setText("");
			}
		});
		//FOLLOW SNAPSHOT
		add(btn, BorderLayout.NORTH);
		add(textField, BorderLayout.SOUTH);
		add(textAreaScroller, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int size = list.size();
		if (size >1)
			//CREATE SPACE
			textArea.append("\n");
		textArea.append(list.get(size - 1));
	}
}