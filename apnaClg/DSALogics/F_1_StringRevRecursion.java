package DSALogics;

public class F_1_StringRevRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello there";
		
		reverseNormal(str);
		
		reverseRecursion(str,str.length());
		
	}
	
	public static void reverseRecursion(String str, int len) {
		//base case
		if(len == 0) {
			return;
		}
		
		System.out.print(str.charAt(len-1));
		reverseRecursion(str,len-1);
		
	}
	
	
	public static void reverseNormal(String str) {
		char[] charr = str.toCharArray();
		char[] res = new char[charr.length];
		int p = 0;
		for(int i=charr.length-1;i>=0;i--) {
			res[p] = charr[i];
			p++;
		}
		
		String strres = new String(res);
		System.out.println(strres);
	}

}
