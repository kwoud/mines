package mines;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//leave out javax.swing.* to get to know the packages
//import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		JMenuItem optionsItemSetSize = new JMenuItem("Set grid size...");
		JMenuItem optionsItemDecreaseButtonSize = new JMenuItem("Decrease button size");
		JMenuItem optionsItemIncreaseButtonSize = new JMenuItem("Increase button size");
		optionsItemDecreaseButtonSize.setActionCommand("decrease");
		optionsItemDecreaseButtonSize.addActionListener(this);
		optionsItemIncreaseButtonSize.setActionCommand("increase");
		optionsItemIncreaseButtonSize.addActionListener(this);
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
	public void actionPerformed(ActionEvent arg0) {
		if ("exitprogramm".equals(arg0.getActionCommand())) {
			int dialogButton = JOptionPane.showConfirmDialog(null, "Really quit?", "Exit Warning", JOptionPane.YES_NO_OPTION);
			if(dialogButton == JOptionPane.YES_OPTION) { 
				System.exit(0);
			}
		}
		if ("about".equals(arg0.getActionCommand())) {
			JOptionPane.showMessageDialog(null, "This is kwoudMines version 0.0.x", "About kwoudMines", JOptionPane.INFORMATION_MESSAGE);
		}
		if ("increase".equals(arg0.getActionCommand())) {
			StartWindow.increaseSize();
		}
		if ("decrease".equals(arg0.getActionCommand())) {
			StartWindow.decreaseSize();
		}
	}
}
