
public class TooMuchGroupsException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public TooMuchGroupsException() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getMessage() {
		return "Too much groups. there are only " + FileClass.counterOfGroups + 
				" groups";
	}

}
