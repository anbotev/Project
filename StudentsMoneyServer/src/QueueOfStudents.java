import java.awt.List;
import java.util.LinkedList;
import java.util.Queue;

public class QueueOfStudents {

	public static Queue<Student> studentsQueue;

	public QueueOfStudents(Queue<Student> studentsQueue) {
		super();
		this.studentsQueue = studentsQueue;
	}

	public static void addInQueue(Student student) {

		studentsQueue = new LinkedList<Student>();
		
		studentsQueue.offer(student);
		

	}

}
