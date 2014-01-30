package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.Collections;

public class ListDictionary extends PredictivePrototype {

	private String dictFile = "testfiles/words";
	private File file = new File(dictFile);
	private ArrayList<WordSig> wordSet = new ArrayList<WordSig>();

	public ListDictionary() {
		readFileToArrayList();
	}

	private void readFileToArrayList() {
		String dictSig = new String();

		try {
			Scanner in = new Scanner(file);
			String word = new String();

			do {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);
					wordSet.add(new WordSig(word, dictSig));
				}

			} while(in.hasNextLine());

		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}

		Collections.sort(wordSet);
	}

}
