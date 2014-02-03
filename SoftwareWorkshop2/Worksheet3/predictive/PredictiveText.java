package predictive;

import java.io.*;

public class PredictiveText {

	protected static String dictFile = "testfiles/words";
	protected static File file = new File(dictFile);

	/** Converts a word to its numerical signature.
	 *
	 * @param word alphabetical sequence to be converted in to mobile
	 * signature.
	 * @return string containing the nuerical signature of the input word.
	 */
	public static String wordToSignature(String word) {
		String letter = "";

		/* StringBuilder class is used to compile the digits since it presents
		 * significant speed improvements when concatenation of strings is
		 * performed many times. For each word, there will be only a few digits
		 * that are combined, so a simple String += would be sufficient. When
		 * calculating the signatures of an entire dictionary, the speed
		 * restrictions become large.
		 *
		 * StringBuffer is another alternative to StringBuilder. It offers the
		 * benefits of being synchronised. This means it can be useful when
		 * multiple threads are used, but reduces the maximum possible speed of
		 * operation. The threaded operation is not utilised here, so
		 * StringBuilder is used to be faster, and is almost always the
		 * preferable method. */
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			letter = Character.toString(word.charAt(i));
			if (letter.matches("[a-c]")) {
				sb.append("2");
			} else if (letter.matches("[d-f]")) {
				sb.append("3");
			} else if (letter.matches("[g-i]")) {
				sb.append("4");
			} else if (letter.matches("[j-l]")) {
				sb.append("5");
			} else if (letter.matches("[m-o]")) {
				sb.append("6");
			} else if (letter.matches("[p-s]")) {
				sb.append("7");
			} else if (letter.matches("[t-v]")) {
				sb.append("8");
			} else if (letter.matches("[w-z]")) {
				sb.append("9");
			} else {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/** Method to limit the words that are considered as valid when converting
	 * a signature to words. Currently ignores words that contain anything
	 * other than lower case a-z.
	 *
	 * @param word string of letters to check for valididy.
	 * @return true if the word is valid.
	 */
	protected static boolean isValidWord(String word) {
		return word.matches("[a-z]*");
	}
}
