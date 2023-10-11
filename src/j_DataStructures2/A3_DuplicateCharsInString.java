package j_DataStructures2;

import java.util.HashSet;
import java.util.Scanner;

/*
 * Write an efficient Java/C/Python/Ruby program to return the duplicate characters from given String, 
 * for example, if given String is "C++" then your program should print "+" Similarly, 
 * if the input is "Java and JavaScript" then your program should print "J", "a" and "v". 
 * You can ignore the case for finding duplicates.
 */
public class A3_DuplicateCharsInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String str = sc.next();
		
		HashSet<Character> set = new HashSet<Character>();
		HashSet<Character> resultSet = new HashSet<Character>();
		for(int i=0;i<str.length();i++) {
			if(!set.contains(str.charAt(i))) {
				set.add(str.charAt(i));
			}else {
				resultSet.add(str.charAt(i));
			}
		}
		
		System.out.println(resultSet);
		
	}
}
