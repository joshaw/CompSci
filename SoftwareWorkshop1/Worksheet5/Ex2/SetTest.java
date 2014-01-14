/** Test class for the Set data type, implemented as an extension of the List
 * class.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 2
 * File name : SetTest.java
 * @version 2013-12-08
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class SetTest {

	public static void main(String[] args) {
		Set s =
			Set.cons(4, Set.cons(5, Set.cons(6, Set.cons(7, Set.empty()))));

		Set r =
			Set.cons(5, Set.cons(4, Set.cons(5, Set.cons(6, Set.cons(7, Set.empty())))));

		System.out.println(Set.equals(s, r));
		System.out.println(s.equals(r));

	}

	/* Test an empty set. */
	@Test
	public void testEmpty() {
		Set s = new Set();
		assertTrue(s.isEmpty());
	}

	/* Test a non-empty set. */
	@Test
	public void testNotEmpty() {
		Set s =
			Set.cons(4, Set.cons(5, Set.cons(6, Set.cons(7, Set.empty()))));
		assertFalse(s.isEmpty());
	}

	/* Check two sets with different numbers of elements to be equal. */
	@Test
	public void testIsEqual() {
		Set s =
			Set.cons(4, Set.cons(5, Set.cons(6, Set.cons(7, Set.empty()))));
		Set r = Set.cons(5, Set.cons(4,
					Set.cons(5, Set.cons(6, Set.cons(7, Set.empty())))));

		assertTrue("Should be the same.", Set.equals(s, r));
	}

	/* Test sets with different numbers of elements and different contents to
	 * not be equal. */
	@Test
	public void testIsNotEqual() {
		Set s =
			Set.cons(4, Set.cons(5, Set.cons(6, Set.cons(7, Set.empty()))));
		Set r = Set.cons(8, Set.cons(7,
					Set.cons(6, Set.cons(5, Set.cons(4, Set.empty())))));

		assertFalse("Should be different.", s.equals(r));
	}

	/* Test that two empty sets are indeed equal. */
	@Test
	public void testEmptySets() {
		Set s = new Set();
		Set r = new Set();
		assertTrue(r.equals(s));
	}

}
