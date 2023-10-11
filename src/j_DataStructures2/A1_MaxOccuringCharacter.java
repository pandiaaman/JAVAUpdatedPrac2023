package j_DataStructures2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Write an efficient Java/C/Python program to return the maximum occurring character 
 * in the input string, e.g., if the input string is "Java" then the function should return 'a'.
 */
public class A1_MaxOccuringCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		int[] alphabets = new int[26];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the string");
		String str = sc.next();
		str = str.toLowerCase();
		
		//first method : create 26 size array, increment the letter value by 1 : O(n)	
		char[] chararr = str.toCharArray();
		
		int i=0;
		while(i<chararr.length) {
			alphabets[chararr[i] - 97]++;
			i++;
		}
		
		int maxChar = -1;
		int maxVal = 0;
		for(int j=0;j<alphabets.length;j++) {
//			System.out.println(alphabets[j]);
			if(alphabets[j] > maxVal) {
				maxChar = j;
				maxVal = alphabets[j];
			}
		}
		
		System.out.println((char)(maxChar+97));
		
		
		//second method : using hashmap
		//store key value pairs, if the key already exists then increment the value by one
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int k=0;k<chararr.length;k++) {
			if(charMap.containsKey(chararr[k])) {
				charMap.put(chararr[k], charMap.get(chararr[k])+1);
			}else {
				charMap.put(chararr[k], 1);
			}
		}
		
		System.out.println(charMap);
		
		
		for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			System.out.println(entry.getKey() + " ->  " + entry.getValue() );
		}
		
		Character key = Collections.max(charMap.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println(key);
	}

}
