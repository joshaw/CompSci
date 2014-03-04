package quizObject;

import java.io.Serializable;

public class Quiz implements Serializable {

	public static final long serialVersionUID = 43L;

	private int quizID = 0;
	private Question[] questions = new Question[7];

	public Quiz() {

		/* Create example quiz object with several question objects. This
		 * information should be retreived from the database. */
		for (int i = 1; i < 6; i++) {
			questions[i] = new Question("test");
		}
	}

	public Question[] getQuestions() {
		return questions;
	}

	public Question getQuestion(int i) {
		try {
			return questions[i];
		} catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Question index out of bounds.");
		}
		return new Question();
	}
}
