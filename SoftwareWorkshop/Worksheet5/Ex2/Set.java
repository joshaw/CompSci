/** Implementation of the data structure set using lists as the base type. Sets
 * do not place any importance on the order or multiplicity of the elements.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 2
 * File name : Set.java
 * @version 2013-12-08
 */
import java.util.ArrayList;

public class Set extends List {

	private boolean empty;

	/** Creates a new set with a head and tail present. Since the head and tail
	 * are explicitly defined, {@link isEmpty} will return false.
	 *
	 * @param head an integer held at the head of this set
	 * @param tail a set containing another head and tail, or the empty set to
	 * represent the end of the set.
	 */
	public Set(int head, Set tail) {
		super(head, tail);
		this.empty = false;
	}

	/** Create an instance of a set which contains nothing, ie the empty set.
	 */
	public Set() {
		this.empty = true;
	}

	public static Set empty() {
		return new Set();
	}

	/** Provides a constructor method so that sets can be created without
	 * needing to call new.
	 *
	 * @param head an integer held in the current position in the set
	 * @param tail another set
	 * @return a new set with the provided contents.
	 */
	public static Set cons(int head, Set tail) {
		return new Set(head, tail);
	}

	/** Converts a list to a set by simply copying to the contents to the
	 * equivalent data structure.
	 *
	 * @param list the list to be converted to a set
	 * @return a set containing the contents of the original list.
	 */
	public static Set toSet(List list) {
		if (list.isEmpty()) {
			return new Set();
		} else {

			/* The head can be transfered directly, the tail needs to be
			 * converted. */
			return new Set(list.getHead(), toSet(list.getTail()));
		}
	}

	/** Converts a set to an array for internal use. An array is easier to
	 * check the contents, but is more difficult to add/remove elements.
	 *
	 * The set is used since it is easy and efficient to add/remove/change
	 * values that are not at the end, since the pointers to the rest of the
	 * elements can be easily changed. The array is used for fast adding,
	 * removing and comparason operations since the data is held all in the
	 * same location in memory. For this reason, we can convert a set to an
	 * array for operations like compare since the array exists only for the
	 * time the comparason operates and is much better suited to this
	 * operation. This results in a more efficient algorithm, so faster
	 * results.
	 *
	 * @param s set to be converted
	 * @param array the array which is added to as the set is traversed.
	 * @return an ArrayList containing all the numeric elements of the original
	 * set.
	 */
	private static ArrayList<Integer> setToArray(Set s, ArrayList<Integer> array) {

		/* If the array is empty, ie the recursion has reached the empty list
		 * at the end of the set, then return the array. */
		if (s.isEmpty()) {
			return array;
		} else {

			/* If the array has in it the current head of the set, then there
			 * is no need to re-add it, so do nothing except call the method
			 * again on the rest of the set. */
			if (array.contains(s.getHead())) {
				return setToArray(Set.toSet(s.getTail()), array);

			/* Otherwise, the array does not contain the current value at head,
			 * so add it as a new element to the array and call the method
			 * again on the rest of the set. */
			} else {
				array.add(s.getHead());
				return setToArray(Set.toSet(s.getTail()), array);
			}
		}
	}

	/** Allows to check if two sets are equal, irrespective of the order or
	 * multiplicity of the elements.
	 *
	 * @param s1 the first set
	 * @param s2 the second set to compare with the first
	 * @return true if the two sets are the same, false if they differ.
	 */
	public static boolean equals(Set s1, Set s2) {

		/* If both sets are empty then they must be equal. Can't check the
		 * length since elements can be duplicated in one set and the two still
		 * be equal. */
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}

		/* Convert each of the sets to arrays so that the comparason can be
		 * done in a single step. */
		ArrayList<Integer> s1Array = setToArray(s1, new ArrayList<Integer>());
		ArrayList<Integer> s2Array = setToArray(s2, new ArrayList<Integer>());

		/* Compare the sets using the containsAll method of ArrayList. This
		 * will check that all of one array's elements are present in the
		 * other, then do the same for the other. Thus, if A member of B and B
		 * member of A, then A must equal B. */
		if (s1Array.containsAll(s2Array) && s2Array.containsAll(s1Array)) {
			return true;
		} else {
			return false;
		}
	}

	/** Compare an instance of a set to another set for equality.
	 *
	 * @param s2 the second set to compare to the current
	 * @return true if the two sets are the same, false if they differ.
	 */
	public boolean equals(Set s2) {
		return equals(s2, this);
	}

}
