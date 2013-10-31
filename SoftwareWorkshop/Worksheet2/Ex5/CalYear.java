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
	public static void main(String[] args) {
		int year = 2013;
		int first;
		int last = 1;

		String[][] monthData = new String[12][8];
		String yearString = "";

		if (args.length == 1) {
			year = Integer.parseInt(args[0]);
		}else if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			last = Integer.parseInt(args[1]);
		}

		String[] days = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
		String[] months = {
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
		byte[] monthMax = {31,28,31,30,31,30,31,31,30,31,30,31};

		// Check for leap year (divisible by 4, unless divisible by 100, unless
		// divisible by 400) and change Feb days accordingly.
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

		for (int month = 0; month < 12; month++) {

			// Initialise the monthData array to empty strings
			for (int i = 0; i < monthData[month].length; i++) {
				monthData[month][i] = "";
			}

			// Set the first element of eachsub array to the name of the month
			// that subarray represents
			monthData[month][0] = months[month];

			for (String day:days) {
				monthData[month][1] += String.format("%3s", day);
			}

			// "week" refers to the rows in each month. Since there is also a
			// row for the month name and the days, start at 2
			int week = 2;

			first = last;
			for (int i=1; i<=7*6; i++) {

				int j = i - first;
				if (j < 1) {
					monthData[month][week] += "   ";
				}else if(j <= monthMax[month]){
					monthData[month][week] += String.format("%3s", j);
					if (j == monthMax[month]) {
						last = i%7;
					}
				} else {
					monthData[month][week] += "   ";
				}
				if (i%7==0) {
					week++;
				}
			}
		}

		yearString = String.format("%35s%n%n",year);
		for (int i = 0; i < 12; i+=3) {
			for (int j = 0; j < monthData[i].length; j++) {
				yearString += (monthData[i][j] + " " +
						monthData[i+1][j] + " " +
						monthData[i+2][j] + "\n");
			}
			yearString += "\n";
		}

		System.out.println(yearString);
	}
}
