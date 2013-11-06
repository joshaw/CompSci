/** A class to create a calendar of the specified year, or this if no year is
 * given, and write it to a string for printing.
 *
 * The year is used to determine whether or not it is a leap year, and an
 * additional arguement is used to specify the day of the week the 1st January
 * is on. Subsequent mont starts are determined automatically from the last day
 * of the previous month.
 *
 * An object of type CalYear must be created and the methods applied to that
 * object. The class could be implemented as static so that the methods can be
 * applied to the class by removing the constructors and making the methods
 * static.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 5
 * File name : CalYear.java
 * @version 2013-10-31
 */
public class CalYear {

	/* Define the names of the days of the week, months of the year and the
	 * number of days in each month.*/
	private final String[] days = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
	private final String[] months = {
		"       January       " ,
		"       February      " ,
		"        March        " ,
		"        April        " ,
		"         May         " ,
		"         June        " ,
		"         July        " ,
		"        August       " ,
		"      September      " ,
		"       October       " ,
		"       November      " ,
		"       December      " };
	private final byte[] monthMax = {31,28,31,30,31,30,31,31,30,31,30,31};

	private int year;
	private int last = 1;
	private String adbc = "AD";
	private int width = 3;

	/* Main string to hold the calendar */
	private String yearString = "";

	/** Constructer for the CalYear class
	 *
	 * @param year the year for which to make a calendar, affects the number of
	 * days in Februray.
	 * @param first the first day of January, 0 for Mon through 6 for Sun.
	 * Each proceding month starts after the last day of the preceding month.
	 * @param width the number of months to display side by side. Defaults to 3
	 */
	public CalYear(int year, int first, int width) {
		this.year = year;
		this.last = first;
		this.width = width;
		calYear();
	}

	/** Constructer for the CalYear class
	 *
	 * @param year the year for which to make a calendar, affects the number of
	 * days in Februray.
	 * @param first the first day of January, 0 for Mon through 6 for Sun.
	 * Each proceding month starts after the last day of the preceding month.
	 */
	public CalYear(int year, int first) {
		this(year, first, 3);
	}

	/** Constructer for the CalYear class
	 *
	 * @param year the year for which to make a calendar, affects the number of
	 * days in Februray.
	 */
	public CalYear(int year){
		this(year, 1, 3);
	}

	/** The empty constuctor uses the current time to calculate the current
	 * year and uses the default values for the first day of the year and the
	 * width of the calendar. */
	public CalYear(){
		year = (int) Math.floor(
				System.currentTimeMillis()/1000/3600/24/365.25 +1970);
		calYear();
	}

	/** Class CalYear main method. Creates a multiline string which holds a
	 * calendar for the year specified in {@link year}. Each month starts on
	 * the day after the last day of the preceding month.
	 *
	 * The whole year is represented as a string. As an intermediate step, the
	 * year is contained within the monthData array. 12 elements make up the
	 * year.
	 *
	 * Within each month element are 8 elements. The first holds the month
	 * name, the second the days of the week and the remaining 6 the days of
	 * the month.
	 *
	 * |          Month            |
	 * |    Days of the week       |
	 * +---+---+---+---+---+---+---+
	 * |" "|" "| 1 | 2 | 3 | 4 | 5 |   Each row is an elemnt in the monthArray
	 * +---+---+---+---+---+---+---+
	 * | 6 | 7 | 8 | 9 |10 |11 |12 |
	 * +---+---+---+---+---+---+---+
	 * |13 |14 |15 |16 |17 |18 |19 |
	 * +---+---+---+---+---+---+---+
	 * |20 |21 |22 |23 |24 |25 |26 |
	 * +---+---+---+---+---+---+---+
	 * |27 |28 |29 |30 |31 |" "|" "|  Empty grid places are padded with spaces
	 * +---+---+---+---+---+---+---+
	 * |" "|" "|" "|" "|" "|" "|" "|  The last row is used for all months
	 * +---+---+---+---+---+---+---+  though it only contains numbers when the
	 *                                month starts late enough for the last
	 *                                week to reach this row.
	 */
	public void calYear() {

		/* The year can start on Mon through Sun in the first week. If the
		 * suppplied starting day is outside this range, exit.*/
		if (last > 6 || last < 0) {
			System.out.println("Error, first day of the month is too large");
			System.exit(1);
		}

		int first = 1;

		/* Each line of a month is held in an element array. Multiple lines
		 * make up a month, each of which is held in this array. Each month is
		 * given 8 element:
		 * 		- 1 for the month name
		 * 		- 1 for the day names
		 * 		- 6 for the weeks in the month.
		 */
		String[][] monthData = new String[12][8];

		/* Alter the maximum number of days in a month depending on whether the
		 * year is a leap year.*/
		checkLeapYear();

		for (int cMonth = 0; cMonth < 12; cMonth++) {

			/* Initialise the monthData array to empty strings rather than
			 * null*/
			for (int i = 0; i < monthData[cMonth].length; i++) {
				monthData[cMonth][i] = "";
			}

			/* Set the first element of each sub-array to the name of the month
			 * that subarray represents*/
			monthData[cMonth][0] = months[cMonth];

			for (String day:days) {
				monthData[cMonth][1] += String.format("%3s", day);
			}

			/* "week" refers to the rows in each month. Since there is also a
			 * row for the month name and the days, start at 2*/
			int week = 2;

			/* Set the first day of the current month equal to the last day of
			 * the previous month to ensure continuity. The offset of 1 to move
			 * the day forward is accounted for in "last". */
			first = last;

			/* A month can span at most 6 separate weeks, so allow for a
			 * maximum of 6 week rows per month (7days * 6weeks)
			 *
			 * "cPosition" is the current position in the 7x6 grid of possible
			 * days * "cDay" is the number of the day of the month currently
			 * used.
			 */
			for (int cPosition=1; cPosition<=7*6; cPosition++) {

				// Take account of the offset of the start of the week
				int cDay = cPosition - first;
				if (cDay < 1) {

					// Pad the spaces before the month starts with spaces
					monthData[cMonth][week] += "   ";

				}else if(cDay <= monthMax[cMonth]){

					// Add the day to the current month array as a string
					monthData[cMonth][week] += String.format("%3s", cDay);

					/* At the end of the month, make a note of the position of
					 * the last day for the start of the next month. */
					if (cDay == monthMax[cMonth]) {
						last = cPosition%7;
					}

				} else {

					/* At the end of the month, pad the empty days to the end
					 * of the month grid.*/
					monthData[cMonth][week] += "   ";

				}

				/* Every 7 days, we start a new week element in the month
				 * array. */
				if (cPosition%7==0) {
					week++;
				}
			}
		}

		/* Correct the year for negatives and change the adbc string
		 * accordingly.*/
		checkADBC();

		/* Write the year and ad/bc data into the string using the defined
		 * width to align center.*/
		yearString = String.format("%" + 12*width + "s%3s%n%n",year, adbc);

		/* Write the monthArray data to the string yearString in groups of
		 * "width" so that several months appear side by side.*/

		// Don't go above the max number of months.
		int i=0;
		while (i < 12){

			// For each set of months, print name, day names, and weeks.
			for (int j = 0; j < monthData[i].length; j++) {

				/* Write "width" entries next to each other separated by a
				 * space. Don't let i+w get larger than the number of months.
				 * _Individual Months Correct, Arranged Underneath_ */
				for (int w=0; w<width && i+w<12; w++) {
					yearString += monthData[i+w][j] + "  ";
				}
				yearString += "\n";
			}

			// Add a newline to separate months except on the last set.
			// if (i < (12-12/width)) {
			// 	yearString += "\n";
			// }

			// Skip on to the next set of "width" months.
			i+= width;
		}
	}

	/** Method to check the provided year for being a leap year or not. If it
	 * is then the maximum number of days in Feb are different, so it is
	 * changed.
	 */
	private void checkLeapYear(){

		/* Check for leap year (divisible by 4, unless divisible by 100, unless
		 * divisible by 400) and change Feb days accordingly.
		 *http://www.rmg.co.uk/explore/astronomy-and-time/time-facts/leap-years
		 */
		boolean leapyear = false;
		if (year%400 == 0) {
			leapyear = true;
		}else if (year%100 == 0) {
			leapyear = false;
		}else if (year%4 == 0) {
			leapyear = true;
		}

		/* If this is a leap year, then change the maximal number of days in
		 * February. */
		if (leapyear) {
			monthMax[1] = 29;
			System.out.println("Leap Year!");
		}
	}

	/** Method to check the given year as being either AD or BC based on
	 * positive or negative year and set the string accordingly */
	private void checkADBC(){
		if (year > 0) {
			adbc = "AD";
		}else{
			adbc = "BC";
			year = 1 - year; /* There is no defined year "0" so the year
			                  * before 1 is -1, or 1 BC */
			/*       AD|BC
			 * 3  2  1 | 1  2  3   --- Julian
			 * 3  2  1 | 0 -1 -2   --- Astronomical
			 */
		}
	}

	/** Defines the print method for the class CalYear
	 *
	 * @return the string holding the calendar, yearString.
	 */
	@Override
	public String toString(){
		return yearString;
	}

}
