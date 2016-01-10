import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static Pattern pattern ; 
	private static Matcher matcher ; 
	 
	private static final String NAME_PATTERN = "[À-ß][-À-ÿ]+";
	private static final String NUMBER_PATTERN = "[0-9]{9}";
	private static final String GROUP_PATTERN = "[0-9]+";
	private static final String POINTS_PATTERN = "[0-9]+";
	
	public Validator() {
		
	}
	
	public static boolean isNameValid(String split) {
		
		pattern = Pattern.compile(NAME_PATTERN);
		matcher =pattern.matcher(split);
		
		return matcher.matches();
	}
		public static boolean isNumberValid(String split) {
			
			pattern = Pattern.compile(NUMBER_PATTERN);
			matcher =pattern.matcher(split);
			
			return matcher.matches();
	}
		
		public static boolean isGroupValid(String split) {
			
			pattern = Pattern.compile(GROUP_PATTERN);
			matcher =pattern.matcher(split);
			
			return matcher.matches();
	}
		public static boolean isPointsValid(String split) {
			
			pattern = Pattern.compile(POINTS_PATTERN);
			matcher=pattern.matcher(split);
			
			return matcher.matches();
		}
	
	
	
	
	
}
