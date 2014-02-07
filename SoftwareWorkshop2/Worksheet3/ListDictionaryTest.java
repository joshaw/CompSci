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

public class ListDictionaryTest {
	public static void main(String[] args) {

		ListDictionary dict = new ListDictionary();

		/* Exploring writing the dictionary object to disk so that it can be
		 * read from disk instead of creating the dictionary every time the
		 * program is run. Turns out not to offer any speed improvements. Does
		 * illustrate the size of the dictionary when all words ahve been read
		 * and signatures calculated ~11MB. */
		// File f = new File("dictionary.ser");
		// if(f.exists()) {

		// 	System.out.println("Using existing dictionary file.");
		// 	try{
		// 		FileInputStream dictStream = new FileInputStream("dictionary.ser");
		// 		ObjectInputStream reader = new ObjectInputStream(dictStream);
		// 		dict = (ListDictionary) reader.readObject();

		// 	} catch (IOException e) {
		// 		System.out.println("IOException");
		// 		System.err.println(e.getMessage());
		// 		dict = new ListDictionary();

		// 	} catch (ClassNotFoundException e) {
		// 		System.out.println("ClassNotFoundException");
		// 		System.err.println(e.getMessage());
		// 		dict = new ListDictionary();
		// 	}

		// } else {
		// 	System.out.println("Creating new dictionary file.");
		// 	dict = new ListDictionary();
		// 	try{
		// 		// Serialize data object to a file
		// 		ObjectOutputStream out = new ObjectOutputStream(
		// 				new FileOutputStream("dictionary.ser"));
		// 		out.writeObject(dict);
		// 		out.close();
		// 	} catch (IOException e) {
		// 		System.err.println(e);
		// 		dict = new ListDictionary();
		// 	}
		// }

		System.out.println(ListDictionary.wordToSignature("home"));
		System.out.println(ListDictionary.wordToSignature("hello"));

		System.out.println(dict.signatureToWords("4663"));
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
		comp.add("gone");
		comp.add("good");
		comp.add("goof");
		comp.add("home");
		comp.add("hone");
		comp.add("hood");
		comp.add("hoof");
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
