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

	private int[] array;
	private boolean verbose = false;
	private int count = 0;

	public Bubble(int [] array){
		this.array = array;
	}

	/** Method to sort an integer array using the Bubble sort algorithm
	 *
	 * @param verbose if true, prints out each step of the sort for inspection.
	 * @return a sorted integer array, ascending from smallest to largest.
	 */
	public int[] sort(boolean verbose){
		boolean sorted = false;
		boolean flip;

		// The size of the array that we are working with.
		int n = array.length;

		do{
			// Print the steps involved in sorting if asked
			if (verbose) {
				System.out.println(this.toString());
			}

			flip = false;

			// For each element, up to the second to last, check if it and its
			// neighbour (the next element in the array) are in the correct
			// order, ie if it is smaller than its neighbour, then don't do
			// anything, else, using a temporary variable, swap them
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

		// Do this while there are still flips being made.
		}while(!sorted);

		return array;
	}

	/** Method to sort an integer array using the Bubble sort algorithm.
	 * Default use is with verbose off.
	 *
	 * @return a sorted integer array, ascending from smallest to largest.
	 */
	public int[] sort(){
		return sort(verbose);
	}

	/**
	 * @return the number of rounds required to sort the array. 0 if the array
	 * has not yet been sorted.
	 */
	public int getSortCount(){
		return count;
	}

	/** toString defines how to print a Bubble array.
	 * @return the print type of a Bubble array
	 */
	@Override
	public String toString(){
		String output = "[";
		for (int i = 0; i < array.length-1; i++) {
			output += array[i] + ",";
		}
		output += array[array.length-1] + "]";
		return output;
	}

}
