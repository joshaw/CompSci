import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class T9Controller {

	private T9Model model;
	private T9View view;

	private ArrayList<String> currentWords;
	private int sel = 0;
	private String curWord = "";

	public T9Controller(T9Model model, T9View view) {
		this.model = model;
		this.view = view;

		view.addButtonListner(new ButtonListener());
	}

	private String getWord(int i) {
		String temp = currentWords.get(i);
		return "THIS";
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int buttonNumber = Integer.parseInt(e.getActionCommand());

			String oldText = view.getTextArea();

			if (buttonNumber > 0 && buttonNumber <= 9) {

				currentWords = model.wordPrefixList("" + buttonNumber);
				view.setTextArea(getWord(sel));

			} else if (buttonNumber == 10) {
				sel++;
				view.setTextArea(getWord(sel));
			} else if (buttonNumber == 11) {
				curWord = "";
				sel = 0;
				view.reset();
			} else if (buttonNumber == 12) {
				view.setTextArea("Hash button pressed");
			}
		}
	}

}
