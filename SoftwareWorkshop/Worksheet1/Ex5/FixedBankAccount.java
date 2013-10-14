/** Defines the class FixedBankAccount to hold an initial capital for d days
 * and return the final contents of the account after n days.
 * @author Josh Wainwright
 * @version 2013-10-11
 */
public class FixedBankAccount {

	private double initialCapital;
	private int d;

	private double interestRate = 0.01;

	/** A simple class to hold an initial capital for a specified number of
	 * days.
	 *
	 * @param initialCapital is the starting contents of the account
	 * @param d is the number of days it will be held
	 */
	public FixedBankAccount(double initialCapital, int d){
		this.initialCapital = initialCapital;
		this.d = d;
	}

	/**
	 * @return the initialCapital of {@link #FixedBankAccount}
	 */
	public double getInitialCapital(){
		return initialCapital;
	}

	/**
	 * @return the number of days of {@link #FixedBankAccount}
	 */
	public int getDays(){
		return d;
	}

	/** toString defines how to print a computer account
	 *
	 * @return the print type of an account
	 */
	@Override
	public String toString(){
		return "£" + initialCapital + ", " + d;
	}

	/** Returns the total capital in the account after the number of full years
	 * represented by {@link #d} days.
	 *
	 * Partial years are not counted since the interest is added at the end of
	 * each year.
	 *
	 * @return the final capital after d days
	 */
	public double getTotalCapital(){
		int years = d/365;

		double finalCapital = (initialCapital * Math.pow(1 + interestRate, years));

		return Math.round(finalCapital * 100.0) / 100.0;
	}

}
