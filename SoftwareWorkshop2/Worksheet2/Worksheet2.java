/** Methods for working with AVL height balanced trees, ie trees which follow
 * the format leftValue < rootValue < rightValue.
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
	 * @param a tree to check for height balanced-ness.
	 * @return true if tree is balanced.
	 */
	public static boolean isHeightBalanced(Tree a) {

		// Difference in height between two subtrees of this root.
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
		if (a.getEmpty()) return 0;

		return a.getRight().getHeight() - a.getLeft().getHeight();
	}

	/** Returns true if the given tree is a search tree, ie each value to the
	 * right is greater and each value to the left is less than the current
	 * value for every node in the tree.
	 *
	 * @param a tree to check.
	 * @return true if the tree is a search tree.
	 */
/*	public static boolean isSearchTree(Tree a) {
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
	} */
	public static boolean isSearchTree(Tree a) {

		/* Traverse the tree in order and add to a List. If this list is
		 * sorted, the tree must be a search tree.*/
		List elements = TreeOps.inorder(a);
		return isSortedList(elements);
	}

	/** Returns true if a list is sorted. Used to check if a tree converted to
	 * a list by in-order tranversal is a search tree.
	 *
	 * @param elements list to check for sortedness
	 * @return true if the list is sorted.
	 */
	private static boolean isSortedList(List elements) {

		// Is empty or only contains a single value.
		if (elements.isEmpty() || elements.getTail().isEmpty()) {
			return true;
		}

		if (elements.getHead() <= elements.getTail().getHead()) {
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
		}

		// New Value needs to go to the left
		if (n <= a.getValue()) {
			Tree newTree =
				new Tree(a.getValue(), insertHB(n, a.getLeft()), a.getRight());
			return balanceTree(newTree);
		}

		// New Value needs to go to the right
		// n >= a.getValue()
		Tree newTree =
			new Tree(a.getValue(), a.getLeft(), insertHB(n, a.getRight()));
		return balanceTree(newTree);
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

		// Empty tree cannot have any value removed
		if (a.getEmpty()) {
			throw new IllegalStateException("Value, " + x + ", not in tree");
		}

		// Value to be removed must be in left subtree
		if (x < a.getValue()) {
			Tree tmpTree = new Tree(a.getValue(),
					deleteHB(a.getLeft(), x, newTree), a.getRight());
			return balanceTree(tmpTree);
		}

		// Value to be removed must be in right subtree
		if (x > a.getValue()) {
			Tree tmpTree = new Tree(a.getValue(),
					a.getLeft(), deleteHB(a.getRight(), x, newTree));
			return balanceTree(tmpTree);
		}

		// We've found the value to be removed, n == a.getValue()

		// Just delete the node since it is a leaf
		if (a.getLeft().getEmpty() && a.getRight().getEmpty())
			return new Tree();

		// Make right child node the new root
		if (a.getLeft().getEmpty()) return a.getRight();

		// Make left child node the new root
		if (a.getRight().getEmpty()) return a.getLeft();

		// Largest child from left subtree becomes new root.
		int maxFromSub = max(a.getLeft());
		Tree leftBalanced = deleteHB(a.getLeft(), maxFromSub);
		// System.out.println(leftBalanced);
		// System.out.println("Balance " + balanceTree(leftBalanced));

		Tree tmpTree = new Tree(maxFromSub,
				leftBalanced,
				a.getRight());
		return balanceTree(tmpTree);
	}

	/** Balances a tree by performing a rotation. Only works when the tree is
	 * unbalanced by max of 1.
	 *
	 * @param a tree to balance.
	 * @return new tree which is balanced
	 */
	public static Tree balanceTree(Tree a) {

		// Left subtree is too tall
		if (heightDiff(a) < -1) {

			// Single rotation needed
			if (heightDiff(a.getLeft()) < 0) return LL(a);

			// Double rotation needed
			if (heightDiff(a.getLeft()) > 0) return LR(a);
		}

		// Right subtree is too tall
		if (heightDiff(a) > 1) {

			// Single rotation needed
			if (heightDiff(a.getRight()) > 0) return RR(a);

			// Double rotation needed
			if (heightDiff(a.getRight()) < 0) return RL(a);
		}

		// Tree is balanced
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

		// There are no elements to find the max of.
		if (a.getEmpty()) {
			throw new IllegalStateException("tree has no elements.");
		}

		// If there is nothing to the right, this must be the largest.
		if (a.getRight().getEmpty()) {
			return a.getValue();
		}

		// Otherwise find the largest elements on the right side.
		return max(a.getRight());
	}

}
