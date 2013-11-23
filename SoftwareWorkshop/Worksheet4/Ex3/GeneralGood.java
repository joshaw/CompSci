public class GeneralGood {

	private String name;
	private int orderNumber;
	private double standardPrice;
	private boolean availible;

	public GeneralGood(String name, int orderNumber, double standardPrice,
			boolean availible) {
		this.name = name;
		this.orderNumber = orderNumber;
		this.standardPrice = standardPrice;
		this.availible = availible;
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

	public void setAvailible(boolean availible) {
		this.availible = availible;
	}

	public boolean getAvailible() {
		return availible;
	}

}
