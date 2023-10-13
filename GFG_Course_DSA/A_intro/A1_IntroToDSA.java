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
	  * c < log log n < log n < n^1/3 < n^1/2 < n < n^2 < n^3 < n^4 < 2^n < n^n
	  * 
	  * order of growth is the amount of time the algorithm will grow by if the input size increases
	  */
	
	//AYMPTOTIC NOTATIONS
	/*
	 * Big O : exact or upper bound : worst case
	 * Theta : exact : to be used when we know the exact bound on the function
	 * Omega : exact or lower bound : atleast this much time
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
	
	public static boolean isPrime(int n) {
		if(n == 1) //1
			return false;
		if(n == 2 || n == 3) //1
			return true;
		if(n%2 == 0 || n%3 == 0) //1
			return false;
		
		for(int i = 5; i*i < n; i=i+6) { //square root of n
			if(n%i == 0 || n%i+2 == 0) {
				return false;
			}
		}
		return true;
	}
}
