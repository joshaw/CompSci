package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PredictivePrototype {

	public static String wordToSignature(String word) {
		String letter = "";

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
			}
		}
		return sb.toString();
	}

	public static Set<String> signatureToWords(String signature){
		String dict = "words";
		File file = new File(dict);
		String dictSig = new String();

		TreeSet<String> wordSet = new TreeSet<String>();

		try {
			Scanner in = new Scanner(file);
			String word = new String();

			do {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);
					if (dictSig.equals(signature)) {
						wordSet.add(word);
					}
				}

			} while(in.hasNextLine());

		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}

		return wordSet;
	}

	private static boolean isValidWord(String word) {
		if (word.replaceAll("[a-z]","").equals("")) {
			return true;
		}
		return false;
	}

}
