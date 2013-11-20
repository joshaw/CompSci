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
	}
}
