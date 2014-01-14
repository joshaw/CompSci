/** Test class for the Equals class.
 *
 * If the program is run without the JUnit runtime files included, ie without
 * testing with JUnit, then the program will take two arguements and return
 * true if they are the same and false if they differ, irrespective of the
 * case.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 1
 * File name : EqualsTest.java
 * @version 2013-11-07
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class EqualsTest {

	/** Test function for the Equals method. Two arguements are given on the
	 * commandline and they are checked to be either equal or different,
	 * irrespective of the case.
	 */
	public static void main(String[] args){

		// Use two arguements to the program.
		if (args.length == 2) {
			if(Equals.equals(args[0], args[1])){
				System.out.println("Strings are Equal");
			}else{
				System.out.println("Strings are Different");
			}
		}
	}

	private String test = "test";

	@Test
	public void TestEquals1(){
		assertTrue("The strings should be equal", Equals.equals(test, "tesT"));
	}
	@Test
	public void TestEquals2(){
		assertTrue("The strings should be equal", Equals.equals(test,"TEST"));     // true
	}
	@Test
	public void TestEquals3(){
		assertTrue("The strings should be equal", Equals.equals(test ,"TesT"));     // true
	}
	@Test
	public void TestEquals4(){
		assertTrue("The strings should be equal", Equals.equals(test,"tESt"));     // true
	}
	@Test
	public void TestEquals5(){
		assertFalse("The strings should be different", Equals.equals(test,"tes"));      // false
	}
	@Test
	public void TestEquals6(){
		assertFalse("The strings should be different", Equals.equals(test,"testS"));    // false
	}
	@Test
	public void TestEquals7(){
		assertFalse("The strings should be different", Equals.equals(test,""));         // false
	}

}
