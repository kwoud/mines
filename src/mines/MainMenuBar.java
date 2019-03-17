package mines;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//leave out javax.swing.* to get to know the packages
//import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MainMenuBar extends JMenuBar implements ActionListener {
	public MainMenuBar() {
		// Create and add menus to menu bar
		JMenu fileMenu = new JMenu("File");
		JMenu optionsMenu = new JMenu("Options");
		JMenu helpMenu = new JMenu("Help");
		this.add(fileMenu);
		this.add(optionsMenu);
		this.add(helpMenu);

		// create and add menu items to file menu
		JMenuItem fileItemOpen = new JMenuItem("Open...");
		JMenuItem fileItemSave = new JMenuItem("Save...");
		JMenuItem fileItemExit = new JMenuItem("Exit");
		fileItemExit.setActionCommand("exitprogramm");
		fileItemExit.addActionListener(this);
		fileMenu.add(fileItemOpen);
		fileMenu.add(fileItemSave);
		fileMenu.add(fileItemExit);

		// create and add menu items to options menu
		JMenuItem optionsItemReveal = new JMenuItem("Reveal");
		JMenuItem optionsItemSetSize = new JMenuItem("Set grid size...");
		JMenuItem optionsItemDecreaseButtonSize = new JMenuItem("Decrease button size");
		JMenuItem optionsItemIncreaseButtonSize = new JMenuItem("Increase button size");
		optionsItemReveal.setActionCommand("reveal");
		optionsItemSetSize.setActionCommand("setsizewindow");
		optionsItemDecreaseButtonSize.setActionCommand("decrease");
		optionsItemIncreaseButtonSize.setActionCommand("increase");
		optionsItemReveal.addActionListener(this);
		optionsItemSetSize.addActionListener(this);
		optionsItemDecreaseButtonSize.addActionListener(this);
		optionsItemIncreaseButtonSize.addActionListener(this);
		optionsMenu.add(optionsItemReveal);
		optionsMenu.add(optionsItemSetSize);
		optionsMenu.add(optionsItemDecreaseButtonSize);
		optionsMenu.add(optionsItemIncreaseButtonSize);

		// create and add menu items to help menu
		JMenuItem helpItemAbout = new JMenuItem("About");
		helpMenu.add(helpItemAbout);
		helpItemAbout.setActionCommand("about");
		helpItemAbout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("exitprogramm".equals(e.getActionCommand())) {
			int dialogButton = JOptionPane.showConfirmDialog(null, "Really quit?", "Exit Warning",
					JOptionPane.YES_NO_OPTION);
			if (dialogButton == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		if ("about".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(null, "This is kwoudMines version 0.0.x", "About kwoudMines",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if ("increase".equals(e.getActionCommand())) {
			StartWindow.increaseSize();
		}
		if ("decrease".equals(e.getActionCommand())) {
			StartWindow.decreaseSize();
		}
		if ("setsizewindow".equals(e.getActionCommand())) {
			new SetSizeFrame("Set grid size");
		}
		if ("reveal".equals(e.getActionCommand())) {
			StartWindow.reveal();
		}
	}
}
