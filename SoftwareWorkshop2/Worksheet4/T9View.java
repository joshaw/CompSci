/** View component of the T9 Predictive Text application GUI.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet4
 * File name : T9View.java
 * @version 2014-02-18
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Observer;
import java.util.Observable;

public class T9View extends JFrame implements Observer {

	int count = 0;

	JButton[] buttons = new JButton[14];

	JTextArea textArea = new JTextArea();
	private T9Model model;

	public T9View(T9Model model) {

		this.model = model;

		JPanel controls = new JPanel();
		GridLayout ControlsLayout = new GridLayout(0, 3, 5, 5);
		BorderLayout PanelLayout = new BorderLayout();

		textArea = new JTextArea(5, 10);
		textArea.setFont(new Font("Serif", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		this.setLayout(new BorderLayout());
		textArea.setPreferredSize( new Dimension( 400, 240 ) );
		add(textArea, BorderLayout.PAGE_START);
		controls.setLayout(ControlsLayout);

		for (int i = 1; i < 14; i++) {
			String buttonID = "" + i;
			buttons[i] = new JButton();
			buttons[i].setActionCommand(buttonID);
			controls.add(buttons[i]);
		}

		setButtonText();

		add(controls);
		this.pack();
		this.setTitle("T9 Predictive Text");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void setButtonText() {
		buttons[1].setText("    1");
		buttons[2].setText("abc 2");
		buttons[3].setText("def 3");
		buttons[4].setText("ghi 4");
		buttons[5].setText("jkl 5");
		buttons[6].setText("mno 6");
		buttons[7].setText("pqrs 7");
		buttons[8].setText("tuv 8");
		buttons[9].setText("wxyz 9");
		buttons[10].setText("*");
		buttons[11].setText("space");
		buttons[12].setText("#");
		buttons[13].setText("Del");
	}

	public void reset() {
		textArea.setText("");
	}

	public void setTextArea(String text) {
		textArea.setText(text);
	}
	public String getTextArea() {
		return textArea.getText();
	}

	public void addButtonListner(ActionListener bal) {
		for (int i = 1; i < 14; i++) {
			buttons[i].addActionListener(bal);
			buttons[i].setMnemonic(i+96);

			if (i == 10) { buttons[i].setMnemonic(107); } // STAR - ADD
			else if (i == 11) { buttons[i].setMnemonic(32); } // SPACE
			else if (i == 12) { buttons[i].setMnemonic(109); } // HASH-SUBTRACT
			else if (i == 13) { buttons[i].setMnemonic(8); } // BACK_SPACE
		}
	}

	public void redrawText(String textContent) {
		textArea.setText(textContent);
	}

	public void update(Observable obs, Object obj) {
		textArea.setText(obj.toString());
	}

	private static final long serialVersionUID = 1L;

}
