/** Test class for the Student super-class and the UG and MSC sub-classes
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : StudentTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import org.junit.Before;
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
		System.out.println("Final mark: " + b.finalMark());
		System.out.println("Has passed? " + b.hasPassed());

		b.changeMark(2, 85);
		System.out.println(b);
		System.out.println("Final mark: " + b.finalMark());
		System.out.println("Has passed? " + b.hasPassed());

		b.ignoreAssessment(1);
		System.out.println(b);

		System.out.println("Final mark: " + b.finalMark());
		System.out.println("Has passed? " + b.hasPassed());
	}

	/* Test Student 1 * ******************************************************/
	// Create a UG student and test the final mark and if they passed.
	UGstudent b = new UGstudent("Person Number2");
	@Before
	public void makeTest1() {
		b.addAssessment("inclass", 20, 39);
		b.addAssessment(2, 5, 55);
		b.addAssessment("exercise", 15, 48);
		b.addAssessment(3, 60, 36);
	}

	@Test
	public void test1() {
		assertEquals("b final", 39, b.finalMark());
	}

	@Test
	public void test2() {
		assertFalse("b passed", b.hasPassed());
	}

	/* Test Student 2 * ******************************************************/
	// Create a student, change one of the marks and test final mark and passed
	MSCstudent c = new MSCstudent("Person Number2");
	@Before
	public void makeTest2() {
		c.addAssessment("inclass", 20, 48);
		c.addAssessment("exercise", 5, 64);
		c.addAssessment("exercise", 15, 63);
		c.addAssessment("final", 60, 46);

		c.changeMark(3, 85);
	}

	@Test
	public void test3() {
		assertEquals("c, final", 73, c.finalMark());
	}

	@Test
	public void test4() {
		assertTrue("c passed", c.hasPassed());
	}

	/* Test Student 3 * ******************************************************/
	// Create a student, remove a value and test final mark and passed value.
	MSCstudent d = new MSCstudent("Person Number2");
	@Before
	public void makeTest3() {
		d.addAssessment("inclass", 20, 48);
		d.addAssessment("exercise", 5, 64);
		d.addAssessment("exercise", 15, 63);
		d.addAssessment("final", 60, 46);

		d.ignoreAssessment(1);
	}
	@Test
	public void test5() {
		assertEquals("d final", 49, d.finalMark());
	}
}
