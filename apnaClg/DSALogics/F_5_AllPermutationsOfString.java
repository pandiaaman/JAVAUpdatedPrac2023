package DSALogics;

public class F_5_AllPermutationsOfString {

	/*
	 * time complexity : O(n!)
	 * permutations : 
	 * 
	 * abc => abc,acb, bac,bca, cab,cba
	 */
	public static void printPermutations(String input, String newStr) {
		//base case
		if(input.length() == 0) {
			System.out.println(newStr);
			return;
		}
		
		for(int i=0;i<input.length();i++) {
			char currentChar = input.charAt(i);
			
			String subStr = input.substring(0,i) + input.substring(i+1); //if abc comes in, this gives us bc for 0th index
			
			printPermutations(subStr,newStr+currentChar);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		String input = "abc";

		printPermutations(input, "");
		
	}

}
