
public class NotEnoughWeeksException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3549112716997095009L;

	@Override
	public String getMessage() {
		return "Not have more than 15 weeks!";
	}

}
