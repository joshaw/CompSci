import list.*;
import tree.*;

public class Worksheet1Test {

	public static void main(String[] args) {

		List la = new List(2, new List(3, new List(4, new List())));
		List lb = new List(2, new List(-3, new List(4, new List())));
		List lc = new List();
		List ld = new List(2, new List(5, new List(5, new List(8, new List()))));
		List le = new List(5, new List(7, new List(8, new List(9, new List()))));
		List lf = new List(2, new List(5, new List(5, new List(5, new List(7,
						new List(8, new List(8, new List(9, new List()))))))));

		System.out.println("allPositive");
		System.out.println(la + " " + Worksheet1.allPositive(la));
		System.out.println(lb + " " + Worksheet1.allPositive(lb));

		System.out.println("\nsorted");
		System.out.println(la + " " + Worksheet1.sorted(la));
		System.out.println(lb + " " + Worksheet1.sorted(lb));

		System.out.println("\nmerge");
		System.out.println(ld);
		System.out.println(le);
		System.out.println(Worksheet1.merge(ld, le));

		// System.out.println("\npreppend");
		// System.out.println(d);
		// System.out.println(e);
		// System.out.println(Worksheet1.preppend(d, e));

		// System.out.println("\nreverse");
		// System.out.println(la);
		// System.out.println(Worksheet1.reverse(la));

		System.out.println("\nremoveDuplicates");
		System.out.println(lf);
		System.out.println(Worksheet1.removeDuplicates(lf));

		Tree ta = new Tree(5,
				new Tree(3,
					new Tree(1, Tree.emptyTree, Tree.emptyTree),
					new Tree(4, Tree.emptyTree, Tree.emptyTree)
				),
				new Tree(8,
					new Tree(6, Tree.emptyTree, Tree.emptyTree),
					Tree.emptyTree
				)
			);

		System.out.println(ta);
		System.out.println(Worksheet1.mirror(ta));

		System.out.println("\nprintDescending");
		Worksheet1.printDescending(ta);

		System.out.println("\nmax");
		System.out.println(Worksheet1.max(ta));
	}

}
