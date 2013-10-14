/**  This class is to test the Fraction class and its methods.
 *   We create several objects of class Fraction, print them to the screen and
 *   also print the sum and product of them. Also show the empty constructor.
 */
public class FractionTest {

	public static void main(String[] args){

		// Creates a new Fraction with numerator 1 and denominator 2
		Fraction f1 = new Fraction(1,2);
		// Creates a new Fraction with numerator 3 and denominator 7
		Fraction f2 = new Fraction(3,7);

		System.out.println(f1);

		// Print the product and sum of the two fractions
		System.out.println("Product of f1 and f2: " + f2.getProduct(f1));

		System.out.println("Sum     of f1 and f2:" + f2.getSum(f1));

		Fraction f3 = new Fraction();

		System.out.println(f3);

	}

}
