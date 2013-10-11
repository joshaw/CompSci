/** Defines the class Fraction for hold the numerator and denominator of a
 * fraction and returning both elements and the sum and product of two
 * Fractions.
 *
 * @author Josh Wainwright
 * @version 2013-10-11
 */
public class Fraction{

	private int numerator = 1;
	private int denominator = 1;

	/** A simple class to hold a fraction and return the parts of it as well as
	 * combinations of two fractions.
	 *
	 * @param numerator is the top of the fraction
	 * @param denominator is the bottom of the fraction
	 */
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(){}

	/**
	 * @return the numerator of {@link #Fraction}
	 */
	public int getNumerator(){
		return numerator;
	}

	/**
	 * @return the denominator of {@link #Fraction}
	 */
	public int getDenominator(){
		return denominator;
	}

	/** toString defines how to print a computer account
	 *
	 * @return the print type of an account
	 */
	@Override
	public String toString(){
		return numerator + "/" + denominator;
	}

	/** defines how to multiply two Fractions together
	 *
	 * @param f is a Fraction that shall be multiplied with this fraction
	 * @return a Fraction the is the product of the operator fraction and the
	 * argument
	 */
	public Fraction getProduct(Fraction f){

		int newNumerator = this.numerator * f.getNumerator();
		int newDenominator = this.denominator * f.getDenominator();

		return new Fraction(newNumerator,newDenominator);

	}

	/** defines how to add two fractions together
	 *
	 * @param f is a Fraction that shall be add to this fraction
	 * @return a Fraction the is the sum of the operator fraction and the
	 * argument
	 */
	public Fraction getSum(Fraction f){

		int n1 = this.numerator;
		int n2 = f.getNumerator();
		int d1 = this.denominator;
		int d2 = f.getDenominator();

		int newNumerator = n1 * d2 + n2 * d1;
		int newDenominator = d1 * d2;

		return new Fraction(newNumerator, newDenominator);

	}

}
