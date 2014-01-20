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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	static List lEmpty = new List();

	static Tree ta;
	static Tree tEmpty = new Tree();

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

/******************************************************************************
 * Junit tests - Lists                                                        *
 *****************************************************************************/

	// Test method "allPositive"
	@Test // True
	public void testAllPositiveTrue() {
		assertTrue(Worksheet1.allPositive(la));
	}

	@Test // True
	public void testAllPositiveTrue2() {
		assertTrue(Worksheet1.allPositive(lEmpty));
	}

	@Test // False
	public void testAllPositiveFalse() {
		assertFalse(Worksheet1.allPositive(lb));
	}

	// Test method "sorted"
	@Test // True
	public void testSortedTrue() {
		assertTrue(Worksheet1.sorted(la));
	}

	@Test // False
	public void testSortedFalse() {
		assertFalse(Worksheet1.sorted(lb));
	}

	// Test method "merge"
	@Test
	public void testMerge() {
		List compareList = new List(2, new List(5, new List(5, new List(5,
			new List(7, new List(8, new List(8, new List(9, new List()))))))));

		assertTrue(List.equals(compareList, Worksheet1.merge(ld, le)));
	}

	@Test // Merge two empty lists
	public void testMerge2() {
		List compareList = new List();
		assertTrue(List.equals(compareList, Worksheet1.merge(lEmpty, lEmpty)));
	}

	@Test // Merge list with empty list
	public void testMerge3() {
		assertTrue(List.equals(la, Worksheet1.merge(la, lEmpty)));
	}

	// Test method "removeDuplicates"
	@Test
	public void testRemoveDuplicates() {
		List dupList = new List(2, new List(5, new List(5, new List(5,
			new List(7, new List(8, new List(8, new List(9, new List()))))))));
		List compareList = new List(2, new List(5, new List(7, new List(8,
							new List(9, new List())))));

		assertTrue(List.equals(compareList,
					Worksheet1.removeDuplicates(dupList)));
	}

	@Test
	public void testRemoveDuplicates2() {

		/* Empty list contains no duplicates so the new list is the same as the
		 * original. */
		List compareList = new List();
		assertTrue(List.equals(compareList,
					Worksheet1.removeDuplicates(lEmpty)));
	}

/******************************************************************************
 * Junit tests - Trees                                                        *
 *****************************************************************************/

	// Create tree for testing
	@Before
	public void makeTree() {
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		ta = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers[i], ta);
		}
	}

	// Test method "mirror"
	@Test
	public void testMirror() {
		Tree tEmptyReversed = new Tree();
		assertEquals(tEmptyReversed.toString(),
				Worksheet1.mirror(tEmpty).toString());
	}

	@Test
	public void testMirror2() {
		Tree taReversed = new Tree(1,
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

		assertEquals(ta.toString(), Worksheet1.mirror(taReversed).toString());
	}

	// Test method "max"
	@Test
	public void testMax() {
		assertEquals(9, Worksheet1.max(ta));
	}

	@Test (expected=IllegalStateException.class)
	public void testMax2() {
		Worksheet1.max(tEmpty);
	}

	@Test
	public void testMax3() {

		// 8 is not the max, so the equality is true
		assertTrue(8 != Worksheet1.max(ta));
	}

	// Test method "printDescending"
	@Test
	public void testPrintDescending() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Worksheet1.printDescending(ta);
		assertEquals("9 8 7 6 5 4 3 2 1 ", outContent.toString());
	}

	@Test
	public void testPrintDescending2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Worksheet1.printDescending(tEmpty);
		assertEquals("", outContent.toString());
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

	@Test (expected=IllegalStateException.class)
	public void testDelete2() {
		int[] numbers = {1, 9, 2, 8, 4, 7, 3, 6};
		Tree taDel = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			taDel = tree.SearchTreeOps.insert(numbers[i], taDel);
		}

		assertEquals(taDel.toString(), Worksheet1.delete(ta, 0).toString());
	}

}
