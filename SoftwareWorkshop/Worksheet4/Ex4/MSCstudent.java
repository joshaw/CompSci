/** Class to represent a postgraduate student. Extends the Student superclass
 * with only the pass mark being different.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : MSCstudent.java
 * @version 2013-11-24
 */
public class MSCstudent extends Student {

	public MSCstudent(String name) {

		// Set the pass mark to 50
		super(name, 50);
	}
}


