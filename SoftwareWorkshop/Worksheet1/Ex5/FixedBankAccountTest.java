/**  This class is to test the FixedBankAccount class and its methods.
 *
 *   We create an object of class FixedBankAccount, print it to the screen and
 *   calculate the final capital after d days.
 */
public class FixedBankAccountTest {

	public static void main(String[] args){

		//Create an account with £1000 for 1000 days.
		FixedBankAccount testAccount = new FixedBankAccount(1000.00, 1000);

		System.out.println(testAccount);

		System.out.println("£" + testAccount.getTotalCapital());

	}

}
