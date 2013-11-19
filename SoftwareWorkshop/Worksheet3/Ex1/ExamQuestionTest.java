/** Test class for the ExamQuestion superclass and the ExamQuestionNumeric and
 * ExamQuestionSimpleChoice subclasses.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 1
 * File name : ExamQuestionTest.java
 * @version 2013-11-19
 */

import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class ExamQuestionTest {

	public static void main(String[] args) {

		ExamQuestionNumeric q1 =
	new ExamQuestionNumeric("2+3 = ?", 3, 5);

		System.out.println(q1.answer(5));
		System.out.println(q1.answer(6));

		ArrayList<String> a = new ArrayList<String>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");

		ExamQuestionSimpleChoice q2 =
			new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);

		System.out.println(q2.answer(2));
		System.out.println(q2.answer(3));
	}

	private ExamQuestionNumeric q1;
	private ExamQuestionSimpleChoice q2;

	/* Create an object of type ExamQuestionNumeric, with question, max score
	 * and answer. */
	@Before
	public void makeQuestion1() {
		q1 = new ExamQuestionNumeric("2+3 = ?", 3, 5);
	}

	/* Test the return value for ExamQuestionNumeric */
	@Test
	public void testQuestion1a() {
		assertEquals(3, q1.answer(5));
	}
	@Test
	public void testQuestion1b() {
		assertEquals(0, q1.answer(6));
	}

	/* Create an object of type ExamQuestionSimpleChoice, with question, max
	 * score, a list of possible answers and an answer selection. */
	@Before
	public void makeQuestion2(){
		ArrayList<String> a = new ArrayList<String>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");
		q2 = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);
	}

	/* Test the return value for ExamQuestionSimpleChoice */
	@Test
	public void testQuestion2a() {
		assertEquals(10, q2.answer(2));
	}
	@Test
	public void testQuestion2b() {
		assertEquals(0, q2.answer(3));
	}
}
