package mines;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class SetSizeFrame extends JFrame {
	JLabel xlabel = new JLabel("X:");
	private JLabel ylabel = new JLabel("Y:");
	private JLabel mlabel = new JLabel("Number of mines");

	private SpinnerModel modelX = new SpinnerNumberModel(StartWindow.getGridX(), 1, 20, 1);
	private SpinnerModel modelY = new SpinnerNumberModel(StartWindow.getGridY(), 1, 20, 1);
	private SpinnerModel modelM = new SpinnerNumberModel(StartWindow.getNumMines(), 1, StartWindow.getGridX() * StartWindow.getGridY(), 1);
	private JSpinner spinnerX = new JSpinner(modelX);
	private JSpinner spinnerY = new JSpinner(modelY);
	private JSpinner spinnerM = new JSpinner(modelM);

	private JButton okButton = new JButton("Set");
	private JButton cancelButton = new JButton("Close");

	public SetSizeFrame(String title) {
		super(title);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // check close operation

		this.setLayout(new GridLayout(4, 2, 5, 5));

		spinnerX.addChangeListener(l -> setModelM());
		spinnerY.addChangeListener(l -> setModelM());

		okButton.addActionListener(e -> {
			StartWindow.setGridX((Integer) spinnerX.getValue());
			StartWindow.setGridY((Integer) spinnerY.getValue());
			StartWindow.setNumMines((Integer) spinnerM.getValue());
			StartWindow.drawGrid();
		});
		cancelButton.addActionListener(e -> dispose());

		Container c = getContentPane();
		c.add(xlabel);
		c.add(spinnerX);
		c.add(ylabel);
		c.add(spinnerY);
		c.add(mlabel);
		c.add(spinnerM);
		c.add(okButton);
		c.add(cancelButton);

		this.setVisible(true);
	}

	public void setModelM() {
		spinnerM.setVisible(false);
//		System.out.println(spinnerM.getFont().toString());
		spinnerM.setFont(new Font("Dialog", Font.PLAIN, 12)); // otherwise changes to bold
		int valM = ((Integer) spinnerM.getValue());
		int valXY = ((Integer) spinnerX.getValue()) * ((Integer) spinnerY.getValue());
		if (valM > valXY)
			valM = valXY;
		modelM = new SpinnerNumberModel(valM, 1, valXY, 1);
		spinnerM.setModel(modelM);
		spinnerM.setVisible(true);
	}

}
