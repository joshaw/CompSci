package tree;

/* This class provides sample static methods for binary search trees.
 */
public class SearchTreeOps extends TreeOps {
	/* Search for n in a tree t, and return the subtree whose root is n
	 * If n does not occur in the tree, throw an exception.
	 */
	public static Tree find(int n, Tree t) {
		if (t.getEmpty())
			throw new IllegalArgumentException("Value not present in search"
					+ " tree");
		else if (n == t.getValue())
			return t;
		else if (n < t.getValue())
			return find(n, t.getLeft());
		else
			return find(n, t.getRight());
	}

	/* Insert n into a tree t in order, and return the resulting tree.
	 */
	public static Tree insert(int n, Tree t) {
		if (t.getEmpty())
			return new Tree(n, new Tree(), new Tree());
		else if (n <= t.getValue())
			return new Tree(t.getValue(), insert(n, t.getLeft()), t.getRight());
		else
			return new Tree(t.getValue(), t.getLeft(), insert(n, t.getRight()));
	}

	/**
     * Returns an ordered Tree from a given List of int.
     */

	public static Tree listToTree(list.List l) {
		if (l.isEmpty()) {
			return new Tree();
		} else {
			return insert(l.getHead(), listToTree(l.getTail()));
		}
	}

	/**
	 *  sort a list by creating a sorted tree and traversing it in inorder.
	 */

    public static list.List treeSort(list.List l) {
    	return inorder(listToTree(l));
    }

}
