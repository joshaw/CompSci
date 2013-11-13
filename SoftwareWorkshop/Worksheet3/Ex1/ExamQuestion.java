/** Defines the superclass ExamQuestion for holding information about an exam
 * question.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 1
 * File name : ExamQuestion.java
 * @version 2013-11-13
 */
public class ExamQuestion {

	private String question;
	private int maximalMark;

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}

	public int getMaximalMark() {
		return maximalMark;
	}

	@Override
	public String toString(){
		return question + ", max: " + maximalMark;
	}

}
