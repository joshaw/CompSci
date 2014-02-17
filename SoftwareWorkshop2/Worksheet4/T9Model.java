/*#############################################################################
#                                    Model                                    #
#############################################################################*/

import java.util.Observable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import predictive.*;

public final class T9Model {

	private int total;
	private TreeDictionary dict;

	T9Model() {
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

	public void setValue(String val) {
		System.out.println("Value = " + val);
	}

	public void printValue(int val) {
		System.out.println("Int = " + val);
	}
}
