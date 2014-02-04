package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeDictionary extends PredictiveText implements Dictionary {

	private boolean empty;
	private Set<String> value;
	private TreeDictionary td2, td3, td4, td5, td6, td7, td8, td9;

	public TreeDictionary(Set<String> value, TreeDictionary td2,
			TreeDictionary td3, TreeDictionary td4, TreeDictionary td5,
			TreeDictionary td6, TreeDictionary td7, TreeDictionary td8,
			TreeDictionary td9){
		this.empty = false;
		this.value = value;
		this.td2 = td2;
		this.td3 = td3;
		this.td4 = td4;
		this.td5 = td5;
		this.td6 = td6;
		this.td7 = td7;
		this.td8 = td8;
		this.td9 = td9;
	}

	public TreeDictionary(boolean head) {
		if (!head) {
			throw new IllegalStateException("Not recognised.");
		}
		this.empty = false;
		this.value = value;
		this.td2 = new TreeDictionary();
		this.td3 = new TreeDictionary();
		this.td4 = new TreeDictionary();
		this.td5 = new TreeDictionary();
		this.td6 = new TreeDictionary();
		this.td7 = new TreeDictionary();
		this.td8 = new TreeDictionary();
		this.td9 = new TreeDictionary();
	}

	public TreeDictionary() {
		this.empty = true;
	}

	public TreeDictionary(String dictFile){
		readDictionary(dictFile);
	}

	public boolean getEmpty() {
		return empty;
	}

	public Set<String> getValue() {
		if (getEmpty()) {
			throw new IllegalStateException(
					"Trying to access root not of an empty tree");
		}
		return value;
	}

	public TreeDictionary getTD(int number) {
		switch (number) {
			case 2: return td2;
			case 3: return td3;
			case 4: return td4;
			case 5: return td5;
			case 6: return td6;
			case 7: return td7;
			case 8: return td8;
			case 9: return td9;
			default : throw new IllegalStateException(
							  "Not a valid dictionary.");
		}
	}

	private void readDictionary(String dictFile) {
		String dictSig;

		File file = new File(dictFile);

		try {
			Scanner in = new Scanner(file);
			String word;

			while(in.hasNextLine()) {
				word = in.nextLine();

				if (isValidWord(word)) {
					dictSig = wordToSignature(word);

					for (int i = 0; i < dictSig.length(); i++) {
						char num = dictSig.charAt(i);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}
	}

	public Set<String> signatureToWords(String signature) {
		return new TreeSet<String>();
	}
}
