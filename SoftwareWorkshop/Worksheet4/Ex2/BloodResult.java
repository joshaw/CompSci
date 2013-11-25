/** Static class for querying a list of blood test records.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 2
 * File name : BloodResult.java
 * @version 2013-11-24
 */
import java.util.ArrayList;

public class BloodResult {

	private static int highest = -1;
	private static int averageDiastolic = 0;

	/** Calculates the highest abnormal systolic and the average diastolic
	 * pressures from the list.
	 *
	 * @param bloodRecord an arrayList, each element of which is an object of
	 * type Blood.
	 */
	private static void calulateHighestAndTotal(ArrayList<Blood> bloodRecord) {
		int currentSystolic = 0;
		int totalDiastolic = 0;

		for (Blood day: bloodRecord){
			currentSystolic = day.getSystolic();

			/* Systolic pressures are only abnormal if > 140. Check this and
			 * find the highest by comaring each with the previous highest
			 * found. */
			if (currentSystolic > 140) {
				if (currentSystolic > highest) {
					highest = currentSystolic;
				}
			}

			// Keey count of total diastolic
			totalDiastolic += day.getDiastolic();
		}
		averageDiastolic = totalDiastolic / bloodRecord.size();
	}

	/** Prints the results of the blood test, with the highest systolic
	 * pressure, or a message if non were abnormal, and the average diastolic.
	 *
	 * @param bloodRecord an arrayList, each element of which is an object of
	 * type Blood.
	 */
	public static void printResult(ArrayList<Blood> bloodRecord){

		calulateHighestAndTotal(bloodRecord);

		/* If "highest" is still -1, then it has not been changed, thus there
		 * were no results greater than the abnormal limit. */
		if (highest == -1) {
			System.out.println("All measurements were normal.");
		} else {
			System.out.println("Highest Abnormal Systolic: " + highest);
		}

		System.out.println("Average diastolic pressure: " + averageDiastolic);
	}

	/** Individual method to calculate and return the highest systolic pressure
	 * from the list of tests.
	 *
	 * @param bloodRecord an arrayList, each element of which is an object of
	 * type Blood.
	 * @return the highest abnormal systolic pressure measured.
	 */
	public static int getHighestSystolic(ArrayList<Blood> bloodRecord) {
		calulateHighestAndTotal(bloodRecord);
		return highest;
	}

	/** Individual method to calculate and return the average diastolic
	 * pressure from the list of tests.
	 *
	 * @param bloodRecord an arrayList, each element of which is an object of
	 * type Blood.
	 * @return the average diastolic pressure measured.
	 */
	public static int getAverageDiastolic(ArrayList<Blood> bloodRecord) {
		calulateHighestAndTotal(bloodRecord);
		return averageDiastolic;
	}
}
