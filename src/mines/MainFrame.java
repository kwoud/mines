package mines;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {
	private JButton[] buttons;
	private Grid grid;
	private Container c;
	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_24x24.png");
	ImageIcon bolt  = new ImageIcon("./src/mines/icon/bolt_24x24.png");

	
	public MainFrame(String title, Grid backend) {
		super(title);
		grid = backend;
		c = getContentPane(); // save content pane in variable
		reframe();
	}

	public void setLayout() {
		this.setLayout(new GridLayout(grid.getGridY(), grid.getGridX()));
	}
	
	public void reframe() {
		this.removeAll();
		this.setLayout();
		this.createButtons();
		this.addButtons();
		this.refresh();
		this.repaint();
	}
	
	public void refresh() {
		int btnSize = StartWindow.getButtonSize();
		this.setSize(grid.getGridX()*btnSize, grid.getGridY()*btnSize+StartWindow.getMenuSize());
		this.revalidate();
	}

	public void removeAll() {
		c.removeAll();
	}

	public void createButtons() {
		System.out.println(cloud.getDescription());
		Insets insets = new Insets(0, 0, 0, 0);
		Font font = new Font("CourierNew", Font.BOLD, 24);
		buttons = new JButton[grid.getGridSize()];
		for (int i = 0; i < grid.getGridSize(); i++) {
			buttons[i] = new JButton();
			buttons[i].setMargin(insets);
			buttons[i].setFont(font);
			buttons[i].setForeground(Color.BLACK);
			buttons[i].addMouseListener(this);
		}
	}

	public void addButtons() {
		for (int i = 0; i < grid.getGridX() * grid.getGridY(); i++) {
			c.add(buttons[i]);
		}
	}
	
	private String getString(JButton btn) {
		int val = StartWindow.getValue(Arrays.asList(buttons).indexOf(btn));
		if (val == 9) return "*";
		if (val == 0) return "";
		return Integer.toString(val);
	}
	
	public void reveal() {
		for (int i = 0; i < grid.getGridX() * grid.getGridY(); i++) {
			buttons[i].setContentAreaFilled(false);
			buttons[i].setText(getString(buttons[i]));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton currButton = (JButton) e.getSource();
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (currButton.isContentAreaFilled()) {
				if (currButton.getIcon() != null) {
					currButton.setIcon(null);
				} else {
					currButton.setIcon(cloud);
				}
			}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (currButton.getIcon() == null) {
				currButton.setContentAreaFilled(false);
				System.out.println(Arrays.asList(buttons).indexOf(currButton));
				currButton.setText(getString(currButton));
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
