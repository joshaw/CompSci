/** Defines an exam question with a single answer which is one of a list.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 1
 * File name : ExamQuestionSimpleChoice.java
 * @version 2013-11-13
 */
import java.util.ArrayList;

public class ExamQuestionSimpleChoice extends ExamQuestion {

	private int correctInt;
	private ArrayList<String> possibleAnswers;
	private boolean correct;

	public ExamQuestionSimpleChoice(
			String question,
			int maximalMark,
			ArrayList<String> possibleAnswers,
			int correctInt) {

		super(question, maximalMark);
		this.correctInt = correctInt;
		this.possibleAnswers = possibleAnswers;
	}

	/** Allows submission of an attempted answer for the question. If the
	 * answer matches the correct answer, then it is "correct" and the marks
	 * are returned.
	 *
	 * @param submittedAnswer answer submitted for the question which is
	 * checked against the correct answer.
	 * @return the return of the returnMarks method which calculates how many
	 * marks should be awarded.
	 */
	public int answer(int submittedAnswer) {
		if (submittedAnswer == correctInt) {
			correct = true;
		} else {
			correct = false;
		}
		return returnMarks();
	}

	/** Method which returns the number of marks awarded for the given question
	 * based on the answer that was sumbitted. If the correct answer is given,
	 * then the maximal marks are given, else the marks are 0.
	 **/
	public int returnMarks() {
		if (correct) {
			return super.getMaximalMark();
		} else {
			return 0;
		}
	}

}
