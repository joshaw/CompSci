/** Defines the class FixedBankAccount to hold an initial capital for "days"
 * days and return the final contents of the account after n days.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 1
 * Exercise  : 5
 * @version 2013-10-11
 */
public class FixedBankAccount {

	private int initialCapitalPence;
	private int days;

	final double interestRate = 0.01;

	/** A simple class to hold an initial capital for a specified number of
	 * days.
	 *
	 * @param initialCapital is the starting contents of the account in pounds.
	 * This is then converted to pence for manipulation
	 * @param days is the number of days it will be held
	 */
	public FixedBankAccount(double initialCapital, int d){

		//Convert the given pounds to pence and convert to integer
		double tempInitialCapital = initialCapital * 100;
		this.initialCapitalPence = (int) tempInitialCapital;

		this.days = d;
	}

	/**
	 * @return the initialCapital of {@link #FixedBankAccount}
	 */
	public double getInitialCapital(){
		return initialCapitalPence/100.0;
	}

	/**
	 * @return the number of days of {@link #FixedBankAccount}
	 */
	public int getDays(){
		return days;
	}

	/** toString defines how to print a computer account
	 *
	 * @return the print type of an account
	 */
	@Override
	public String toString(){
		return "£" + initialCapitalPence/100.0 + " (" + days + " days)";
	}

	/** Returns the total capital in the account after the number of full years
	 * represented by {@link #days} days.
	 *
	 * @return the final capital after "days" days
	 */
	public double getTotalCapital(){
		// Partial years are not counted since the interest is added at the end
		// of each year so integer division rounds to nearest integer.
		int years = days/365;

		// interestRate to the power years gives the total interest for that
		// many years. Multiply this by initialCapital gives total after years
		double finalCapital = (initialCapitalPence * Math.pow(1 + interestRate, years));
		finalCapital = (int) finalCapital;

		// Returns number of pounds, so converts from pence to pounds.
		return finalCapital/100;
	}

}
