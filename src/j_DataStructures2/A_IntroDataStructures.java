package j_DataStructures2;

public class A_IntroDataStructures {

	public static void main(String[] args) {
		/*
		 * Data Structure : is a way to organize data in memory
		 * makes it easier to process data
		 * 
		 * can be done in two ways
		 * 		linear : (stored sequentially in memory) : array, linkedList, Stack, Queue
		 * 		non linear : (elements are connected to one another) Graph, Tree
		 * 
		 * Algorithm : set of instructions to perform a task or solve a problem
		 * 	best algo is the one that takes least time and memory/space
		 * 		eg. to find sum of n natural numbers : 
		 * 			if we loop through each element and add all to the predefined sum variable initiated as zero
		 * 			if we use n(n+1)/2 in one line we get our answer
		 * 
		 * 
		 * Time Complexity : amount of time taken by an algorithm to run
		 * 		in above eg, looping will take O(n) time complexity and direct line will have O(1)
		 * 
		 * 
		 * Space Complexity : amount of memory or space taken by an algo to run
		 * 
		 * Asymptotic analysis of algorithm : 
		 * 		helps in evaluating the performance of an algorithm in terms of input size and in relation to the increase in input
		 * 		shows how time and space increase with increase in input size
		 * 
		 * Asymptotic notations : 
		 * 		are mathematical tools that are used to describe the running time of an algorithm in terms of input size
		 * 		we determine the best case(Omega), worst case(Big O) and average case using asymptotic notations
		 * 
		 * 		Omega notation : way to express the lower bound of an algo's running time
		 * 		(Best time an algorithm will take to complete)
		 * 
		 * 		Big O notation : shows the upper bound of an algorithm
		 * 		(Worst time of an algorithm)
		 * 
		 * 		Theta notation : expresses both the upper and the lower bound of an algo 	 
		 */

		double val = 999999;
		
		//finding sum of first n natural nos: using the loop method
		long startTime = System.currentTimeMillis();
		findSum1(val);
		long endTime = System.currentTimeMillis();
		System.out.println("time taken by looping method : " + (endTime - startTime));
		
		//finding the sum of first n natural nos using mathematical formula
		startTime = System.currentTimeMillis();
		findSum2(val);
		endTime = System.currentTimeMillis();
		System.out.println("time taken by mathematical method : " + (endTime - startTime));
	}

	public static void findSum1(double val) {
		double sum = 0;
		for(double i=1;i<=val;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	public static void findSum2(double val) {
		System.out.println(val*(val+1)/2);
	}
}
