import java.io.*;
import java.util.*;

public class HashClass {
	static ArrayList<HashMap<FirstStudent, Integer>> groupArr = new ArrayList<HashMap<FirstStudent, Integer>>();
	
	 //SORT ALL OBJECTS KEY BY VALUE AND PUT THEM IN STUDENTARR(0) (FIRST HASHMAP)
	public static HashMap<FirstStudent, Integer> sortInHashMap() throws FileNotFoundException{
		for (int line=1; line<Test.weeks; line++){
			  Iterator<Map.Entry<FirstStudent, Integer>> iterator1 = FileClass.studentArr.get(line).entrySet().iterator();
			  while(iterator1.hasNext()){
				  Map.Entry<FirstStudent, Integer> entry = iterator1.next();
				  
				  if( FileClass.studentArr.get(0).containsKey(entry.getKey())){
					  FileClass.studentArr.get(0).put(entry.getKey(), entry.setValue(
							  FileClass.studentArr.get(0).get(entry.getKey()))+
							  FileClass.studentArr.get(line).get(entry.getKey()));
					  
				  }
				  else {
					  FileClass.studentArr.get(0).put(entry.getKey(), entry.getValue());
				  }
			  }
			  }
		
		return FileClass.studentArr.get(0);
	}
	
	
	//SORT ALL STUDENTS BY GROUP IN HASHMAPS
	public static boolean sortAllStudentsByGroup(int[] groups, int groupCounter) throws FileNotFoundException, GroupNotFoundException{
		if (Test.weeks> (FileClass.counter/FileClass.counterOfExercise)){
			 // System.out.println("Too much weeks. there are only " + FileClass.counter/FileClass.counterOfExercise + " weeks");
			  return false;
		  }
		  else{
		  for (int numberOfGroups=0; numberOfGroups<groupCounter; numberOfGroups++){
		  HashMap<FirstStudent, Integer> mapOfGroups = new HashMap<FirstStudent,Integer>();
		  Iterator<Map.Entry<FirstStudent, Integer>> sortIterator = FileClass.studentArr.get(0).entrySet().iterator();  
		  while (sortIterator.hasNext()){
			  Map.Entry<FirstStudent, Integer> sortEntry = sortIterator.next();
			  if(sortEntry.getKey().group == groups[numberOfGroups]){
				  mapOfGroups.put(sortEntry.getKey(), sortEntry.getValue()); 
		  }

		  }
		  
		  groupArr.add(mapOfGroups);
		  }
		  return true;
		  }
	  }
	
	public static void printHash(int groupCounter) throws FileNotFoundException{
		for (int i=0; i<groupCounter; i++){
		for(Map.Entry<FirstStudent, Integer> student : groupArr.get(i).entrySet()){
			  System.out.print(student.getKey() + " ");
			  System.out.println(student.getValue());  
		  }
	}
	}
}
