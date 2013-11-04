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

	private static String calendar = "";
	private static int first = 0;
	private static int max;

	static Calendar today = Calendar.getInstance();
	private static int currentMonthMax = today.getActualMaximum(Calendar.DAY_OF_MONTH);

	private static final String[] days = {" Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

	// /** Constructor for the {@link #Cal} class
	//  *
	//  * @param first
	//  * @param max
	//  */
	// public Cal(int first, int max) {
	// 	this.first = first;
	// 	this.max = max;
	// 	this.generateCal();
	// }

	// /** Constructor for the {@link #Cal} class
	//  *
	//  * @param first
	//  */
	// public Cal(int first) {
	// 	this(first, 31);
	// }

	// /** Constructor for the {@link #Cal} class
	//  */
	// public Cal() {
	// 	this(0, 31);
	// }

	/** Create a calendar string and store it in the calendar variable. Checks
	 * for the initial day being in the range 0->6 (Mon to Sun) and ends on the
	 * "maximum" day.
	 */
	public static void generateCal() {

		calendar = "";
		if (first > 6 || first < 0) {
			System.out.println("Error, first day of the month is too large");
			System.exit(1);
		}

		for (String day:days) {
			calendar += day + " ";
		}
		calendar += "\n";

		for (int i=1; i<=max+first; i++) {
			int j = i - first;
			if (j < 1) {
				calendar += "   ";
			}else{
				calendar = calendar + String.format("%3s", j);
				if (i%7==0) {
					calendar += "\n";
				}
			}
		}
	}

	/** Method for getting the calendar created in the {@link Cal} class
	 *
	 * @return a multiline string containing a calendar of the month.
	 */
	public static String Calendar(int f, int m) {
		first = f;
		max = m;
		generateCal();
		return calendar;
	}

	public static String Calendar(int f) {
		first = f;
		max = currentMonthMax;
		generateCal();
		return calendar;
	}

	public static String Calendar(){
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
