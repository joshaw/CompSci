/** Test class for the Goods classes, GeneralGood superclass and PerishableGood
 * subclass.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : GoodsTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class GoodsTest {
	public static void main(String[] args) {
		PerishableGood pg =
			new PerishableGood("Name", 12321, 2, true, new Day(25, 12, 2013));
		System.out.println(pg);

		// Set the best before date into the past
		pg.setBestBefore(new Day(1, 12, 2013));
		System.out.println(pg);

		GeneralGood gg =
			new GeneralGood("Other", 321123, 5.0, true);
		System.out.println(gg);
	}

	PerishableGood a =
		new PerishableGood("Name", 1, 2, true, new Day(2, 5, 2013));
	@Test
	public void testGoods() {
		assertEquals("2/5/2013", a.getBestBefore().toString());
	}

	@Test
	public void testGoods2() {
		assertFalse(a.getAvailable());
	}

	// Change the best before to be in the future, so now should be available
	@Test
	public void testGoods3() {
		a.setBestBefore(new Day(1,1,2014));
		assertTrue(a.getAvailable());
	}

}
