/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : Student.java
 * @version 2013-11-24
 */
import java.util.InputMismatchException;
import java.util.ArrayList;

public abstract class Student {

	private int passMark;
	private int mark;
	private int finalMark;
	private String name;
	private ArrayList<int[]> assessments = new ArrayList<int[]>();

	public Student(String name, int passMark) {
		this.name = name;
		this.passMark = passMark;
	}

	public void addAssessment(String type, int percentage, int mark) {
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

		int[] tempArray = {typeInt, percentage, mark};
		assessments.add(tempArray);
	}

	public int finalMark() {
		double tempPerc = 0;
		double totalAvailible = 0;

		checkTotalPerc();

		for (int i = 0; i < assessments.size(); i++) {
			int[] test = assessments.get(i);
			tempPerc += test[1] * test[2];
			totalAvailible += test[1];
		}
		finalMark = (int) (tempPerc / totalAvailible);
		return finalMark;
	}

	public boolean hasPassed() {
		if (finalMark >= passMark) {
			return true;
		} else {
			return false;
		}
	}

	private void checkTotalPerc() {

		int totalPerc = 0;
		for (int j = 0; j < assessments.size(); j++) {
			totalPerc += assessments.get(j)[1];
		}
		if (totalPerc < 100) {
			System.out.println("Warning: total percentage for all " +
					"assessments do not add up to 100%. Total is currently " +
					(100-totalPerc) + " short.");
		}
		if (totalPerc > 100) {
			throw new InputMismatchException(
					"The marks submitted give a total above 100%.");
		} else if (totalPerc < 0) {
			throw new InputMismatchException(
					"The marks submitted give a total below 0%.");
		}

	}

	public void changeMark(int i, int newMark) {
		int[] test = assessments.get(i);
		int[] testNew = {test[0], test[1], newMark};
		assessments.set(i, testNew);
	}

	public void removeAssessment(int i) {
		assessments.remove(i);
	}

	@Override
	public String toString() {
		String tempString = name + "\n";

		for (int i = 0; i < assessments.size(); i++) {
			int typeInt = assessments.get(i)[0];
			String type;
			if (typeInt == 1) {
				type = "Exercise";
			} else if (typeInt == 2) {
				type = "In-Class";
			} else {
				type = "Final";
			}
			tempString += String.format("%s %8s: %2s, %s%n",
					i, type, assessments.get(i)[1], assessments.get(i)[2]);
		}

		return tempString;
	}

}
