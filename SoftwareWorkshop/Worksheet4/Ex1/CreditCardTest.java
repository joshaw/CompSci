/** Test class for the CreditCard class and GoldCard sub-class.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 1
 * File name : CreditCardTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardTest {
	public static void main(String[] args) {

		System.out.println("Credit Card");
		CreditCard ccTest = new CreditCard("TestCard", "1234abcd", 1000, 5000);

		System.out.println(ccTest);

		System.out.println("Gold Card");
		GoldCard gcTest = new GoldCard("TestGold", "987zyx", 2000, 10000, 200);

		System.out.println(gcTest);
	}

	@Test
	public void testCreditCard() {
		CreditCard b = new CreditCard("TestCard", "123abc", 1000, 500);
		assertEquals(1000, b.getAmount(), 0.001);
	}

	@Test
	public void testGoldCard() {
		GoldCard b = new GoldCard("TestGold", "987zyx", 2000, 10000, 200);
		assertEquals(1800, b.getAmount(), 0.001);
	}

	@Test
	public void testGoldCard2() {
		GoldCard b = new GoldCard("TestGold", "987zyx", 2000, 10000, 200);
		assertEquals("TestGold", b.getName());
	}
}
