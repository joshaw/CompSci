/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : predictive
 * File name : predictive/TreeDictionary.java
 * @version 2014-02-06
 */
package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeDictionary extends PredictiveText implements Dictionary {

	private int number;
	private boolean empty;
	private Set<String> wordSet = new TreeSet<String>();
	private TreeDictionary[] treeArray = new TreeDictionary[10];

	/** Constructor for the TreeDictionary class.
	 */
	public TreeDictionary() {
		this.wordSet = new TreeSet<String>();
		this.empty = true;
	}

	/** Constructor for the TreeDictionary class. Makes a TreeDictionary using
	 * the file provided as argement.
	 *
	 * @param dictFile dictionary file to use.
	 */
	public TreeDictionary(String dictFile){
		this.empty = false;
		treeArray = makeTrees();
		readDictionary(dictFile);
	}

	/** Returns true if the TreeDictionary is empty.
	 *
	 * @return true if empty.
	 */
	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	/** Returns the set of words that are stored for a given signature, or
	 * signature prefix.
	 *
	 * @return Set containing the words that match a given signature.
	 */
	public Set<String> getWordSet() {
		return wordSet;
	}

	/** Returns a subtree of the current TreeDictionary.
	 *
	 * @param number the number of the subtree to be returned, 2-9.
	 * @return a TreeDictionary holding the words corresponding to the given
	 * signature.
	 */
	public TreeDictionary getTD(int number) {
		return treeArray[number];
	}

	/** Adds a word to a given subtree in the current TreeDictionary.
	 *
	 * @param number subtree to add to.
	 * @param word word to add.
	 */
	public void addToTD(int number, String word) {
		treeArray[number].wordSet.add(word);
	}

	/** Read a dictionary file and create a TreeDictionary object with the
	 * contents.
	 *
	 * @param dictFile path to the dictionary file.
	 */
	private void readDictionary(String dictFile) {
		String dictSig;

		File file = new File(dictFile);

		try {
			Scanner in = new Scanner(file);
			String word;

			while(in.hasNextLine()) {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);

					addWord(dictSig, word, this);
					// for (int i = 0; i < dictSig.length(); i++) {
					// 	int num = Character.getNumericValue(dictSig.charAt(i));
					// 	this.addToTD(num, word);
					// }
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}

		for (int i = 2; i <= 9; i++) {
			System.out.println(i + " = " + this.getTD(i).wordSet);
		}
	}

	private void addWord(String signature, String word, TreeDictionary tree) {
		String num = signature.substring(0,1);
		int numInt = Integer.parseInt(num);
		// System.out.println(num + " " + signature + " - " + word);

		if (signature.length() == 1) {
			// System.out.println("1");
			return;
		}
		if (tree.isEmpty()) {
			tree.treeArray = makeTrees();
		}
		tree.addToTD(numInt, word);
		tree.setEmpty(false);
		addWord(signature.substring(1), word, tree.getTD(numInt));
	}

	public Set<String> signatureToWords(String signature) {
		while (signature.length()) {
			
		}
		return new TreeSet<String>();
	}

	private TreeDictionary[] makeTrees() {
		TreeDictionary[] temp = new TreeDictionary[10];
		for (int i = 0; i < 10; i++) {
			temp[i] = new TreeDictionary();
		}
		return temp;
	}

	// @Override
	// public String toString() {
	// 	return toString(this);
	// }

	// private String toString(TreeDictionary tree) {
	// 	// System.out.println(this.getTD(4).getTD(2).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(3).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(4).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(5).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(6).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(7).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(8).wordSet);
	// 	// System.out.println(this.getTD(4).getTD(9).wordSet);
	// 	// System.out.println(this.wordSet.size());
	// 	// System.out.println(this.isEmpty());
	// 	if (this.isEmpty()) {
	// 		// StringBuilder temp = new StringBuilder();
	// 		// for (int i = 2; i < 10; i++) {
	// 		// 	temp.append(this.getTD(i));
	// 		// }
	// 		return "isEmpty";
	// 		// return temp.toString();
	// 	}

	// 	StringBuilder treeString = new StringBuilder();
	// 	for (int i = 2; i < 10; i++) {
	// 	System.out.println("HERE +  " + i);
	// 		treeString.append(i + " - " + toString(tree.getTD(i)));
	// 	}
	// 	return treeString.toString();
	// }

}
