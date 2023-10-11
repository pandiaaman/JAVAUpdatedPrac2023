import java.util.regex.Pattern;

public class TestTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		System.out.println("hello");
		
		//mutable
		String str1 = "hello";
		
		String str2 = new String("hello21");
		
		//immutable
		StringBuffer strbuf = new StringBuffer("hello buffer");
		
		StringBuilder strbuild = new StringBuilder("heeloo builder");
		
		
		//
		int in = 5;
		
		String stri = String.valueOf(in);
		
		
		String strr1 = "krishna123";
		String strr2 = "aman456krishna";
		
		int n1 = strr1.length();
		int n2 = strr2.length();
		
		int[] arr = new int[36]; //26 are alpha and 10 are digits
		
		for(int i1 = 0; i1< n1 ; i1++) {
			System.out.println(strr1.charAt(i1));
			if(Pattern.matches("\\d", strr1.charAt(i1)+"" )) {
				System.out.println("number" + strr2.charAt(i1));
				arr[Integer.parseInt(strr2.charAt(i1)+"") + 26] = -1;
			}else {
				arr[strr1.charAt(i1) - 'a'] = -1;
			}
		}
		
		for(int i = 0; i< arr.length; i++) {
			System.out.println(i + " " + arr[i]);
		}
		
		String finalString = "";
		
		for(int i2 = 0; i2< n2 ; i2++) {
//			if(Pattern.matches("\\d", strr2.charAt(i2)+"" )) {
//				arr[strr2.charAt(i2) + 26] = -1;
//			}else {
				if(arr[strr2.charAt(i2) - 'a'] != -1) {
					finalString += strr2.charAt(i2);
				}
//			}
		}
		
		System.out.println(finalString);
		
		
		
//		if(strr2.length() > strr1.length()) {
//			for(int i = 0 ; i< strr2.length() ; i++) {
//				char c = strr1.charAt(i);
//				
//				if(!strr2.contains(c+"")) {
//					System.out.print(c);
//				}
//			}
//		}
//		for(int i = 0 ; i< strr1.length() ; i++) {
//			char c = strr1.charAt(i);
//			
//			if(!strr2.contains(c+"")) {
//				System.out.print(c);
//			}
//		}
		
		//hashing for uncommon
//		System.out.println('f' - 'a');
//		System.out.println(9 - 'a');
//
//		System.out.println("7");
	System.out.println(Pattern.matches("\\d", "4"));
	}

}
