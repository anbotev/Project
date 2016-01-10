
public class GroupNotFoundException extends Exception {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  GroupNotFoundException() {
		
	}

	public GroupNotFoundException(String message) {
		super(message);

	}



	@Override
	public String getMessage() {
		return "Group which you entered cannot be found!!";
	}
	
}
