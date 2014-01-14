/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet1
 * File name : worksheet1.java
 * @version 2014-01-14
 */
public class Worksheet1 {

	public static boolean allPositive(List a) {
		if (a.isEmpty()) { return true; }

		if (a.getHead() < 0) {
			return false;
		} else {
			return allPositive(a.getTail());
		}

	}

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

	public static List merge(List a, List b) {
		if (a.isEmpty()) {
			return b;
		}
		if (b.isEmpty()) {
			return a;
		}

		return merge(a, b, new List());
	}

	public static List merge(List a, List b, List merged) {
		if (a.getHead().isEmpty()) {
			
		}
		int aHead = a.getHead();
		int bHead = b.getHead();

		if (aHead < bHead) {
			merge(a.getTail(), b, new List(aHead, merged));
		} else {
			merge(a, b.getTail(), new List(bHead, merged));
		}

		return merged;
	}
}
