/** 
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 4
 * File name : FrequencyTest.java
 * @version 2013-11-14
 */
public class FrequencyTest {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("testfile.txt");
		Frequency.countLetters("../testfile.txt", false);

		System.out.println();
		System.out.println("Don Quixote");
		Frequency.countLetters("../DonQuixote.txt");

		System.out.println();
		System.out.println("Alice in Wonderland");
		Frequency.countLetters("../AliceInWonderland.txt", true);
	}
}
