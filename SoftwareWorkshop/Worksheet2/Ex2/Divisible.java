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
		int j = 0;

		if (args.length == 1) {
			int temp = Integer.parseInt(args[0]);
			if (temp > 2) {
				maximum = temp;
			}
		}

		int width = (int) Math.log10(maximum) + 2;

		for (int i = 0; i < maximum; i++) {
			if (((i%2==0) || (i%3==0) || (i%5==0)) && ((i%7!=0) || (i%11!=0))) {
				System.out.printf("%"+width+"s", i);
				j++;
			}
			if (j==20) {
				System.out.println();
				j = 0;
			}
		}
		System.out.println();
	}

}
