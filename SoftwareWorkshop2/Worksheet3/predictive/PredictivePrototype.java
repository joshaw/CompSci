/** Prototype implementation of methods that convert a word to its signature as
 * it would be represented when typed by a mobile keypad.
 *
 * wordToSignature takes a word and produces the numbers thay would need to be
 * pressed to produce it.  signatureToWords takes a numerical signature and,
 * using a library of words, produces the possible words that would produce
 * that signature.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * File name : PredictivePrototype.java
 * @version 2014-01-31
 */
package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PredictivePrototype extends PredictiveText {

	// private static String dictFile = "testfiles/words";
	// private static File file = new File(dictFile);

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

	// 		/* Convert each letter in the word to a character to be compared
	// 		 * against a regex to determine corresponding number. */
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
	// 		} else { // anything other than [a-z] return space.
	// 			sb.append(" ");
	// 		}
	// 	}
	// 	return sb.toString();
	// }

	/** Using a dictionary of acceptable words, produces a Set of words that
	 * would produce the given signature.
	 *
	 * @param signature signature to convert to words.
	 * @return a Set containing all the words that could produce the given
	 * signature.
	 */
	public static Set<String> signatureToWords(String signature){
		String dictSig = new String();

		TreeSet<String> wordSet = new TreeSet<String>();

		try {
			Scanner in = new Scanner(file);
			String word = new String();

			/* For the whole file, if the word is valid, calculate its
			 * signature and add it to the set of words. */
			while(in.hasNextLine()) {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);
					if (dictSig.equals(signature)) {
						wordSet.add(word);
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found. " + dictFile);
		}
		return wordSet;
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
