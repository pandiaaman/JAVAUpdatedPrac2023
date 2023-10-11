package j_DataStructures2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Write an efficient program in Java/C/C++ to check if two String is an anagram of each other. 
 * An anagram contains are of the same length and contains the same character, but in a different order, 
 * for example, "Army" and "Mary" is the anagram. Your program should return true if both Strings are the anagram, 
 * false otherwise
 */
public class A8_Anagram {

	public static void main(String[] args) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter first string");
		String str1 = sc.nextLine();
		System.out.println("enter second string");
		String str2 = sc.nextLine();
		
		if(str1.length() != str2.length()) {
			System.out.println("not anagrams");
			return;
		}
		
		for(Character c : str1.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c,1);
			}
		}
		
		System.out.println(map);
		
		for(Character c : str2.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)-1);
			}
			else {
				System.out.println("not anagrams");
				return;
			}
		}
		
		System.out.println(map);
		
		int sum = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			sum = sum + entry.getValue();
		}
		
		if(sum==0) {
			System.out.println("anagrams");
		}else {
			System.out.println("not anagrams");
		}
		
		
		
		
//		for(int i=0;i<)
		
		
	}
}
