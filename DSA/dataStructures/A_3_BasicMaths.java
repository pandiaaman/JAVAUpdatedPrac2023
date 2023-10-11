package dataStructures;

import java.util.Arrays;

public class A_3_BasicMaths {

	public static int factorial(int k) {
		if(k<=1) {
			return 1;
		}
		return k * factorial(k-1);
	}
	
	public static int trailingZerosFactorial(int k) {
		
		int res = 0;
		for(int i=5;i<=k;i=i*5) {
			res = res + (k/i);
		}
		return res;
	}
	
	public static boolean isNumberPalindrome1(String k) {
		StringBuilder str = new StringBuilder(k);
		
		if(k.equals(str.reverse().toString())) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumberPalindrome2(int k) {
		int rev = reverse(k);
//		System.out.println(rev);
		return k==rev?true:false;
	}
	
	public static int reverse(int k) { //123
		int rev = 0;
		int rem = 0;
		while(k>0) {
			rem = k%10; //3
			rev = rev*10 + rem;
			k = k/10; //12
		}
		return rev;
	}
	
	public static boolean isPrime(int n) {
		if((n&1)==0 && n>2) {
			//n%2==0
			return false;
		}
		if(n<1) {
			return false;
		}
		for(int i=3;i<=Math.sqrt(n);i=i+2) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean[] seiveOfErathoSthenes(int n) {
		boolean[] isPrime = new boolean[n+1];
		
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false; //0 is not prime, we are taking it in since arrays are 0 index based
		isPrime[1] = false; //1 is not prime
		
		
		for(int i=2; i<Math.sqrt(n); i++) {
			for(int j = 2*i; j<=n; j+=i) { //moving from 2nd multiple and moving forward i times so its a table of i
				isPrime[j] = false;
			}
		}
		
		
		return isPrime;
	}
	
	
	public static int gcdbruteforce(int a, int b) {
		
		int i;
		if(a<b) {
			i=a;
		}else {
			i=b;
		}
		
		for(int j = i; j>1; j--) {
			if(a%j == 0 && b%j == 0) {
				return j;
			}
		}
		return 1;
	}
	
	public static int gcdeuclidian(int a, int b) {
		
		if(b==0) {
			return a;
		}
		else {
//			return gcdeuclidian(b,Math.abs(a - b));
			return gcdeuclidian(b, a%b);
		}
	}
	
	
	public static int fastPower(int a, int b) {
		int res = 1;
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("factorial of 5 : " + factorial(5));
		System.out.println("no of trailing zeros in 12! : " + trailingZerosFactorial(12));
		System.out.println("is 121 palindrome ? " + isNumberPalindrome1(Integer.toString(121)));
		System.out.println("is 15951 palindrome ? " + isNumberPalindrome2(15951));
		System.out.println("is 17 prime ? " + isPrime(17));
		System.out.println("array of prime values till 20 using seive of eratoshenes : " + Arrays.toString(seiveOfErathoSthenes(20)));
		System.out.println("gcd of 30 and 20 : " + gcdbruteforce(30, 20));
		System.out.println("gcd euclidian of 30 and 20 : " + gcdeuclidian(30, 20));
	}
}
