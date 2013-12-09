/** Class to hold the information required to generate an invoice for an
 * account. Implements the Measurable interface to return some measure.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 1
 * File name : Invoice.java
 * @version 2013-12-08
 */
public class Invoice implements Measurable {

	private int accountNumber;
	private int sortCode;
	private double amount;

	/** Create an instance of an Invoice
	 *
	 * @param accountNumber a reference number for the account
	 * @param sortCode the sort code
	 * @param amount amount to be billed
	 */
	public Invoice(int accountNumber, int sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public int getSortCode() {
		return sortCode;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	/** Use the interface method to return the weight
	 * 
	 * @return the amount stored in the invoice
	 */
	public double getMeasure() {
		return amount;
	}
}
