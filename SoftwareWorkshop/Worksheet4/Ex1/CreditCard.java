/** Creates a representaion of a credit card with an account name, number, an
 * initial amount and a limit.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 1
 * File name : CreditCard.java
 * @version 2013-11-24
 */
public class CreditCard {

	private String name;
	private String accountNumber;
	private double amount;
	private double limit;

	/** Constructor for the CreditCard class.
	 *
	 * @param name a name associated with the account
	 * @param accountNumber a number associated with the account
	 * @param amount an initial amount that is stored in the account
	 * @param limit a maximum value that can be removed from the account
	 */
	public CreditCard(
			String name, String accountNumber, double amount, double limit) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.limit = limit;
	}

	/** Allows viewing and changing the name of the account
	 *
	 * @param name a name associated with the account
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	/** Allows viewing and changing the number of the account
	 *
	 * @param accountNumber a number associated with the account
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	/** Allows viewing and changing the amount stored in the account
	 *
	 * @param amount an initial amount that is stored in the account
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}

	/** Allows viewing and changing the limit associated with the account
	 *
	 * @param limit a maximum value that can be removed from the account
	 */
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public double getLimit() {
		return limit;
	}

	public String toString() {
		return name + ": No. = " + accountNumber + ", Balance = " + amount +
			", Limit = " + limit;
	}

}
