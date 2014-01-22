	// // Exercise 3

	// public static boolean isSearchTree( Tree a )
	// {
	// }

	// // Exercise 4

	// public static Tree insertHB(int n, Tree t)
	// {
	// }

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

	private static int heightDiff(Tree a) {
		return a.getRight().getHeight() - a.getLeft().getHeight();
	}

	// static boolean isSearchTree(Tree a) {
	// 	return isSearchTree(a, false);
	// }

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

	public static Tree insertHB(int n, Tree a) {
		if (a.getEmpty()) {
			return new Tree(n, new Tree(), new Tree());
		} else if (n <= a.getValue()) {
			Tree newTree =
				new Tree(a.getValue(), insertHB(n, a.getLeft()), a.getRight());

			newTree = sortHeightDifferences(newTree);

			return newTree;

		} else {
			Tree newTree =
				new Tree(a.getValue(), a.getLeft(), insertHB(n, a.getRight()));

			newTree = sortHeightDifferences(newTree);

			return newTree;
		}
	}

	private static Tree sortHeightDifferences(Tree a) {
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

	private static Tree LL(Tree t) {
		int a = t.getValue();
		int l = t.getLeft().getValue();
		Tree A = t.getLeft().getLeft();
		Tree B = t.getLeft().getRight();
		Tree C = t.getRight();

		return new Tree(l, A, new Tree(a, B, C));
	}

	private static Tree RR(Tree t) {
		int a = t.getValue();
		int l = t.getRight().getValue();
		Tree A = t.getRight().getRight();
		Tree B = t.getRight().getLeft();
		Tree C = t.getLeft();

		return new Tree(l, new Tree(a, C, B), A);
	}

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
}
