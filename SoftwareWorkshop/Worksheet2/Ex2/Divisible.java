/** Defines a program to prints, without duplicates, the integers between 0 and
 * "maximum" which are divisible by any of 2, 3, and 5, but not by any of 7 and
 * 11 in increasing order.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 2
 * @version 2013-11-07
 */
public class Divisible {

	public static void main(String[] args) {

		int maximum = 300;
		int columns = 0;

		// Accept argument to program as "maximum" if it exists.
		if (args.length == 1) {
			int temp = Integer.parseInt(args[0]);
			if (temp > 2) {
				maximum = temp;
			}
		}

		// Calculate the nessessary width of each column based on the number of
		// digits needed for maximum, the largest value to be printed.
		int width = (int) Math.log10(maximum) + 2;

		//Main loop. For each integer from 0 to maximum, check if conditions
		//apply. If true, then print number with appropriate spacing.
		for (int i = 0; i < maximum; i++) {
			if (((i%2==0) || (i%3==0) || (i%5==0)) && ((i%7!=0) || (i%11!=0))) {
				System.out.printf("%"+width+"s", i);
				columns++;
			}
			// Print a newline when 20 columns have been printed, unless the
			// last number is the last in the row.
			if ( ( columns==20 ) && ( i<maximum-1 ) ) {
				System.out.println();
				columns = 0;
			}
		}
		// Finish last entry with newline.
		System.out.println();
	}

}
