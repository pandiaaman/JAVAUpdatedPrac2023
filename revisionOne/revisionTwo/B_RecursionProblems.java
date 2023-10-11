package revisionTwo;

public class B_RecursionProblems {

	public static void main(String[] args) {
		int fact = factorialRec(5);
		System.out.println(fact);
		
		int sum = sumRec(5);
		System.out.println(sum);
		
		int fibSum = fibValRec(4);
		System.out.println(fibSum);
		
		String str = "wowowow";
		boolean isPalin = checkPalindrome(str);
		System.out.println(isPalin);
	}
	
	public static int factorialRec(int n) {
		
		if(n<=1) {
			return 1;
		}
		return n * factorialRec(n-1);
	}
	
	public static int sumRec(int n) {
		if(n<=1) {
			return 1;
		}
		
		return n + sumRec(n-1);
	}
	
	public static int fibValRec(int n) {
		
		if(n==1 || n==2) {
			return 1;
		}
		
		return fibValRec(n-1) + fibValRec(n-2);
	}
	
	
	public static boolean checkPalindrome(String str) {
		
		if(str.length() == 0 || str.length() ==1) {
			return true;
		}
		
		if(str.charAt(0) == str.charAt(str.length()-1)) {
			return checkPalindrome(str.substring(1,str.length()-1));
		}
		
		return false;
	}
	
}
