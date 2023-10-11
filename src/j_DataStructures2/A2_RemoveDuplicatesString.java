package j_DataStructures2;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*
 * Write a program to remove all the duplicate characters from a given input String, 
 * like, if the given String is "Java" then the output should be "Jav". 
 * The second or further occurrence of duplicates should be removed.
 */
public class A2_RemoveDuplicatesString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String str = sc.next();
			
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for(int i=0;i<str.length();i++) {
			set.add(str.charAt(i));
		}
		
		String result = "";
		
		//how to get the value from a set
		for(Character c : set) {
			result = result.concat(c.toString());
		}
		
		System.out.println(result);
		
		
	}
}
