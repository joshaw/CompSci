/** Recursive Data Structures. Methods for use with Lists and Trees as defined
 * in the accompanying packages "list" and "tree".
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : Worksheet1
 * Exercise  : 1-8
 * File name : Worksheet1Test.java
 * @version 2014-01-17
 */
import list.*;
import tree.*;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Worksheet1Test {

	// Create data structures for use in tests.
	static List la = new List(2, new List(3, new List(4, new List())));
	static List lb = new List(2, new List(-3, new List(4, new List())));
	static List lc = new List();
	static List ld = new List(2, new List(5, new List(5, new List(8,
						new List()))));
	static List le = new List(5, new List(7, new List(8, new List(9,
						new List()))));
	static List lf = new List(2, new List(5, new List(5, new List(5,
						new List(7, new List(8, new List(8, new List(9,
						new List()))))))));

	static Tree ta;

	public static void main(String[] args) {

		// Test all positive
		System.out.println("allPositive");
		System.out.println(la + " " + Worksheet1.allPositive(la)); // true
		System.out.println(lb + " " + Worksheet1.allPositive(lb)); // false

		// Test sorted list
		System.out.println("\nsorted");
		System.out.println(la + " " + Worksheet1.sorted(la)); // true
		System.out.println(lb + " " + Worksheet1.sorted(lb)); // false

		// Merge two lists
		System.out.println("\nmerge");
		System.out.println(ld);
		System.out.println(le);
		System.out.println(Worksheet1.merge(ld, le));

		// System.out.println("\npreppend");
		// System.out.println(d);
		// System.out.println(e);
		// System.out.println(Worksheet1.preppend(d, e));

		// System.out.println("\nreverse");
		// System.out.println(la);
		// System.out.println(Worksheet1.reverse(la));

		// Remove duplicate entries
		System.out.println("\nremoveDuplicates");
		System.out.println(lf);
		System.out.println(Worksheet1.removeDuplicates(lf));

		// Populate tree for testing
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		Tree ta = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers[i], ta);
		}

		// Mirror tree along vertical axis
		System.out.println("\nmirror");
		System.out.println(ta);
		System.out.println(Worksheet1.mirror(ta));

		// Print all entries in descending order
		System.out.println("\nprintDescending");
		Worksheet1.printDescending(ta);

		// Return max element
		System.out.println("\nmax");
		System.out.println(Worksheet1.max(ta));

		// Delete an element
		System.out.println("\ndelete");
		System.out.println("[ [ Orig ] ]\n" + ta);
		System.out.println("\n[ [ New ] ] \n" + Worksheet1.delete(ta, 5)); // remove 5
	}

	@Test
	public void testAllPositiveTrue() {
		assertTrue(Worksheet1.allPositive(la));
	}

	@Test
	public void testAllPositiveFalse() {
		assertFalse(Worksheet1.allPositive(lb));
	}

	@Test
	public void testSortedTrue() {
		assertTrue(Worksheet1.sorted(la));
	}

	@Test
	public void testSortedFalse() {
		assertFalse(Worksheet1.sorted(lb));
	}

	@Test
	public void testMerge() {
		List compList = new List(2, new List(5, new List(5, new List(5,
			new List(7, new List(8, new List(8, new List(9, new List()))))))));

		assertTrue(List.equals(compList, Worksheet1.merge(ld, le)));
	}

	@Test
	public void testRemoveDuplicates() {
		List dupList = new List(2, new List(5, new List(5, new List(5,
			new List(7, new List(8, new List(8, new List(9, new List()))))))));
		List compList = new List(2, new List(5, new List(7, new List(8,
							new List(9, new List())))));

		assertTrue(List.equals(compList,
					Worksheet1.removeDuplicates(dupList)));
	}

	@Before
	public void makeTree() {
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		ta = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers[i], ta);
		}
	}

	@Test
	public void testMirror() {
		Tree taReverse = new Tree(1,
							new Tree(5,
								new Tree(9,
									new Tree(),
									new Tree(8,
										new Tree(),
										new Tree(7,
											new Tree(),
											new Tree(6,
												new Tree(),
												new Tree())))),
								new Tree(2,
									new Tree(4,
										new Tree(),
										new Tree(3,
											new Tree(),
											new Tree())),
									new Tree())),
							new Tree());

		assertEquals(ta.toString(), Worksheet1.mirror(taReverse).toString());
	}

	@Test
	public void testMax() {
		assertEquals(9, Worksheet1.max(ta));
	}

	@Test
	public void testDelete() {
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 6};
		Tree taDel = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			taDel = tree.SearchTreeOps.insert(numbers[i], taDel);
		}

		assertEquals(taDel.toString(), Worksheet1.delete(ta, 3).toString());
	}

	@Test
	public void testDelete1() {
		int[] numbers = {1, 4, 2, 9, 3, 8, 7, 6};
		Tree taDel = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			taDel = tree.SearchTreeOps.insert(numbers[i], taDel);
		}

		assertEquals(taDel.toString(), Worksheet1.delete(ta, 5).toString());
	}

	@Test(expected=IllegalStateException.class)
	public void testDelete2() {
		int[] numbers = {1, 4, 2, 9, 3, 8, 7, 6};
		Tree taDel = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			taDel = tree.SearchTreeOps.insert(numbers[i], taDel);
		}
		 Worksheet1.delete(ta, 10);
	}

}
