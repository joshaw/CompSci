package list;

/**
 * The class Listops defines a number of static methods to work with
 * lists using the List class.
 */
public class ListOps extends List {

	/**
	 * Select and return the nth element of a list a.  Assume that the
	 * nth element exists.
	 */

	public static int select(int n, List a) {
	if (a.isEmpty())
		throw new IllegalStateException(
			  "select - list does not have enough elements.");
	else if (n == 0)
		return a.getHead();
	else
		return select(n-1, a.getTail());
	}

	/**
	 * Return the last element of list a.  Assume that theres is an element.
	 */
	public static int last(List a) {
	if (a.isEmpty())
		throw new IllegalStateException("list does not have any elements.");
	else if (a.getTail().isEmpty())
		return a.getHead();
	else
		return last(a.getTail());
	}

	/**
	 * Add an element x to the end of a list a.
	 * Return the extended list.
	 */
	public static List addToEnd(List a, int x) {
		if (a.isEmpty()) {
			return cons(x, empty());
		} else {
			return cons(a.getHead(), addToEnd(a.getTail(), x));
		}
	}

	/**
	 * Creates a List which is the result of List b appended to the
	 * end of List a
	 */
	public static List append(List a, List b) {
		if (a.isEmpty()) {
			return b;
		} else {
			return cons(a.getHead(), append(a.getTail(), b));
		}
	}

	/**
	 * addToEnd can also be defined using append without any further recursion.

	public static List addToEnd(List a, int x) {
		return append(a, cons(x, empty()));
	}

	*/

	/**
	 * A naive implementation of reversing a List. Can take quite long
	 * on large lists
	 */
	public static List naiveReverse(List a) {
		if (a.isEmpty()) {
			return empty();
		} else {
			return addToEnd(naiveReverse(a.getTail()), a.getHead());
		}
	}

	/**
	 * An efficient (tail recursive) implementation to reverse a List
	 * that uses a helper method and an accumulator
	 */
	public static List reverse(List list) {
		return reverseAccumulate(list, empty());
	}

	/**
	 * reverseAccumulate reverses the elements of the list 'original' and adds
	 * them at the front of the list 'reversed', returning the resulting list.
	 */
	private static List reverseAccumulate(List original, List reversed) {
		if (original.isEmpty()) {
			return reversed;
		} else {
			return reverseAccumulate(original.getTail(),
					 cons(original.getHead(), reversed));
		}
	}

	public static int max(List list) {
		if (list.isEmpty())
			throw new IllegalStateException("list does not have any elements.");
		else if (list.getTail().isEmpty()) {
			return list.getHead();
		} else {
			return Math.max(list.getHead(), max(list.getTail()));
		}
	}
 }
