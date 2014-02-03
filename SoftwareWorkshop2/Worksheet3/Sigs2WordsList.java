/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : Sigs2WordsList.java
 * @version 2014-02-03
 */
import predictive.*;

public class Sigs2WordsList {
	public static void main(String[] args) {
		ListDictionary dict = new ListDictionary();

		for (String sig: args) {
			System.out.print(sig + ": ");
			System.out.println(dict.signatureToWords(sig));
		}
	}
}
