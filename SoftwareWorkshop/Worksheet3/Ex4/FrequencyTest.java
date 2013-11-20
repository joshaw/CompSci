/** Test class for the Frequency class which counts the number of letters in a
 * file and the relative frequencies of each and produces a graph to show.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 4
 * File name : FrequencyTest.java
 * @version 2013-11-19
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class FrequencyTest {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("testfile.txt");
		Frequency.countLetters("testfile.txt", false);

		System.out.println();
		System.out.println("Don Quixote");
		Frequency.countLetters("DonQuixote.txt");

		System.out.println();
		System.out.println("Alice in Wonderland");
		Frequency.countLetters("AliceInWonderland.txt", true);
	}

	@Test
	public void frequencyTest1() {
		double[] testDoubleArray = {0.0750, 0.0167, 0.0750, 0.0083, 0.1750,
			0.0000, 0.0000, 0.0167, 0.0333, 0.0000, 0.0000, 0.0500, 0.0167,
			0.0333, 0.0667, 0.0583, 0.0000, 0.0750, 0.1000, 0.0917, 0.0500,
			0.0083, 0.0417, 0.0083, 0.0000, 0.0000};

		/* assertArrayEquals with two double[] arrays is not present in the
		 * version of JUnit installed on university server (only in 4.6 and
		 * above.
		assertArrayEquals(testArray, Frequency.countLetters("testfile.txt", false), 1);
		*/

		long[] testLongArray = new long[testDoubleArray.length];
		for (int i = 0; i < testDoubleArray.length; i++) {
    		testLongArray[i] = (long) testDoubleArray[i];
		}

		double[] returnedDoubleArray = Frequency.countLetters("../testfile.txt", false);
		long[] returnedLongArray = new long[returnedDoubleArray.length];
		for (int i = 0; i < returnedDoubleArray.length; i++) {
    		returnedLongArray[i] = (long) returnedDoubleArray[i];
		}

		assertArrayEquals(testLongArray, returnedLongArray);
	}
}
