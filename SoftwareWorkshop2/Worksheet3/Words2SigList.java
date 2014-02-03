import predictive.*;

import java.io.*;
import java.util.Scanner;

public class Words2SigList {
	public static void main(String[] args) {

		if (args.length > 0) {
			for (String word: args) {
				System.out.print(word + ": ");
				System.out.println(ListDictionary.wordToSignature(word));
			}
		} else {
			String testFile = "testfiles/words";
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
