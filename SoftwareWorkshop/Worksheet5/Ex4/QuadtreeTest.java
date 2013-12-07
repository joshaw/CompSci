/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 4
 * File name : QuadtreeTest.java
 * @version 2013-12-07
 */
public class QuadtreeTest {
	public static void main(String[] args) {

		/* Create a Quadtree as described on the sheet. */
		Quadtree qt0 = new Quadtree(0);
		Quadtree qt10 = new Quadtree(10);
		Quadtree qt20 = new Quadtree(20);
		Quadtree qt30 = new Quadtree(30);
		Quadtree qt40 = new Quadtree(40);
		Quadtree qt50 = new Quadtree(50);
		Quadtree qt60 = new Quadtree(60);
		Quadtree qt70 = new Quadtree(70);
		Quadtree qt80 = new Quadtree(80);
		Quadtree qt90 = new Quadtree(90);
		Quadtree qt100 = new Quadtree(100);
		Quadtree qt110 = new Quadtree(110);
		Quadtree qt120 = new Quadtree(120);

		Quadtree qtBig1 = new Quadtree(qt110, qt100, qt120, qt90);
		Quadtree qtBig2 = new Quadtree(qt60, qtBig1, qt70, qt80);
		Quadtree qtBig3 = new Quadtree(qt50, qt40, qtBig2, qt30);

		Quadtree qtBig = new Quadtree(qt0, qtBig3, qt10, qt20);
		/* End Creation. */

		System.out.println("Orig: " + qtBig);

		// qtBig.rot("clock");
		Quadtree.rot(qtBig, "clock");

		// System.out.println("Rot : " + qtBig.rot("clock"));
		System.out.println("New : " + qtBig);

		// System.out.println(qtBig.rot("clock"));
	}
}
