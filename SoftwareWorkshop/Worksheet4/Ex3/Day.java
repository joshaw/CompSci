/** Extremely simple class to hold the components of a day as represented in UK
 * standard notation.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : Day.java
 * @version 2013-11-24
 */
public class Day {

	private int day;
	private int month;
	private int year;

	/** Constructor for the Day class to hold a particular date.
	 *
	 * @param day an integer representing a day of the month
	 * @param month an integer representing a month of the year
	 * @param year an integer representing the year (ad).
	 */
	public Day(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
