/** Interface for a Dictionary type which stores a set of words along with
 * their numerical signatures.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * File name : Dictionary.java
 * @version 2014-02-03
 */
package predictive;

import java.util.Set;

interface Dictionary {

	/* Takes a numerical signature as an arguement and queries a data structure
	 * which holds a dictionary of words, along with their numerical signature
	 * in some sorted order and returns a string set of the words that have
	 * that numerical signature. */
	Set<String> signatureToWords(String signature);
}
