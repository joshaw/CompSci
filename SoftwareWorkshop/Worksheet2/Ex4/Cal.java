public class Cal {
	public static void main(String[] args) {
		short max = 31;
		short first = 0;

		if (args.length == 2) {
			max = Short.parseShort(args[0]);
			first = Short.parseShort(args[1]);
		}

		if (first > 6) {
			System.out.println("Error, first day of the month is too large");
			System.exit(1);
		}

		String[] days = {" Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};

		for (String day:days) {
			System.out.print(day + " ");
		}
		System.out.println();

		for (int i=1; i<=max+first; i++) {
			int j = i - first;
			if (j < 1) {
				System.out.print("   ");
			}else{
				System.out.printf("%3s", j);
				if (i%7==0) {
					System.out.println();
				}
			}
		}
		System.out.println();
	}
}
