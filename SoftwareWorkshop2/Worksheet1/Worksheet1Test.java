public class Worksheet1Test {

	public static void main(String[] args) {

		List a = new List(2, new List(3, new List(4, new List())));
		List b = new List(2, new List(-3, new List(4, new List())));

		System.out.println("allPositive");
		System.out.println(Worksheet1.allPositive(a));
		System.out.println(Worksheet1.allPositive(b));

		System.out.println("\nsorted");
		System.out.println(Worksheet1.sorted(a));
		System.out.println(Worksheet1.sorted(b));

		System.out.println("\nmerge");
		System.out.println(a);
		System.out.println(b);
		System.out.println(Worksheet1.merge(a, b));
	}

}
