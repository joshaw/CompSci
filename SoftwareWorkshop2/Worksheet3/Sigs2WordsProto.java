/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : Sigs2WordsProto.java
 * @version 2014-02-03
 */
import predictive.*;

public class Sigs2WordsProto {
	public static void main(String[] args) {
		for (String sig: args) {
			System.out.print(sig + ": ");
			System.out.println(PredictivePrototype.signatureToWords(sig));
		}
	}
}
