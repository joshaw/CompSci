/**  This class is to test the ComputerAccout class and its methods.
 *   We create an object of class ComputerAccout, print this to the screen and
 *   change the password associated with the account.
 */
public class ComputerAccoutTest {

	public static void main(String[] args){

		/* Creates a new ComputerAccout with realName Joe Bloggs, userName
		 * j.Bloggs and password password. */
		ComputerAccout testAccount = new ComputerAccout("Joe Bloggs", "j.bloggs", "password");

		System.out.println(testAccount);

		System.out.println("\nChange password to \"SomethingNew\"");

		testAccount.changePassword("SomethingNew");

		System.out.println("\n" + testAccount);


	}

}
