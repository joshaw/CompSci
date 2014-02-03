/** Class which reads a dictionary of words into memeory for use when
 * converting a word signature to its set of possible words. Means that the
 * dictionary does not need to be parsed for every signature to be converted.
 *
 * A TreeMap is used for fast access to the possible words when converting
 * signatures to words.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : Worksheet3
 * File name : MapDictionary.java
 * @version 2014-02-03
 */
package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class MapDictionary extends PredictiveText implements Dictionary {

	private TreeMap<String,TreeSet<String>> wordSet =
		new TreeMap<String,TreeSet<String>>();

	/** Constructor of the MapDictionary class. Reads the default dictionary
	 * file into memory on creation of the object.
	 */
	public MapDictionary() {
		readDictionary(dictFile);
	}

	/** Constructor of the MapDictionary class. Reads the default dictionary
	 * file into memory on creation of the object.
	 *
	 * @param dictFile path to the dictionary file to be used.
	 */
	public MapDictionary(String dictFile) {
		readDictionary(dictFile);
	}

	/** Parses a dictionary file (line separated list of words), calculates the
	 * signature for each word and stores the word and its signature in a
	 * TreeMap. Since keys (signatures) cannot be repeated in a TreeMap, the
	 * values (words) are stored as elements in a TreeSet such that multiple
	 * words with the same signature are stored together.
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

					TreeSet<String> temp;

					/* If the wordSet already contains this key, then add the
					 * new word to the set. */
					if (wordSet.containsKey(dictSig)) {
						temp = wordSet.get(dictSig);

					/* Otherwise, this is the first instance of this signature,
					 * so add it to a new set and add the set. */
					} else {
						temp = new TreeSet<String>();
					}
					temp.add(word);
					wordSet.put(dictSig, temp);
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}
	}

	/** Using the dictionary file created with this object, the set of words
	 * that have the signature provided are located. A treeSet of those words
	 * is returned.
	 *
	 * @param signature signature to search for the corresponding words.
	 * @return set of words that have the same signature as the one provided.
	 */
	public Set<String> signatureToWords(String signature){
		if (signature.equals("")) {
			return new TreeSet<String>();
		}

		return wordSet.get(signature);
	}

}
