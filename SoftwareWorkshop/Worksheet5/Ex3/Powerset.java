import java.util.ArrayList;

public class Powerset extends Set {

	public static void main(String[] args) {
		Set s =
			Set.cons(1, Set.cons(2, Set.cons(3, Set.cons(4, Set.empty()))));
		System.out.println(s);
		System.out.println(Powerset.powerSet(s));

		Set r =
			Set.cons(1, Set.cons(2, Set.cons(3, Set.cons(4, Set.empty()))));
		System.out.println(r);

	}

	// public static ArrayList<Set> powerset2(Set s, ArrayList<Set> power){
	// 	if (s.isEmpty()) {
	// 		return power;
	// 	} else {
	// 		power.add(Set.toSet(s.getTail()));

	// 		return powerset(Set.toSet(s.getTail()), power);
	// 	}
	// }

	// public static ArrayList<Set> power = new ArrayList<Set>();
	// public static Set powerset(Set s){
	// 	System.out.println(power);
	// 	power.add(s);
	// 	if (s.isEmpty() || s.getTail().isEmpty()) {
	// 		return new Set();
	// 	} else {
	// 		power.add(powerset(Set.toSet(s.getTail())));
	// 		return Set.toSet(s.getTail());
	// 	}
	// }

	public static ArrayList<Set> powerSet(Set originalSet, ArrayList<Set> sets){
		if (originalSet.isEmpty()) {
			sets.add(new Set());
			return sets;
		} else if (originalSet.getTail().isEmpty()){
			sets.add(new Set(originalSet.getHead(), Set.empty()));
			return sets;
		} else {
			sets.add(new Set(originalSet.getHead(), Set.empty()));
			return powerSet(Set.toSet(originalSet.getTail()), sets);
		}
	}

	public static ArrayList<Set> powerSet(Set originalSet){
		return powerSet(originalSet, new ArrayList<Set>());
	}
}
