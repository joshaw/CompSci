	// // Exercise 5

	// public static Tree deleteHB( Tree a, int x )
	// {
	// }
// }
/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet2
 * File name : Worksheet2.java
 * @version 2014-01-21
 */
import tree.*;

public class Worksheet2 {

	/**
	 *
	 * @param a
	 * @return
	 */
	public static boolean isHeightBalanced(Tree a) {
		int heightDiff = a.getRight().getHeight() - a.getLeft().getHeight();
		if (heightDiff > 1 || heightDiff < -1) {
			return false;
		}
		if (a.getLeft().getEmpty() || a.getRight().getEmpty()){
			return true;
		}
		return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
	}

	/**
	 *
	 * @param a
	 * @return
	 */
	private static int heightDiff(Tree a) {
		return a.getRight().getHeight() - a.getLeft().getHeight();
	}

	/**
	 *
	 * @param a
	 * @return
	 */
	public static boolean isSearchTree(Tree a) {
		if (a.getEmpty()) {
			return true;
		}

		if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
			return true;
		}

		if (a.getLeft().getEmpty() && a.getValue() < a.getRight().getValue()) {
			return isSearchTree(a.getRight());
		}

		if (a.getRight().getEmpty() && a.getLeft().getValue() < a.getValue()) {
			return isSearchTree(a.getLeft());
		}

		if (a.getValue() < a.getRight().getValue()
				&& a.getValue() > a.getLeft().getValue()) {
			return isSearchTree(a.getLeft())
				&& isSearchTree(a.getRight());
		}

		return false;

	}

	/**
	 *
	 * @param n
	 * @param a
	 * @return
	 */
	public static Tree insertHB(int n, Tree a) {
		if (a.getEmpty()) {
			return new Tree(n, new Tree(), new Tree());
		} else if (n <= a.getValue()) {
			Tree newTree =
				new Tree(a.getValue(), insertHB(n, a.getLeft()), a.getRight());

			newTree = balanceTree(newTree);

			return newTree;

		} else {
			Tree newTree =
				new Tree(a.getValue(), a.getLeft(), insertHB(n, a.getRight()));

			newTree = balanceTree(newTree);
	/** Deletes a value from a balanced search tree ensuring that the new tree
	 * is also balanced.
	 *
	 * @param a tree to delete value from.
	 * @param x value to be deleted.
	 * @return new balanced search tree without the deleted value.
	 */
	public static Tree deleteHB(Tree a, int x) {
		return deleteHB(a, x, new Tree());
	}

	/** Deletes a value from a balanced search tree ensuring that the new tree
	 * is also balanced.
	 *
	 * @param a tree to delete value from.
	 * @param x value to be deleted.
	 * @param newTree copy of the new tree that is added to to make a copy of
	 * the original without the deleted value.
	 * @return new balanced search tree without the deleted value.
	 */
	public static Tree deleteHB(Tree a, int x, Tree newTree) {
		if (a.getEmpty()) {
			throw new IllegalStateException("Value, " + x + ", not in tree");

		} else if (x < a.getValue()) {
			Tree tmpTree = new Tree(a.getValue(),
					deleteHB(a.getLeft(), x, newTree), a.getRight());
			return balanceTree(tmpTree);

		} else if (x > a.getValue()) {
			Tree tmpTree = new Tree(a.getValue(),
					a.getLeft(), deleteHB(a.getRight(), x, newTree));
			return balanceTree(tmpTree);

		} else { // n == a.getValue()
			if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {

				// Just delete the node since it is a leaf
				return new Tree();
			} else if (a.getLeft().getEmpty()) {

				// Make child node the new root
				return a.getRight();
			} else if (a.getRight().getEmpty()) {

				// Make child node the new root
				return a.getLeft();
			} else {

				// Largest child from left subtree becomes new root.
				int maxFromSub = max(a.getLeft());
				Tree tmpTree = new Tree(maxFromSub,
						deleteHB(a.getLeft(), maxFromSub, new Tree()),
						a.getRight());
				return balanceTree(tmpTree);
			}
		}
	}

	/**
	 *
	 * @param a
	 * @return
	 */
	private static Tree balanceTree(Tree a) {
		if (heightDiff(a) < -1) {
			if (heightDiff(a.getLeft()) < -1) {
				a = LL(a);
			} else {
				a = LR(a);
			}
		} else if (heightDiff(a) > 1) {
			if (heightDiff(a.getRight()) > 1) {
				a = RR(a);
			} else {
				a = RL(a);
			}
		}

		return a;
	}

	/** Perform a left-left rotation on a tree. Only works on trees that have a
	 * height greater than 1. Used for balancing height balanced trees.
	 *
	 * @param t tree to be rotated.
	 */
	private static Tree LL(Tree t) {
		int a = t.getValue();
		int l = t.getLeft().getValue();
		Tree A = t.getLeft().getLeft();
		Tree B = t.getLeft().getRight();
		Tree C = t.getRight();

		return new Tree(l, A, new Tree(a, B, C));
	}

	/**
	 *
	 * @param t
	 */
	private static Tree RR(Tree t) {
		int a = t.getValue();
		int l = t.getRight().getValue();
		Tree A = t.getRight().getRight();
		Tree B = t.getRight().getLeft();
		Tree C = t.getLeft();

		return new Tree(l, new Tree(a, C, B), A);
	}

	/**
	 *
	 * @param t
	 */
	private static Tree LR(Tree t) {
		int a = t.getValue();
		int l = t.getLeft().getValue();
		int c = t.getLeft().getRight().getValue();
		Tree A = t.getLeft().getLeft();
		Tree B1 = t.getLeft().getRight().getLeft();
		Tree B2 = t.getLeft().getRight().getRight();
		Tree C = t.getRight();

		return new Tree(c, new Tree(l, A, B1), new Tree(a, B2, C));
	}

	/**
	 *
	 * @param t
	 */
	private static Tree RL(Tree t) {
		int a = t.getValue();
		int l = t.getRight().getValue();
		int c = t.getRight().getLeft().getValue();
		Tree A = t.getRight().getRight();
		Tree B1 = t.getRight().getLeft().getRight();
		Tree B2 = t.getRight().getLeft().getLeft();
		Tree C = t.getLeft();

		return new Tree(c, new Tree(a, C, B2), new Tree(l, B1, A));
	}

	/** Returns the maximum element from a sorted binary tree.
	 *
	 * @param a tree to return the max element from.
	 * @return the maximum element.
	 */
	public static int max(Tree a) {
		if (a.getEmpty()) {

			// There are no elements to find the max of.
			throw new IllegalStateException("tree has no elements.");

		} else if (a.getRight().getEmpty()) {

			// If there is nothing to the right, this must be the largest.
			return a.getValue();

		} else {

			// Otherwise find the largest elements on the right side.
			return max(a.getRight());
		}
	}

}
