package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Uday Reddy
 * @version 2014-01-14 based on version of 2012
 *
 * Tree class defines a recursive type called Tree (for Binary Trees),
 * and provides constructor and getter methods.
 *
 * The original Tree class is modified here with an additional field
 * `height' for facilitating efficient height-balanced operations.
 */
public class Tree {

	/**
	 * Tree class defines a recursive type called Tree, and provides
	 * constructor and accessor methods.
	 */

	protected final boolean empty;
	protected final int value;
	protected final Tree left, right;

	protected final int height;

	/**
	 * Creates a new Tree with root value and left and right
	 * subtrees.
	 */
	public Tree(int value, Tree left, Tree right) {
		this.empty = false;
		this.value = value;
		this.left = left;
		this.right = right;

		int maxHeight = Math.max(
				left.getHeight(), right.getHeight());
		this.height = maxHeight + 1;
	}

	/**
	 * Creates an empty tree
	 */
	public Tree() {
		this.empty = true;
		this.value = 0;
		this.left = null;
		this.right = null;
		this.height = -1;
	}

	/**
	 * Creates a tree with a single leaf node
	 */

	public Tree(int x) {
		this.empty = false;
		this.value = x;
		this.left = new Tree();
		this.right = new Tree();
		this.height = 0;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * returns true if this tree is empty (eg nil)
	 */
	public boolean getEmpty() {
		return empty;
	}

	/**
	 * gets the root value of this tree
	 */
	public int getValue() {
		if (empty) {
			throw new IllegalStateException(
					"Trying to access root of an empty tree");
		}
		return value;
	}

	/**
	 * gets the left subtree of this node
	 */
	public Tree getLeft() {
		if (empty) {
			throw new IllegalStateException(
					"Trying to access subtree of an empty tree");
		}
		return left;
	}

	/**
	 * gets the right subtree of this node
	 */
	public Tree getRight() {
		if (empty) {
			throw new IllegalStateException(
					"Trying to access subtree of an empty tree");
		}
		return right;
	}

	/**
	 * Creates a multi-line String that represents this Tree. The
	 * format looks like this
	 <code>
	 10
	 |
	 |- 14
	 |   |
	 |   |- 17
	 |   |
	 |   |- 13
	 |       |
	 |       | - [nil]
	 |       |
	 |       |- 12
	 |
	 |- 6
	 </code>
	 * Where the bottom child is the left sub tree and the top child
	 * is the right sub tree.  If both children are nil or the empty
	 * tree then they will not be printed. If only one child is nil
	 * then both children are printed to so it can be known which was
	 * the right child and which was the left child.
	 * @param tree The tree, which may not be null
	 * @return A string containing the formatted tree
	 */
	@Override public String toString() {
		return format(this);
	}

	/**
	 * source (with modifications) http://www.connorgarvey.com/blog/?p=82
	 * Print a formatted representation of the given tree. The format
	 * looks like this
	 <code>
	 10
	 |
	 |- 14
	 |   |
	 |   |- 17
	 |   |
	 |   |- 13
	 |       |
	 |       | - [nil]
	 |       |
	 |       |- 12
	 |
	 |- 6
	 </code>
	 * Where the bottom child is the left sub tree and the top child
	 * is the right sub tree.  If both children are nil or the empty
	 * tree then they will not be printed. If only one child is nil
	 * then both children are printed to so it can be known which was
	 * the right child and which was the left child.
	 * @param tree The tree, which may not be null
	 * @return A string containing the formatted tree
	 */
	public static void print(Tree tree) {
		System.out.print(format(tree));
	}

	public static String format(Tree tree) {
		final StringBuilder buffer = new StringBuilder();
		return formatTreeHelper(tree, buffer,
				new LinkedList<Iterator<Tree>>()).toString();
	}

	private static String formatTreeDrawLines(
			java.util.List<Iterator<Tree>> parentIterators,
			boolean amLast) {

		StringBuilder result = new StringBuilder();
		Iterator<Iterator<Tree>> it = parentIterators.iterator();
		while (it.hasNext()) {

			Iterator<Tree> anIt = it.next();
			if (anIt.hasNext() || (!it.hasNext() && amLast)) {
				result.append("   |");
			} else {
				result.append("    ");
			}
		}
		return result.toString();
	}

	private static StringBuilder formatTreeHelper(
			Tree t, StringBuilder buffer,
			java.util.List<Iterator<Tree>> parentIterators) {

		if (!parentIterators.isEmpty()) {
			boolean amLast =
				!parentIterators.get(parentIterators.size() - 1).hasNext();
			String lines = formatTreeDrawLines(parentIterators, amLast);
			buffer.append("\n").append(lines).append("\n").
				append(lines).append("- ");
		}

		if (t.getEmpty()) {
			buffer.append("[nil]");
			return buffer;
		} else {
			buffer.append(t.getValue());
		}

		if (!(t.getLeft().getEmpty() && t.getRight().getEmpty())) {

			Iterator<Tree> it = getChildrenIterator(t);
			parentIterators.add(it);

			while (it.hasNext()) {
				Tree child = it.next();
				formatTreeHelper(child, buffer, parentIterators);
			}
			parentIterators.remove(it);
		}
		return buffer;
	}

	private static Iterator<Tree> getChildrenIterator(Tree t) {
		if (t.getEmpty()) {
			return Collections.<Tree>emptyList().iterator();
		} else {
			return Arrays.asList(new Tree[] {
				t.getRight(), t.getLeft()}).iterator();
		}
	}

	@Override
	public boolean equals(Object o) {
		Tree t = (Tree) o;
		if (this.empty) {
			return t.empty;
		} else {
			return !t.empty && this.value == t.value &&
				this.left.equals(t.left) && this.right.equals(t.right);
		}
	}

}
