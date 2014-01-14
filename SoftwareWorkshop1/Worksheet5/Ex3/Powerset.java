import java.util.ArrayList;

public class Powerset extends Set {

	public static void main(String[] args) {
		Set s =
			Set.cons(1, Set.cons(2, Set.cons(3, Set.empty())));
		System.out.println(s);
		Powerset.powerSet(s);
		System.out.println();
		// System.out.println(Powerset.powerSet(s));

		Set r =
			Set.cons(1, Set.cons(2, Set.cons(3, Set.cons(4, Set.empty()))));
		// System.out.println(r);

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

			// System.out.println(1);
			sets.add(new Set());
			System.out.print("[], ");
			return sets;

		} else if (originalSet.getTail().isEmpty()){

			// System.out.println(2);
			sets.add(new Set(originalSet.getHead(), Set.empty()));
			System.out.print(originalSet.getHead() + ", ");
			return powerSet(Set.toSet(originalSet.getTail()), sets);

		} else {

			// System.out.println(3);
			sets.add(new Set(originalSet.getHead(), Set.empty()));
			Set temp = new Set();
			for (Set x: sets ) {
				temp = new Set(originalSet.getTail().getHead(), x);
			}
			System.out.print(temp + ", " + originalSet.getHead() + ", ");
			return powerSet(Set.toSet(originalSet.getTail()), sets);
		}
	}

	public static ArrayList<Set> powerSet(Set originalSet){
		return powerSet(originalSet, new ArrayList<Set>());
	}
}
