/** Tests for the PredictivePrototype class which converts words to their
 * corresponding numerical signature and converts signatures to the set of
 * words with that signature.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet3
 * File name : PredictivePrototypeTest.java
 * @version 2014-02-03
 */
import predictive.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

public class PredictivePrototypeTest {
	public static void main(String[] args) {
		System.out.println(PredictivePrototype.wordToSignature("home"));
		System.out.println(PredictivePrototype.wordToSignature("hello"));

		System.out.println(PredictivePrototype.signatureToWords("4663"));
	}

	// test wordToSignature ----------------------------------------------------
	@Test
	public void testWordToSignature() {
		assertEquals("4663", PredictivePrototype.wordToSignature("home"));
	}

	@Test // empty string
	public void testWordToSignature2() {
		assertEquals("", PredictivePrototype.wordToSignature(""));
	}

	@Test // repeated letters
	public void testWordToSignature3() {
		assertEquals("222222", PredictivePrototype.wordToSignature("aaaaaa"));
	}

	@Test // very long word
	public void testWordToSignature4() {
		String comp = "763866668587264276726742745426865226626646747";
		assertTrue(comp.equals(PredictivePrototype.wordToSignature(
						"pneumonoultramicroscopicsilicovolcanoconiosis")));
	}

	// test signatureToWords ---------------------------------------------------
	@Test // multi-word returned
	public void testSignatureToWords() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("gone");
		comp.add("good");
		comp.add("goof");
		comp.add("home");
		comp.add("hone");
		comp.add("hood");
		comp.add("hoof");
		assertTrue(comp.equals(PredictivePrototype.signatureToWords("4663")));
	}

	@Test // empty string
	public void testSignatureToWords2() {
		TreeSet<String> comp = new TreeSet<String>();
		assertTrue(comp.equals(PredictivePrototype.signatureToWords("")));
	}

	@Test // very long word
	public void testSignatureToWords3() {
		TreeSet<String> comp = new TreeSet<String>();
		comp.add("pneumonoultramicroscopicsilicovolcanoconiosis");
		assertTrue(comp.equals(PredictivePrototype.signatureToWords(
						"763866668587264276726742745426865226626646747")));
	}

}
