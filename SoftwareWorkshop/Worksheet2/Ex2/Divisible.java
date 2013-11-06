/** Defines a program to print, without duplicates, the integers between 0 and
 * "maximum" which are divisible by any of 2, 3, and 5, but not by any of 7 and
 * 11 in increasing order.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 2
 * File name : Divisible.java
 * @version 2013-11-07
 */
public class Divisible {

	private static int maximum = 300;
	private static String numbers = "";
	private static int count = 0;

	/** Method to find all the integers, without duplicates, from 0 upto but
	 * not including "maximum" that satisfy the conditions specified. Stores
	 * the resulting formatted string in the variable called "numbers" for
	 * retreival and prints the string to the screen. */
	public static void findDivisible(int maximum){

		numbers = "";
		int columns = 0;

		/* Calculate the nessessary width of each column based on the number of
		 * digits needed for maximum, the largest value to be printed.*/
		int width = (int) Math.log10(maximum) + 2;

		/* Main loop. For each integer from 0 to maximum, check if conditions
		 * apply. If true, then print number with appropriate spacing. Stops
		 * when i is less than maximum, so that the numbers upto, but not
		 * including maximum are checked.
		 * _Loop_ */
		for (int i = 0; i < maximum; i++) {

			/* _Conditional Expression_
			 * (2 OR 3 OR 5) AND (NOT 7 AND NOT 11) */
			if (((i%2==0) || (i%3==0) || (i%5==0)) && ((i%7!=0) && (i%11!=0))) {

				// _Print Formatting_
				numbers += String.format("%"+width+"s", i);
				columns++;
				count++;
			}

			/* Print a newline when 20 columns have been printed, unless the
			 * last number is the last in the row.*/
			if ( ( columns==20 ) && ( i<maximum-1 ) ) {
				numbers += "\n";
				columns = 0;
			}
		}
		System.out.println(numbers);
	}

	/** Method for returning the string that contains the results of the
	 * findDivisible method.
	 *
	 * @return the contents of the string numbers. If the findDivisible method
	 * has been called, then this contains the integers that were found,
	 * otherwise is the null string.
	 */
	public static String getNumbers() {
		return numbers;
	}

	/** Method for returning the number of integers found when calling the
	 * {@link #findDivisible} method.
	 *
	 * @return the number of integers found
	 */
	public static int getCount() {
		return count;
	}

}
