/** Test class for the Divisible class which finds integers that match certain
 * parameters.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 2
 * File name : DivisibleTest.java
 * @version 2013-11-07
 */
public class DivisibleTest {
	public static void main(String[] args) {

		int maximum = 300;

		try{
			// Accept argument to program as "maximum" if it exists.
			if (args.length > 0) {
				int temp = Integer.parseInt(args[0]);
				if (temp > 2) {
					maximum = temp;
				}
			}else{
				System.out.println("Using default value for maximum: " + maximum);
			}
		}catch(NumberFormatException e){
			System.out.println("Not a valid input. Using default value 300");
		}

		/* Find the numbers that math the criteria from 0 to "maximum" as
		 * provided by the arguements to the program. */
		Divisible.findDivisible(maximum);
		System.out.println("\nThere are " + Divisible.getCount() + " numbers that satisfy");

		System.out.println();

		/* Find the applicable numbers from 0 to 135.*/
		Divisible.findDivisible(135);
		System.out.println("\nThere are " + Divisible.getCount() + " numbers that satisfy");
	}
}
