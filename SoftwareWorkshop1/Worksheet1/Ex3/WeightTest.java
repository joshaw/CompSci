/**  This class is to test the Weight class and its methods.
 *   We create an object of class Weight and retreive the value in pounds and
 *   converted to kilograms */
public class WeightTest {

	public static void main(String[] args){

		/* Creates a new ComputerAccout with realName Joe Bloggs, userName
		 * j.Bloggs and password password. */
		Weight testWeight = new Weight(15);

		System.out.println("Pounds   : " + testWeight.getPounds());
		System.out.println("Kilograms: " + testWeight.getKilograms());

		Weight testWeight2 = new Weight(49);

		System.out.println("Pounds   : " + testWeight2.getPounds());
		System.out.println("Kilograms: " + testWeight2.getKilograms());

	}

}
