public class GoldCard extends CreditCard {

	private double fee;

	public GoldCard(String name, String accountNumber,
			double amount, double limit, double fee) {

		super(name, accountNumber, amount, limit);
		super.setAmount(super.getAmount() - fee);
	}
}
