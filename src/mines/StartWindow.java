package mines;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartWindow {

	private static void createAndShowGUI() {
		JFrame frame = new MainFrame("kwoudMines");
		frame.setSize(20*60, 15*60);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
