/** Sub-class of CreditCard which adds a fee which is subtracted from the
 * balance of the account on creation.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 1
 * File name : GoldCard.java
 * @version 2013-11-24
 */
import java.util.InputMismatchException;

public class GoldCard extends CreditCard {

	private double fee;

	public GoldCard(String name, String accountNumber,
			double amount, double limit, double fee) {

		super(name, accountNumber, amount, limit);

		/* If the limit or the balance is greater than the fee, the fee is
		 * subtracted from the initial balance. */
		if (super.getLimit() > fee | super.getAmount() > fee) {
			super.setAmount(super.getAmount() - fee);
		} else {
			throw new InputMismatchException("Cannot create account. The fee " +
					"is greater than the balance of the account.");
		}
	}
}
