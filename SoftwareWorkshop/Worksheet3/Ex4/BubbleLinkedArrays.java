/** Defines a program that will perform a Bubble sort on an array of unsorted
 * integers.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 3
 * File name : Bubble.java
 * @version 2013-11-07
 */
public class BubbleLinkedArrays extends Bubble{

	private int[] array;
	private char[] array2;
	private boolean verbose = false;
	private int count = 0;

	public BubbleLinkedArrays(int [] array, char[] array2){
		super(array);
		this.array = array;
		this.array2 = array2;
	}

	/** Method to sort an integer array using the Bubble sort algorithm
	 *
	 * @param verbose if true, prints out each step of the sort for inspection.
	 * @return a sorted integer array, ascending from smallest to largest
	 */
	public int[] sort(boolean verbose){
		boolean sorted = false;
		boolean flip;

		// The size of the array that we are working with.
		int n = array.length;

		// _Nested Loops_
		do{
			// Print the steps involved in sorting if asked
			if (verbose) {
				System.out.println(this.toString());
			}

			flip = false;

			/* For each element, up to the second to last, check if it and its
			 * neighbour (the next element in the array) are in the correct
			 * order, ie if it is larger than its neighbour, then don't do
			 * anything, else, using a temporary variable, swap them. */
			for (int i = 0; i < n-1; i++) {

				// _Conditional Expression_
				if (array[i] < array[i+1]) {

					// _Value Swap_
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;

					char temp2 = array2[i];
					array2[i] = array2[i+1];
					array2[i+1] = temp2;

					flip = true;
				}
			}
			/* If a round through the array is made and no flips were made,
			 * then the array is sorted, so stop checking.*/
			if (!flip) break;

			/* Originally, n is the size of the array. For each round through
			 * the array, the biggest number will always be placed at the end,
			 * so there is no need to check it. So stop one element earlier on
			 * each round. Reduces number of check needed.*/
			n--;

			count++;
			if(count > 100) break;

		// Do this while there are still flips being made.
		}while(!sorted);

		// _Return_
		return array;
	}

	public char[] getArray2() {
		return array2;
	}

	/** Method to sort an integer array using the Bubble sort algorithm.
	 * Default use is with verbose off.
	 *
	 * @return a sorted integer array, ascending from smallest to largest.
	 */
	public int[] sort(){
		return sort(verbose);
	}
}
