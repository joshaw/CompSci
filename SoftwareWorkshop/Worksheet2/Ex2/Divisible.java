public class Divisible {

	public static void main(String[] args) {

		int maximum = 300;
		int j = 0;

		for (int i = 0; i < maximum; i++) {
			if (((i%2==0) || (i%3==0) || (i%5==0)) && ((i%7!=0) || (i%11!=0))) {
				System.out.print(i + " ");
				j++;
			}
			if (j==20) {
				System.out.println();
				j = 0;
			}
		}

	}

}
