/** Test class for the Cal class for creating a calendar in a string.
 *
 * Run with the JUnit files to test using the test classes.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 4
 * File name : CalTest.java
 * @version 2013-11-07
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class CalTest {
	public static void main(String[] args) {

		/* Create a calendar which starts on the third day of the month with a
		 * total of 28 days. */
		System.out.println(Cal.calMonth(3, 28));
		System.out.println("Max: " + Cal.getMax() + "\n");

		/* Create a calendar which starts on the sixth day of the month and has
		 * a total of 31 days. */
		System.out.println(Cal.calMonth(6, 31) + "\n");

		/* Create the default calendar (with 31 days and starting on the
		 * "zeroth" day of the month). */
		System.out.println(Cal.calMonth());
		System.out.println("Max: " + Cal.getMax() + "\n");

		/* Attempt to create a new calendar which starts on the seventh day of
		 * the month. Will fail since this is more than a week.*/
		System.out.println(Cal.calMonth(8));
	}

	/* Create a calendar which starts on the third day of the month with a
	 * total of 28 days. */
	@Test
	public void CalTest1(){
		String calString1 =
			" Mo Tu We Th Fr Sa Su " + "\n" +
			"           1  2  3  4" + "\n" +
			"  5  6  7  8  9 10 11" + "\n" +
			" 12 13 14 15 16 17 18" + "\n" +
			" 19 20 21 22 23 24 25" + "\n" +
			" 26 27 28";

		assertEquals(calString1, Cal.calMonth(3,28));
	}

	/* Create the default calendar (with 31 days and starting on the "zeroth"
	 * day of the month). */
	@Test
	public void CalTest2(){
		String calString2 =
			" Mo Tu We Th Fr Sa Su " + "\n" +
			"  1  2  3  4  5  6  7" + "\n" +
			"  8  9 10 11 12 13 14" + "\n" +
			" 15 16 17 18 19 20 21" + "\n" +
			" 22 23 24 25 26 27 28" + "\n" +
			" 29 30";

		assertEquals(calString2, Cal.calMonth());
	}
}
