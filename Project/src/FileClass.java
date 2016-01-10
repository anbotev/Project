import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class FileClass {
	public static int counter = 0;
	public static int counterOfExercise = 0;
	public static Scanner fileReader = null;
	static ArrayList<HashMap<FirstStudent, Integer>> studentArr = new ArrayList<HashMap<FirstStudent, Integer>>();
	static String groupCollector="a";
	static int counterOfGroups = 0;
	static int counterOfFiles = 0;
	static ArrayList<HashMap<FirstStudent, Integer>> map = new ArrayList<HashMap<FirstStudent,Integer>>();
	public static boolean readFilesInFolder(File folder, int weeks) throws FileNotFoundException{
		
		String[] splitArray = null;
		
		  
		  for (int numberOfWeeks=1; numberOfWeeks<=weeks; numberOfWeeks++){
			  HashMap<FirstStudent, Integer> mapOfStudents = new HashMap<FirstStudent,Integer>();
			  
			  //READ FOLDER
			  for (File fileEntry : folder.listFiles()) {
				 fileReader = new Scanner(fileEntry,"windows-1251");
			    	
				  
				  //SORT FILES BY WEEKS AND PUT THEM INTO HASHMAP
			    	if(fileEntry.getName().contains(String.valueOf(numberOfWeeks))){
			    		while (fileReader.hasNextLine()){
			    		String split = fileReader.nextLine();
			    		//if(split.contains("\\s")) { split.replaceAll("\\s", ",");}
			    		splitArray = split.split(",");
			    		if(Validator.isNameValid(splitArray[0]) && Validator.isNameValid(splitArray[1])){
			    			if(Validator.isNumberValid(splitArray[2])){
			    				if(Validator.isGroupValid(splitArray[3])){
			    					if(Validator.isPointsValid(splitArray[4])){
			    						
			    		FirstStudent student1 =  new FirstStudent(splitArray[0], splitArray[1],
			    				Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]));
			    		if(mapOfStudents.containsKey(student1)){
			    			String points = JOptionPane.showInputDialog(null,"The student: " + student1.name + " " + student1.secoundName +  
									  " has been two times on this exercise.\nFirst the student has " + mapOfStudents.get(student1) 
									+ " points." + " Second has " + splitArray[4] + " points" + "\nPlease choose with 1 for " + mapOfStudents.get(student1) 
									+ " points or 2 for " + splitArray[4] + " points to save in list for the excercise " + numberOfWeeks + " !" );
			    		if(Integer.parseInt(points)==1) {
			    			splitArray[4] = String.valueOf(mapOfStudents.get(student1));
			    		}
			    		}
			    		mapOfStudents.put(student1 , Integer.parseInt(splitArray[4]));
			    					
			    					}else System.out.println("The points " + splitArray[4] + " of " +
						    		         splitArray[0] + " " + splitArray[1] + " in file " + fileEntry.getName() + " must be written with numberss!"); 
			    				}else System.out.println("The group " + splitArray[3] + " of " +
					    		         splitArray[0] + " " + splitArray[1] + " in file " + fileEntry.getName() + " must be written with numbers!");
			    			}else { System.out.println("The faculty number " + splitArray[2] + " of student " + splitArray[0] +
			    				 " " + splitArray[1] + " in file " + fileEntry.getName() + " must be only with numbers and length 9 symbols");
			    			}
			    	}else  System.out.println("The name " + splitArray[0] + " " + splitArray[1] + 
			    			" is not in cyrillic in file " + fileEntry.getName()); 
			    		       
			    		counter++;
			    	
			    	}                      
			    	}
			    	if(fileReader !=null){
			    	fileReader.close();
			    	} 	
			  }
			  
		  
		  studentArr.add(mapOfStudents);
		  }
		  if (fileReader != null){
		  
			 fileReader.close();
			  return true;
		  
		  }
		  else return false;
		
		}

	public static boolean readFolder(File folder) throws FileNotFoundException {
		for (File fileEntry : folder.listFiles()) {
			 fileReader = new Scanner(fileEntry,"windows-1251");
		}
	    if(fileReader==null) {
	    	return false;
	    }else return true;
	}
	
	public static void findMyGroups(File folder) throws FileNotFoundException{
		String[] splitArray = null;  
			  //READ FOLDER
			  for (File fileEntry : folder.listFiles()) {
				 counterOfFiles++;
				  fileReader = new Scanner(fileEntry,"windows-1251");
			    		while (fileReader.hasNextLine()){
			    			
			    		String split = fileReader.nextLine();
			    		splitArray = split.split(",");
			    		if(groupCollector.contains(splitArray[3])==false){
			    	    groupCollector = groupCollector + "," + splitArray[3];
			    	    counterOfGroups++;
			    		}
	}
			    		
			    	}
		}
	
	
	public static void countExercisePerWeek(File folder) throws FileNotFoundException{

			 for (File fileEntry : folder.listFiles()) {
				 if(fileEntry.getName().contains("1")){
					 counterOfExercise++;
				 }
		}
	}
	
	public static void writeInFile(File folder, int[] groups, int groupCounter) throws FileNotFoundException{
		String[] splitArray = null;
		PrintStream fileWriter = new PrintStream("all.txt");
		  for (int i=1; i<counterOfGroups; i++){
			  splitArray = groupCollector.split(",");
				  fileWriter.println("GROUP " + splitArray[i] );
			  for(Map.Entry<FirstStudent, Integer> student : studentArr.get(0).entrySet()){
				  if (student.getKey().group == Integer.parseInt(splitArray[i])){
				  fileWriter.print(student.getKey() + " ");
				  fileWriter.println(student.getValue());
				  }
				  }
			  fileWriter.println();
		  }
	      fileWriter.println();
          fileWriter.println();
		  fileWriter.println("HISTORY");
		  fileWriter.println();
		 
		  for (File fileEntry : folder.listFiles()) {
			  
			  fileWriter.println(fileEntry.getName());

					  fileReader = new Scanner(fileEntry,"windows-1251");
				  while(fileReader.hasNextLine()){
					  String split = fileReader.nextLine();
					  splitArray = split.split(",");
			    		if(Validator.isNameValid(splitArray[0]) && Validator.isNameValid(splitArray[1]) &&
			    			Validator.isNumberValid(splitArray[2]) && 
			    			Validator.isGroupValid(splitArray[3])&& 
			    			Validator.isPointsValid(splitArray[4])){
				  fileWriter.println(splitArray[0] + " " + splitArray[1] + " " + splitArray[2] +
						  " " + splitArray[3] + " " + splitArray[4]);	
			    	}else fileWriter.println("wrong data!"); 
			    	}
		  
				  fileWriter.println();
		  }
		  if(fileWriter!=null){
			  fileWriter.close();
		  }
		  
	}

	
}
	
