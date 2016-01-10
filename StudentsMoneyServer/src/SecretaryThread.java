import java.net.Socket;
import java.util.ArrayList;

public class SecretaryThread extends Thread {

	private Socket socket;
	public ArrayList<Student> listIncorect;
	
	public SecretaryThread(Socket socket){ 
		this.socket=socket;
	}
	
	@Override
	public void run(){ 
		listIncorect = new ArrayList<Student>();
		
		for(int i =0 ;i<QueueOfStudents.studentsQueue.size();i++){
			
			if((QueueOfStudents.studentsQueue.poll().grade)<5&&
					(QueueOfStudents.studentsQueue.poll().amount)>500){ 
				listIncorect.add(QueueOfStudents.studentsQueue.poll());
			}
			
			
		}
		
		
		
	
	}
}
