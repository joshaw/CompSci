/* Date        : 2013-10-04
 * Name        : Josh Wainwright
 * UID         : 1079596
 * Title       : Exercise 4
 * Description : Use given formulea to calculate values for sum and product of
 *             : a pair of fractions.*/

public class ex4 {
	public static void main(String[] args) {

		double e1, e2, d1, d2;

		e1 = 1; e2 = 1;
		d1 = 2; d2 = 3;

		double ep = (e1/d1) * (e2/d2);
		double es = (e1/d1) + (e2/d2);

		es = (e1*d2 + e2*d1) / (d1 * d2);
		ep = (e1 * e2) / (d1 * d2);

		System.out.println("    Sum = " + es(1, 1, 2, 3));
	//	System.out.println("Product = " + ep(1, 1, 2, 3));

		System.out.println("    Sum = " + es(1, 3, 3, 4));
	//	System.out.println("Product = " + ep(1, 3, 3, 4));

	//	System.out.println("    Sum = " + es(1, 2, 2, 3));
		System.out.println("Product = " + ep(1, 2, 2, 3));

	//	System.out.println("    Sum = " + es(1, 2, 4, 3));
		System.out.println("Product = " + ep(1, 2, 4, 3));

	}

	public static double es(double e1, double e2, double d1, double d2){
		return (e1/d1) + (e2/d2);
	}

	public static double ep(double e1, double e2, double d1, double d2){
		return (e1/d1) * (e2/d2);
	}
}
