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

		/* If there is suffiecient funds, the fee is subtracted from the
		 * initial balance. */
		if (super.getAmount() > fee) {
			super.setAmount(super.getAmount() - fee);
		} else {
			throw new InputMismatchException("The fee is greater than the" +
					" balance of the account.");
		}
	}
}
