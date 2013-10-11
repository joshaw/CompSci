/**  This class is to test the ComputerAccout class and its methods.
 *   We create an object of class ComputerAccout, print this to the screen and
 *   change the password associated with the account.
 */
public class WeightTest {

	public static void main(String[] args){

		/* Creates a new ComputerAccout with realName Joe Bloggs, userName
		 * j.Bloggs and password password. */
		Weight testWeight = new Weight(15);

		System.out.println("Pounds   : " + testWeight.getPounds());
		System.out.println("Kilograms: " + testWeight.getKilograms());

	}

}
