/** Class which reads a dictionary of words into memeory for use when
 * converting a word signature to its set of possible words. Means that the
 * dictionary does not need to be parsed for every signature to be converted.
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

public class ListDictionary extends PredictiveText implements Dictionary {

	// private String dictFile = "testfiles/words";
	// private File file = new File(dictFile);
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
	 * signature for each file and stores the word and its signature in an
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
			String word = new String();

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

	// /** Converts a word to its numerical signature.
	//  *
	//  * @param word alphabetical sequence to be converted in to mobile
	//  * signature.
	//  * @return string containing the nuerical signature of the input word.
	//  */
	// public static String wordToSignature(String word) {
	// 	String letter = "";

	// 	/* StringBuilder class is used to compile the digits since it presents
	// 	 * significant speed improvements when concatenation of strings is
	// 	 * performed many times. For each word, there will be only a few digits
	// 	 * that are combined, so a simple String += would be sufficient. When
	// 	 * calculating the signatures of an entire dictionary, the speed
	// 	 * restrictions become large.
	// 	 *
	// 	 * StringBuffer is another alternative to StringBuilder. It offers the
	// 	 * benefits of being synchronised. This means it can be useful when
	// 	 * multiple threads are used, but reduces the maximum possible speed of
	// 	 * operation. The threaded operation is not utilised here, so
	// 	 * StringBuilder is used to be faster, and is almost always the
	// 	 * preferable method. */
	// 	StringBuilder sb = new StringBuilder();

	// 	for (int i = 0; i < word.length(); i++) {
	// 		letter = Character.toString(word.charAt(i));
	// 		if (letter.matches("[a-c]")) {
	// 			sb.append("2");
	// 		} else if (letter.matches("[d-f]")) {
	// 			sb.append("3");
	// 		} else if (letter.matches("[g-i]")) {
	// 			sb.append("4");
	// 		} else if (letter.matches("[j-l]")) {
	// 			sb.append("5");
	// 		} else if (letter.matches("[m-o]")) {
	// 			sb.append("6");
	// 		} else if (letter.matches("[p-s]")) {
	// 			sb.append("7");
	// 		} else if (letter.matches("[t-v]")) {
	// 			sb.append("8");
	// 		} else if (letter.matches("[w-z]")) {
	// 			sb.append("9");
	// 		} else {
	// 			sb.append(" ");
	// 		}
	// 	}
	// 	return sb.toString();
	// }

	/** Using the dictionary file created with this object, the set of words
	 * that have the signature provided are located. A treeSet of those words
	 * is returned.
	 *
	 * @param signature signature to search for the corresponding words.
	 * @param upperRange maximum number of words to search forwards to find
	 * others that have the same signature.
	 * @param lowerRange maximum number of words to search backwards that have
	 * have the same signature.
	 * @return set of words that have the same signature as the one provided.
	 */
	public Set<String> signatureToWords(String signature,
			int upperRange, int lowerRange) {

		if (signature.equals("")) {
			return new TreeSet<String>();
		}

		WordSig test = new WordSig("", signature);
		int index = Collections.binarySearch(wordSet, test);

		TreeSet<String> foundWords = new TreeSet<String>();

		int upperMax = index + upperRange;
		int lowerMin = index - lowerRange;

		if (upperMax > wordSet.size()) {
			upperMax = wordSet.size();
		}
		if (lowerMin < 0) {
			lowerMin = 0;
		}

		for (int i = lowerMin; i < upperMax; i++) {

			WordSig attempt = wordSet.get(i);
			if (attempt.getSignature().equals(signature)) {
				foundWords.add(attempt.getWord());
			}
		}

		return foundWords;
	}

	/** Using the dictionary file created with this object, the set of words
	 * that have the signature provided are located. A treeSet of those words
	 * is returned.
	 *
	 * @param signature signature to search for the corresponding words.
	 * @return set of words that have the same signature as the one provided.
	 */
	public Set<String> signatureToWords(String signature){
		return signatureToWords(signature, 15, 15);
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

	// /** Method to limit the words that are considered as valid when converting
	//  * a signature to words. Currently ignores words that contain anything
	//  * other than lower case a-z.
	//  *
	//  * @param word string of letters to check for valididy.
	//  * @return true if the word is valid.
	//  */
	// protected static boolean isValidWord(String word) {
	// 	// String validTest = "[a-z]";
	// 	// if (word.replaceAll(validTest,"").equals("")) {
	// 	// 	return true;
	// 	// }
	// 	// return false;

	// 	// Match letters 0 or more times.
	// 	return word.matches("[a-z]*");
	// }

}
