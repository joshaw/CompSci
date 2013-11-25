/** Class for representing a student as well as their grades on different
 * assessments with methods for returning their final mark and whether or not
 * they have passed.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : Student.java
 * @version 2013-11-25
 */
import java.util.InputMismatchException;
import java.util.ArrayList;

public abstract class Student {

	private int passMark;
	private int mark;
	private String name;
	private ArrayList<int[]> assessments = new ArrayList<int[]>();

	public Student(String name, int passMark) {
		this.name = name;
		this.passMark = passMark;
	}

	public int getPassMark() {
		return passMark;
	}

	public String getName() {
		return name;
	}

	public ArrayList<int[]> getAssessments() {
		return assessments;
	}

	/** Allows an assessment of type "type" to be added to the student's
	 * record.
	 *
	 * @param type one of "exercise", "inclass" or "final" to specify the type
	 * of assessment it represents.
	 * @param percentage the percentage of the total mark this assessment
	 * counts for.
	 * @param mark the percentage of the full marks achieved in this assessment
	 */
	public void addAssessment(String type, int percentage, int mark) {

		/* Represent the type of assessment as an integer for storage. If the
		 * assessment is given as an integer, the other method is used where
		 * the string does not need to be parsed. */
		int typeInt = 0;
		if (type.equals("exercise")) {
			typeInt = 1;
		} else if (type.equals("inclass")) {
			typeInt = 2;
		} else if (type.equals("final")) {
			typeInt = 3;
		} else {
			throw new InputMismatchException("The provided assessment type " +
					"is not valid. Use one of \"exercise\", \"inclass\" or" +
					" \"final\".");
		}

		/* Add the provided information to the assessments array with a default
		 * "valid" value of 1 to indicate that it it valid. */
		int[] tempArray = {typeInt, percentage, mark, 1};
		assessments.add(tempArray);
	}

	/** Allows an assessment of type "type" to be added to the student's
	 * record.
	 *
	 * @param typeInt one of 1, 2 or 3, each representing a different
	 * assessment type, 1=exercise, 2=inclass, 3=final.
	 * @param percentage the percentage of the total mark this assessment
	 * counts for.
	 * @param mark the percentage of the full marks achieved in this assessment
	 */
	public void addAssessment(int typeInt, int percentage, int mark) {

		/* If the integer representation of the assessment type is incorrect,
		 * then throw an error with further information. */
		if (typeInt < 1 | typeInt > 3) {
			throw new InputMismatchException("The provided assessment type, " +
					typeInt + ", is not valid. Use one of 1 , 2 or 3.");
		}

		/* Add the provided information to the assessments array with a default
		 * "valid" value of 1 to indicate that it it valid. */
		int[] tempArray = {typeInt, percentage, mark, 1};
		assessments.add(tempArray);
	}

	/** Calculates and returns the final mark based on all of the assessments
	 * that are marked as valid.
	 * @return the final mark as a percentage calculated from all of the valid
	 * assessments added to the student's record.
	 */
	public int finalMark() {
		double tempPerc = 0;
		double totalAvailible = 0;

		checkTotalPerc();

		/* For each assessment, if it is marked as valid, keep a count of the
		 * (individual percentage) * (achieved percentage) and the (total
		 * percentage available). */
		for (int i = 0; i < assessments.size(); i++) {
			int[] test = assessments.get(i);
			if (test[3] == 1) {
				tempPerc += test[1] * test[2];
				totalAvailible += test[1];
			}
		}

		// Return the percentage achieved overall as integer
		return (int) (tempPerc / totalAvailible);
	}

	/** Returns true if the final mark is greater than the pass mark, else the
	 * student failed and false is returned.
	 *
	 * @return boolean value for pass (true) or fail (false)
	 */
	public boolean hasPassed() {
		if (finalMark() >= passMark) {
			return true;
		} else {
			return false;
		}
	}

	/** Checks if the percentage of all assessments, including those that are
	 * marked as invalid, sum to 100%.
	 */
	private void checkTotalPerc() {
		int totalPerc = 0;

		/* For each assessment, keep a count of the total percentage available.
		 * Ideally, these should sum to 100% meaning that for the whole course,
		 * all marks are available. */
		for (int j = 0; j < assessments.size(); j++) {
			totalPerc += assessments.get(j)[1];
		}

		if (totalPerc < 100) {
			System.out.println("Warning: total percentage for all " +
					"assessments do not add up to 100%. Total is currently " +
					(100-totalPerc) + " short.");
		} else if (totalPerc > 100) {
			throw new InputMismatchException(
					"The marks submitted give a total above 100%.");
		} else if (totalPerc < 0) {
			throw new InputMismatchException(
					"The marks submitted give a total below 0%.");
		}
	}

	/** Allows a mark to be able to change the mark of one of the assessments
	 *
	 * @param i the number of the assessment, starting at 0, to be changed,
	 * counting in the order that they were added to the record, same as the
	 * numbers printed in the {@link toString} method.
	 * @param newMark the new value of the mark to be stored in position i
	 */
	public void changeMark(int i, int newMark) {
		int[] test = assessments.get(i);
		int[] testNew = {test[0], test[1], newMark, 1};
		assessments.set(i, testNew);
	}

	/** Allows an assessment to be ignored when calculating the final mark. The
	 * assessment is not removed from the record, instead the "valid" tag is
	 * set to 0 (false) and so will not be included in the calculation of the
	 * total mark,
	 *
	 * @param i the number of the assessment to be ignored.
	 */
	public void ignoreAssessment(int i) {
		// assessments.remove(i);
		int[] tempAssessment = assessments.get(i);
		tempAssessment[3] = 0;
		assessments.set(i, tempAssessment);
	}

	@Override
	public String toString() {
		String tempString = name + "\n";

		for (int i = 0; i < assessments.size(); i++) {
			int[] test = assessments.get(i);
			int typeInt = test[0];
			String type;
			if (typeInt == 1) {
				type = "Exercise";
			} else if (typeInt == 2) {
				type = "In-Class";
			} else {
				type = "Final";
			}
			tempString += String.format("%s %8s: %2s %2s %s%n",
					i, type, test[1], test[2], test[3]);
		}

		return tempString;
	}

}
