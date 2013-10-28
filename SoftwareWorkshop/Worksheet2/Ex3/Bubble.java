/** Defines a program that will perform a Bubble sort on an array of unsorted
 * integers.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 3
 * @version 2013-11-07
 */
public class Bubble {
	public static void main(String[] args) {
		boolean sorted = false;
		boolean flip;

		int n = 100;
		int maximum = 10000;
		short count = 0;
		int[] array = new int[n];

		// Fill the array with random integers between 0 and maximum
		for (int i = 0; i < n; i++) {
			double number = Math.random() * maximum;
			array[i] = (int) number;
		}

		// Make a copy of the array "array" as "original" so that the original is
		// availible after sorting.
		int[] original = new int[n];
		System.arraycopy( array, 0, original, 0, array.length );

		int rounds = array.length;
		do{
			printArray(array);

			flip = false;
			// For each element, up to the second to last, check if it and its
			// neighbour (the next element in the array) are in the correct
			// order, ie if it is smaller than its neighbour, then don't do
			// anything, else, using a temporary variable, swap it and its
			// neighbour.
			for (int i = 0; i < n-1; i++) {
				if (array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					flip = true;
				}
			}
			// If a round through the array is made and no flips were made,
			// then the array is sorted, so stop checking.
			if (!flip) break;

			// Originally, n is the size of the array. For each round through
			// the array, the biggest number will always be placed at the end,
			// so there is no need to check it. So stop one element earlier on
			// each round. Reduces number of check needed.
			n--;

			count++;
			if(count > 100) break;

		}while(!sorted);

		System.out.println("\nPerformed " + count + " rounds.");
		System.out.print("Original: ");
		printArray(original);
		System.out.print("  Sorted: ");
		printArray(array);

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
