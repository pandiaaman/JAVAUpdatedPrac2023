package d_regex;

import java.util.regex.Pattern;

public class A_RegexBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java.util.regex package
		/*
		 * matcher class
		 * pattern class
		 * matchResult interface
		 * patternSyntaxException class
		 */
		long startTime = System.currentTimeMillis();
		
		boolean ifMatch1;
		ifMatch1 = Pattern.matches(".*s", "aasdfadsfs");	
		ifMatch1 = Pattern.matches("[abc]","a");// a or b or c
		ifMatch1 = Pattern.matches("[abc]..","abc"); // a or b or c and then two char after that
		ifMatch1 = Pattern.matches("[^abc]","d"); //negating a or b or c
		ifMatch1 = Pattern.matches("[a-zA-Z]","A");
		ifMatch1 = Pattern.matches("[a-d[m-p]]","n"); // union of a to d or m to p
		ifMatch1 = Pattern.matches("[a-z&&[p-t]]","s");//intersection of a-z and p to t
		ifMatch1 = Pattern.matches("[a-z&&[^b-e]]","d");//false : intersection of a to z and negation of b to e
		
		//quantifiers
		ifMatch1 = Pattern.matches("[abc]?",""); // ? is 0 or 1 times
		ifMatch1 = Pattern.matches("[abc]?","a"); // one time present
		ifMatch1 = Pattern.matches("[abc]*","abc");//* is 0 or more times
		ifMatch1 = Pattern.matches("[abc]+","aabbc"); // + is 1 or more times
		ifMatch1 = Pattern.matches(".*[a]{2}.*","maan");//. means any character  * 0 or more times, a comes twice and then again any char 0 or more times
		ifMatch1 = Pattern.matches("[a]{4,}","aaaaaaa");// a comes atleast 4 times
		
		//regex metacharacters
		ifMatch1 = Pattern.matches("\\d","5"); // \\d is for digits
		ifMatch1 = Pattern.matches("\\d*","6856"); // \\d* for 0 or more digits
		ifMatch1 = Pattern.matches("\\D","a"); // \\D is for NON digits
		ifMatch1 = Pattern.matches("\\w","3"); // \\w is for words and digits
		ifMatch1 = Pattern.matches("\\W","*");// \\W is NON words/digits so basically special chars
		
		//examples
		ifMatch1 = Pattern.matches("[\\d]*[-]?","234-");
		//for email
		ifMatch1 = Pattern.matches("[\\w]*[@]{1}[a-z]+mail.com$","pandiaman16@gmail.com");
		
		
		
		
		System.out.println(ifMatch1);
		
		
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime - startTime));
	}

}
