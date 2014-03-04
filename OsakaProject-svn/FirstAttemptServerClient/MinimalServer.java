import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimalServer {

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
		private BufferedReader in;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));

				while (true) {
					String line = in.readLine();
					if (line != null) {
						System.out.println(line);
					}
				}
			} catch(Exception e){
				System.err.println(e.getMessage());
			} finally {
				try {
					socket.close();
				} catch(Exception e){}
			}
		}

	}

}
