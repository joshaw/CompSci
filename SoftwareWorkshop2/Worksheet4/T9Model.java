/** Class for the model component of the T9 Predictive Text application GUI.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet4
 * File name : T9Model.java
 * @version 2014-02-19
 */
import java.util.Observable;
import java.util.ArrayList;
import java.util.Set;

import predictive.*;

public final class T9Model extends Observable {

	private TreeDictionary dict;

	private ArrayList<String> currentWords;
	private int sel = 0;
	private String curWord = "";
	private String curSig = "";
	private String textContent = "";

	/** Constructor for the model class. Simply initiates a new instance of a
	 * dictionary object.
	 */
	public T9Model() {
		dict = new TreeDictionary("words.txt");
	}

	/** Returns a list of word prefixes that match the given signature.
	 *
	 * @param sig signature to find prefixes for.
	 * @return ArrayList of word prefixes.
	 */
	public ArrayList<String> wordPrefixList(String sig) {
		Set<String> wordSet = dict.signatureToWords(sig);
		return setToArrayList(wordSet);
	}

	/** Converts a set to an ArrayList.
	 *
	 * @param set set to convert.
	 * @return all the elements from set added, in the order they are returned
	 * by the set's compareTo method, to an ArrayList.
	 */
	private ArrayList<String> setToArrayList(Set<String> set) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(set);
		return list;
	}

	/** Returns the i'th prefix from the list of possible words. If the list is
	 * empty, then returns the original signature.
	 *
	 * @param i element from the list to return.
	 * @return i'th element from the list of prefixes.
	 */
	private String getWord(int i) {
		if (currentWords.size() == 0) {
			return curSig;
		}
		String temp = currentWords.get(i);
		return temp;
	}

	/** If a button number has been pressed, then add that number to the
	 * signature, get the first in the list of possible words from the list of
	 * prefixes that matches that signature and notifyObservers using the
	 * sentence so far as well as this new word.
	 *
	 * @param buttonNumber number, 1-9, of the button that was pressed.
	 */
	public void handleNumberButton(int buttonNumber) {
		curSig += buttonNumber;
		currentWords = wordPrefixList(curSig);
		curWord = getWord(0);

		this.setChanged();
		notifyObservers(textContent + curWord);
	}

	/** The star button was pressed, meaning the next item in the list is
	 * required. If there are words availible, the increase the word selection
	 * counter, and retreive that item from the list of possible words.
	 */
	public void handleStarButton() {
		if (sel < currentWords.size()-1) {
			sel++;
			curWord = getWord(sel);

			this.setChanged();
			notifyObservers(textContent + curWord);
		}
	}

	/** The hash button was pressed, meaning the previous item in the list is
	 * required. If there are words availible, the decrease the word selection
	 * counter, and retreive that item from the list of possible words.
	 */
	public void handleHashButton() {
		if (sel > 0) {
			sel--;
			curWord = getWord(sel);

			this.setChanged();
			notifyObservers(textContent + curWord);
		}
	}

	/** The space button was pressed meaning the current word is finished and a
	 * new word should be started. Reset the current signature, word and word
	 * selection variables.
	 */
	public void handleSpace() {
		textContent += curWord + " ";
		this.setChanged();

		notifyObservers(textContent);
		curSig = "";
		sel = 0;
		curWord = "";
	}

	/** The delete button was pressed. If pressed inside a word, the remove the
	 * last entered letter. Otherwise remove the last entered word.
	 *
	 */
	public void handleDelete() {

		/* We're still in a word, so only delete a letter. Remove last digit
		 * and get first of possible words. */
		if (curWord.length() > 0) {
			curSig = curSig.substring(0, curSig.length() - 1);
			currentWords = wordPrefixList(curSig);
			curWord = getWord(0);

			this.setChanged();
			notifyObservers(textContent + curWord);

		/* Otherwise delete the whole of the last word, back to the previous
		 * space. */
		} else {
			int lastSpace = textContent.lastIndexOf(" ");

			// If there are no words left, then the text is empty.
			if (lastSpace > 0) {
				textContent = textContent.substring(0, lastSpace);
			} else {
				textContent = "";
			}

			this.setChanged();
			notifyObservers(textContent);
		}
	}
}
