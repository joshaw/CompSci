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

	private int count = 0;

	private JButton[] buttons = new JButton[14];
	private JTextArea textArea = new JTextArea();

	private T9Model model;

	public void test(){}

	/** Constructor for the T9View class. Initiates the user interface with an
	 * instance of the model.
	 *
	 * @param model the backend to use to support the UI.
	 */
	public T9View(T9Model model) {

		/* UI consists of a main panel which contains the text area for
		 * displaying the entered text and another panel which contains the
		 * buttons for entering text.
		 *
		 * The main panel has a border layout with the text area at the top and
		 * the buttons panel in the center. The buttons panel is arranged using
		 * a grid layout with small spacing between the buttons. */

		this.model = model;

		// Layout of overall window and buttons.
		BorderLayout PanelLayout = new BorderLayout();
		GridLayout ControlsLayout = new GridLayout(0, 3, 5, 5);

		JPanel controls = new JPanel();
		controls.setLayout(ControlsLayout);

		textArea = new JTextArea(5, 10);
		textArea.setPreferredSize(new Dimension( 400, 240 ));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Serif", Font.PLAIN, 18));

		/* Buttons are stored in an array for simplicity. array position 0 is
		 * empty for easy reference to buttons 1-9 and star (10), space (11),
		 * hash (12) and delete (13). The actionCommand of each button is set
		 * to the number it represents so that the button can be identified
		 * whilst allowing other aspect, eg text, to be changed. */
		for (int i = 1; i < 14; i++) {
			buttons[i] = new JButton();
			buttons[i].setActionCommand("" + i);
			controls.add(buttons[i]);
		}

		this.setLayout(new BorderLayout());
		this.add(textArea, BorderLayout.PAGE_START);

		setButtonText();
		this.addButtonListner(new ButtonListener());
		add(controls);

		this.pack();
		this.setTitle("T9 Predictive Text");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	/** Set the text on each button to be displayed.
	 */
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

	/** Add an ActionListener to all buttons along with mnemonic for keyboard
	 * control of buttons. (To use mnemonic hold alt while using number pad to
	 * press relevent button. Space key might not work work depending on window
	 * manager being used).
	 *
	 * @param bal ActionListener to add to this button.
	 */
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

	/** Update method, called by the notifyObservers method in a model class.
	 * Changes the textArea's text to a new value.
	 *
	 * @param obs Observable which caused the change.
	 * @param obj new text to replce in the textArea.
	 */
	@Override
	public void update(Observable obs, Object obj) {
		textArea.setText(obj.toString());
	}

	/** Button listener inner class. Defines the action to take when a button
	 * is pressed.
	 */
	class ButtonListener implements ActionListener {

		/** Perform this action.
		 *
		 * @param e when this event is triggered.
		 */
		public void actionPerformed(ActionEvent e) {

			int buttonNumber = Integer.parseInt(e.getActionCommand());

			String oldText = textArea.getText();

			// Button pressed was a number.
			if (buttonNumber > 1 && buttonNumber <= 9) {
				model.handleNumberButton(buttonNumber);

			// Button pressed was star.
			} else if (buttonNumber == 10) {
				model.handleStarButton();

			// Button pressed was hash.
			} else if (buttonNumber == 12) {
				model.handleHashButton();

			// Button pressed was space.
			} else if (buttonNumber == 11) {
				model.handleSpace();

			// Button pressed was delete.
			} else if (buttonNumber == 13) {
				model.handleDelete();
			}
		}
	}

	private static final long serialVersionUID = 1L;

}
