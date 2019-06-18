package mines;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MineButton extends JButton {
	ImageIcon cloud = new ImageIcon("./src/mines/icon/cloud_24x24.png");
	ImageIcon bolt  = new ImageIcon("./src/mines/icon/bolt_24x24.png");
	Color[] colours = new Color[] {Color.ORANGE, Color.GREEN, Color.CYAN, Color.BLUE, Color.PINK, Color.RED, Color.DARK_GRAY, Color.BLACK};

	public MineButton() {
		super();
	}
}
