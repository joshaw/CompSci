import quizObject.*;
import loginRequest.*;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class QuizClient {

	private static final int PORT = 9000;

	BufferedReader userInput;
	PrintWriter out;
	InputStream inputStream;
	Socket socket;
	ObjectInputStream objectInput;

	public QuizClient() {
		System.out.println("Client running");
	}

	private void run() throws Exception {

		socket = new Socket("localhost", PORT);
		userInput = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(socket.getOutputStream(), true);

		objectInput = new ObjectInputStream(socket.getInputStream());

		createNewLogin("josh", "password");

		/* Read the next from the stream. If its a Quiz object, perform
		 * some actions, otherwise, do something else. */
		Object object = objectInput.readObject();
		if (object instanceof Quiz) {

			Quiz quiz = (Quiz) object;

			// Loop through questions and print to screen.
			for (int i = 1; i < quiz.getQuestions().length-1; i++) {

				Question thisQuestion = quiz.getQuestion(i);
				System.out.println(thisQuestion.getQuestion());

				for (int j = 0; j < thisQuestion.getNumOfAnswers(); j++) {
					System.out.println(thisQuestion.getAnswer(j));

				}
				Thread.sleep(2000);
			} // END OF QUESTIONS

		} else {
			System.out.println("Object was not of type \"Quiz\".");
		}
	}

	public static void main(String[] args) throws Exception {
		QuizClient client = new QuizClient();
		client.run();
	}

	public void createNewLogin(String username, String password) {
		LoginRequest login = new LoginRequest(username, password);
		System.out.println(login);
	}

}
