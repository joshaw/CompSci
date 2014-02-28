package quizObject;

import java.util.ArrayList;
import java.io.Serializable;

public class Question implements Serializable {

	public static final long serialVersionUID = 42L;

	private String question;
	private ArrayList<String> answers = new ArrayList<String>();

	public Question(String test) {

		/* Create example quiestion with several example answers. This
		 * information should come from the database. */
		question = "This is the question.";
		for (int i = 1; i < 11; i++) {
			answers.add("Answer number " + i);
		}
	}

	public Question() {}

	public void setQuestion(String Question) {
		 this.question = question;
	}

	public void setAnswer(int i, String answer) {
		this.answers.set(i, answer);
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer(int i) {
		return answers.get(i);
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public int getNumOfAnswers() {
		return answers.size();
	}

}
