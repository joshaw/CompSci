/** Class for representing an item as a general good, storing information such
 * as the name, order number, price and availability of that item.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : GeneralGood.java
 * @version 2013-11-24
 */
public class GeneralGood {

	private String name;
	private int orderNumber;
	private double standardPrice;
	private boolean available;

	public GeneralGood(String name, int orderNumber, double standardPrice,
			boolean available) {
		this.name = name;
		this.orderNumber = orderNumber;
		this.standardPrice = standardPrice;
		this.available = available;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setStandardPrice(double standardPrice) {
		this.standardPrice = standardPrice;
	}

	public double getStandardPrice() {
		return standardPrice;
	}

	public void setavailable(boolean available) {
		this.available = available;
	}

	public boolean getavailable() {
		return available;
	}

}
