/** Commandline program to convert a word provided to its numerical signature
 * using the MapDictionary class.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : Words2SigMap.java
 * @version 2014-02-03
 */
import predictive.*;

import java.io.*;
import java.util.Scanner;

public class Words2SigMap {
	public static void main(String[] args) {

		/* If arguements are given on the command line, then for each of those
		 * words, calculate the numerical signature. */
		if (args.length > 0) {
			for (String word: args) {
				System.out.print(word + ": ");
				System.out.println(MapDictionary.wordToSignature(word));
			}
		} else {

		/* If no arguments are given to the program, calculate the signatures
		 * for every word in the defined dictionary. */
			String testFile = "testfiles/words.txt";
			System.out.println("###\nReading from file " + testFile + "\n###");

			File file = new File(testFile);
			Scanner scanner;
			int wordNum = 0;
			try {
				scanner = new Scanner(file);
				while (scanner.hasNextLine()){

					String line = scanner.nextLine();
					String[] wordOfLine = line.split("\\W");

					for (String word : wordOfLine){
						if (!word.equals("")) {

							System.out.println(word + ": " +
									ListDictionary.wordToSignature(word));
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("File not found.");
			}
		}
	}
}
