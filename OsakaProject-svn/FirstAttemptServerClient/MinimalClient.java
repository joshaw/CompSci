import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimalClient {

	BufferedReader in;
	PrintWriter out;

	public MinimalClient() {
		System.out.println("Client running");
	}

	private void run() throws Exception {

		Socket socket = new Socket("localhost", 9000);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(socket.getOutputStream(), true);

		while (true) {
			String line = in.readLine();
			out.println(line);
		}
	}

	public static void main(String[] args) throws Exception {
		MinimalClient client = new MinimalClient();
		client.run();
	}

}
