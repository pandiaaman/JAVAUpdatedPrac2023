package DSALogics;
import java.util.Scanner;
public class B_5_Recursion {
/*
 * a method is recursive when it calls itself
 */
	public static void main(String[] args) {
		// we will practice by calling different recursive methods in this class
		Scanner sc = new Scanner(System.in);
		
		//creating factorial using recursion
		System.out.println("enter no to find factorial");
		int k=sc.nextInt();
		int factorialans = k<0?-1:calculateFactorial(k);
		System.out.println(factorialans);
		
		//creating fibonacci series sum using recursion
		System.out.println("enter the no of terms in fibonacci to find the sum of");
		int n=sc.nextInt();
		int fibonaccisum = calculateFibonacciSum(n-1,0,1);
		System.out.println(fibonaccisum);
		
		int fibonaccisum2 = calculateFibonacciSum2(n);
		System.out.println("using diff fibonacccisum2 : " + fibonaccisum2);
		
		//creating a palindrome using recursion
		boolean isPalindrome = checkPalindrome("lololwolol");
		System.out.println(isPalindrome);
	}

	public static int calculateFactorial(int k) {
		
		if(k==1 || k==0) { //breaking condition or the base case of recursion
			return 1;
		}
		return k*(calculateFactorial(k-1));
	}
	
	public static int calculateFibonacciSum(int n,int a,int b) {
		if(n==0) {
			return 0;
		}
		return a + b + calculateFibonacciSum(n-1,b,a+b); //1 1 2 3 5 8
		//3,1+1+ f(2,1,2)
			//2,1+2+f(1,2,3)
				//1,2+3+f(0,3,5)
	}
	
	public static int calculateFibonacciSum2(int n) {
		if(n==1 || n==2) {
			return 1;
		}
		return calculateFibonacciSum2(n-1)+calculateFibonacciSum2(n-2);
		//c(4)+c(3)
		//c(3)+c(2) + c(2)+c(1)
		//c(2)+c(1) + 1 + 1 + 1
		//1 + 1 +3 = 5
	}
	
	public static boolean checkPalindrome(String str) {
		if(str.length()==0 || str.length()==1) {
			return true;
		}
		
		if(str.charAt(0) == str.charAt(str.length()-1)) {
			return checkPalindrome(str.substring(1,str.length()-1));
		}
		return false;
	}
}
//if we dont have a base case in the recursion call, then the call will keep going on
//we will get stack overflow error, as there is a certain amount of memory dedicated for one call and it will be overloaded
