package mines;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class StartWindow {

	private static void createAndShowGUI() {
		JFrame frame = new MainFrame("kwoudMines");
		frame.setSize(20*40, 15*40);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set menu bar
		JMenuBar menuBar = new MainMenuBar();
		menuBar.setPreferredSize(new Dimension(100, 25));
		frame.setJMenuBar(menuBar);
		
		// show frame
		frame.setVisible(true);
		//JOptionPane.showMessageDialog(frame, "Welcome to kwoudMines!");
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
