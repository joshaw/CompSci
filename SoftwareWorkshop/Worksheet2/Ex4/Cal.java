/** A class that defines a month calendar (similar to the GNU tool cal).
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 4
 * File name : Cal.java
 * @version 2013-11-07
 */
import java.util.Calendar;
public class Cal {

	private static String calendar = ""; // to hold the full month calendar
	private static int first = 0;        // first day of the month (Mon -> Sun)
	private static int max;              // Number of days in the month

	static Calendar today = Calendar.getInstance();
	private static int currentMonthMax = today.getActualMaximum(Calendar.DAY_OF_MONTH);

	private static final String[] days = {" Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

	/** Create a calendar string and store it in the calendar variable. Checks
	 * for the initial day being in the range 0->6 (Mon to Sun) and ends on the
	 * "maximum" day.
	 */
	public static void generateCal() {

		// Reset the calendar string to empty.
		calendar = "";

		// Print an error and exit if the first day is too large.
		if (first > 6 || first < 0) {
			System.out.println("Error, first day of the month is too large");
			System.exit(1);
		}

		// Add the names of the days of the week to the string.
		for (String day:days) {
			calendar += day + " ";
		}
		calendar += "\n";

		/* Loop through all the days in the month ending with an offset to take
		 * account of the empty days at the start of the month. */
		for (int i=1; i<=max+first; i++) {
			int j = i - first;

			/* If the current day is negative or 0 then we are still in the
			 * first week before the start of the month, so pad with spaces. */
			if (j < 1) {
				calendar += "   ";
			}else{

				/* Formatting appropriately, add the next day to the end of the
				 * string. */
				calendar = calendar + String.format("%3s", j);

				// Start a newline whenever there is an end to the week.
				if (i%7==0) {
					calendar += "\n";
				}
			}
		}
	}

	/** Methods for getting the calendar created in the {@link Cal} class.
	 *
	 * Each method sets the values of the variables first and max and then
	 * calls the method to generate the string. If no "max" is given, the
	 * current month is calculated and the number of days in that month used.
	 *
	 * @return a multiline string containing a calendar of the month.
	 */
	public static String CalMonth(int f, int m) {
		first = f;
		max = m;
		generateCal();
		return calendar;
	}
	public static String CalMonth(int f) {
		first = f;
		max = currentMonthMax;
		generateCal();
		return calendar;
	}
	public static String CalMonth(){
		first = 0;
		max = currentMonthMax;
		generateCal();
		return calendar;
	}

	/** Method to return the stored value of the first day of the month used to
	 * create the calendar.
	 *
	 * @return the first day of the month, 0 for Monday, through 6 for Sunday
	 */
	public static int getFirst() {
		return first;
	}

	/** Method to return the stored value of the number of days in the month.
	 *
	 * @return the number of days in the month.
	 */
	public static int getMax() {
		return max;
	}
}
