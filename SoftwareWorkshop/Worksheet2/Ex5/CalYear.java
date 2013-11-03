/**
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
		"        June         " ,
		"        July         " ,
		"       August        " ,
		"      September      " ,
		"       October       " ,
		"      November       " ,
		"      December       " };
	private final byte[] monthMax = {31,28,31,30,31,30,31,31,30,31,30,31};

	private int year;
	private int last = 1;
	private String adbc = "AD";

	/* Main string to hold the calendar */
	private String yearString = "";

	/** Constructer for the CalYear class
	 *
	 * @param year the year for which to make a calendar, affects the number of
	 * days in Februray.
	 * @param first the first day of January, 0 for Mon through 6 for Sun.
	 * Each proceding month starts after the last day of the preceding month.
	 */
	public CalYear(int year, int first) {
		this.year = year;
		this.last = first;
		calYear();
	}

	public CalYear(int year){
		this(year, 1);
	}

	/** The empty constuctor uses the current time to calculate the current
	 * year.
	 */
	public CalYear(){
		year = (int) Math.floor(System.currentTimeMillis()/1000/3600/24/365.25 +1970);
		calYear();
	}

	/** Class CalYear main method. Creates a multiline string which holds a
	 * calendar for the year specified in {@link year}. Each month starts on
	 * the day after the last day of the preceding month.
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

		for (int currentMonth = 0; currentMonth < 12; currentMonth++) {

			/* Initialise the monthData array to empty strings rather than
			 * null*/
			for (int i = 0; i < monthData[currentMonth].length; i++) {
				monthData[currentMonth][i] = "";
			}

			/* Set the first element of each sub-array to the name of the month
			 * that subarray represents*/
			monthData[currentMonth][0] = months[currentMonth];

			for (String day:days) {
				monthData[currentMonth][1] += String.format("%3s", day);
			}

			/* "week" refers to the rows in each month. Since there is also a
			 * row for the month name and the days, start at 2*/
			int week = 2;

			first = last;
			for (int i=1; i<=7*6; i++) {

				int j = i - first;
				if (j < 1) {
					monthData[currentMonth][week] += "   ";
				}else if(j <= monthMax[currentMonth]){
					monthData[currentMonth][week] += String.format("%3s", j);
					if (j == monthMax[currentMonth]) {
						last = i%7;
					}
				} else {
					monthData[currentMonth][week] += "   ";
				}
				if (i%7==0) {
					week++;
				}
			}
		}

		checkADBC();

		yearString = String.format("%35s%3s%n%n",year, adbc);
		for (int i = 0; i < 12; i+=3) {
			for (int j = 0; j < monthData[i].length; j++) {
				yearString += (monthData[i][j] + " " +
						monthData[i+1][j] + " " +
						monthData[i+2][j] + "\n");
			}
			yearString += "\n";
		}

	}

	private void checkLeapYear(){

		/* Check for leap year (divisible by 4, unless divisible by 100, unless
		 * divisible by 400) and change Feb days accordingly.*/
		boolean leapyear = false;
		if (year%400 == 0) {
			leapyear = true;
		}else if (year%100 == 0) {
			leapyear = false;
		}else if (year%4 == 0) {
			leapyear = true;
		}
		if (leapyear) {
			monthMax[1] = 29;
			System.out.println("Leap Year!");
		}
	}

	private void checkADBC(){
		if (year >= 0) {
			adbc = "AD";
		}else{
			adbc = "BC";
			year = -1 - year;
		}
	}

	@Override
	public String toString(){
		return yearString;
	}

}
