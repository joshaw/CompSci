/** Test class for the Cal class for creating a calendar in a string.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 4
 * File name : CalTest.java
 * @version 2013-11-07
 */
public class CalTest {
	public static void main(String[] args) {

		// Create a calendar which starts on the third day of the month
		System.out.println(Cal.Calendar(3, 28));
		System.out.println("Max: " + Cal.getMax() + "\n");

		// Create a calendar which starts on the sixth day of the month and has
		// a total of 31 days.
		System.out.println(Cal.Calendar(6, 31) + "\n");

		// Create the default calendar (with 31 days and starting on the
		// "zeroth" day of the month)
		System.out.println(Cal.Calendar());
		System.out.println("Max: " + Cal.getMax() + "\n");

		// Attempt to create a new calendar which starts on the seventh day of
		// the month. Will fail since this is more than a week.
		System.out.println(Cal.Calendar(8,31));

	}
}
