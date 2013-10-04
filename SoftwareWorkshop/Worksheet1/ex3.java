/* Date        : 2013-10-04
 * Name        : Josh Wainwright
 * UID         : 1079596
 * Title       : Exercise 3
 * Description : Calculate a total given the starting point taking into
 *             : account compound interest*/

import java.util.Scanner;
public class ex3 {
	public static void main(String[] args) {

		double total;
		double capital = 100;
		double interestRate = 2.3;
		int years = 5;

		total = capital * Math.pow((1 + 0.01 * interestRate),years);

		System.out.println("The total after " + years + " years is £"
				+ Math.round(total*100.0)/100.0 + ".\n");

		years = 500;
		total = capital * Math.pow((1 + 0.01 * interestRate),years);

		System.out.println("The total after " + years + " years is £"
				+ Math.round(total*100.0)/100.0 + ".");

	}
}
