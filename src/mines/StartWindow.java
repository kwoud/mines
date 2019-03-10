package mines;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartWindow {

	public static void main(String[] args) {
		// initiate frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainFrame("kwoudMines");
				frame.setSize(20*60, 15*60);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
