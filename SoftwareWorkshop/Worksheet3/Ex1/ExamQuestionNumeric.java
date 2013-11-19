/** Defines an exam question with a single numeric answer.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 1
 * File name : ExamQuestionNumeric.java
 * @version 2013-11-19
 */
public class ExamQuestionNumeric extends ExamQuestion {

	private int correctInt;
	private boolean correct;

	/** A numeric question is defined as the question itself, an integral value
	 * for the maximum availible mark and an integral value for the correct
	 * answer which is awarded the maximal mark.
	 *
	 * @param question the question asked.
	 * @param maximalMark the maximum marks availible for a correct answer.
	 * @param correctInt the correct answer to the {@link question}
	 */
	public ExamQuestionNumeric(String question, int maximalMark, int correctInt) {
		super(question, maximalMark);
		this.correctInt = correctInt;
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
