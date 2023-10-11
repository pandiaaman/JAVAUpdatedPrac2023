package j_DataStructures2;

import java.util.Scanner;

/*
 * Write an efficient program to print all permutations of a given String
 * For example, if given input is "123" then your program should print all 6 permutations 
 * e.g. "123", "132", "213", "231", "312" and "321".
 */
public class A6_AllPermutationsOfString {

	public static void main(String[] args) {
		
		//using recursion
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		
		String str = sc.nextLine();
		
		printPermutations(str, "");
		
		
	}
	
	public static void printPermutations(String str, String resultString) {
		
		if(str.length() == 0) {
			System.out.println(resultString);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char currentChar = str.charAt(i);
			
			String subString = str.substring(0,i)+str.substring(i+1);
			
			printPermutations(subString, resultString+currentChar);
		}
		
	}
	
}
