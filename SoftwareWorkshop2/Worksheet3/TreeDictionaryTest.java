/** Test class for the ListDictionary implementation of a dictionary to hold
 * word/signature pairs which allows the reverse searching of signatures to
 * find relevant words.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : ListDictionaryTest.java
 * @version 2014-02-03
 */
import predictive.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import java.util.Set;
import java.util.TreeSet;
import java.io.*;

public class TreeDictionaryTest {
	public static void main(String[] args) {

		TreeDictionary dict = new TreeDictionary("testfiles/words.txt");

		// System.out.println(ListDictionary.wordToSignature("home"));
		// System.out.println(ListDictionary.wordToSignature("hello"));

		// System.out.println(dict.signatureToWords("4663"));
		System.out.println(dict);
	}

	static ListDictionary dict;

	/* Creat a ListDictionary object that can be used by subsequent tests since
	 * reading file takes considerable time, this should not be performed for
	 * every test case. */
	@BeforeClass
	public static void makeDictionary() {
		dict = new ListDictionary();
	}

	// test wordToSignature ---------------------------------------------------
	@Test // simple case
	public void testWordToSignature() {
		assertEquals("4663", ListDictionary.wordToSignature("home"));
	}

	@Test // empty string
	public void testWordToSignature2() {
		assertEquals("", ListDictionary.wordToSignature(""));
	}

	@Test // repeated letters
	public void testWordToSignature3() {
		assertEquals("222222", ListDictionary.wordToSignature("aaaaaa"));
	}

	@Test // very long word
	public void testWordToSignature4() {
		String comp = "763866668587264276726742745426865226626646747";
		assertTrue(comp.equals(ListDictionary.wordToSignature(
						"pneumonoultramicroscopicsilicovolcanoconiosis")));
	}

	// test signatureToWords --------------------------------------------------
	@Test // multiple returned possible words
	public void testSignatureToWords() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("gome");
		comp.add("gond");
		comp.add("gone");
		comp.add("good");
		comp.add("goof");
		comp.add("home");
		comp.add("hond");
		comp.add("hone");
		comp.add("hood");
		comp.add("hoof");
		comp.add("inne");
		assertTrue(comp.equals(dict.signatureToWords("4663")));
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
