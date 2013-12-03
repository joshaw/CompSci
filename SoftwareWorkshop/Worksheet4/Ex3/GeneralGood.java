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
	private double price;
	private boolean available = true;

	/** Constructor for the GeneralGood class to represent a good that has no
	 * expiry date.
	 *
	 * @param name a name of the product being represented
	 * @param orderNumber a number representing the order that has been made
	 * @param price a price of the item
	 * @param available a boolean value describing the availiblity of the item
	 */
	public GeneralGood(String name, int orderNumber, double price,
			boolean available) {
		this.name = name;
		this.orderNumber = orderNumber;
		this.price = price;
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

	public void setStandardPrice(double price) {
		this.price = price;
	}

	public double getStandardPrice() {
		return price;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean getAvailable() {
		return available;
	}

	@Override
	public String toString() {
		if (available) {
			return name + " (" + orderNumber + "): " + price;
		} else {
			return name + " (" + orderNumber + "): Unavailable";
		}
	}

}
