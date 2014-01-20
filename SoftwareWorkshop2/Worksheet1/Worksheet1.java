/** Methods for manipulating the List and Tree recursive data structures.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet1
 * File name : worksheet1.java
 * @version 2014-01-14
 */
import list.*;
import static list.List.empty;
import static list.List.cons;
import tree.*;
import static tree.SearchTreeOps.find;

public class Worksheet1 {

	/** Returns true iff all elements of an integer list a greater than zero.
	 * If the list is empty, then there are no non-positive elements, so
	 * vacuously true.
	 *
	 * @param a list to be checked
	 * @return true iff all elements are positive, else false.
	 */
	public static boolean allPositive(List a) {
		if (a.isEmpty()) { return true; }

		if (a.getHead() < 0) {
			return false;
		} else {
			return allPositive(a.getTail());
		}
	}

	/** Returns true iff an integer list is sorted in ascending numerical
	 * order. If the list is empty, or only has a single value, then it must be
	 * sorted.
	 *
	 * @param a list to be checked
	 * @return true iff the list is sorted, else false.
	 */
	public static boolean sorted(List a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		}

		int aHead = a.getHead();
		int bHead = a.getTail().getHead();

		if (aHead > bHead) {
			return false;
		} else {
			return sorted(a.getTail());
		}
	}

	/** Auxillary method for merging. Merges two sorted inter lists.
	 *
	 * @param a first integer list to be merged with
	 * @param b second integer list.
	 * @param merged list of integers holding the intermediate steps of the
	 * merge as it is performed.
	 * @return new sorted list with all components of inputs, maintaining any
	 * duplicates.
	 */
	public static List merge(List a, List b) {
		if (a.isEmpty()) {
			return b;
		}
		if (b.isEmpty()) {
			return a;
		}

		int aHead = a.getHead();
		int bHead = b.getHead();

		/* If the element of the first list is smaller than the second, add it
		 * to the new list and continue with it's tail and the whole of the
		 * other list, and vice versa. */
		if (aHead < bHead) {
			return new List(aHead, merge(a.getTail(), b));
		} else {
			return new List(bHead, merge(a, b.getTail()));
		}
	}

	/** Removes any duplicate elements from a sorted integer list. If the list
	 * is empty, then there are no duplicates, so the array is not changed.
	 *
	 * @param a list to have duplicates removed from.
	 * @return new list with no duplicate elements.
	 */
	public static List removeDuplicates(List a) {
		if (a.isEmpty()) {
			return a;
		}
		return list.ListOps.reverse(removeDuplicates(a, new List()));
	}

	/** Auxillary removeDuplicates method. Removes any duplicates from a sorted
	 * integer list.
	 *
	 * @param a list to have duplicates removed from.
	 * @param singles list holding the intermediate steps in the duplicate
	 * removal.
	 * @return new list with no duplicate elements.
	 */
	private static List removeDuplicates(List a, List singles) {

		/* If the tail is empty, there are no more elements to check, so return
		 * the list with this element added. */
		if (a.getTail().isEmpty()) {
			return new List(a.getHead(), singles);
		}

		int first = a.getHead();
		int second = a.getTail().getHead();

		/* If the two elements from the list are different, then add the first
		 * to the new list, the second will be checked against the next.  */
		if (first != second) {
			singles = new List(first, singles);
		}

		return removeDuplicates(a.getTail(), singles);
	}

	/** Preppends a list onto the start of another.
	 *
	 * @param a original base list
	 * @param b list to be added to the start of a
	 * @return new list containing the contents of b then the contents of a.
	 */
	public static List preppend(List a, List b) {
		if (b.isEmpty()) {
			return a;
		}
		if (a.isEmpty()) {
			return b;
		}
		return new List(b.getHead(), preppend(a, b.getTail()));
	}

//	/** Reverses the order of the elements of an integer list.
//	 *
//	 * @param a list to be reversed
//	 * @return new list which is the reverse of the original.
//	 */
//	public static List reverse(List a) {
//		return reverse(a, new List());
//	}

//	/** Auxillary reverse method. Reverses the order of the elements of a list.
//	 *
//	 * @param a list to be reversed
//	 * @param reversed list holding the intermediate steps in the reversal of
//	 * the original.
//	 * @return new list which is the reverse of the original.
//	 */
//	private static List reverse(List a, List reversed) {
//		if (a.isEmpty()) {
//			return reversed;
//		}
//		reversed = new List(a.getHead(), reversed);
//		return reverse(a.getTail(), reversed);
//	}

	/** Returns a new tree which is the mirror image of the input tree in the
	 * vertical plane. If the tree is empty, then it is the mirror image of
	 * itself.
	 *
	 * @param a the tree to be reflected
	 * @return a mirror of a.
	 */
	public static Tree mirror(Tree a) {
		if (a.getEmpty()) {
			return a;
		}
		return new Tree(a.getValue(),
				mirror(a.getRight()), mirror(a.getLeft()));
	}

	/** Print the elemens of a sorted binary tree in descending order
	 *
	 * @param a a tree of which to print the elements of.
	 */
	public static void printDescending(Tree a) {
		if (!a.getEmpty()) {
			printDescending(a.getRight());
			System.out.print(a.getValue() + " ");
			printDescending(a.getLeft());
		}
	}

	/** Returns the maximum element from an unsorted binary tree.
	 *
	 * @param a tree to return the max element from.
	 * @return the maximum element.
	 */
	public static int maxUnsorted(Tree a) {
		if (a.getEmpty()) {
			throw new IllegalStateException("tree has no elements.");
		} else if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
			return a.getValue();
		} else if (a.getLeft().getEmpty()) {
			return Math.max(a.getValue(), max(a.getRight()));
		} else if (a.getRight().getEmpty()) {
			return Math.max(a.getValue(), max(a.getLeft()));
		} else {
			return Math.max(max(a.getLeft()), max(a.getRight()));
		}
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

	/** Returns a tree which is the same as the input, but with a single value
	 * removed.
	 *
	 * @param a the tree to remove a value from
	 * @param x the value to remove from the tree
	 * @return a new tree without one copy of the value x.
	 */
	public static Tree delete(Tree a, int x) {
		return delete(a, x, new Tree());
	}

	public static Tree delete(Tree a, int x, Tree newTree) {
		if (a.getEmpty()) {
			throw new IllegalStateException("Tree does not contain " + x);
		} else if (a.getValue() == x) {
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
				return new Tree(maxFromSub,
						delete(a.getLeft(), maxFromSub, new Tree()),
						a.getRight());
			}
		} else if (x > a.getValue()) {
			return new Tree(a.getValue(),
					a.getLeft(), delete(a.getRight(), x, newTree));
		} else {
			return new Tree(a.getValue(),
					delete(a.getLeft(), x, newTree), a.getRight());
		}
	}
}
