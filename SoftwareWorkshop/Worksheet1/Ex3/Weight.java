/** Defines the class ComputerAccout for holding info about a computer account
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 1
 * Exercise  : 3
 * @version 2013-10-11
 */
public class Weight {

	double pounds;
	double conversion = 0.45359237;

	/** A simple class to hold a weight and return it in different units.
	 *
	 * @param pounds is the number of pounds held in this Weight
	 */
	public Weight(double p){
		pounds = p;
	}

	/**
	 * @return the number of pounds in {@link #Weight}
	 */
	public double getPounds(){
		return pounds;
	}

	/**
	 * @return the number of pounds in {@link #Weight} converted to kilograms.
	 */
	public double getKilograms(){
		return pounds * conversion;
	}

}
