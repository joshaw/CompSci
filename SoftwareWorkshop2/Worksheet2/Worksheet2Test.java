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
import org.junit.BeforeClass;
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
	static Tree taAddHBComp;
	static Tree tb;
	static Tree tbAddHBComp;
	static Tree tEmptyAddHBComp;

	@BeforeClass
	public static void makeTreeNonSearch() {

		// --------------------------------------------------------------------
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		tUnbalancedSearch = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			tUnbalancedSearch = tree.SearchTreeOps.insert(numbers[i],
					tUnbalancedSearch);
		}

		// --------------------------------------------------------------------
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

		// --------------------------------------------------------------------
		int[] numbers2 = {6, 3, 8, 1, 5, 7, 9, 2, 4};
		ta = new Tree();
		for (int i = 0; i < numbers2.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers2[i], ta);
		}

		int[] numbers3 = {6, 3, 8, 1, 5, 7, 9, 2, 4, 10};
		taAddHBComp = new Tree();
		for (int i = 0; i < numbers3.length; i++) {
			taAddHBComp = tree.SearchTreeOps.insert(numbers3[i], taAddHBComp);
		}

		// --------------------------------------------------------------------
		int[] numbers4 = {12, 5, 15, 2, 9, 18};
		tb = new Tree();
		for (int i = 0; i < numbers4.length; i++) {
			tb = tree.SearchTreeOps.insert(numbers4[i], tb);
		}

		int[] numbers5 = {6, 3, 8, 1, 5, 7, 9, 2, 4, 10};
		tbAddHBComp = new Tree();
		for (int i = 0; i < numbers5.length; i++) {
			tbAddHBComp = tree.SearchTreeOps.insert(numbers5[i], tbAddHBComp);
		}

		// --------------------------------------------------------------------
		tEmptyAddHBComp = new Tree(1, new Tree(), new Tree());
	}

	// ------------------------------------------------------------------------
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

	// ------------------------------------------------------------------------
	@Test
	public void testIsHeightBalanced() {
		assertTrue(Worksheet2.isHeightBalanced(ta));
	}

	@Test
	public void testIsHeightBalanced2() {
		assertFalse(Worksheet2.isHeightBalanced(tUnbalancedSearch));
	}

	// ------------------------------------------------------------------------
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

	// ------------------------------------------------------------------------
	@Test
	public void testInsertHB() {
		Tree taAddHB = Worksheet2.insertHB(10, ta);

		assertTrue(taAddHB.equals(taAddHBComp));
		assertTrue(Worksheet2.isSearchTree(taAddHB));
		assertTrue(Worksheet2.isHeightBalanced(taAddHB));
	}

	@Test
	public void testInsertHB2() {

		System.out.println();
		System.out.println(tb);
		// Tree tbAddHB = Worksheet2.insertHB(21, tb);
		System.out.println(Worksheet2.insertHB(21, tb));
		// assertTrue(tbAddHB.equals(tbAddHBComp));
		// assertTrue(Worksheet2.isSearchTree(tbAddHB));
		// assertTrue(Worksheet2.isHeightBalanced(tbAddHB));
	}

	@Test
	public void testInsertHB3() {
		Tree tEmptyAddHB = Worksheet2.insertHB(1, tEmpty);

		assertTrue(tEmptyAddHB.equals(tEmptyAddHBComp));
		assertTrue(Worksheet2.isSearchTree(tEmptyAddHB));
		assertTrue(Worksheet2.isHeightBalanced(tEmptyAddHB));
	}
	// ------------------------------------------------------------------------
}
