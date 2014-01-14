/** Class to represent an undergraduate student. Extends the Student superclass
 * with only the pass mark being different.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : UGstudent.java
 * @version 2013-11-24
 */
public class UGstudent extends Student {

	public UGstudent(String name) {

		// Set the pass mark to 40
		super(name, 40);
	}
}
