package predictive;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeDictionary extends PredictiveText implements Dictionary {

	private int number;
	private boolean empty;
	private Set<String> wordSet;
	private TreeDictionary[] treeArray = new TreeDictionary[10];
	// private TreeDictionary td2, td3, td4, td5, td6, td7, td8, td9;

	public TreeDictionary() {
		this.wordSet = new TreeSet<String>();
		this.empty = true;
	}

	public TreeDictionary(String dictFile){
		this.empty = false;
		// this.treeArray = new TreeDictionary[10];
		treeArray = makeTrees();
		readDictionary(dictFile);
	}

	public boolean isEmpty() {
		return empty;
	}

	public Set<String> getWordSet() {
		return wordSet;
	}

	public TreeDictionary getTD(int number) {
		return treeArray[number];
	}

	public void addToTD(int number, String word) {
		treeArray[number].wordSet.add(word);
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

					addWord(dictSig, word, this);
					for (int i = 0; i < dictSig.length(); i++) {
						int num = Character.getNumericValue(dictSig.charAt(i));
						this.addToTD(num, word);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Dictionary file not found.");
		}

		for (int i = 2; i <= 9; i++) {
			System.out.println(i + " = " + this.getTD(i).wordSet);
		}
	}

	private void addWord(String signature, String word, TreeDictionary tree) {
		String num = signature.substring(0,1);
		int numInt = Integer.parseInt(num);
		System.out.println(num + " " + signature + " - " + word + " - " + num);

		if (signature.length() == 1) {
			System.out.println("1");
			return;
		}
		if (tree.isEmpty()) {
			tree.treeArray = makeTrees();
		}
		addWord(signature.substring(1), word, tree.getTD(numInt));
	}

	public Set<String> signatureToWords(String signature) {
		return new TreeSet<String>();
	}

	private TreeDictionary[] makeTrees() {
		TreeDictionary[] temp = new TreeDictionary[10];
		for (int i = 0; i < 10; i++) {
			temp[i] = new TreeDictionary();
		}
		return temp;
	}

}
