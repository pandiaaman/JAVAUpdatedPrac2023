package DSALogics;


/*
 * backtracking is a very common and an important concept in DSA
 * lets take the example of permutations of a string
 * 
 * to calculate each permutation of a string, we reach to the end and we go back to find another combination
 * this process of going back to find another combination is called backtracking
 */
public class F_91_Backtracking {

	public static void printPermutations(String str, String resultString) {
		//base case
		if(str.length() == 0) {
			System.out.println(resultString);
			return;
		}

		
		for(int i=0;i<str.length();i++) {
			char currentChar = str.charAt(i);
			
			printPermutations(str.substring(0,i) + str.substring(i+1), resultString+currentChar);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printPermutations("abc","");
	}

}
