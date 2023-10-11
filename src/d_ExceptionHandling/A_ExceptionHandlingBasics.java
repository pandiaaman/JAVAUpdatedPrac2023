package d_ExceptionHandling;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

//import UserDefinedException;


public class A_ExceptionHandlingBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//checked exceptions : checked at the compile time
			//IOException
			//FileNotFoundException
			//CloneNotSupportedException
			//SQLException
		//unchecked exceptions : exceptions under runtime and error classes
			//ArithmeticExceptions
			//NullPointerException
			//IndexOutOfBoundsException
			//NumberFormatException
			
		//error : (also unchecked exceptions)
			//StackOverflowError
			//VirtualMachineError
			//OutOfMemoryError
		
		Scanner sc = new Scanner(System.in);

		//ArithmeticException
		try {
		//	int in1 = sc.nextInt();
			int a1 = 100;
			System.out.println(a1/0);
		}catch(ArithmeticException e) {
			System.out.println("error : " + e);
		}finally {
			System.out.println("arithmetic Exception");
		}
		
		//NullPointerException
		String s = null;
		try {
			System.out.println(s.length());
		}
//		catch(Exception e) { //Unreachable catch block for NullPointerException. It is already handled by the catch block for Exception
//			System.out.println(e);
//		}
		catch(NullPointerException e) {
			System.out.println("error : " + e);
		}finally {
			System.out.println("null pointer");
		}
		
		//NumberFormatException
		try {
			String strr = "abc";
			int strri = Integer.parseInt(strr);
		}catch(NumberFormatException e) {
			System.out.println("error : "  + e);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//ArrayIndexOutOfBoundsException
		try {
			int[] arr1 = new int[] {1,2,3};
			System.out.println(arr1[5]);
		}catch(ArithmeticException e) {
			System.out.println("error : " + e);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("error : " + e);
		}
		System.out.println("still going");
		
		
		try {
			int age = sc.nextInt();
			if(age<18) {
				throw new UserDefinedException("age is less than 18");
			}
			else {
				System.out.println("good age");
			}
		}catch(UserDefinedException e) {
			System.out.println("error : " + e);
		}catch(Exception e) {
			System.out.println("error: " + e);
		}
		
		
		
	}

}
