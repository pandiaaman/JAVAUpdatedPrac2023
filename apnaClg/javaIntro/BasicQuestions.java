package javaIntro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQuestions {

	public static void main(String[] args) {
		
	
		//find the factorial using recursion 
		int factorialRec = factorialRec(3);
		System.out.println(factorialRec);
		
		Scanner sc = new Scanner(System.in);
		int positives = 0, negatives = 0, zeros = 0;
		while(true) {
			System.out.println("do you want to input a number? 1 yes 2 no");
			int n= sc.nextInt();
			if(n==1) {
				System.out.println("enter your no");
				int p = sc.nextInt();
				System.out.println("you entered " + p);
				if(p<0) {
					negatives++;
				}
				else if(p==0) {
					zeros++;
				}
				else if(p>0) {
					positives++;
				}
			}
			else {
				break;
			}
		}
		System.out.printf("you are out with %d positives, %d zeros and %d negatives", positives, zeros, negatives);
		
		
		//finding greatest common divisor of two numbers
		int p = gcd(36,8);
		System.out.println("GCD of 36 and 8 is " + p);
		System.out.println();
		findfactors(36).forEach(x -> System.out.println(x));
		
		
		//GCD: 
		/*
		 * Euclidean algorithm (repeated subtraction):

This approach is based on the principle that the GCD of two numbers A and B will be the same even 
if we replace the larger number with the difference between A and B. In this approach, we perform
GCD operation on A and B repeatedly by replacing A with B and B with the difference(A, B) as long 
as the difference is greater than 0.
		 */
		int gcdrec = gcdrecursion(30,20);
		System.out.println("gcd using recursion by euclidian " + gcdrec);
		
		fibonacciseries(10);
		System.out.println("fib using recursion :" + fibonaccirecursion(7));
		
		String stt = sc.next();
		int avar = sc.nextInt();
		String stt1 = sc.nextLine();
		sc.next();
		int avar1 = sc.nextInt();
		
		System.out.println(stt + " " + avar + " " + stt1 + " " + avar1);
		
		
		String str = "asdf";
		StringBuffer stbuf = new StringBuffer(str);
		
		System.out.println(stbuf);
	}
	
	
	
	public static int factorialRec(int n) {
		if(n<0) {
			return -1;
		}
		//base case
		if(n<=1) {
			return 1;
		}
		return n*factorialRec(n-1);
	}
	
	public static int gcd(int a, int b) {
		List<Integer> fact1 = findfactors(a);
		
		List<Integer> fact2 = findfactors(b);
		
		System.out.println("factors of " + a);
		fact1.forEach(x -> System.out.println(x));
		
		System.out.println("factors of " + b);
		fact2.forEach(x -> System.out.println(x));
		
		fact1.retainAll(fact2);
		
		System.out.println("after retaining");
		fact1.forEach(x-> System.out.println(x));
		if(fact1.size() == 0) {
			return 1;
		}
		else {
			return fact1.get(fact1.size()-1);
		}
	}
	
	public static List<Integer> findfactors(int n) {
		List<Integer> listfactors = new ArrayList<Integer>();
		for(int i=1;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				if(i==n/i) {
					listfactors.add(i);
				}else {
					listfactors.add(i);
					listfactors.add(n/i);
				}
			}
		}
		
		Collections.sort(listfactors,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) return 1;
				else return -1;
			}
			
		});
		return listfactors;
	}
	
	public static int gcdrecursion(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcdrecursion(b, Math.abs(b-a));
		}
	}

	
	public static void fibonacciseries(int n) {
		int a=1;
		int b=1;
		System.out.print(a + " " + b + " ");
		int c;
		for(int i=1;i<=n;i++) {
			c= a+b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
	
	public static int fibonaccirecursion(int n) {
		//base case
		if(n==0)
			return 0;

		if(n==1 || n==2)
			return 1;
		return fibonaccirecursion(n-1) + fibonaccirecursion(n-2);
	}
}
