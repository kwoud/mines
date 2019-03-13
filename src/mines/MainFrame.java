package mines;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private JButton[] buttons;
	private int gridX, gridY;
	private Container c;
	
	public MainFrame(String title, int X, int Y) {
		super(title);
		
		// set layout manager
		setGridSize(X,Y);
		
		// create Swing component
		createButtons();
		
		// add Swing components to content pane
		c = getContentPane();

		// add components to container
		addButtons();
	}
	
	public void setLayout() {
		this.setLayout(new GridLayout(gridY,gridX));
	}
	
	public void setGridSize(int x, int y) {
		gridX = x;
		gridY = y;
		setLayout(new GridLayout(gridY,gridX));
	}
	
	public void removeAll() {
		c.removeAll();
	}
	
	public void createButtons() {
		buttons = new JButton[gridX*gridY];
		for(int i=0; i<gridX*gridY; i++) {
			buttons[i] = new JButton(Integer.toString(i));
		}
	}
	
	public void addButtons() {
		for(int i=0; i<gridX*gridY; i++) {
			c.add(buttons[i]);
		}
	}

}
