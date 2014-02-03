/** Class for storing the pairing of a word with its numerical signature and
 * allowing the sorting of such pairings by the numerical value of the
 * signature.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : predictive
 * File name : predictive/WordSig.java
 * @version 2014-02-03
 */
package predictive;

import java.math.BigInteger;

public class WordSig implements Comparable<WordSig> {

	private String word;
	private String signature;

	public WordSig(String word, String signature) {
		this.word = word;
		this.signature = signature;
	}

	public String getWord() {
		return word;
	}

	public String getSignature() {
		return signature;
	}

	@Override
	public int compareTo(WordSig ws) {

		/* signatures are stored as strings. Here they are converted to Doubles
		 * so that they are sorted numerically rather than lexiographically.
		 * Double is large enough to allow words up to ~300 letters. */
		Double sig = Double.parseDouble(signature);
		Double wsSig = Double.parseDouble(ws.signature);
		return sig.compareTo(wsSig);
	}

}
