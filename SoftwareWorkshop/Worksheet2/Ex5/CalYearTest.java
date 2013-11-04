/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 5
 * File name : CalYearTest.java
 * @version 2013-11-02
 */
public class CalYearTest {
	public static void main(String[] args) {

		int year = 2013;
		int first = 1;
		int width = 3;

		if (args.length > 0) {
			year = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			first = Integer.parseInt(args[1]);
		}
		if (args.length > 2) {
			width = Integer.parseInt(args[2]);
		}

		// Create new year calendar
		CalYear cy = new CalYear(year, first, width);

		System.out.println(cy);

	}
}
