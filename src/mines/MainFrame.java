package mines;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {
	private JButton[] buttons;
	private int gridX, gridY;
	private Container c;
//	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_16x16.png");
	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_24x24.png");
	
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
		Insets insets = new Insets(0,0,0,0);
		Font font = new Font("CourierNew", Font.BOLD, 24);
		for(int i=0; i<gridX*gridY; i++) {
			c.add(buttons[i]);
			buttons[i].setMargin(insets);
			buttons[i].setFont(font);
			buttons[i].addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton currButton = (JButton) e.getSource();
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (currButton.getIcon() != null || !currButton.isVisible()) {
				currButton.setIcon(null);
			} else {
				currButton.setIcon(cloud);
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (currButton.getIcon() == null) {
//				currButton.setVisible(false);
				currButton.setContentAreaFilled(false);
				currButton.setText("1");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) { 

	}

	@Override
	public void mouseExited(MouseEvent e) { /* do nothing */ }

	@Override
	public void mousePressed(MouseEvent e) { /* do nothing */ }

	@Override
	public void mouseReleased(MouseEvent e) { /* do nothing */ }

}
