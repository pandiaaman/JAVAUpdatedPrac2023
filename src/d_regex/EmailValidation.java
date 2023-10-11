package d_regex;
import java.util.regex.Pattern;

public class EmailValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String useremail = "pandiaaman16@gmail.com";
		if(Pattern.matches(".*@\\w+mail.com", useremail)) {
			System.out.println("matches");
		}
	}

}
