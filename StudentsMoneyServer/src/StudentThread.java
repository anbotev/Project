import java.io.PrintStream;
import java.net.Socket;
import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentThread extends Thread {

	private Socket socket;
	private Scanner reader;
	private PrintStream writer;

	public StudentThread(Socket socket) {

		this.socket = socket;

	}

	@Override
	public void run() {

		try {
			reader = new Scanner(socket.getInputStream());
			writer = new PrintStream(socket.getOutputStream());

			writer.println("Kind of award: 1.Normal or 2.Special  ? ");
			String kind = reader.nextLine();

			String studentInfo = reader.nextLine();

			String[] dataString = studentInfo.split("\\*");

			Student student = new Student(dataString[0], Double.parseDouble(dataString[1]),
					Double.parseDouble(dataString[2]), Integer.parseInt(dataString[3]),
					Integer.parseInt(dataString[4]));

			if (kind.equals("2") && (Integer.parseInt(dataString[4])) > 4) {
				writer.println("You cannot take special because you take it many times! ");
			} else {
				QueueOfStudents.addInQueue(student);
				writer.println("You are in the list!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
