package tree;
import tree.Tree;
import tree.SearchTreeOps;
import java.io.*;

public class TreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String outFile = "tree.dot";
		try {
			BufferedWriter out =
					new BufferedWriter(new FileWriter(outFile));

	/*		Tree t = new Tree (6,
					new Tree(4,
							new Tree(2,
									new Tree(1, Tree.emptyTree, Tree.emptyTree),
									Tree.emptyTree),
							new Tree(5, Tree.emptyTree, Tree.emptyTree)),
				    new Tree(8, new Tree(7, Tree.emptyTree, Tree.emptyTree),
								new Tree(9, Tree.emptyTree, Tree.emptyTree)));
*/
//			Tree t = Tree.makeCompleteTree(8);
//			System.out.println(t);

			list.List l = new list.List();
			l = list.List.cons(3, l);
			l = list.List.cons(5, l);
			l = list.List.cons(2, l);
			l = list.List.cons(7, l);
			l = list.List.cons(-6, l);
			l = list.List.cons(1, l);
			l = list.List.cons(4, l);
			l = list.List.cons(9, l);
			l = list.List.cons(12, l);

			Tree t = SearchTreeOps.emptyTree;
			t = SearchTreeOps.listToTree(l);

	     	out.write(t.toDot());
			out.close();

			list.List sortedList = SearchTreeOps.treeSort(l);

			System.out.println(sortedList);

		}
		catch (IOException e) {
			System.out.println("Could not write to file " + outFile);
		}
	}
}
