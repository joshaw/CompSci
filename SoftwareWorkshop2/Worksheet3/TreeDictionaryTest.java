/** Test class for the TreeDictionary implementation of a dictionary to hold
 * word/signature pairs which allows the reverse searching of signatures to
 * find relevant words.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : TreeDictionaryTest.java
 * @version 2014-02-03
 */
import predictive.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.*;

public class TreeDictionaryTest {
	public static void main(String[] args) {

		TreeDictionary dict = new TreeDictionary("testfiles/shortwords.txt");
		// TreeDictionary dict = new TreeDictionary("/usr/share/dict/words");

		System.out.println(dict.signatureToWords("4663"));

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

	static TreeDictionary dict;

	/* Creat a TreeDictionary object that can be used by subsequent tests since
	 * reading file takes considerable time, this should not be performed for
	 * every test case. */
	@BeforeClass
	public static void makeDictionary() {
		dict = new TreeDictionary("testfiles/words.txt");
	}

	// test wordToSignature ---------------------------------------------------
	@Test // simple case
	public void testWordToSignature() {
		assertEquals("4663", TreeDictionary.wordToSignature("home"));
	}

	@Test // empty string
	public void testWordToSignature2() {
		assertEquals("", TreeDictionary.wordToSignature(""));
	}

	@Test // repeated letters
	public void testWordToSignature3() {
		assertEquals("222222", TreeDictionary.wordToSignature("aaaaaa"));
	}

	@Test // very long word
	public void testWordToSignature4() {
		String comp = "763866668587264276726742745426865226626646747";
		assertTrue(comp.equals(TreeDictionary.wordToSignature(
						"pneumonoultramicroscopicsilicovolcanoconiosis")));
	}

	// test signatureToWords --------------------------------------------------
	@Test // multiple returned possible words
	public void testSignatureToWords() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("hometown");
		comp.add("hometowns");
		System.out.println("comp + " + comp);
		System.out.println("dict + " + dict.signatureToWords("46638"));
		assertTrue(comp.equals(dict.signatureToWords("46638")));
	}

	@Test //empty string
	public void testSignatureToWords2() {
		TreeSet<String> comp = new TreeSet<String>();
		assertTrue(comp.equals(PredictivePrototype.signatureToWords("")));
	}

	@Test // very long signature
	public void testSignatureToWords3() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("pneumonoultramicroscopicsilicovolcanoconiosis");
		assertTrue(comp.equals(PredictivePrototype.signatureToWords(
						"763866668587264276726742745426865226626646747")));
	}

}
