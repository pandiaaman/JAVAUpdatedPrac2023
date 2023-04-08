package a_basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//enums in java
enum Weekday{
	MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);
	
	int value;
	Weekday(int value) {
		this.value = value;
	}
}
public class A_introJAVA {
	
	//java inner classes : must be defined outside the main method
	public class Inner{
		int innervar1 = 3;
		int innervar2;
	};
	
	//defining vars in the outside class
	int outervar1 = 2;
	int outervar2 = 5;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		/*
		 * source code = (compiler) = > byte code = (JVM) = > object code/machine code 
		 */
		
		System.out.println("hello there");
		System.out.print("yooo \n");
		System.out.println("wassup");
		System.out.printf("hi there %s %nyou are %d years old%n", "aman",21);
		
		/*
		 * variables in java : 
		 * 		primitive
		 * 			byte: 1 byte : 8 bits : -2^(8-1) to 2^(8-1)-1
		 * 			boolean: 1 bit
		 * 			char: 2 bytes : 16 bits
		 * 			short: 2 bytes : 16 bits 
		 * 			int: 4 bytes : 32 bits : -32,768 to 32,767
		 * 			float: 4 bytes : 32 bits : can hold upto 6-7 digits of precision
		 * 			double: 8 bytes : 64 bits : can hold upto 15 digits of precision
		 * 			long: 8 bytes : 64 bits
		 * 
		 * 		non primitive
		 * 
		 * every method has a stack memory area, storing its variables 
		 * a class object when created using the new method, is stored in heap area
		 * we create a reference of the object when we have to call that object
		 * this is created in the stack and contains the address of the object in heap area
		 * 
		 * 
		 * 
		 * binary representation : 
		 */
		
		//binary : 3 octal  : 8 hexadecimal : 16
		System.out.println(Integer.parseInt("1101",2));
		
		int binaryNum = 0B1101;
		System.out.println(binaryNum);
		
		int res1 = binaryToDecimal(1101,2);//2 is the base for binary, to get hexadecimal put 16 , for octal put 8
		System.out.println(res1);
		
		//swapping two variables
		int var1 = 3;
		int var2 = 7;
		System.out.println("before swapping : var1:" + var1 + " var2:" + var2);
		var1 = var2 + var1; //10
		var2 = var1 - var2; //3
		var1 = var1 - var2; //7
		System.out.println("swapping #1 : var1:" + var1 + " var2:" + var2);
		
		var1 = var1 + var2 - (var2 = var1);
		System.out.println("swapping #2 : var1:" + var1 + " var2:" + var2);
		
		
		//taking input from user
//		try {
//			System.out.println("input using read, takes in ascii, enter an integer");
//			int inp1 = System.in.read();
//			System.out.println(inp1); //takes in the ascii values and prints them
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//taking inputs using bufferedReader
//		BufferedReader br1 = null;
//		try {
//			System.out.println("enter any integer");
//			InputStreamReader isr1 = new InputStreamReader(System.in);
//			 br1 = new BufferedReader(isr1);
//			int inp2 = Integer.parseInt(br1.readLine());
//			System.out.println(inp2);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				br1.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		//using scanner
		/*
		 * nextLine takes the input with \n at the end
		 * where as the inputs like nextInt do not have \n at the end
		 * so if we have another input coming in after nextInt it will take \n instead as it is still there in scanner
		 * ALWAYS USE NEXTLINE INPUT AFTER NEXTINT TO USE THE \N AFTERWARDS
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("whats your name");
		String inp3 = sc.nextLine();
		System.out.println("You entered : " + inp3);
		
		
		System.out.println("enter an integer");
		int inp4 = 0;
		try {
			inp4 = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println("you entered :" + inp4);
		
		//nextInt() does not read the new line character \n hence after the newLine() we still have one \n in the scanner
		//to remove that we need a nextLine() character
		sc.nextLine();
		
		System.out.println("enter another string YOU WOULD NOTICE WE NEED sc.nextLine() after nextInt() to remove the \n ");
		String inp5 = sc.nextLine();
		System.out.println("you input : " + inp5);
		
		//Operators
		
		/*
		 * arithmetic operators
		 * 		+ - * \/ %
		 * logical operators
		 * 		|| && ^
		 * assignment operators
		 * 		== != =
		 * comparison operators
		 * 		> < >= <= !
		 * bitwise operators
		 * 		| & ^
		 * ternary operators
		 * 		? : 
		 * 
		 * left shift and right shift
		 * 		>> << >>>
		 */
		double var4 = 10;
		var4/=3;
		System.out.println(var4);
		
		
		//Math class
		System.out.println("enter the base and perpendicular to find the hypotenuse of triangle");
		double tribase = sc.nextDouble();
		double triperp = sc.nextDouble();
		
		double trihyp = Math.sqrt(Math.pow(tribase, 2) * Math.pow(triperp, 2));
		System.out.println("hypotenuse of triangle is " + trihyp);
		System.out.println(Math.PI);
		
		//generating random numbers in java
		double rand1 = Math.random();
		System.out.println("generating a random no : " + rand1);
		
		//random no between 1 and 10
		int rand2 = (int) (1 + Math.random()*10);
		System.out.println("random no between 1 and 10 : " + rand2);
		
		Random rand3 = new Random();
		System.out.println(rand3.nextInt()); //result is between the int limits which is -2 billion to 2 billion
		
		//bounding the random values using Random
		System.out.println(rand3.nextInt(6) + 1); // (6) prints between 0 to 5, so we add 1
		
		
		//if statement in java
		if((rand3.nextInt(5)+1) > 4) {
			System.out.println("this is greater than 4");
		}else{
			System.out.println("less than 4");
		}
		
		//switch statement
		int age1 = 12;
		switch(age1) {
		case 12:
			System.out.println("this is 12");
			break;
		case 2:
			System.out.println("this is 2");
			break;
			
		default:
			System.out.println("default");
			
		}
		
		//logical operators
		
		if(true && true) {
			System.out.println("this is and opertor");
		}
		
		if(true || false) {
			System.out.println("this is or operator");
		}
		
		if(!false) {
			System.out.println("this is not operator");
		}
		
		//bitwise operators
		
		System.out.println(3 & 5);
		// 011 & 101 => 001 => 1
		
		//java while loop 
		int i1 = 0;
		while(i1<9) {
			System.out.println(i1);
			if(i1==5) {
				i1++;
				continue;
			}
			if(i1==7) {
				break;
			}
			i1++;
		}
		
		for(int i=0;i<10;i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
		
		
		//nested loops to make a pyramid
		for(int i=1;i<=5;i++) {
//			for(int k=i;k>=0;k--) {
//				
//			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		//arrays
		String[] strarr = new String[] {"str1","str2","str3"};
		for(String str: strarr) {
			System.out.println(str);
		}
		
		for(int i = 0;i<strarr.length;i++) {
			System.out.println(strarr[i]);
		}
		
		//java string methods 
		String str2 = "ahsh dkd akas";
		
		char[] charr1 = str2.toCharArray();
		for(char a : charr1) {
			System.out.println(a);
		}
		
		String[] starr1 = str2.split("\s");
		for(String a : starr1) {
			System.out.println(a);
		}
		
		//primitive //wrapper
		/*--------------------
		 * int		Integer
		 * double 	Double
		 * char		Character
		 * short	Short
		 * long		Long
		 * boolean	Boolean
		 */
		
		//auto-boxing : conversion from primitive to wrapper class
		Boolean bool1 = true;
		Character char1 = 'c';
		Integer int1 = 23;
		Double doub1 = 23.23;
		Float flo1 = 23.24f; 
		
		
		
		//unboxing : conversion from wrapper class to primitive
		int unboxInteger = int1;
		System.out.println(unboxInteger);
		
		
		//arrayList in java
		/*
		 * Collection interface extends Iterable interface
		 * Collection interface has following classes:
		 * 		List
		 * 			ArrayList
		 * 			LinkedList
		 * 		Set
		 * 			HashSet
		 * 			TreeSet
		 * 		Queue
		 * 			PriorityQueue
		 * 			Dequeue
		 * 			
		 */
		List<Integer> ls1 = new ArrayList<Integer>();
		ls1.add(1);
		ls1.add(5);
		ls1.add(2);
		ls1.add(7);
		ls1.add(6);
		ls1.add(4);
		ls1.add(3);
		
		//using streams with array list
		ls1.stream().sorted().forEach(System.out::println);
		ls1.stream().sorted().filter(x->x%2==0).map(x->x*2).forEach(System.out::println);
		
		//replace element in ls1
		ls1.set(3, 4);//at element 3 puts 4
		//remove an element
		ls1.remove(2); //removes the 2nd index //index starts from 0
		
		Iterator itr1 = ls1.iterator();
		while(itr1.hasNext()) {
			System.out.println("iterator through ls1" + itr1.next());
		}
		
		
		List<Integer> ls2 = Arrays.asList(1,2,4,5,7,3,6);
		Collections.sort(ls2);
		
		//2D array list
		ArrayList<ArrayList<String>> grocery  = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> foodItems = new ArrayList<String>();
		foodItems.add("potatoes");
		foodItems.add("bhindi");
		foodItems.add("biscuits");
		
		ArrayList<String> drinkItems = new ArrayList<String>();
		drinkItems.add("mango juice");
		drinkItems.add("orange juice");
		
		System.out.println(foodItems);
		System.out.println(drinkItems);
		
		grocery.add(foodItems);
		grocery.add(drinkItems);
		
		System.out.println(grocery);
		
		//using hash map
		HashMap<String,ArrayList<String>> groceryMap = new HashMap<String,ArrayList<String>>();
		groceryMap.put("drinkItems", drinkItems);
		groceryMap.put("foodItems", foodItems);
		
		ArrayList<String> foodRes = groceryMap.get("foodItems");
		System.out.println(foodRes);
		
		//hashtable 
		Hashtable<String,ArrayList<String>> groceryTable = new Hashtable<String,ArrayList<String>>();
		groceryTable.put("drinkItems", drinkItems);
		groceryTable.put("foodItems", foodItems);
		
		//printf method
		System.out.printf("hello there %s you are %d years old right? %n btw you got %f in maths that is %b %n", "aman",25,23.34f,true);
		
		//to define the number of digits to come after decimal in float value : %.2f shows two digits after decimal
		System.out.printf("%.2f",125.32568);
		
		//dates in java
		Date dt1 = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dt1);
		System.out.println(df1.format(dt1));
		
		String dt2 = df1.format(new Date());
		
		Calendar cl = Calendar.getInstance();
		Date dt3 = cl.getTime();
		System.out.println("using calendar" + dt3);
			
		//roll a dice
		System.out.println((int)(1+Math.random()*6));
		System.out.println(new Random().nextInt(6)+1);
		
		
		//access modifiers in java
		/*
		 * private visible only to class
		 * public visible to all classes
		 * protected within package
		 * default
		 */
		
		
		//Exception handling:
		/*
		 * Throwable class:
		 * 		Exception and Errors
		 * 		Compile Time exception 		Run Time Exceptions
		 * 		(checked exceptions)		(unchecked exceptions)
		 *   	--------------------------------------------------
		 * 		classNotFoundException		IndexOutOfBoundsException
		 * 		IOException					ArithmeticException
		 * 		SQLException				IllegalThreadStateException
		 * 		CloneNotSupportedException	NullPointerException
		 * 		FileNotFoundException		ClassCastException
		 */
		
		
		//file class in java
		try {
			File file1 = new File("xyz.txt");
			FileInputStream fis1 = new FileInputStream(file1);
			System.out.println(file1.getPath());
			System.out.println(file1.getAbsolutePath());
		
		}catch(IOException e) {
			System.out.println("IO exception");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("can not find the file");
			e.printStackTrace();
		}
		
		//writing to a file
		FileWriter writer = null;
		try {
			File file2 = new File("abc.txt");
			writer = new FileWriter(file2);
			writer.write("roses are red violets are blue, strings are objects, boolean can be false or true");
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//reading from a file
		/*
		 * FileReader : reads stream of characters. one by one read() retruns an int value which contains the byte value
		 * 	when read() returns -1 there is no more data to read.
		 */
		try {
			FileReader reader = new FileReader("abc.txt");
			int data = reader.read();
			while(data!= -1) {
				System.out.print((char) data);
				data = reader.read();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		//java method chaining
		String str5 = "bro";
		System.out.println(str5.concat("  code    ").toUpperCase().trim().concat(" asdf"));
		
		//enums
		Weekday day = Weekday.MONDAY;
		System.out.println(day.value);
		
		
		//hashmaps: 
		/*
		 * extends AbstractMap and implements Map, Cloneable, Serializable
		 * very similar to array list, they contain key value pairs of objects
		 * they are not thread safe or not synchronized that is that two threads can simultaneously work on them
		 * thread safe option will be hash table 
		 * we can store null values as well unlike hash table, it can have one null key and multiple null values
		 * keys can not be duplicated, they must be unique
		 * hash map does not maintain any order
		 * initial capacity is 16, just like string buffer/string builder
		 * 
		 */
		
		HashMap<Integer,String> hmap1 = new HashMap<Integer,String>();
		hmap1.put(1, "one");
		hmap1.put(2, "two");
		hmap1.put(3, "three");
		hmap1.put(4,"four");
		
		System.out.println("map : " + hmap1);
		
		hmap1.remove(3);
		System.out.println("after removing 3 :" + hmap1);

		HashMap<Integer,String> hmap2 = (HashMap<Integer, String>) hmap1.clone();
		System.out.println("clone :" + hmap2);
		
		hmap1.put(5, "five");
		
		//get
		System.out.println(hmap1.get(4));
		
		//printing the key value pairs using entrySet()
		for(Map.Entry<Integer, String> entry : hmap1.entrySet()) {
			System.out.println("key : " + entry.getKey() + " -> value : " + entry.getValue());
		}
		
		//size
		System.out.println(hmap1.size());
		
		//to see if given key is present or not
		System.out.println("contains key 3 ? :" + hmap1.containsKey(3));
		
		//clearing the hashmap
		hmap1.clear();
		System.out.println("after clear : " + hmap1);
		
		
		//custom exceptions
		/*
		 * checked : compile time : FileNotFound, ClassNotFound, IOException, SQLException, ClassCast
		 * unchecked : run time : 	NullPointer, Arithmetic, IndexOutOfBounds, IllegalThreads
		 * 
		 * UserMade Exceptions : extends Exception
		 */
		System.out.println("enter the age");
		int ageinp = sc.nextInt();
		
		try {
			checkAge(ageinp);
		}catch(AgeException e) {
			System.out.println("age is less than 18");
			e.printStackTrace();
		}
		
		
		
		
		A_introJAVA outerOb = new A_introJAVA();
		A_introJAVA.Inner innerOb = outerOb.new Inner(); 
		innerOb.innervar1 = 4;
		
		
		//lambda expressions
		/*
		 * mainly used to call the Single abstract methods in the functional interface, like Runnable, or other custom functional interfaces
		 * 
		 */

		
		
		
		
		
		System.out.printf("%n %n %n");
		sc.close();
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime - startTime));
	}
	
	
	
	public static int binaryToDecimal(int n,int base) {
		int result = 0;
		int rem;
		int i = 0;
		while(n>0) {
			rem = n%10;
			result += (int) (rem * Math.pow(base, i++));
			n/=10;
		}
		return result;
	}
	
	public static void checkAge(int age) throws AgeException {
		if(age<18) {
			throw new AgeException("age is less than 18");
		}
		else {
			System.out.println("you are allowed to enter");
		}
	}

}

class AgeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AgeException(String message){
		super(message);
	}
}
