import predictive.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import java.util.Set;
import java.util.TreeSet;

public class ListDictionaryTest {
	public static void main(String[] args) {
		ListDictionary dict = new ListDictionary();

		System.out.println(ListDictionary.wordToSignature("home"));
		System.out.println(ListDictionary.wordToSignature("hello"));

		System.out.println(dict.signatureToWords("4663"));
	}

	static ListDictionary dict;

	@BeforeClass
	public static void makeDictionary() {
		dict = new ListDictionary();
	}

	@Test
	public void testWordToSignature() {
		assertEquals("4663", PredictivePrototype.wordToSignature("home"));
	}

	@Test
	public void testWordToSignature2() {
		assertEquals("", PredictivePrototype.wordToSignature(""));
	}

	@Test
	public void testWordToSignature3() {
		assertEquals("222222", PredictivePrototype.wordToSignature("aaaaaa"));
	}

	@Test
	public void testWordToSignature4() {
		String comp = "763866668587264276726742745426865226626646747";
		assertTrue(comp.equals(PredictivePrototype.wordToSignature(
						"pneumonoultramicroscopicsilicovolcanoconiosis")));
	}

	@Test
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

	@Test
	public void testSignatureToWords2() {
		TreeSet<String> comp = new TreeSet<String>();
		assertTrue(comp.equals(PredictivePrototype.signatureToWords("")));
	}

	@Test
	public void testSignatureToWords3() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("pneumonoultramicroscopicsilicovolcanoconiosis");
		assertTrue(comp.equals(PredictivePrototype.signatureToWords(
						"763866668587264276726742745426865226626646747")));
	}

}
