package mines;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


public class StartWindow {
	private static Grid grid;
	private static MainFrame frame;
	// set private class variables to standard values
	private static int buttonSize = 24;
	private static int incrSize = 5;
	
	private static final int _MENUSIZE_ = 50; 
	
	
	private static void createAndShowGUI()  {		
		// initiate main frame and create buttons through <MainFrame> constructor
		grid = new Grid();
		frame = new MainFrame("kwoudMines", grid.getGridX(), grid.getGridY());
		setFrameSize();
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
	 
	public static int getGridX() {return grid.getGridX();}
	
	public static int getGridY() {return grid.getGridY();}
	
	public static void setNumMines(int num) {grid.setNumMines(num);}
	
	public static int getNumMines() {return grid.getNumMines();}
	
	public static int getButtonSize() {return buttonSize;}
	
	public static void setFrameSize() {
		frame.setSize(grid.getGridX()*buttonSize, grid.getGridY()*buttonSize+_MENUSIZE_); // find better way to deal with menu size; buttons are now squares; maybe introduce new method setSize for class
	}
	
	public static void increaseSize() {
		buttonSize += incrSize;
		setFrameSize();
		frame.revalidate();
	}
	
	public static void decreaseSize() {
		buttonSize -= incrSize;
		setFrameSize();
		frame.revalidate();
	}
	
	public static void setGridSize(int x, int y) {
		grid.setGridSize(x, y);
		frame.removeAll();
		frame.setGridSize(grid.getGridX(), grid.getGridY());
		frame.createButtons();
		frame.addButtons();
		setFrameSize();
		frame.revalidate();
		frame.repaint();
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
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
