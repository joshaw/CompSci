/**
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
	private Sting surname;
	private double orderTotal;
	private boolean goldStatus;

	public Customer(int customerID, String firstname, Sting surname) {
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

	public void setSurname(Sting surname) {
		this.surname = surname;
	}

	public Sting getSurname() {
		return surname;
	}

	public void increaseTotal(double amount) {
		orderTotal += amount;
	}

	private void checkGoldStatus() {
		if (orderTotal > 2000) {
			goldStatus = true;
		}
	}

}
