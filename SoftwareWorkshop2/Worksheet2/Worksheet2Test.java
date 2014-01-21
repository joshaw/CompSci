/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet2
 * File name : Worksheet2Test.java
 * @version 2014-01-21
 */
import tree.*;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Worksheet2Test {
	public static void main(String[] args) {

		int[] numbers = {6, 3, 8, 1, 5, 7, 9, 2, 4};
		ta = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers[i], ta);
		}
		// System.out.println(ta);
		// System.out.println();
		// System.out.println(Worksheet2.isSearchTree(ta));

		System.out.println(Worksheet2.insertHB(5, ta));

	}

	static Tree tEmpty = new Tree();
	static Tree tUnbalancedSearch;
	static Tree tUnbalancedNonSearch;
	static Tree ta;

	// Create tree for testing
	@Before
	public void makeTree() {
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		tUnbalancedSearch = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			tUnbalancedSearch = tree.SearchTreeOps.insert(numbers[i],
					tUnbalancedSearch);
		}
	}

	@Before
	public void makeTreeNonSearch() {
		tUnbalancedNonSearch = new Tree(3,
								new Tree(4,
									new Tree(),
									new Tree()
								),
								new Tree(5,
									new Tree(),
									new Tree()
								)
							   );
	}

	@Before
	public void makeBalancedTree() {
		int[] numbers = {6, 3, 8, 1, 5, 7, 9, 2, 4};
		ta = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers[i], ta);
		}
	}

	/* Some comme
	 * */
	@Test
	public void testGetHeight() {
		assertEquals(-1, tEmpty.getHeight());
	}

	@Test
	public void testGetHeight2() {
		assertEquals(5, tUnbalancedSearch.getHeight());
	}

	@Test
	public void testGetHeight3() {
		assertEquals(3, ta.getHeight());
	}

	@Test
	public void testIsHeightBalanced() {
		assertTrue(Worksheet2.isHeightBalanced(ta));
	}

	@Test
	public void testIsHeightBalanced2() {
		assertFalse(Worksheet2.isHeightBalanced(tUnbalancedSearch));
	}

	@Test
	public void testIsSearchTree() {
		assertTrue(Worksheet2.isSearchTree(ta));
	}

	@Test
	public void testIsSearchTree2() {
		assertTrue(Worksheet2.isSearchTree(tUnbalancedSearch));
	}

	@Test
	public void testIsSearchTree3() {
		assertTrue(Worksheet2.isSearchTree(tEmpty));
	}

	@Test
	public void testIsSearchTree4() {
		assertFalse(Worksheet2.isSearchTree(tUnbalancedNonSearch));
	}
}
