/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : StudentTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

	public static void main(String[] args) {
		UGstudent a = new UGstudent("Person Number1");
		System.out.println(a);

		a.addAssessment("inclass", 20, 78);
		a.addAssessment("exercise", 5, 70);
		a.addAssessment("exercise", 15, 90);
		a.addAssessment("exercise", 15, 30);
		a.addAssessment("final", 45, 66);

		System.out.println(a);

		System.out.println("Final mark: " + a.finalMark());
		System.out.println("Has passed? " + a.hasPassed());

		System.out.println("\n");

		MSCstudent b = new MSCstudent("Person Number2");

		b.addAssessment("inclass", 20, 48);
		b.addAssessment("exercise", 5, 64);
		b.addAssessment("exercise", 15, 63);
		b.addAssessment("final", 60, 46);

		System.out.println(b);

		b.changeMark(2, 70);
		System.out.println(b);

		b.removeAssessment(1);
		System.out.println(b);

		System.out.println("Final mark: " + b.finalMark());
		System.out.println("Has passed? " + b.hasPassed());
	}

	@Test
	public void test1() {
	}
}
