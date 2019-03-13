package mines;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;


public class StartWindow {
	private static JFrame frame;
	private static int gridX;
	private static int gridY;
	private static int buttonSize;
	private static int incrSize;
	
	
	private static void createAndShowGUI()  {
		// initiate main frame
		frame = new MainFrame("kwoudMines");
		gridX=20;
		gridY=15;
		buttonSize=60;
		incrSize=5;
		frame.setSize(gridX*buttonSize, gridY*buttonSize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set menu bar
		JMenuBar menuBar = new MainMenuBar();
		menuBar.setPreferredSize(new Dimension(100, 25));
		frame.setJMenuBar(menuBar);
				
		// show frame
		frame.setVisible(true);
	}
	
	 public static JFrame getFrame() {
		return frame;
	}
	 
	public static int getGridX() {
		return gridX;
	}
	
	public static int getGridY() {
		return gridY;
	}
	
	public static int getButtonSize() {
		return buttonSize;
	}
	
	public static void increaseSize() {
		buttonSize += incrSize;
		frame.setSize(gridX*buttonSize, gridY*buttonSize);
		frame.revalidate();
	}
	
	public static void decreaseSize() {
		buttonSize -= incrSize;
		frame.setSize(gridX*buttonSize, gridY*buttonSize);
		frame.revalidate();
	}
	
	public static void main(String[] args) {
		// schedule a job for the event dispatch thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create and show this apps gui
				createAndShowGUI();
			}
		});
	}
}
