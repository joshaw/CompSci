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
}
