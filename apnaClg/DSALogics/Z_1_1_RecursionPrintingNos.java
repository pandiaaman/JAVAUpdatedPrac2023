package DSALogics;

public class Z_1_1_RecursionPrintingNos {

	public static void main(String[] args) {
		int n=5;
		
		printUsingRec(n);
		System.out.println(printSum(n));
		System.out.println(factorial(n));
		fibonacciTillNth(n,1,1);
		System.out.println(fibonacciAtNth(n));
		int x = 4;
		System.out.println(printPower(x,n));
		System.out.println(printPowerLogN(x,n));

		//check the first and last occurance of char in a string using recursion
		String str = "23aababrjababaacpfllababehtba";
		char ch = 'a';
		findFirstAndLastOccuranceOfAnElementInAString(str,0,ch);
		System.out.println(ch + "occurs first at :" + first + " and last occurance at : " + last);
		
		//check if any array is sorted (strictly increasing)
		int arr[] = new int[] {2,3,4,5,6,7,9};
		if(checkIfSorted(arr,0)) {
			System.out.println("strictly increasing");
		}else {
			System.out.println("not increasing");
		}
		
		//move all the x to the end of the string
		String str1 = "asgxadfxxxwerxewrt";
		System.out.println(moveXtoEnd(str1,0));
		
		//remove duplicates in a string
		String str2 = "axxbybatqrtttaxbyabyxtqrrre";
		System.out.println(removeDuplicates(str2,0));
		
		//print all the subsequences of a string
		/*
		 * length : 1 2 3 4...
		 * each length : char : 1
		 * 	for each char :   
		 *  
		 */
		
	}
	
	
	public static String strNoDup = "";
	public static String removeDuplicates(String str, int index) {
		//base case
		if(index == str.length()) {
			return strNoDup;
		}
		
		if(!strNoDup.contains(String.valueOf(str.charAt(index)))){
			strNoDup+=str.charAt(index);
		}
		
		return removeDuplicates(str,index+1);
		
	}
	
	
	public static String strRes="";
	public static int xCount = 0;
	public static String moveXtoEnd(String str, int index) {
		//basecase
		if(index==str.length()-1) {
			while(xCount>=0) {
				strRes+="x";
				xCount--;
			}
			return strRes;
		}
		
		if(str.charAt(index) != 'x') {
			strRes+=str.charAt(index);
		}
		else if(str.charAt(index) == 'x') {
			xCount++;
		}
		
		return moveXtoEnd(str,index+1);
		
	}
	
	
	public static boolean checkIfSorted(int[] arr,int index) {
		
		if(index == arr.length-1) {
			return true;
		}
		
		else if(arr[index] < arr[index+1]) {
			return checkIfSorted(arr,index+1);
		}
		else {
			return false;
		}
	}

	public static int first = -1;
	public static int last = -1;
	private static void findFirstAndLastOccuranceOfAnElementInAString(String str,int index, char c) {
		//base case
		if(index >= str.length()-1) {
			return;
		}
		
		
		if(str.charAt(index) == c) {
			if(first==-1) {
				first = index;
			}else {
				last = index;
			}
		}
		
		findFirstAndLastOccuranceOfAnElementInAString(str, index+1, c);
	}

	public static void printUsingRec(int n) {
		if(n==0) {
			return;
		}
		
		System.out.println(n); //comment these lines and see the difference
		printUsingRec(n-1);
		System.out.println(n);
	}
	
	public static int printSum(int n) {
		if(n==0) {
			return 0;
		}
		return n + printSum(n-1);
				
	}
	
	public static int factorial(int n) {
		if(n<=1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static void fibonacciTillNth(int n,int a, int b) {
		if(n==0) {
			return;
		}
		
		int c = a+b;
		System.out.print(c + " ");
		fibonacciTillNth(n-1,b,c);
		
	}
	
	
	public static int fibonacciAtNth(int n) {
	
		if(n<=2) { //since the first and second terms of fibonacci are 1 only
			return 1;
		}
		return fibonacciAtNth(n-1)+fibonacciAtNth(n-2);
	}
	
	public static int printPower(int x, int n) {
		if(n==0) {
			return 1;
		}
		return x*printPower(x,n-1);
	}
	
	public static int printPowerLogN(int x, int n) {
		if(n==0) {
			return 1;
		}
		if(x==0) {
			return 1;
		}
		//if n is even
		if(n%2 == 0) {
			return (printPowerLogN(x,n/2)*printPowerLogN(x,n/2));
		}else {
			return (printPowerLogN(x,n/2)*printPowerLogN(x,n/2)*x);
		}
	}
}
