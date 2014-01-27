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
import list.*;

public class Worksheet2 {

	/** Returns true if a tree is AVL height balanced.
	 *
	 * @param a tree to check.
	 * @return true if tree is balanced.
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

	/** Calculates the height difference of a tree from the current node.
	 * Calculated as (height of right subtree) - (height of left subtree).
	 *
	 * @param a tree to compare.
	 * @return integer height difference of the tree.
	 */
	private static int heightDiff(Tree a) {
		return a.getRight().getHeight() - a.getLeft().getHeight();
	}

	/** Returns true if the given tree is a search tree, ie each value to the
	 * right is greater and each value to the left is less than the current
	 * value for every node in the tree.
	 *
	 * @param a tree to check.
	 * @return true if the tree is a search tree.
	 */
	// public static boolean isSearchTree(Tree a) {
	// 	if (a.getEmpty()) {
	// 		return true;
	// 	}

	// 	if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
	// 		return true;
	// 	}

	// 	if (a.getLeft().getEmpty() && a.getValue() < a.getRight().getValue()) {
	// 		return isSearchTree(a.getRight());
	// 	}

	// 	if (a.getRight().getEmpty() && a.getLeft().getValue() < a.getValue()) {
	// 		return isSearchTree(a.getLeft());
	// 	}

	// 	if (a.getValue() < a.getRight().getValue()
	// 			&& a.getValue() > a.getLeft().getValue()) {
	// 		return isSearchTree(a.getLeft())
	// 			&& isSearchTree(a.getRight());
	// 	}

	// 	return false;
	// }

	public static boolean isSearchTree(Tree a) {
		List elements = TreeOps.inorder(a);
		return isSortedList(elements);
	}

	private static boolean isSortedList(List elements) {
		if (elements.isEmpty() || elements.getTail().isEmpty()) {
			return true;
		}
		if (elements.getHead() < elements.getTail().getHead()) {
			return isSortedList(elements.getTail());
		}
		return false;
	}

	/** Inserts a new value into a balanced search tree and ensures that the
	 * new tree is also balanced.
	 *
	 * @param n value to be added.
	 * @param a tree to add value to.
	 * @return new balanced search tree with the new value.
	 */
	public static Tree insertHB(int n, Tree a) {
		if (a.getEmpty()) {
			return new Tree(n, new Tree(), new Tree());
		} else if (n <= a.getValue()) {
			Tree newTree =
				new Tree(a.getValue(), insertHB(n, a.getLeft()), a.getRight());

			return balanceTree(newTree);

		} else {
			Tree newTree =
				new Tree(a.getValue(), a.getLeft(), insertHB(n, a.getRight()));

			return balanceTree(newTree);
		}
	}

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

	/** Balances a tree by performing a rotation. Only works when the tree is
	 * unbalanced by max of 1.
	 *
	 * @param a tree to balance.
	 * @return new tree which is balanced
	 */
	private static Tree balanceTree(Tree a) {
		if (heightDiff(a) < -1) {
			if (heightDiff(a.getLeft()) < 0) {
				a = LL(a);
			} else if (heightDiff(a.getLeft()) > 0) {
				a = LR(a);
			}
		} else if (heightDiff(a) > 1) {
			if (heightDiff(a.getRight()) > 0) {
				a = RR(a);
			} else if (heightDiff(a.getRight()) < 0) {
				a = RL(a);
			}
		}

		return a;
	}

	/** Perform a left-left rotation on a tree. Only works on trees that have a
	 * height greater than 1. Used for balancing height balanced trees.
	 *
	 * @param t tree to be rotated.
	 * @return rotated tree
	 */
	private static Tree LL(Tree t) {
		int a = t.getValue();
		int l = t.getLeft().getValue();
		Tree A = t.getLeft().getLeft();
		Tree B = t.getLeft().getRight();
		Tree C = t.getRight();

		return new Tree(l, A, new Tree(a, B, C));
	}

	/** Perform a right-right rotation on a tree. Only works on trees that have
	 * a height greater than 1. Used for balancing height balanced trees.
	 *
	 * @param t tree to be rotated.
	 * @return rotated tree
	 */
	private static Tree RR(Tree t) {
		int a = t.getValue();
		int l = t.getRight().getValue();
		Tree A = t.getRight().getRight();
		Tree B = t.getRight().getLeft();
		Tree C = t.getLeft();

		return new Tree(l, new Tree(a, C, B), A);
	}

	/** Perform a left-right rotation on a tree. Only works on trees that have
	 * a height greater than 1. Used for balancing height balanced trees.
	 *
	 * @param t tree to be rotated.
	 * @return rotated tree
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

	/** Perform a right-left rotation on a tree. Only works on trees that have
	 * a height greater than 1. Used for balancing height balanced trees.
	 *
	 * @param t tree to be rotated.
	 * @return rotated tree
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
