package mines;

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
		
		gridX = X;
		gridY = Y;
		
		// set layout manager
		setLayout();
		// create Swing components
		createButtons();
		// save content pane in variable
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
		this.setLayout(new GridLayout(gridY,gridX));
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
