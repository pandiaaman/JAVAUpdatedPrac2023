package dataStructures;

public class G_1_PalindromePartitioningProblem {

	/*
	 *  “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
	 *  Determine the fewest cuts needed for a palindrome partitioning of a given string.
	 *  For example, minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.
	 */
	
	/*
	 * process : if a string is palindrome we can return 0
	 * Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, 
	 * 		recursively calculate the cost for each cut and return the minimum value. 
	 * 
	 */
	
	public static void main(String[] args) {
		String str = "abbabaaabaababa";
//		System.out.println("min no of cuts required for palindromic partitioning are : " + minPalindromeP);
	}
}
