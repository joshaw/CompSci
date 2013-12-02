/** Creates a representation of a blood test record. The systolic and diastolic
 * pressures and the day the measurement was taken are recorded.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 2
 * File name : Blood.java
 * @version 2013-11-22
 */
public class Blood {

	private int systolic;
	private int diastolic;
	private Day dayMeasured;

	/** Constructor for the Blood class
	 *
	 * @param systolic a record of the systolic pressure measured
	 * @param diastolic a record of the diastolic pressure measured
	 * @param dayMeasured the day the measurement was taken of type Day
	 */
	public Blood(int systolic, int diastolic, Day dayMeasured) {
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.dayMeasured = dayMeasured;
	}

	/** Allows viewing and changing of the systolic pressure for a blood test
	 * record
	 *
	 * @param systolic a record of the systolic pressure measured
	 */
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}
	public int getSystolic() {
		return systolic;
	}

	/** Allows viewing and changing of the diastolic pressure for a blood test
	 * record
	 *
	 * @param diastolic a record of the diastolic pressure measured
	 */
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}
	public int getDiastolic() {
		return diastolic;
	}

	/** Allows viewing and changing of the day that a blood test record was
	 * taken.
	 *
	 * @param dayMeasured the day the measurement was taken of type Day
	 */
	public void setDayMeasured(Day dayMeasured) {
		this.dayMeasured = dayMeasured;
	}
	public Day getDayMeasured() {
		return dayMeasured;
	}

}
