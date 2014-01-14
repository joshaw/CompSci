/** Representation of a customer. Each is associated with an ID, name, order
 * total and a gold status.
 *
 * The order total is increased every time an order is made and reset to zero
 * at the start of each month. If, during a single month, the order total
 * exceeds a predefined limit (2000), the customer is given Gold Status.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : Customer.java
 * @version 2013-11-24
 */
import java.util.Calendar;
public class Customer {

	private int customerID;
	private String firstname;
	private String surname;
	private double orderTotal;
	private boolean goldStatus = false;

	private final int GOLDLIMIT = 2000;

	/** Constructor for the Customer class to represent a customer with th
	 * orders they have made and if they have gold status or not.
	 *
	 * @param customerID a unique number to identify each customer
	 * @param firstname the firstname of the customer
	 * @param surname the last name of the customer
	 */
	public Customer(int customerID, String firstname, String surname) {
		this.customerID = customerID;
		this.firstname = firstname;
		this.surname = surname;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	/** Adds the paid amount the total spent this month
	 *
	 * @param amount amount to add to this month's total
	 */
	public void increaseMonthTotal(double amount) {
		checkFirstDayMonth();
		orderTotal += amount;
		checkGoldStatus();
	}

	/** Checks if the current day is the first day of the month. If it is, the
	 * value of the total money spent is reset to zero.
	 */
	private void checkFirstDayMonth() {
		Calendar cal = Calendar.getInstance();
		if(cal.get(Calendar.DAY_OF_MONTH) == 1){
			orderTotal = 0;
		}
	}

	/** If the customer has spent more than the given amount in a single month,
	 * they are given Gold Status.
	 */
	private void checkGoldStatus() {
		if (orderTotal > GOLDLIMIT) {
			goldStatus = true;
		}
	}

}
