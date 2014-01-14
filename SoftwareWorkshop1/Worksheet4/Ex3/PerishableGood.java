/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : PerishableGood.java
 * @version 2013-11-24
 */
import java.util.Calendar;

public class PerishableGood extends GeneralGood {

	private Day bestBefore;
	private boolean perished = false;

	public PerishableGood(String name, int orderNumber, double standardPrice,
			boolean availible, Day bestBefore) {

		super(name, orderNumber, standardPrice, availible);
		this.bestBefore = bestBefore;
		checkBestBefore();
	}

	public void setBestBefore(Day bestBefore) {
		this.bestBefore = bestBefore;
		checkBestBefore();
	}

	public Day getBestBefore() {
		return bestBefore;
	}

	public boolean getPerished() {
		return perished;
	}

	/** Checks the best before date compared to the current date. If the best
	 * before date is 8 or less days in, the future, then the price of the item
    GoodsTest.java
	 * is reduced by half. If the best before date is 2 or less days in the
	 * future then the item is said to be perished and shall not be shipped.
	 */
	private void checkBestBefore() {
		int reducePriceDays = 8;
		int perishedDays = 2;

		// Get the value of the best before date as a java Calendar.
		Calendar c = Calendar.getInstance();
		c.set(bestBefore.getYear(), bestBefore.getMonth()-1,
				bestBefore.getDay(), 0, 0);

		// Get today's date.
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);

		/* Move the best before date 8 days backward and check if the current
		 * date is still before it. If not, reduce the price by half. */
		c.add(Calendar.DAY_OF_YEAR, 0-reducePriceDays);
		if (!today.before(c)) {
			super.setStandardPrice(super.getStandardPrice() * 0.5);
		}

		/* Move the best before date forward so that it is now 2 days prior to
		 * the original date. If todays date is not before it, then the item
		 * has perished. */
		c.add(Calendar.DAY_OF_YEAR, reducePriceDays - perishedDays);
		if (!today.before(c)) {
			super.setAvailable(false);
			perished = true;
		} else {
			super.setAvailable(true);
			perished = false;
		}
	}

}
