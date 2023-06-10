package dataStructures;

public class Z_1_AllPossibleSubstrings {

	public static void allSubstrings(String str, String res, int index) {
		
		//each letter has the option to either be a part or not be a part of the substring
		
		//base case
		if(index == str.length()) {
			System.out.println(res);
			return;
		}
		
		char currChar = str.charAt(index);
		
		//including the char
		allSubstrings(str, res+currChar, index+1);
		//not including the char
		allSubstrings(str, res, index+1);	
		
	}
	public static void main(String[] args) {
		String st1 = "abc";
		allSubstrings(st1,"", 0);
	}
}
