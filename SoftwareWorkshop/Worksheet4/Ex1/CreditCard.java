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

	public CreditCard(
			String name, String accountNumber, double amount, double limit) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.limit = limit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

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
