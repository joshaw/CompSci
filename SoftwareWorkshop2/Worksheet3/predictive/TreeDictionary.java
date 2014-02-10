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

public class TreeDictionary extends PredictiveText implements Dictionary, java.io.Serializable {

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

	/** Set the empty flag of the current object.
	 *
	 * @param empty boolean value for empty.
	 */
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
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}
	}

	/** Add a word, with the given signature to a given TreeDictionary. Adds
	 * the word to the Set that is contained in the appropriate tree. The word
	 * is added recursively to all applicable subtrees from the signature.
	 *
	 * eg, the word 'home', which as signature '4663' will be added to the set
	 * in subtree 4, in the subtree 6 of 4, the subtree of 6 of 6 of 4 and 3 of
	 * 6 of 6 of 4.
	 *
	 * Adding, to an initially empty TreeDictionary object, the words 'home',
	 * 'goal' and then 'ions' gives the following tree.
	 *
	 *    root
	 *        4 [home, goal, ions]
	 *            6 [home, goal, ions]
	 *                2 [goal]
	 *                    5 [goal]
	 *                6 [home, ions]
	 *                    3 [home]
	 *                    7 [ions]
	 *
	 * @param signature
	 * @param word
	 * @param tree
	 */
	private void addWord(String signature, String word, TreeDictionary tree) {
		String num = signature.substring(0,1);
		int numInt = Integer.parseInt(num);

		if (tree.isEmpty()) {
			tree.treeArray = makeTrees();
		}
		tree.setEmpty(false);
		tree.addToTD(numInt, word);

		if (signature.length() > 1) {
			addWord(signature.substring(1), word, tree.getTD(numInt));
		}
		System.out.println("Done - " + word);
	}

	/**
	 *
	 * @param signature
	 * @return
	 */
	public Set<String> signatureToWords(String signature) {
		TreeDictionary temp = this;
		int num;
		while (signature.length() > 0) {
			num = Integer.parseInt(signature.substring(0,1));
			signature = signature.substring(1);
			if (temp.isEmpty()) {
				return new TreeSet<String>();
			}
			temp = temp.getTD(num);
		}
		return temp.wordSet;
	}

	/**
	 *
	 * @return
	 */
	private TreeDictionary[] makeTrees() {
		TreeDictionary[] temp = new TreeDictionary[10];
		for (int i = 0; i < 10; i++) {
			temp[i] = new TreeDictionary();
		}
		return temp;
	}
}
