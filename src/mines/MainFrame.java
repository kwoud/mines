package mines;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		
		// set layout manager
		setLayout(new GridLayout(15,20));
		
		// create Swing component
		JButton[] buttons = new JButton[300];
		for(int i=0; i<300; i++) {
			buttons[i] = new JButton(Integer.toString(i));
		}
		
		// add Swing components to content pane
		Container c = getContentPane();
		//JPanel panel = new JPanel();
		
		for(int i=0; i<300; i++) {
			//panel.add(buttons[i]);
			c.add(buttons[i]);
		}
		
		//this.add(panel);
		
		//c.add(buttons, BorderLayout.NORTH);
	}

}
