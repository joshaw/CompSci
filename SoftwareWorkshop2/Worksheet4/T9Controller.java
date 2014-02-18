import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class T9Controller {

	private T9Model model;
	private T9View view;

	private ArrayList<String> currentWords;
	private int sel = 0;
	private String curWord = "";
	private String curSig = "";
	private String textContent = "";

	public T9Controller(T9Model model, T9View view) {
		this.model = model;
		this.view = view;

		view.addButtonListner(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int buttonNumber = Integer.parseInt(e.getActionCommand());

			String oldText = view.getTextArea();

			if (buttonNumber > 1 && buttonNumber <= 9) {
				model.handleNumberButton(buttonNumber);

			} else if (buttonNumber == 10) { // STAR
				model.handleStarButton();

			} else if (buttonNumber == 12) { // HASH
				model.handleHashButton();

			} else if (buttonNumber == 11) { // SPACE
				model.handleSpace();

			} else if (buttonNumber == 13) { // DEL
				model.handleDelete();
			}
		}
	}
}
