import java.util.ArrayList;

public class Powerset {

	public static void main(String[] args) {
		Set s =
			Set.cons(1, Set.cons(2, Set.cons(3, Set.cons(4, Set.empty()))));
		System.out.println(s);
		Powerset.powerset(s);
		System.out.println(power);
	}

	// public static ArrayList<Set> powerset2(Set s, ArrayList<Set> power){
	// 	if (s.isEmpty()) {
	// 		return power;
	// 	} else {
	// 		power.add(Set.toSet(s.getTail()));

	// 		return powerset(Set.toSet(s.getTail()), power);
	// 	}
	// }

	public static ArrayList<Set> power = new ArrayList<Set>();
	public static Set powerset(Set s){
		// powerset(string) {
		// 	add string to set;
		// 	for each char in string {
		// 		let substring = string excluding char,
		// 		add powerset(substring) to set
		// 	}
		// 	return set;
		// }
		System.out.println(power);
		power.add(s);
		if (s.isEmpty() || s.getTail().isEmpty()) {
			return new Set();
		} else {
			power.add(powerset(Set.toSet(s.getTail())));
			return Set.toSet(s.getTail());
		}
	}

	public static ArrayList<Set> powerSet(Set originalSet){
		ArrayList<Set> sets = new ArrayList<Set>();
		if (originalSet.isEmpty()) {
			sets.add(new Set());
			return sets;
		}
	}
	// public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    	// Set<Set<T>> sets = new HashSet<Set<T>>();
    	// if (originalSet.isEmpty()) {
    		// sets.add(new HashSet<T>());
    		// return sets;
    	// }
    	// List<T> list = new ArrayList<T>(originalSet);
    	// T head = list.get(0);
    	// Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
    	// for (Set<T> set : powerSet(rest)) {
    		// Set<T> newSet = new HashSet<T>();
    		// newSet.add(head);
    		// newSet.addAll(set);
    		// sets.add(newSet);
    		// sets.add(set);
    	// }
    	// return sets;
	// }

	// public static ArrayList<Set> powerset(Set s) {
	// 	return powerset(s, new ArrayList<Set>());
	// }
}
