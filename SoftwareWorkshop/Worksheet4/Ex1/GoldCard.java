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

	/** Constructor for a Gold Card account for the GoldCard class.
	 *
	 * @param name a name associated with the account
	 * @param accountNumber a number associated with the account
	 * @param amount an initial amount that is stored in the account
	 * @param limit a maximum value that can be removed from the account
	 * @param fee an initial cost for setting up the account
	 */
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
