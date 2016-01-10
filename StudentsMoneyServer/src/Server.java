import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT = 2789;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);

		System.out.println("Server started!");

		while (true) {

			try {

				Socket socket = serverSocket.accept();

				Mainthread mainthread = new Mainthread(socket);
				mainthread.start();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
