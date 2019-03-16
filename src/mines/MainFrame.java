package mines;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {
	private JButton[] buttons;
	private int gridX, gridY;
	private Container c;
	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_16x16.png");
	
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
		System.out.println(cloud.getDescription());
		buttons = new JButton[gridX*gridY];
		for(int i=0; i<gridX*gridY; i++) {
			buttons[i] = new JButton();
		}
	}
	
	public void addButtons() {
		for(int i=0; i<gridX*gridY; i++) {
			c.add(buttons[i]);
			buttons[i].addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			JButton currButton = (JButton) e.getSource();
			if (currButton.getIcon() != null) {
				currButton.setIcon(null);
			} else {
				currButton.setIcon(cloud);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) { /* do nothing */ }

	@Override
	public void mouseExited(MouseEvent e) { /* do nothing */ }

	@Override
	public void mousePressed(MouseEvent e) { /* do nothing */ }

	@Override
	public void mouseReleased(MouseEvent e) { /* do nothing */ }

}
