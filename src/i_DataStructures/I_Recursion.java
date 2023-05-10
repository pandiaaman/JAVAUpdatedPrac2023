package i_DataStructures;

public class I_Recursion {

	public static void main(String[] args) {
		/*
		 * a recursive method calls itself
		 * can be a substitute of iteration
		 * divide a problem into sub problems of the same type as the original
		 * commonly used with advanced sorting algos and for navigating trees
		 * 
		 * Advantages : 
		 * 		easy to debug
		 *  	easy to read/write
		 *  
		 * Disadvantages:
		 * 		slower
		 * 		uses more memory
		 * 
		 * this is slower because with each method we add more method stacks in the memory stack
		 * so since stacks are called in the LIFO manner, if there are lots of stacks the program becomes slower
		 */

		walk(5);
		System.out.println();
		walkRec(5);
		
		//factorial using recursion
		int res = factorialRec(5); //15! = 15*14*13..*3*2*1
		System.out.println(res);
		
		res = powerRec(3,3);
		System.out.println(res);
	}

	private static int powerRec(int n, int i) {
		if(i<1) return 1;
		return n*powerRec(n,i-1);
	}

	private static int factorialRec(int n) {
		if(n <= 1) return 1;
		if(n < 0) return -1;
		
		return n*factorialRec(n-1);
		
	}

	private static void walkRec(int steps) {
		//base case
		if(steps<1) return;
		System.out.println("you take a walk");
		
		walkRec(steps-1); //recursive case
	}

	private static void walk(int steps) {
		for(int i= 0 ; i< steps; i++) {
			System.out.println("you take a walk");
		}
	}
	

}
