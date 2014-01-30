/** Test class for working with sorted AVL height balanced trees.
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

	static Tree tEmpty = new Tree();
	static Tree tUnbalancedSearch;
	static Tree tUnbalancedNonSearch;
	static Tree ta;
	static Tree taAddHBComp;
	static Tree taDelHBComp;
	static Tree tb;
	static Tree tbAddHBComp;
	static Tree tbDelHBComp;
	static Tree tc;
	static Tree td;
	static Tree tEmptyAddHBComp;

	/* Generate required trees for use in tests before all tests occur, means
	 * that the creation needs only be performed once, and trees can be used
	 * for multiple tests. */
	@BeforeClass
	public static void makeTreeNonSearch() {

		// --------------------------------------------------------------------
		// Unbalanced tree, sorted
		int[] numbers = {1, 5, 9, 2, 8, 4, 7, 3, 6};
		tUnbalancedSearch = new Tree();
		for (int i = 0; i < numbers.length; i++) {
			tUnbalancedSearch = tree.SearchTreeOps.insert(numbers[i],
					tUnbalancedSearch);
		}

		// --------------------------------------------------------------------
		// Unbalanced tree, unsorted
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
		// Sorted, balanced tree.
		int[] numbers2 = {6, 3, 8, 1, 5, 7, 9, 2, 4};
		ta = new Tree();
		for (int i = 0; i < numbers2.length; i++) {
			ta = tree.SearchTreeOps.insert(numbers2[i], ta);
		}

		// Same as previous, wwith 10 added.
		int[] numbers3 = {6, 3, 8, 1, 5, 7, 9, 2, 4, 10};
		taAddHBComp = new Tree();
		for (int i = 0; i < numbers3.length; i++) {
			taAddHBComp = tree.SearchTreeOps.insert(numbers3[i], taAddHBComp);
		}

		// Same as ta, with 1 and 2 removed, balanced.
		int[] numbers4 = {6, 4, 8, 3, 5, 7, 9};
		taDelHBComp = new Tree();
		for (int i = 0; i < numbers4.length; i++) {
			taDelHBComp = tree.SearchTreeOps.insert(numbers4[i], taDelHBComp);
		}

		// --------------------------------------------------------------------
		// Sorted, balanced tree.
		int[] numbers5 = {12, 5, 15, 2, 9, 18};
		tb = new Tree();
		for (int i = 0; i < numbers5.length; i++) {
			tb = tree.SearchTreeOps.insert(numbers5[i], tb);
		}

		// Save as previous with 21 added, balanced.
		int[] numbers6 = {12, 5, 18, 2, 9, 15, 21};
		tbAddHBComp = new Tree();
		for (int i = 0; i < numbers6.length; i++) {
			tbAddHBComp = tree.SearchTreeOps.insert(numbers6[i], tbAddHBComp);
		}

		// Same as tb with 18 deleted, sorted, balanced.
		int[] numbers7 = {12, 5, 2, 9, 15};
		tbDelHBComp = new Tree();
		for (int i = 0; i < numbers7.length; i++) {
			tbDelHBComp = tree.SearchTreeOps.insert(numbers7[i], tbDelHBComp);
		}

		// --------------------------------------------------------------------
		// Empty tree with single value added.
		tEmptyAddHBComp = new Tree(1);

		// Sorted tree, with duplicates.
		tc = new Tree(5,
				new Tree(5),
				new Tree(5)
			);

		// Complex, sorted, balanced tree.
		td = new Tree(30,
				new Tree(20,
					new Tree(15,
						new Tree(13),
						new Tree(18)
					),
					new Tree(25)
				),
				new Tree(40,
					new Tree(35),
					new Tree(50)
				)
			);
	}

	// Test getHeight ---------------------------------------------------------
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
	public void testGetHeight4() {
		assertEquals(2, tb.getHeight());
	}

	// test isHeightBalanced --------------------------------------------------
	@Test
	public void testIsHeightBalanced() {
		assertTrue(Worksheet2.isHeightBalanced(ta));
	}

	@Test
	public void testIsHeightBalanced2() {
		assertFalse(Worksheet2.isHeightBalanced(tUnbalancedSearch));
	}

	@Test
	public void testIsHeightBalanced3() {
		assertTrue(Worksheet2.isHeightBalanced(tb));
	}

	// test isSearchTree ------------------------------------------------------
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

	@Test
	public void testIsSearchTree5() {
		assertTrue(Worksheet2.isSearchTree(tc));
	}

	// test balanceTree -------------------------------------------------------
	@Test
	public void testBalanceTree(){
		assertTrue(tc.equals(Worksheet2.balanceTree(tc)));
	}

	@Test
	public void testBalanceTree2() {
		Tree tz = new Tree(30,
				new Tree(20,
					new Tree(10),
					new Tree()
				),
				new Tree()
			);
		Tree tzComp = new Tree(20,
				new Tree(10),
				new Tree(30)
			);
		assertTrue(tzComp.equals(Worksheet2.balanceTree(tz)));
	}

	@Test
	public void testBalanceTree3() {

		// Unbalanced, sorted tree.
		Tree tz = new Tree(30,
				new Tree(20,
					new Tree(10),
					new Tree(25)
				),
				new Tree()
			);

		// Balanced, sorted to compare.
		Tree tzComp = new Tree(20,
				new Tree(10),
				new Tree(30,
					new Tree(25),
					new Tree()
				)
			);
		assertTrue(tzComp.equals(Worksheet2.balanceTree(tz)));
	}

	/* Multiple assert statements are used to check that an insertion, or
	 * deletion, maintains properties such as height balanced-ness, sortedness
	 * etc. If any of these fail, then the insertHB/deleteHB must be incorrect.
	 * */
	// test insertHB ----------------------------------------------------------
	@Test
	public void testInsertHB() {
		Tree taAddHB = Worksheet2.insertHB(10, ta);

		assertTrue(taAddHB.equals(taAddHBComp));
		assertTrue(Worksheet2.isSearchTree(taAddHB));
		assertTrue(Worksheet2.isHeightBalanced(taAddHB));
	}

	@Test
	public void testInsertHB2() {
		assertTrue(Worksheet2.isHeightBalanced(tb));

		Tree tbAddHB = Worksheet2.insertHB(21, tb);

		assertTrue(tbAddHB.equals(tbAddHBComp));
		assertTrue(Worksheet2.isSearchTree(tbAddHB));
		assertTrue(Worksheet2.isHeightBalanced(tbAddHB));
	}

	@Test
	public void testInsertHB3() {
		Tree tEmptyAddHB = Worksheet2.insertHB(1, tEmpty);

		assertTrue(tEmptyAddHB.equals(tEmptyAddHBComp));
		assertTrue(Worksheet2.isSearchTree(tEmptyAddHB));
		assertTrue(Worksheet2.isHeightBalanced(tEmptyAddHB));
	}

	@Test
	public void testInsertHB4() {
		Tree tcAddHB = Worksheet2.insertHB(5, tc);
		Tree tcAddHBComp = new Tree(5,
				new Tree(5,
					new Tree(5,
						new Tree(),
						new Tree()
					),
					new Tree()
				),
				new Tree(5,
					new Tree(),
					new Tree()
				)
			);

		assertTrue(tcAddHB.equals(tcAddHBComp));
		assertTrue(Worksheet2.isSearchTree(tcAddHB));
		assertTrue(Worksheet2.isHeightBalanced(tcAddHB));
	}

	// test deleteHB ----------------------------------------------------------
	@Test
	public void testDeleteHB() {
		Tree taDelHB = Worksheet2.deleteHB(ta, 2);
		taDelHB = Worksheet2.deleteHB(taDelHB, 1);

		assertTrue(taDelHB.equals(taDelHBComp));
		assertTrue(Worksheet2.isSearchTree(taDelHB));
		assertTrue(Worksheet2.isHeightBalanced(taDelHB));
	}

	@Test
	public void testDeleteHB2() {
		Tree tbDelHB = Worksheet2.deleteHB(tb, 18);

		assertTrue(tbDelHB.equals(tbDelHBComp));
		assertTrue(Worksheet2.isSearchTree(tbDelHB));
		assertTrue(Worksheet2.isHeightBalanced(tbDelHB));
	}

	@Test(expected = IllegalStateException.class)
	public void testDeleteHB3() {
		Worksheet2.deleteHB(ta, 100);
	}

	@Test(expected = IllegalStateException.class)
	public void testDeleteHB4() {
		Worksheet2.deleteHB(tEmpty, 1);
	}

	@Test
	public void testDeleteHB5() {
		Tree tcDelHB = Worksheet2.deleteHB(tc, 5);
		Tree tcDelHBComp = new Tree(5,
				new Tree(),
				new Tree(5,
					new Tree(),
					new Tree()
				)
			);

		assertTrue(tcDelHB.equals(tcDelHBComp));
		assertTrue(Worksheet2.isSearchTree(tcDelHB));
		assertTrue(Worksheet2.isHeightBalanced(tcDelHB));
	}

	@Test
	public void testDeleteHB6() {
		Tree tdComp = new Tree(25,
				new Tree(15,
					new Tree(13),
					new Tree(20,
						new Tree(18),
						new Tree()
					)
				),
				new Tree(40,
					new Tree(35),
					new Tree(50)
				)
			);
		assertTrue(tdComp.equals(Worksheet2.deleteHB(td, 30)));
	}

}
