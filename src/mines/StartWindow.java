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
	
	private static final int MENU_SIZE = 50; 
	
	
	private static void createAndShowGUI()  {		
		// initiate main frame and create buttons through <MainFrame> constructor
		grid = new Grid();
		grid.setGridMines();
		grid.setGridNumbers();
		frame = new MainFrame("kwoudMines", grid);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set menu bar
		JMenuBar menuBar = new MainMenuBar();
		menuBar.setPreferredSize(new Dimension(0, MENU_SIZE/2)); // x-value in Dimension doesn't do anything, why?
		frame.setJMenuBar(menuBar);
				
		// show frame
		frame.setVisible(true);
	}
	
	public static JFrame getFrame() {return frame;}

        public static Grid getGrid() {return grid;}

	public static void setGridX(int x) {
		grid.setGridX(x);}
    
	public static int getGridX() {return grid.getGridX();}

	public static void setGridY(int y) {
		grid.setGridY(y);}

	public static int getGridY() {return grid.getGridY();}
	
	public static void setNumMines(int num) {grid.setNumMines(num);}
	
	public static int getNumMines() {return grid.getNumMines();}
	
	public static int getButtonSize() {return buttonSize;}
	
	public static int getValue(int pos) {return grid.getValue(pos);}
	
	public static int getMenuSize() {return MENU_SIZE;}
	
	public static void increaseSize() {
		buttonSize += incrSize;
		frame.refresh();
	}
	
	public static void decreaseSize() {
		buttonSize -= incrSize;
		frame.refresh();
	}
	
	public static void setButtonSize(int size) {
		buttonSize = size;
	}
	
	public static void drawGrid() {
	    grid.newGrid(getGridX(), getGridY(), getNumMines());
	    frame.reframe();
	}
	
	public static void reveal() {
		frame.revealAll();
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
