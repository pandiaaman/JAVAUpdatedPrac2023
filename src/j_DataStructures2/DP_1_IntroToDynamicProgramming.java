package j_DataStructures2;

import java.util.Arrays;

public class DP_1_IntroToDynamicProgramming {

	/*
	 * TOP DOWN => Recursion + Memoization
	 * BOTTOM UP => Tabulation
	 * space optimization
	 */
	
	public static void main(String[] args) {
		
		//fibonacci basic using recursion
//		printfibonacciRecursion(1, 1, 10);
		
		int n=5;
		
		int[] dpArr = new int[n+1];
		Arrays.setAll(dpArr, (index)->-1);
		
		System.out.println(fibonacciSum(n, dpArr));
	}
	
	public static void printfibonacciRecursion(int a, int b, int n) {
		//base case
		if(n<=0) {
			return;
		}
		System.out.println(b);
		printfibonacciRecursion(b, a+b, n-1);
	}
	
	public static int fibonacciSum(int n, int[] dpArr) {
		//base case
		if(n<=1) {
			return n;
		}
		if(dpArr[n]!=-1) {
			return dpArr[n];
		}
		dpArr[n] =  fibonacciSum(n-1, dpArr)+fibonacciSum(n-2, dpArr);
		return dpArr[n];
	}
	
}
