/*#############################################################################
#                                    Model                                    #
#############################################################################*/

import java.util.Observable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Observable;

import predictive.*;

public final class T9Model extends Observable {

    private int total;
    private TreeDictionary dict;

    private ArrayList<String> currentWords;
    private int sel = 0;
    private String curWord = "";
    private String curSig = "";
    private String textContent = "";

    public T9Model() {
        dict = new TreeDictionary("words.txt");
    }

    public ArrayList<String> wordPrefixList(String sig) {
        Set<String> wordSet = dict.signatureToWords(sig);
        return setToArrayList(wordSet);
    }

    private ArrayList<String> setToArrayList(Set<String> set) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(set);
        return list;
    }

    private String getWord(int i) {
        if (currentWords.size() == 0) {
            return curSig;
        }
        String temp = currentWords.get(i);
        return temp;
    }

    public void handleNumberButton(int buttonNumber) {
        curSig += buttonNumber;
        currentWords = wordPrefixList(curSig);
        curWord = getWord(0);
        view.setTextArea(textContent + curWord);
    }

    public void handleStarButton() {
        if (sel < currentWords.size()-1) {
            sel++;
            curWord = getWord(sel);
            view.setTextArea(textContent + curWord);
        }
    }

    public void handleHashButton() {
        if (sel > 0) {
            sel--;
            curWord = getWord(sel);
            view.setTextArea(textContent + curWord);
        }
    }

	public void handleSpace() {
		textContent += curWord + " ";
		view.redrawText(textContent);
		curSig = "";
		sel = 0;
		curWord = "";
	}

    public void handleDelete() {
        int lastSpace = textContent.lastIndexOf(" ");

        if (curWord.length() > 0) {
            curSig = curSig.substring(0, curSig.length() - 1);
            currentWords = wordPrefixList(curSig);
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

	public void notifyObservers(Object obj) {

	}

}
