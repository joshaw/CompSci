import java.util.Calendar;

public class PerishableGood extends GeneralGood {

	private Day bestBefore;

	public PerishableGood(String name, int orderNumber, double standardPrice,
			boolean availible, Day bestBefore) {

		super(name, orderNumber, standardPrice, availible);
		this.bestBefore = bestBefore;
		checkBestBefore();
	}

	public void setBestBefore(Day bestBefore) {
		this.bestBefore = bestBefore;
	}

	public Day getBestBefore() {
		return bestBefore;
	}

	private void checkBestBefore() {
		Calendar c = Calendar.getInstance();
		c.set(bestBefore.getYear(), bestBefore.getMonth()-1, bestBefore.getDay(), 0, 0);

		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);

		c.add(Calendar.DAY_OF_YEAR, -8);
		if (!today.before(c)) {
			super.setStandardPrice(super.getStandardPrice() * 0.5);
		}

		c.add(Calendar.DAY_OF_YEAR, 6);

		if (!today.before(c)) {
			super.setAvailible(false);
		}
	}

}
