/** Class which reads a dictionary of words into memory for use when converting
 * a word signature to its set of possible words. This means that the
 * dictionary does not need to be parsed for every signature to be converted.
 *
 * A custom recursive data structure, based on TreeSet's is used where each
 * treeSet has a total of 8 subchildren, one for each of the possible values in
 * the signature, 2-9. Within each of these, a set of the possible words is
 * stored for quick retreval when searching for a signature.
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
import java.util.Iterator;

public class TreeDictionary extends PredictiveText implements Dictionary {

	private int number;
	private boolean empty;
	private Set<String> wordSet = new TreeSet<String>();
	private TreeDictionary[] treeArray = new TreeDictionary[10];

	/** Constructor for the TreeDictionary class.
	 */
	private TreeDictionary() {
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
	private boolean isEmpty() {
		return empty;
	}

	/** Set the empty flag of the current object.
	 *
	 * @param empty boolean value for empty.
	 */
	private void setEmpty(boolean empty) {
		this.empty = empty;
	}

	/** Returns the set of words that are stored for a given signature, or
	 * signature prefix.
	 *
	 * @return Set containing the words that match a given signature.
	 */
	private Set<String> getWordSet() {
		return wordSet;
	}

	/** Returns a subtree of the current TreeDictionary.
	 *
	 * @param number the number of the subtree to be returned, 2-9.
	 * @return a TreeDictionary holding the words corresponding to the given
	 * signature.
	 */
	private TreeDictionary getTD(int number) {
		return treeArray[number];
	}

	/** Adds a word to a given subtree in the current TreeDictionary.
	 *
	 * @param number subtree to add to.
	 * @param word word to add.
	 */
	private void addToTD(int number, String word) {
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

		// Populate with empty trees.
		if (tree.isEmpty()) {
			tree.treeArray = makeTrees();
			tree.setEmpty(false);
		}
		tree.setEmpty(false);
		tree.addToTD(numInt, word);

		// If the signature still has some integers left.
		if (signature.length() > 1) {
			addWord(signature.substring(1), word, tree.getTD(numInt));
		}
	}

	/** Converts the given signature to a set of possible words that could be
	 * represented by it using the TreeDictionary object that is operated on.
	 *
	 * @param signature signature to calculate possible words for.
	 * @return set of possible words for that signature.
	 */
	public Set<String> signatureToWords(String signature) {
		int sigLength = signature.length();
		TreeDictionary temp = this;
		int num;

		/* While the signature is not empty, remove the first value and use to
		 * refer to the relevant subtree in the TreeDictionary object. */
		while (signature.length() > 0) {
			try {
				num = Integer.parseInt(signature.substring(0,1));
				if (num < 2) {
					throw new IllegalArgumentException("Signature can " +
							"only contain the values 2-9, found " + num + ".");
				}

				signature = signature.substring(1);
				if (!temp.isEmpty()) {
					temp = temp.getTD(num);
				}
			} catch(IllegalArgumentException e) {
				System.err.println(e);
			}
		}

			TreeSet<String> trimmed = new TreeSet<String>();
			for (String c: temp.wordSet) {
				trimmed.add(c.substring(0,sigLength));
			}
		return trimmed;
	}

	/** Makes a set of 10 trees for extending the TreeDictionary object to a
	 * new layer.
	 *
	 * @return array of empty TreeDictionary objects for use in a
	 * TreeDictionary.
	 */
	private TreeDictionary[] makeTrees() {
		TreeDictionary[] temp = new TreeDictionary[10];

		/* Start at 2 since 0 and 1 are not used on numerical keypad, so do not
		 * appear in signatures. Leave these array positions empty for easier
		 * reference between signature value and position. */
		for (int i = 2; i < 10; i++) {
			temp[i] = new TreeDictionary();
		}
		return temp;
	}
}
