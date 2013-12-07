import java.util.ArrayList;

public class Set extends List {

	private boolean empty;

	public Set(int head, Set tail) {
		super(head, tail);
		this.empty = false;
	}

	public Set() {
		this.empty = true;
	}

	public static Set cons(int head, Set tail) {
		return new Set(head, tail);
	}

	public static Set empty() {
		return new Set();
	}

	public static Set toSet(List list) {
		if (list.isEmpty()) {
			return new Set();
		} else {
			return new Set(list.getHead(), toSet(list.getTail()));
		}
	}

	private static ArrayList<Integer> setToArray(Set s, ArrayList<Integer> array) {
		if (s.isEmpty()) {
			return array;
		} else {
			if (array.contains(s.getHead())) {
				return setToArray(Set.toSet(s.getTail()), array);
			} else {
				array.add(s.getHead());
				return setToArray(Set.toSet(s.getTail()), array);
			}
		}
	}

	public static boolean equals(Set s1, Set s2) {
		ArrayList<Integer> s1Array = setToArray(s1, new ArrayList<Integer>());
		ArrayList<Integer> s2Array = setToArray(s2, new ArrayList<Integer>());

		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}

		if (s1Array.containsAll(s2Array) && s2Array.containsAll(s1Array)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equals(Set s1) {
		return equals(s1, this);
	}

}
