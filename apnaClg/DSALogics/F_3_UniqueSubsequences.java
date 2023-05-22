package DSALogics;


import java.util.Comparator;

import java.util.Set;
import java.util.TreeSet;

public class F_3_UniqueSubsequences {

	public static Set<String> uniqueSubSeq1 = new TreeSet<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {	
			return o2.length() - o1.length();
		}
		
	});
	public static Set<String> uniqueSubSeq2 = new TreeSet<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {	
			return o2.length() - o1.length();
		}
		
	});
	
	public static void uniqueSubsequences(String str, int index, String newStr, Set<String> set) {
		//base case
		if(index == str.length()) {
			set.add(newStr);
			return;
		}
		
		char currentChar = str.charAt(index);
		
		//if we add that char to the subsequence
		uniqueSubsequences(str, index+1, newStr+currentChar,set);
		
		//if we do not add that char
		uniqueSubsequences(str, index+1, newStr,set);
		
	}
	
	public static String longestSubsequence(Set<String> uniqueSubSeq1, Set<String> uniqueSubSeq2) {
		for(String s1 : uniqueSubSeq1) {
			for(String s2 : uniqueSubSeq2) {
				if(s1.equals(s2)) {
					System.out.println(s1);
					return s1;
				}
			}
		}
		return "none";
	}
	
	public static void main(String[] args) {
		String str = "abc";
		uniqueSubsequences(str, 0, "", uniqueSubSeq1);
		
		uniqueSubSeq1.stream().forEach(System.out::println);
		
		String str1 = "abc";
		uniqueSubsequences(str1, 0, "", uniqueSubSeq2);
		
		uniqueSubSeq2.stream().forEach(System.out::println);
		
		System.out.println("longest subsequence");
		
		longestSubsequence(uniqueSubSeq1, uniqueSubSeq2);
		
		
		


	}

}
