/** Class which reads a dictionary of words into memeory for use when
 * converting a word signature to its set of possible words. Means that the
 * dictionary does not need to be parsed for every signature to be converted.
 *
 * An ArrayList of pairs of signatures and words is used for simple addition of
 * words, which can be sorted for faster access.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : Worksheet3
 * File name : ListDictionary.java
 * @version 2014-02-02
 */
package predictive;

import java.io.*;
import java.util.*;

public class ListDictionary extends PredictiveText implements Dictionary, java.io.Serializable {

	private ArrayList<WordSig> wordSet = new ArrayList<WordSig>();

	/** Constructor for the ListDictionary class. Reads the default dictionary
	 * file into memory on creation of the object.
	 */
	public ListDictionary() {
		readDictionary(dictFile);
	}

	/** Constructor for the ListDictionary class. Reads the default dictionary
	 * file into memory on creation of the object.
	 *
	 * @param dictFile path to the dictionary file to be used.
	 */
	public ListDictionary(String dictFile) {
		readDictionary(dictFile);
	}

	/** Returns arrayList containing the pairs of words and signatures
	 * calculated from the dictionary file.
	 *
	 * @return arrayList of word/signature pairs.
	 */
	public ArrayList<WordSig> getWordSet() {
		return wordSet;
	}

	/** Parses a dictionary file (line separated list of words), calculates the
	 * signature for each word and stores the word and its signature in an
	 * arraylist.
	 *
	 * Words deemed non-valid are ignored.
	 *
	 * @param dictFile
	 */
	private void readDictionary(String dictFile) {
		String dictSig = new String();

		try {
			Scanner in = new Scanner(file);
			String word;

			while(in.hasNextLine()) {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);
					wordSet.add(new WordSig(word, dictSig));
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}

		Collections.sort(wordSet);
	}

	/** Using the dictionary file created with this object, the set of words
	 * that have the signature provided are located. A treeSet of those words
	 * is returned.
	 *
	 * @param signature signature to search for the corresponding words.
	 * @return set of words that have the same signature as the one provided.
	 */
	public Set<String> signatureToWords(String signature) {

		if (signature.equals("")) {
			return new TreeSet<String>();
		}

		WordSig test = new WordSig("", signature);
		int index = Collections.binarySearch(wordSet, test);

		TreeSet<String> foundWords = new TreeSet<String>();

		/* Check signatures for the wordSig's before this one, until the
		 * signatures no longer match. */
		String tempSig = signature;
		int i = index - 1;
		while (i >= 0 && tempSig.equals(signature)) {
			foundWords.add(wordSet.get(i).getWord());
			i--;
			tempSig = wordSet.get(i).getSignature();
		}

		// Add the word with corresponding signature.
		foundWords.add(wordSet.get(index).getWord());

		/* Check signatures for the wordSig's after this one, until the
		 * signatures no longer match. */
		tempSig = signature;
		i = index + 1;
		while (i < wordSet.size() && tempSig.equals(signature)) {
			foundWords.add(wordSet.get(i).getWord());
			i++;
			tempSig = wordSet.get(i).getSignature();
		}

		return foundWords;
	}

	/** Returns the word at the given index in the list of word pairs
	 * calculated from the dictionary file
	 *
	 * @param index index of the desired word.
	 * @return word at index "index".
	 */
	public String getWord(int index) {
		return wordSet.get(index).getWord();
	}

	/** Returns the signature at the given index in the list of word pairs
	 * calculated from the dictionary file
	 *
	 * @param signature signature of the desired word.
	 * @return signature at index "index".
	 */
	public String getSignature(int index) {
		return wordSet.get(index).getSignature();
	}

}
