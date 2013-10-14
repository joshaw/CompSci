/** Defines the class Student for holding info about a student at university
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 1
 * Exercise  : 2
 * @version 2013-10-11
 */
public class Student {
	String name, studentID, course;

	/** A simple class to hold info about a student at university
	 *
	 * @param name is the name of a student
	 * @param studentID is the university ID of a student
	 * @param course is the degree programme the student is taking
	 */
	public Student(String name, String studentID, String course){
		this.name = name;
		this.studentID = studentID;
		this.course = course;
	}

	/** toString defines how to print a computer account
	 *
	 * @return the print type of a student
	 */
	@Override
	public String toString() {
		return "[" + name + ", ID: " + studentID + ", " + course + "]";
	}

}
