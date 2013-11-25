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

	public Blood(int systolic, int diastolic, Day dayMeasured) {
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.dayMeasured = dayMeasured;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDayMeasured(Day dayMeasured) {
		this.dayMeasured = dayMeasured;
	}

	public Day getDayMeasured() {
		return dayMeasured;
	}

}
