/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 3
 * File name : BubbleTest.java
 * @version 2013-11-07
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleTest {
	public static void main(String[] args) {

		// ####################################################################
		int n = 10;

		int[] array = new int[n];
		int maximum = 100;

		// Fill the array with random integers between 0 and maximum
		for (int i = 0; i < n; i++) {
			double number = Math.random() * maximum;
			array[i] = (int) number;
		}

		// Create new Bubble instance with the random array that has been made
		Bubble a = new Bubble(array);

		// Get the original array from the object
		System.out.print("Original: ");
		System.out.println(a.toString());

		// Sort the array with verbose output
		a.sort(true);

		// Get the final sorted array from the object
		System.out.print("  Sorted: ");
		System.out.println(a.toString());

		// Get the number of rounds needed to sort the array
		System.out.println("Sorted in " + a.getSortCount() + " rounds.");

		System.out.println("\n\n");

		// ####################################################################
		// Test the sort algorithm with an almost entirely sorted array. Since
		// the smallest value is at the end of the array, the maximum number of
		// rounds is required to sort it, demonstrating the relative
		// inefficiency of the Bubble sort.
		int[] array2 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,1};

		Bubble b = new Bubble(array2);

		System.out.print("Original: ");
		System.out.println(b.toString());

		b.sort(true);

		System.out.print("  Sorted: ");
		System.out.println(b.toString());

		System.out.println("Sorted in " + b.getSortCount() + " rounds.");

		// ####################################################################
		// Test another array of larger integers and negative integers.
		int[] array3 = {3456,4567,2345,-7890};

		System.out.println("\n\n");

		Bubble c = new Bubble(array3);

		System.out.print("Original: ");
		System.out.println(c.toString());

		c.sort(true);

		System.out.print("  Sorted: ");
		System.out.println(c.toString());

		System.out.println("Sorted in " + c.getSortCount() + " rounds.");
	}

	@Test
	public void BubbleTest1(){
		int[] original = {2,4,6,8,0,2};
		int[] sorted = {0,2,2,4,6,8};
		Bubble b = new Bubble(original);
		assertArrayEquals(sorted, b.sort());
	}

	@Test
	public void BubbleTest2(){
		int[] original = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,1};
		int[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Bubble b = new Bubble(original);
		assertArrayEquals(sorted, b.sort());
	}

	@Test
	public void BubbleTest3(){
		int[] original = {3456,4567,2345,-7890};
		int[] sorted = {-7890,2345,3456,4567};
		Bubble b = new Bubble(original);
		assertArrayEquals(sorted, b.sort());
	}

}
