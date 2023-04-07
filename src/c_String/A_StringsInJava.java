package c_String;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
//import java.io.StringF

public class A_StringsInJava {

	public static void main(String[] args) throws ParseException {
		long startTime = System.currentTimeMillis();
		// TODO Auto-generated method stub
		int[] a = new int[5];
		char[] c = new char[5];
		char[] ch1 = new char[] {'a','b'};
		char[] ch = {'a','b','c','d','e'};
		String str = new String(ch);
		System.out.println(str);
		
		String stas = new String("hello");
		String s1 = "hello";
		String s2 = "world";
		
		System.out.println(stas.hashCode() + " " + s1.hashCode());
		
		System.out.println(s1.concat(" ").concat(s2));
		
		System.out.println(s1.charAt(1));
		
		System.out.println(s1.compareTo(s1));
		
		System.out.println(s1.contains("he"));
		
		s1 = s1.replace("e", "a"); //string are immutable, can not be changed, so we need to equate it explicitly
		System.out.println(s1);
		
		StringBuilder sb1 = new StringBuilder("hello"); //string builders are not thread safe, ie., two threads can simultaneously work on a stringBuilder object
		sb1.replace(1, 2, "whaa");
		System.out.println(sb1); //string builders are mutable, so we dont need to equate
		
		String ss = s2.substring(3);
		System.out.println(ss);
		
		String s4 = "hello";
		String s5 = "hello";
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode()); //both are same
		
		
		/*
		 * string concatenation can be done using concat, append methods and using +
		 * StringBuilder uses append
		 * also we can use format method
		 * 		String sconct = String.format(%s,%s,s1,s2);
		 * we can use join method : String sjoin = String.join(" ",s1,s2);
		 */
		
		String sjoin = String.join(" ", s1,s2,s4);
		System.out.println(sjoin);
		
		List<String> lstStr = Arrays.asList(s1,s2,s4,s5,sjoin);
		String lstStrConcat = lstStr.stream().collect(Collectors.joining(", "));
		System.out.println(lstStrConcat);
		
//		int to string conversion
		int intA = 10;
		String strIntA = String.valueOf(intA);
		System.out.println(strIntA);
//		string to int conversion
		String strA = "10";
		int intStrA = Integer.parseInt(strA);
		System.out.println(intStrA*2);
		
		//array of characters
		char[] charr = new char[] {'a','b','c','d'};
		String strch = new String(charr);

		//string methods
		String str1 = new String("i am a string");
		System.out.println(str1.charAt(5));
		System.out.println(str1.replace("am", "we"));
		str1.concat("concat");
		
		
		/*
		 * string bufffer vs string builder:
		 * string buffer is thread safe (synchronized), no two threads can access the object simultaneously
		 */
		
		StringBuffer sbuf1 = new StringBuffer("i am string buffer, i am synchronized");
		StringBuilder sbldr1 = new StringBuilder("i am string builder, multiple threads can access me at the same time");
		
		//methods 
		
		/*
		 * append
		 * reverse
		 * insert
		 * length
		 * capacity
		 * ensurecapacity
		 * substring
		 */
		
		//we can create immutable classes by using final class and final variables
		
		//string tokenizer separates the string into multiple tokens/string
		StringTokenizer sttoken = new StringTokenizer(str1);
		while(sttoken.hasMoreTokens()) {
			System.out.println(sttoken.nextToken());
		}
		
		
		String st1 = "hello";
		String st2 = "hello";
		//both point to the same location in the heap
		//hence we only create one object, ie hello
		System.out.println(st1.equals(st2)); //checks for content
		System.out.println(st1 == st2); //checks for reference
		
		System.out.println(st1.hashCode() + " " + st2.hashCode());
		
		//reversing a string in java
		StringBuffer sbo = new StringBuffer("hello");
		System.out.println(sbo.reverse());
		
		String so = new String("hello");
		char[] chararr = so.toCharArray();
		String rev = "";
		for(int i=chararr.length-1;i>=0;i--) {
			rev+=chararr[i];
		}
		System.out.println("by string char : " + rev);
		
		
		//capitalize each word in java
		String stin = new String("hello, as you can see we are having each word capitalized here");
		String[] stinarr = stin.split("\s");
		for( String ast : stinarr) {
			ast = ast.replace(ast.charAt(0), String.valueOf(ast.charAt(0)).toUpperCase().charAt(0));
			System.out.println(ast);
		}
		
	
		//anagram string using st1 and st2
		//usting toCharArrays
		char[] arrchst1 = st1.toCharArray();
		char[] arrchst2 = st2.toCharArray();
		Arrays.sort(arrchst1);
		Arrays.sort(arrchst2);
		boolean result = Arrays.equals(arrchst1, arrchst2);
		System.out.println(result);
		
		//using lists
		List<String> chlist1 = Arrays.asList(st1.split(""));
		Collections.sort(chlist1);
		List<String> chlist2 = Arrays.asList(st2.split(""));
		Collections.sort(chlist2);

		System.out.println(chlist1);
		System.out.println(chlist2);
		
		System.out.println();
		System.out.println(chlist1.equals(chlist2));
		
		
		//java string to date
		String sdt1 = "17/06/2022";
		Date dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdt1);
		System.out.println(dt1);
		
		
		
		int aaa = 12;
		String sss = String.valueOf(aaa);
		
		//date to string
		Date dto = Calendar.getInstance().getTime();
		
		DateFormat dtof = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String stdto = dtof.format(dto);
		System.out.println(stdto);
		
		Date dc = new Date(); //stores todays date
		System.out.println(dc); 
		
		//string to char
		String sc1 = "a";
		char csc1 = sc1.charAt(0); //wont throw an exception since we are only getting the first char
		
		//char to string
		char cc1 = 'a';
		String scc1 = String.valueOf(cc1);
		//or
		String scc11 = Character.toString(cc1);
		
		//string to int
		//if we dont have the numbers in string, it throws NumberFormatException
		try {
			String si1 = "10";
			int isi1 = Integer.parseInt(si1);
			int isi11 = Integer.valueOf(si1);
			//checking the NumberFormatException
			String notint = "asdd";
			int notint1 = Integer.parseInt(notint);
			System.out.println(notint1);
		}catch(NumberFormatException e) {
			System.out.println("**********************************");
			System.out.println("exception caught " + e);
			System.out.println("**********************************");
		}
		
		//int to string
		int ii1 = 12;
		String sii1 = String.valueOf(ii1);
		String isi1 = Integer.toString(ii1);
		String sii2 = String.format("%d", ii1);
		
		//printf is print format : s is string, d is integer, f is float, t is date time, %n is new line
		System.out.printf("%d %f %n %s %n %b %n", 1,2.3,"asd", true);
		
		//string to long
		String sl1 = "23423";
		try {
		long lsl1 = Long.parseLong(sl1);
		System.out.println(lsl1);
		}catch(NumberFormatException e) {
			System.out.println("error : " + e);
		}
		
		//long to string
		long l1 = 23235l;
		String sll1 = String.valueOf(l1);
		System.out.println(sll1);
		

		//float to string
		float f1 = 23.234f;
		String sf1 = String.valueOf(f1);
		String sf2 = Float.toString(f1);
		
		//string to float
		String fs = "234.234";
		float fs1 = Float.parseFloat(fs);
		
		//string to double
		String ds = "234.234";
		double dd1 = Double.parseDouble(ds);
		
		//double to string
		double dd = 234.234;
		String dds = String.valueOf(dd);
		String dds1 = Double.toString(dd);
		
		Date dtoday = new Date();
		DateFormat dformat = new SimpleDateFormat("dd-MM-yy hh:mm");
		String dtodayformatted = dformat.format(dtoday);
		System.out.println(dtodayformatted);
		
		//string to date
		String sdd1 = "23/03/2027 12:33:54";
		DateFormat dff1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date dsdd1 = dff1.parse(sdd1);
		
		//date to string
		String dsdds = dff1.format(dsdd1);
		
		
		//string to object
		String sstr1 = "asd asd";
		Object obj1 = sstr1;
		
		//int to long
		int ail = 23;
		long li = ail; //widening
		Long lil = new Long(ail);
		
		//long to int
		long lli = 23423l;
		int ill = (int) lli;
		int ill2 = lil.intValue();
		
		//double to int
		double di1 = 233;
		int idi1 = (int)di1;
		
		//string to boolean
		String ssb1 = "true";
		boolean bss1 = Boolean.valueOf(ssb1);
		boolean bss2 = Boolean.parseBoolean(ssb1);
		
		
		//date to timestamp
		Date datets = new Date();
		Timestamp ts1 = new Timestamp(datets.getTime());
		
		
		//binary to decimal/int
		String bin1 = "10101";
		int binint1 = Integer.parseInt(bin1,2); //2 is the redix
		System.out.println(binint1);
		
		//decimal to binary
		int intbin1 = 21;
		String intbinc = Integer.toBinaryString(intbin1);
		
		int ival = binaryToInteger("10101");
		System.out.println(ival);
		
		charpercentage("WOW well there it is");
		
		//dupliacte chars in a string
		//frequency of chars in a string
		frequency("well well lets see this".trim());
		
		//isstringrotation
		isStringRotation("hello","elloh");
		
		//reverse and preserve the position of spaces
		revPreserveSpaces("well lets see this one too");
		
		String arr[] = {"abc","def","ghi"};
		String stt = "abc";
		System.out.println(arr[0] == stt);
		
		
		
		
		
		
		
		
		
		
		
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("time taken is : " + (endTime - startTime));
		
		
		
		
	}
	
	public static int binaryToInteger(String s) {
		int input = Integer.parseInt(s);
		//10101
		int result = 0;
		
//		result += Math.pow(2, result%10);
		int n = 0;
		while(input>0) {
			int rem = input%10;
			System.out.print(rem + " : ");
			result += rem * (Math.pow(2, n++));
			System.out.print(result + " : " );
			input = input/10;
			System.out.println(input);
		}
		
		return result;
	}
	
	public static void charpercentage(String str) {
		
		int countuppercase = 0;
		int countlowercase = 0;
		int countdigits = 0;
		int countothers = 0;
		
		int totalcount = str.length();
		
		for(int i = 0; i<str.length();i++) {
			char ch = str.charAt(i);
			
			if(Character.isDigit(ch)) {
				countdigits++;
			}
			else if(Character.isUpperCase(ch)) {
				countuppercase++;
			}
			else if(Character.isLowerCase(ch)) {
				countlowercase++;
			}
			else {
				countothers++;
			}
			
		}
		System.out.println("total : " + totalcount);
		System.out.println("no of uppercase " + countuppercase);

	}

	
	public static void frequency(String str) {
		str = str.replaceAll("\\s", "");
		char[] charr = str.toCharArray();
		Arrays.sort(charr);
		for(char a : charr) {
			System.out.print(a + " ");
		}
		
		HashMap<Character, Integer> freqMap = new HashMap();
		
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
//			System.out.println("entering with " + ch);
			if(freqMap.containsKey(ch)) {
				int val = freqMap.get(ch);
//				System.out.println("present with value : " + val);
				freqMap.put(ch, ++val);
			}
			else {
//				System.out.println("no present yet" + freqMap.get(ch));
				freqMap.put(ch, 1);
			}
		}
		
		System.out.println(freqMap);
		
		Set<Character> keys = freqMap.keySet();  
		for(Character c : keys) {
			if(freqMap.get(c) > 1) {
			System.out.println("for kkey :" + c + " occurs frequency : " + freqMap.get(c));
			}
		}
	}
	
	public static void isStringRotation(String str1, String str2) {
		str1 = str1.trim();
		str2 = str2.trim();
		str1 = str1.replaceAll("\\s", "");
		str2 = str2.replaceAll("\\s", "");
		if(str1.length()!=str2.length()) {
			System.out.println("NOT a rotation");
			return;
		}
		else {
			String str3 =str1 + str1;
			if(str3.contains(str2)) {
				System.out.println("yes its a rotation");
				return;
			}
			else {
				System.out.println("not a rotation");
				return;
			}
			
		}
	}
	
	public static void revPreserveSpaces(String str) {
		System.out.println(str);
		String k = str.trim();
		int noOfSpaces = (int) k.chars().filter(ch -> ch == ' ').count();
		System.out.println(noOfSpaces);
		StringBuffer strBuf = new StringBuffer(str);
		strBuf.reverse();
		String stres = strBuf.toString();
		stres = stres.replaceAll("\\s", "");
		System.out.println(stres + " " + stres.length() + " " + k.length());
		
		
		
		for(int i = k.length()-1;i>=0;i--) {
			if(k.charAt(i) == ' ') {
//				System.out.println(i);
//				String temp1 = stres.substring(0,i-noOfSpaces-1);
//				System.out.println(temp1);
//				String temp2 = stres.substring(i-noOfSpaces-1);
//				stres = temp1 + " "+ temp2;
//				System.out.println(stres);
			}
		}
		System.out.println(stres);
	}
}
