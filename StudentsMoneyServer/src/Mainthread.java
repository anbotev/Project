import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Mainthread extends Thread {

	private Socket socket;
	private PrintStream writer;
	private Scanner reader;
	

	public Mainthread(Socket socket) {
		this.socket = socket;

	}

	@Override
	public void run() {

		try {

			writer = new PrintStream(socket.getOutputStream());
			reader = new Scanner(socket.getInputStream());

			writer.println("If you are secreatery , please write down the password else you are a student write 1 : ");
			String password = reader.nextLine();
			
			if (checkPassword(password)) {
				SecretaryThread secretaryThread = new SecretaryThread(socket);
				secretaryThread.start();
			} else {
				StudentThread studentThread = new StudentThread(socket);
				studentThread.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkPassword(String password) {

		if (password.equals("parola")) {
			return true;
		} else
			return false;

	}

}
