package A_intro;

import java.util.Scanner;

public class A1_IntroToDSA {

	/*
	 * DSA : data structures and algorithms
	 * 
	 * DS : how we store data efficiently
	 * Algorithms : write the efficient code
	 * 
	 * makes you a better software developer
	 * helps you get insights about the internal workings
	 * competitive coding
	 * 
	 * Roadmap : 
	 *  language -> Java, C++, Python, JavaScript
	 *  DSA basics and implementation : array, linked list, stack, queue, hashmaps, sets, binary search, tree, sorting algos
	 *  	search algos, trees, knapsack, recursion, dynamic programming
	 *  language libraries
	 *  practice techniques : sliding window etc
	 *  
	 * C/C++ : compiled languages
	 * Java/Python : interpreted languages
	 * Python is even better than Java, we need to type even less, but it is even slower
	 */
	
	//ANALYSIS OF ALGORITHMS
	
	/*
	 * below are two ways of running sum of n terms
	 * 
	 * => Asymptotic analysis : 
	 * 		measure the order of growth of a function of program given input size
	 * 		we can analyze the algorithm without implementing them
	 * 
	 * expression of time taken by the code in terms of input size
	 *  
	 * 
	 */
	
	//ORDER OF GROWTH
	 /*
	  * c < log log n < log n < n^1/3 < n^1/2 < n < n < n^2 < n^3 < n^4 < 2^n < n^n
	  */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no");
		int n = sc.nextInt();
		
		int result1 = sumOfN(n);
		System.out.println(result1);
		
		int result2 = sumOfNImproved(n);
		System.out.println(result2);
	}
	
	public static int sumOfN(int n) {
		if(n<=0) {
			return -1;
		}
		int sum = 0;
		for(int i=1;i<=n;i++) { //O(n)
			sum += i;
		}
		
		return sum;
	} 
	
	public static int sumOfNImproved(int n) {
		return n*(n+1)/2; //O(1)
	}
}
