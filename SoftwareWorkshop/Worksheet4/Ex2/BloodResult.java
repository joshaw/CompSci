/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 2
 * File name : BloodResult.java
 * @version 2013-11-22
 */
import java.util.ArrayList;

public class BloodResult {

	private static int highest = -1;
	private static int averageDiastolic = 0;

	private static void calulateHighestAndTotal(ArrayList<Blood> bloodRecord) {

		int currentSystolic = 0;
		int totalDiastolic = 0;
		for (Blood day: bloodRecord){

			currentSystolic = day.getSystolic();
			if (currentSystolic > 140) {
				if (currentSystolic > highest) {
					highest = currentSystolic;
				}
			}

			totalDiastolic += day.getDiastolic();
		}
		averageDiastolic = totalDiastolic / bloodRecord.size();
	}

	public static void printResult(ArrayList<Blood> bloodRecord){

		calulateHighestAndTotal(bloodRecord);

		if (highest == -1) {
			System.out.println("All measurements were normal.");
		} else {
			System.out.println("Highest Abnormal Systolic: " + highest);
		}

		System.out.println("Average diastolic pressure: " + averageDiastolic);
	}

	public static int getHighestSystolic(ArrayList<Blood> bloodRecord) {
		calulateHighestAndTotal(bloodRecord);
		return highest;
	}

	public static int getAverageDiastolic(ArrayList<Blood> bloodRecord) {
		calulateHighestAndTotal(bloodRecord);
		return averageDiastolic;
	}
}
