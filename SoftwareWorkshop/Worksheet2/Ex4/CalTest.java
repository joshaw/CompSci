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
		Cal c = new Cal(2);
		System.out.println(c.getCalendar());

		// Create a calendar which starts on the sixth day of the month and has
		// a total of 30 days.
		Cal c2 = new Cal(5, 30);
		System.out.println(c2.getCalendar());

		System.out.println("Max: " + c2.getMax());

		// Create the default calendar (with 31 days and starting on the
		// "zeroth" day of the month)
		Cal c3 = new Cal();
		System.out.println(c3);

		// Attempt to create a new calendar which starts on the seventh day of
		// the month. Will fail since this is more than a week.
		Cal c4 = new Cal(8);

	}
}
