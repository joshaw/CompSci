/** Test class for the BloodResult class which calculates the highest
 * abnormal systolic and average diastolic pressures from a list of blood test
 * records.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 2
 * File name : BloodTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BloodTest {

	public static void main(String[] args) {
		ArrayList<Blood> mary = new ArrayList<Blood>();

		mary.add(new Blood(94, 61, new Day(2, 5, 2013)));
		mary.add(new Blood(97, 65, new Day(3, 5, 2013)));
		mary.add(new Blood(144, 99, new Day(4, 5, 2013)));
		mary.add(new Blood(123, 88, new Day(5, 5, 2013)));
		mary.add(new Blood(177, 110, new Day(6, 5, 2013)));
		mary.add(new Blood(145, 89, new Day(7, 5, 2013)));

		BloodResult.printResult(mary);
	}

	/** Create a new patient record with several blood test results
	 */
	ArrayList<Blood> mary = new ArrayList<Blood>();
	@Before
	public void makePatientRecord() {
		mary.add(new Blood(94, 61, new Day(2, 5, 2013)));
		mary.add(new Blood(97, 65, new Day(3, 5, 2013)));
		mary.add(new Blood(144, 99, new Day(4, 5, 2013)));
		mary.add(new Blood(123, 88, new Day(5, 5, 2013)));
		mary.add(new Blood(177, 110, new Day(6, 5, 2013)));
		mary.add(new Blood(145, 89, new Day(7, 5, 2013)));
	}

	/** Test the systolic and diastolic pressures held in the blood test record
	 * for the first patient.
	 */
	@Test
	public void testHighestSystolic() {
		assertEquals("Mary Sys", 177, BloodResult.getHighestSystolic(mary));
	}
	@Test
	public void testAverageDiastolic() {
		assertEquals("Mary Dia", 85, BloodResult.getAverageDiastolic(mary));
	}

	/** Create a new patient record with several blood test results
	 */
	ArrayList<Blood> john = new ArrayList<Blood>();
	@Before
	public void makePatientRecord2() {
		john.add(new Blood(94, 61, new Day(2, 5, 2013)));
		john.add(new Blood(97, 70, new Day(3, 5, 2013)));
		john.add(new Blood(114, 94, new Day(4, 5, 2013)));
		john.add(new Blood(93, 78, new Day(5, 5, 2013)));
		john.add(new Blood(117, 110, new Day(6, 5, 2013)));
		john.add(new Blood(115, 84, new Day(7, 5, 2013)));
	}

	/** Test the systolic and diastolic pressures held in the blood test record
	 * for the second patient.
	 */
	@Test
	public void testHighestSystolic2() {
		assertEquals("John Sys", 177, BloodResult.getHighestSystolic(john));
	}
	@Test
	public void testAverageDiastolic2() {
		assertEquals("John Dia", 82, BloodResult.getAverageDiastolic(john));
	}

}
