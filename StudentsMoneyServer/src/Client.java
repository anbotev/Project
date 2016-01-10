import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	
	
	
	public static void main(String[] args) throws UnknownHostException, IOException { 
		
		Socket socket = new Socket("localhost",2789);
		
		Scanner reader = new Scanner(socket.getInputStream());
		PrintStream writer = new PrintStream(socket.getOutputStream());
		Scanner readKeyboard = new Scanner(System.in);
		
		System.out.println("If you are secreatery , please write down the password else you are a student write 1 : ");
		String password = readKeyboard.nextLine();
		
		if (checkPassword(password)) {
			
			
			
			
			
			
			
			
			
		} else {
			
			System.out.println(reader.nextLine());
			String choose = readKeyboard.nextLine();
			writer.println(choose);
			
			System.out.print("Enter name: ");
			String name = readKeyboard.nextLine();
			
			System.out.print("Enter grade: ");
			String grade = readKeyboard.nextLine();
			
			System.out.print("Enter amount: ");
			String amount = readKeyboard.nextLine();
			
			System.out.print("Enter facNumber: ");
			String facNumber = readKeyboard.nextLine();
			
			System.out.println("Enter number of award: ");
			String award = readKeyboard.nextLine();
			
			String student =  new String(name +"*"+ grade +"*"+ amount +"*"+ facNumber
					 +"*"+ award);
			
			writer.println(student);
			
			System.out.println(reader.nextLine());
			
		}
		
		
	}
	
	public static boolean checkPassword(String password) {

		if (password.equals("parola")) {
			return true;
		} else
			return false;

	}

	
}
