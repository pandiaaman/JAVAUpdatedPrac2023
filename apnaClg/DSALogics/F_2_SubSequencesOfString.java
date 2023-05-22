package DSALogics;

public class F_2_SubSequencesOfString {

	public static void subsequences(String str, int index, String newStr) {
		//base case
		if(index == str.length()) {
			System.out.println(newStr);
			return;
		}
		
		char currentchar = str.charAt(index);
		
		//now this current char has the option to either enter the string or not
		
		//if it enters
		subsequences(str, index+1, newStr+currentchar);
		
		//if it doesnt enter
		subsequences(str, index+1, newStr);
		
	}
	
	public static void main(String[] args) {
		String str = "abcd";
		subsequences(str, 0, "");
	}

}
