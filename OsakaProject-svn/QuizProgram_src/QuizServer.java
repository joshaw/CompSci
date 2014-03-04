import quizObject.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

public class QuizServer {

	private static final int PORT = 9000;

	public static void main(String[] args) throws Exception {

		System.out.println("Server is running.");
		ServerSocket listener = new ServerSocket(PORT);

		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Handler extends Thread {

		private Socket socket;

		// Stream capable of transfering serialized objects
		private ObjectOutputStream objectStream;

		/** Constructor for handler. Handles the connection between server and
		 * client.
		 *
		 * @param socket
		 */
		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {

				objectStream = new ObjectOutputStream(socket.getOutputStream());

				Quiz quiz = new Quiz();
				objectStream.writeObject(quiz);

			} catch(Exception e){
				e.printStackTrace();
				System.err.println(e.getMessage());
			} finally {
				try {
					objectStream.close();
					socket.close();
				} catch(Exception e){}
			}
		}

	}

}
