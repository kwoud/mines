package mines;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar {
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
		fileMenu.add(fileItemOpen);
		fileMenu.add(fileItemSave);
		fileMenu.add(fileItemExit);
		
		// create and add menu items to options menu
		JMenuItem optionsItemSetSize = new JMenuItem("Set grid size...");
		JMenuItem optionsItemDecreaseButtonSize = new JMenuItem("Decrease button size");
		JMenuItem optionsItemIncreaseButtonSize = new JMenuItem("Increase button size");
		optionsMenu.add(optionsItemSetSize);
		optionsMenu.add(optionsItemDecreaseButtonSize);
		optionsMenu.add(optionsItemIncreaseButtonSize);
		
		// create and add menu items to help menu
		JMenuItem helpItemAbout = new JMenuItem("About");
		helpMenu.add(helpItemAbout);
	}
}
