package mines;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener, ComponentListener {
	private JButton[] buttons;
	private Grid grid;
	private Container c;
	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_24x24.png");
	ImageIcon bolt  = new ImageIcon("./src/mines/icon/bolt_24x24.png");
	Color[] colours = new Color[] {Color.ORANGE, Color.GREEN, Color.CYAN, Color.BLUE, Color.PINK, Color.RED, Color.DARK_GRAY, Color.BLACK};

	
	public MainFrame(String title, Grid backend) {
		super(title);
		grid = backend;
		this.addComponentListener(this);
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
		
	public void revealAll() {
		for (int i = 0; i < grid.getGridSize(); i++) {
			if(buttons[i].isContentAreaFilled()) {
				if (buttons[i].getBackground()!=Color.RED)
					buttons[i].setBackground(Color.GRAY);
			}
			else {
				if (!isMine(buttons[i]) && isFlagged(buttons[i])) {
					buttons[i].setContentAreaFilled(true);
					buttons[i].setBackground(Color.GRAY);
				}
			}
			revealButton(buttons[i]);
			//buttons[i].removeMouseListener(this);
		}
	}
	
	public void revealZeros(int pos) {
		Vector<Integer> neighs = getUnrevealedNeighbours(pos);
		Iterator<Integer> it = neighs.iterator();
		int currPos;
		while (it.hasNext()) {
			currPos = it.next();
			revealButton(buttons[currPos]);
			buttons[currPos].setContentAreaFilled(false);
			if (grid.isZero(currPos)) revealZeros(currPos);
		}
	}
	
	private Vector<Integer> getUnrevealedNeighbours(int pos) {
		Vector<Integer> unrevealed = new Vector<Integer>();
		Iterator<Integer> it = grid.getValidNeighbour(pos).iterator();
		while(it.hasNext()) {
			int currPos = it.next();
			if (buttons[currPos].isContentAreaFilled()==true) unrevealed.add(currPos);
		}
		it = unrevealed.iterator();
		System.out.print("unrevealed: {");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("}");
		return unrevealed;
	}

	private boolean isMine(JButton btn) {
		int val = StartWindow.getValue(Arrays.asList(buttons).indexOf(btn));
		if (val==9) return true;
		return false;
	}
	
	private boolean isFlagged(JButton btn) {
		if (btn.getIcon() == cloud) return true;
		return false;
	}
	
	private void revealButton(JButton btn) {
		int pos = Arrays.asList(buttons).indexOf(btn);
		
		if (grid.isMine(pos)) {
			if (!isFlagged(btn)) {
				btn.setIcon(bolt);
			} 
		}
		else if (grid.isZero(pos)) {
			btn.setIcon(null);
			btn.setText("");
		}
		else {
			btn.setIcon(null);
			btn.setText(Integer.toString(grid.getValue(pos)));
			btn.setForeground(colours[grid.getValue(pos)-1]); 
		}
		btn.removeMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton currButton = (JButton) e.getSource();
		int currPos = Arrays.asList(buttons).indexOf(currButton);
		if (e.getButton() == MouseEvent.BUTTON3) {
				if (isFlagged(currButton)) { // flag button
					currButton.setIcon(null);
					currButton.setContentAreaFilled(true);
				} else { // unflag button
					currButton.setIcon(cloud);
					currButton.setContentAreaFilled(false);
				}
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (!isFlagged(currButton)) {
				System.out.println(currPos);
				if (grid.isZero(currPos)) {
					currButton.setContentAreaFilled(false);
					revealZeros(currPos);
				}
				else if (grid.isMine(currPos)) {
					currButton.setContentAreaFilled(true);
					currButton.setBackground(Color.RED);
					revealAll();
				}
				else {
					currButton.setContentAreaFilled(false);
				}
				revealButton(currButton);
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

	@Override
	public void componentResized(ComponentEvent e) {
		/*
		int width_ = grid.getGridX();
		int height_ = grid.getGridY();
		Rectangle b = e.getComponent().getBounds();
		e.getComponent().setBounds(b.x, b.y, b.width, b.width*height_/width_);
		*/
		
		double btnSizeX = this.getSize().getWidth() / grid.getGridX();
		double btnSizeY = this.getSize().getHeight() / grid.getGridY();
		if (btnSizeX < btnSizeY) {
			StartWindow.setButtonSize((int) Math.floor(btnSizeX));
		}
		else {
			StartWindow.setButtonSize((int) Math.floor(btnSizeY));
		}
		this.refresh();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
