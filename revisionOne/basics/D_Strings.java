package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class D_Strings {

	/*
	 * Strings are immutable in java
	 * that means that their value once assigned can not be changed
	 * why are string immutable : 
	 * 		reason is that we want to minimize the copies created of the same string in string pool
	 * strings with same values point to the same address and share storage in the pool
	 * multiple string variables can point to the same memory address in heap in case they have the same value
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String st1 = new String("aman");
		String st2 = "aman";
		String st3 = new String("aman");
		
		System.out.println(st1.hashCode());
		System.out.println(st2.hashCode());
		System.out.println(st3.hashCode()); //all are same
		
		st1 = "yellow";
		System.out.println(st1.hashCode());
		
		StringBuffer strbuf = new StringBuffer("this is a buffer");
		/*
		 * string buffer is thread safe but slow and is mutable
		 */
		
		strbuf.append(" trust me!");
		System.out.println(strbuf);
		
		strbuf.reverse();
		System.out.println(strbuf);
		
		strbuf.append(new char[] {'a','b'});
		System.out.println(strbuf);
		
		char ch = strbuf.charAt(4);
		System.out.println(ch);
		
		strbuf.insert(1, "asdf");
		System.out.println(strbuf);
		
		strbuf.replace(1, 5, ""); //end one is not included
		System.out.println(strbuf);
		
		System.out.println(strbuf.indexOf("a"));
	
		String strbufsub = strbuf.substring(3, 9);
		System.out.println(strbufsub);
		
		
		
		//append, reverse, charAt, indexOf, replace, substring, trim, 
		
		
		//string
		String str1 = new String("welcome to the world of strings!");
		
		str1 = str1.concat(" you wouldn't believe your eyes!");
		System.out.println(str1);
		
		System.out.println(str1.charAt(4));
		
		System.out.println(str1.replace("!", ""));
		
		System.out.println(str1.substring(5));
		
		System.out.println(str1.contains("your"));
		
		System.out.println(str1.repeat(2));
		
		System.out.println("asdf".compareTo("bsdf"));
		
		
		ArrayList<String[]> listNames  = new ArrayList<>(); 
		
		
		int freqval = Collections.frequency(Arrays.asList("abc","def","ghi","abc"), "abc");
		System.out.println(freqval);
		
		
		
		
		
		
		
		
		
		
	}

}
