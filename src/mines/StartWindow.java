package mines;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


public class StartWindow {
	private static MainFrame frame;
	private static int gridX;
	private static int gridY;
	private static int buttonSize;
	private static int incrSize;
	
	private static int _MENUSIZE_ = 50; 
	
	
	private static void createAndShowGUI()  {
		// set private class variables to standard values
		gridX=15;
		gridY=10;
		buttonSize=60;
		incrSize=5;
		
		// initiate main frame and create buttons through <MainFrame> constructor
		frame = new MainFrame("kwoudMines", gridX, gridY);
		frame.setSize(gridX*buttonSize, gridY*buttonSize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set menu bar
		JMenuBar menuBar = new MainMenuBar();
		menuBar.setPreferredSize(new Dimension(0, _MENUSIZE_/2)); // x-value in Dimension doesn't do anything, why?
		frame.setJMenuBar(menuBar);
				
		// show frame
		frame.setVisible(true);
	}
	
	public static JFrame getFrame() {return frame;}
	 
	public static int getGridX() {return gridX;}
	
	public static int getGridY() {return gridY;}
	
	public static int getButtonSize() {return buttonSize;}
	
	public static void increaseSize() {
		buttonSize += incrSize;
		frame.setSize(gridX*buttonSize, gridY*buttonSize+_MENUSIZE_);
		frame.revalidate();
	}
	
	public static void decreaseSize() {
		buttonSize -= incrSize;
		frame.setSize(gridX*buttonSize, gridY*buttonSize+_MENUSIZE_);
		frame.revalidate();
	}
	
	public static void setGridSize(int x, int y) {
		gridX = x;
		gridY = y;
		frame.removeAll();
		frame.setGridSize(gridX, gridY);
		frame.createButtons();
		frame.addButtons();
		frame.setSize(gridX*buttonSize, gridY*buttonSize+_MENUSIZE_); // find better way to deal with menu size; buttons are now squares; maybe introduce new method setSize for class
		frame.revalidate();
		frame.repaint();
	}
	
	public static void main(String[] args) {
		// print out size of <int> just for fun
		System.out.println(Integer.toString(Integer.MIN_VALUE) + ":" + Integer.toString(Integer.MAX_VALUE));
		// schedule a job for the event dispatch thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create and show this apps gui
				createAndShowGUI();
			}
		});
	}
}
