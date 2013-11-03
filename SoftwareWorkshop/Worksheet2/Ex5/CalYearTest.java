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

		if (args.length == 1) {
			year = Integer.parseInt(args[0]);
		}else if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			first = Integer.parseInt(args[1]);
		}

		// Create new year calendar
		CalYear cy = new CalYear(year, first);

		System.out.println(cy);

	}
}
