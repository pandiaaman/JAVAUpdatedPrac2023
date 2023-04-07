package d_ExceptionHandling;

public class UserDefinedException extends Exception{

	public UserDefinedException(String str) {
		super(str);
		System.out.println("this is coming from user defined exception");
	}
}
