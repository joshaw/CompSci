/* Date        : 2013-10-04
 * Name        : Josh Wainwright
 * UID         : 1079596
 * Worksheet   : 0
 * Title       : Exercise 1
 * Description : Java program to calculate and print the area of a circle given
 *             : a radius, using the math library to provide a value for pi.*/

public class ex1 {
	public static void main(String[] args) {

		/* Type double is used since multiplication with pi will mean that the
		 * area will not be an integer, double radius allows for non-integer
		 * values to be used.*/
		double area, r;

		r = 5;
		System.out.println("The area is " + Math.PI*r*r);
	}
}
