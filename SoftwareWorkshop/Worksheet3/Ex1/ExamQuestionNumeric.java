
public class ExamQuestionNumeric extends ExamQuestion {

	private int correctInt;
	private boolean correct;

	public ExamQuestionNumeric(String question, int maximalMark, int correctInt) {
		super.setQuestion(question);
		super.setMaximalMark(maximalMark);
		this.correctInt = correctInt;
	}

	/** Method which returns the number of marks awarded for the given question
	 * based on the answer that was sumbitted. If the correct answer is given,
	 * then the maximal marks are given, else the marks are 0.
	 *
	 * @param submittedAnswer Answer to be checked.
	 **/
	public int answer(int submittedAnswer) {
		if (submittedAnswer == correctInt) {
			correct = true;
		} else {
			correct = false;
		}
		return returnMarks();
	}

	public int returnMarks() {
		if (correct) {
			return super.getMaximalMark();
		} else {
			return 0;
		}
	}

}
