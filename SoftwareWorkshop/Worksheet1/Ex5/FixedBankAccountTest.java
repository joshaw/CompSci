/**  This class is to test the FixedBankAccount class and its methods.
 *
 *   We create an object of class FixedBankAccount, print it to the screen and
 *   calculate the final capital after d days.
 */
public class FixedBankAccountTest {

	public static void main(String[] args){

		//Create an account with £1000 for 1000 days.
		FixedBankAccount testAccount = new FixedBankAccount(1000.00, 1000);

		System.out.println("Inital Account: " + testAccount);

		System.out.println("Total Capital: £" + testAccount.getTotalCapital());
		System.out.println();

		//Create an account with £15 for 1000 days.
		FixedBankAccount testAccount2 = new FixedBankAccount(15.00, 1000);

		System.out.println("Inital Account: " + testAccount2);

		System.out.println("Total Capital: £" + testAccount2.getTotalCapital());
		System.out.println();

		//Create an account with £150 for 900 days.
		FixedBankAccount testAccount3 = new FixedBankAccount(150.00, 900);

		System.out.println("Inital Account: " + testAccount3);

		System.out.println("Total Capital: £" + testAccount3.getTotalCapital());
		System.out.println();

	}

}
