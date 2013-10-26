public class Bubble {
	public static void main(String[] args) {
		boolean sorted = false;
		boolean flip;

		int n = 10;
		short count = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			double number = Math.random() * 100;
			a[i] = (int) number;
		}
		// int[] a = {4,3,6,1,9,2};
		int[] b = new int[n];
		System.arraycopy( a, 0, b, 0, a.length );

		int rounds = a.length;
		do{

			printArray(a);

			flip = false;
			for (int i = 0; i < n-1; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					flip = true;
				}
			}
			if (!flip) break;
			n--;

			count++;
			if(count > 100) break;

		}while(!sorted);

		System.out.print("\nOriginal: ");
		printArray(b);
		System.out.print("  Sorted: ");
		printArray(a);

	}

	public static void printArray(int[] a){
			System.out.print("[");
			for (int i = 0; i < a.length-1; i++) {
				System.out.print(a[i] + ",");
			}
			System.out.print(a[a.length-1]);
			System.out.println("]");
	}
}
