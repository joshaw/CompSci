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

	private String getWord(int i) {
		if (currentWords.size() == 0) {
			return curSig;
		}
		String temp = currentWords.get(i);
		return temp;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int buttonNumber = Integer.parseInt(e.getActionCommand());

			String oldText = view.getTextArea();

			if (buttonNumber > 1 && buttonNumber <= 9) {
				curSig += buttonNumber;
				currentWords = model.wordPrefixList(curSig);
				curWord = getWord(0);
				view.setTextArea(textContent + curWord);

			} else if (buttonNumber == 10) { // STAR
				if (sel < currentWords.size()-1) {
					sel++;
					curWord = getWord(sel);
					view.setTextArea(textContent + curWord);
				}

			} else if (buttonNumber == 12) { // HASH
				if (sel > 0) {
					sel--;
					curWord = getWord(sel);
					view.setTextArea(textContent + curWord);
				}

			} else if (buttonNumber == 11) { // SPACE
				textContent += curWord + " ";
				view.redrawText(textContent);
				curSig = "";
				sel = 0;
				curWord = "";
			} else if (buttonNumber == 13) {
				int lastSpace = textContent.lastIndexOf(" ");

				if (curWord.length() > 0) {
					curSig = curSig.substring(0, curSig.length() - 1);
					currentWords = model.wordPrefixList(curSig);
					curWord = getWord(0);
					view.setTextArea(textContent + curWord);
				} else {
					if (lastSpace > 0) {
						textContent = textContent.substring(0, lastSpace);
					} else {
						textContent = "";
					}
					view.setTextArea(textContent);

				}

			}
		}
	}
}
