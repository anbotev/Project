
public class TooMuchWeeksException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7217005644774681379L;
	@Override
	public String getMessage() {
		return "Too much weeks. there are only " + FileClass.counter/FileClass.counterOfExercise + 
				" weeks";
	}
    
	
}
