/** Commandline program to convert a signature provided to its corresponding
 * word using the MapDictionary class.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : Sigs2WordsList.java
 * @version 2014-02-03
 */
import predictive.*;

import java.util.Scanner;

public class Sigs2WordsMap {
	public static void main(String[] args) {
		MapDictionary dict = new MapDictionary();

		/* If arguements are given on the command line, then for each of those
		 * signatures, calculate the possible words. */
		if (args.length > 0) {
			for (String sig: args) {
				System.out.print(sig + ": ");
				System.out.println(dict.signatureToWords(sig));
			}
		} else {

		/* If no arguments are given to the program, calculate the possible
		 * words for every word provided. */
			Scanner in = new Scanner(System.in);
			String input = "";

			do {
				System.out.print("Signature: ");
				input = in.next();
				System.out.print(" = ");
				System.out.print(dict.signatureToWords(input));
				System.out.println();
			} while (!input.equals("STOP"));
		}
	}
}
