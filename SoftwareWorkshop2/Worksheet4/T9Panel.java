import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class T9Panel extends JPanel {
	int count = 0;
	JPanel controls = new JPanel();
	GridLayout ControlsLayout = new GridLayout(0, 3);
	GridLayout PanelLayout = new GridLayout(0, 3);
	JTextField countDisplay = new JTextField("     0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton bS = new JButton("*");
	JButton b0 = new JButton("0");
	JButton bH = new JButton("#");

	private class UpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			count = count + 1;
			countDisplay.setText(new Integer(count).toString());
		}
	}

	private class DownListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			count = count - 1;
			countDisplay.setText(new Integer(count).toString());
		}
	}

	private void setButtonActions() {
		b1.addActionListener(new UpListener());
		b2.addActionListener(new DownListener());
	}

	public T9Panel() {
		add(countDisplay);
		controls.setLayout(layout);
		controls.add(b1);
		controls.add(b2);
		controls.add(b3);
		controls.add(b4);
		controls.add(b5);
		controls.add(b6);
		controls.add(b7);
		controls.add(b8);
		controls.add(b9);
		controls.add(bS);
		controls.add(b0);
		controls.add(bH);
		add(controls);
		setButtonActions();
	}

	private static final long serialVersionUID = 1L;
}
