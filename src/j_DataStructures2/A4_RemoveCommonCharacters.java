package j_DataStructures2;

import java.util.Scanner;

/*
 * Write an efficient Java/c/Python function that takes two strings as arguments and removes the 
 * characters from the first string, which are present in the second string. 
 * For example, if the first String "India is great" and the second String is "in" then the output should be "da s great"
 */
public class A4_RemoveCommonCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first string");
		String str1 = sc.nextLine();
		System.out.println("enter second string");
		String str2 = sc.nextLine();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		String result = "";
		
		for(int i=0;i<str1.length();i++) {
			
			if(!str2.contains(str1.subSequence(i, i+1))) {
				result = result.concat(str1.substring(i, i+1));

			}
		}
		
		System.out.println(result);
	}
}
