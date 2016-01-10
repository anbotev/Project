import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Test {
	static int weeks = 0;
	public static int groupCounter = 0;
	static int[] groups = null;
	public static void main(String[] args) throws IOException, NotEnoughWeeksException, GroupNotFoundException, TooMuchWeeksException, TooMuchGroupsException {
	
		try{
	
	String folderStr = JOptionPane.showInputDialog(null, "Enter directory to search for: ");

	File folder = new File(folderStr);
	if(!FileClass.readFolder(folder)){ 
		throw new ArrayIndexOutOfBoundsException();
	}else {
	String groupStr = JOptionPane.showInputDialog(null, "Enter the ammount of groups you will search for: ");
	if(!Validator.isGroupValid(groupStr)) {
		System.out.println("The amount of groups should be written with numbers!");
		throw new NumberFormatException();
	}else {			
	groupCounter = Integer.parseInt(groupStr);
	groups = new int[Integer.parseInt(groupStr)];
	FileClass.countExercisePerWeek(folder);
	FileClass.findMyGroups(folder);
	
	if (groupCounter <= FileClass.counterOfGroups){
	for (int i=0; i<groupCounter; i++){	
		String groupSearchForStr = JOptionPane.showInputDialog(null,"Enter group to search for: ");
		if(!Validator.isGroupValid(groupSearchForStr)) {
			System.out.println("The group should be written with numbers!");
			throw new NumberFormatException();
		}else {			
		if (FileClass.groupCollector.contains(String.valueOf(groupSearchForStr))){
		groups[i] = Integer.parseInt(groupSearchForStr);
		}
		else throw new GroupNotFoundException();
	}
	}
	}
	else throw new TooMuchGroupsException();

	String weeksStr = JOptionPane.showInputDialog(null, "How many weeks do you want to search for: ");
	if(!Validator.isGroupValid(weeksStr)) {
		System.out.println("The number of weeks should be written with numbers!");
		throw new NumberFormatException();
	}else {			
	weeks = Integer.parseInt(weeksStr);
	if(weeks>FileClass.counterOfFiles/FileClass.counterOfExercise) { throw new TooMuchWeeksException();
	
	}
	System.out.println();
	
	
	if(FileClass.readFilesInFolder(folder, weeks)){
		
	      HashClass.sortInHashMap();
	      if(HashClass.sortAllStudentsByGroup(groups, groupCounter))
	      {HashClass.printHash(groupCounter);}
	      else throw new GroupNotFoundException();
	      FileClass.writeInFile(folder, groups, groupCounter);
	}
	}
	}	
	}
	}catch (FileNotFoundException fnf) {
		System.out.println("Directory not found");
		fnf.printStackTrace();
	}catch (NullPointerException np) {
		System.out.println("Wrong name of the directory");
	}catch (ArrayIndexOutOfBoundsException ai) { 
	}catch (NumberFormatException nf) {
	}
	catch (InputMismatchException im) {
		System.out.println("Please write an amounts of groups, which group to search and number of weeks in NUMBERS!!!");
	} catch (GroupNotFoundException e) {
		System.out.println("Group which you entered cannot be found!!");
	}
	catch (TooMuchGroupsException e){
		System.out.println("Too much groups. There are only " + FileClass.counterOfGroups + " groups");
	}
	catch (TooMuchWeeksException e) {
		System.out.println("Too much weeks. there are only " + FileClass.counterOfFiles/FileClass.counterOfExercise + 
				" weeks");
	}
	}
}
