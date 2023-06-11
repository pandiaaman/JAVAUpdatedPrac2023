package a_basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import java.util.Timer;
import java.util.TimerTask;

//enums in java
enum Weekday{
	MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);
	
	int value;
	Weekday(int value) {
		this.value = value;
	}
}
//just a small change coming from linux side
//threads interface runnable
class TryThread1 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<15;i++) {
			System.out.println("thread implementing runnable " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//threads extends Thread
class TryThread2 extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println("thread extending Thread " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class A_introJAVA implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		
		//binary : 2 octal  : 8 hexadecimal : 16
		System.out.println(Integer.parseInt("1101",2));
		
		int binaryNum = 0B1101;
		System.out.println("binaryyyyyyyyyyyyyyyyyyyyyyyy" + binaryNum);
		
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
		
		Iterator<Integer> itr1 = ls1.iterator();
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
		 * 
		 * threads:
		 * a thread is the minimum unit of processing in java
		 * 
		 */

		//to see the active threads:
		System.out.println(Thread.activeCount());
		
		//name of the running thread
		System.out.println(Thread.currentThread().getName());
		
		//priority fo the thread : 5 is the nominal priority : it ranges from 1 to 10
		/*
		 * priority does not mean that it will run before the lesser priority threads, but in case of notify 
		 * or a deadlock the higher priority thread is given more importance
		 * 
		 * main is a thread in itself
		 */
		System.out.println(Thread.currentThread().getPriority());
		
		
		//using thread.sleep for the main thread in middle of a loop
		for(int i=0;i<5;i++) {
			System.out.println("loop breaking using thread sleep in main :" + i);
			try {
				Thread.sleep(1000);
			}catch(IllegalThreadStateException | InterruptedException e) {
				System.out.println(e);
			}
		}
		
		Runnable runnable1 = new TryThread1(); //making object of a class that implements runnable
		Thread thread1 = new Thread(runnable1); //passing the runnable object to thread object in constructor
		
		Thread thread2 = new TryThread2(); //making object of a class that extends thread
		
		thread1.start();//bringing the thread in the runnable state, scheduler calls the run method and it goes to running state
		thread2.start();
		
		//creating a thread using anonymous class
		Runnable runnable3 = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("thread anonymous runnable " + i);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread3 = new Thread(runnable3);
		thread3.start();
		
		//creating a thread using lambda method
		Runnable runnable4 = () -> {
			for(int i=0;i<5;i++) {
				System.out.println("thread anonymous lambda runnable " + i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread4 = new Thread(runnable4);
		thread4.start();
		
		//easiest way to call
		new Thread(() -> {
			for(int i=50;i<60;i++) {
				System.out.println("thread new object with lambda passed " + i);
				try {
					Thread.sleep(1700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start(); //WE CANT USE JOIN ON THIS SINCE WE DONT HAVE AN OBJECT TO SPECIFY
		
		try {
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		/*
		 * deamon threads are low priority threads that run in the background to perform other functions
		 * that help the main threads like garbage collection etc, JVM terminates when all the user threads
		 * (non-deamon) finish their work
		 */
		
		
		/*
		 * generics in java
		 * changes the input type depending on the type that is passed
		 * shown by <T>
		 * we use wrapper classes with these
		 */
		//lets say we want to display the array with different types
		Integer[] intarr1 = {1,2,3,4};
		Double[] doublearr1 = {1.2,4.4,3.5,1.6};
		Character[] chararr1 = {'a','v','t'};
		
		displayArray(intarr1);
		displayArray(doublearr1);
		displayArray(chararr1);
		
		returnFirstGeneric(intarr1);
		returnFirstGeneric(doublearr1);
		returnFirstGeneric(chararr1);
		
		 //serialization in java
		/*
		 * converting an object to a byte stream and storing it in a text file to be transferred 
		 * to a different system so as to be used there	 
		 * 
		 * variables with transient keyword are not serialized
		 * 
		 * class must implement serializable
		 */
		//writing object
		File fileToSerialize = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		A_introJAVA objser1 = new A_introJAVA();
		objser1.outervar1 = 2;
		objser1.outervar2 = 4;
		
		try {
			fileToSerialize = new File("fileToDeserialize.txt");
			fos = new FileOutputStream(fileToSerialize);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objser1);
		}catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		//reading the object
		//deserialization
		String filePath = fileToSerialize.getAbsolutePath();
		
		File fileToDeserialize = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fileToDeserialize = new File(filePath);
			fis = new FileInputStream(fileToDeserialize);
			ois = new ObjectInputStream(fis);
			A_introJAVA deserializedOb = (A_introJAVA)ois.readObject();
			System.out.println(deserializedOb.outervar1);
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Timer and TimerTask
		 * 
		 * Timer : facility for threads to schedule tasks for future execution once the timer hits a certain level
		 * TimerTask : the task that is scheduled for one time or repeat execution by the timer
		 *
		 */
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println("task is completed");
			}
		};
		
		//now we need to link this task to the timer
		timer.schedule(task, 0); //if time is 0 then the task happens immediately , second argument is delay
		
		//lets create an instance of Calendar class if we want to fix a future date for this task to run
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 9);
		cal.set(Calendar.HOUR_OF_DAY, 0); //0 for midnight 0 to 24
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		//adding the timer to the task now
		timer.schedule(task, cal.getTime());
		
		//to repeat a task often following a given condition, we use scheduleAtFixedRate
		TimerTask task2 = new TimerTask() {
			int counter = 10;

			@Override
			public void run() {
				if(counter>0) {
					System.out.println(counter + " seconds");
				}
				else {
					System.out.println("happy new year");
					timer.cancel();
				}
			}
			
		};
		
		timer.scheduleAtFixedRate(task2, 0, 1000); //countdown every second
		
		//starting the task at a given timeCalendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 2023);
		cal1.set(Calendar.MONTH, Calendar.DECEMBER);
		cal1.set(Calendar.DAY_OF_MONTH, 31);
		cal1.set(Calendar.HOUR_OF_DAY, 23); //0 for midnight 0 to 24
		cal1.set(Calendar.MINUTE, 59);
		cal1.set(Calendar.SECOND, 50);
		cal1.set(Calendar.MILLISECOND, 0);
		
		timer.scheduleAtFixedRate(task2, cal1.getTime(), 1000); //new year countdown
		
		
		
		
		
		/*
		 * package : 
		 * is a bundle of related files that we use in our programs
		 * 
		 */
		
		/*
		 * running a java program on the command prompt
		 * 
		 * set path C:/Users/Programs/.../java jdk /bin
		 * javac Program.java => java file converted to byte code
		 * java Program => byte code converted to machine code using JRE	
		 * 
		 */
		
		
		
		/*
		 * creating an executable jar file using the eclipse ide	
1. Right click on Java project (pick a project with a GUI)
2. Export
3. Java , Runnable Jar file
4. At Launch configuration select your project
5. At Export destination, select where you want this jar file exported to
6. Finish


If you want an icon, convert an image to a .ico file
----------------------------------------------------
1. https://icoconvert.com/ (this is a decent site)
2. Choose your image (file type my vary)
3. Upload
4. Convert to ICO
5. Download your icon


Use Launch4j to create an .exe with custom icon
----------------------------------------------
1. Install Launch4j http://launch4j.sourceforge.net/
2. Output file: browse for the output destination and name your file ending with .exe
3. Jar: browse for where you saved your jar or executable jar file
4. (Optional) Icon: browse for your custom icon (must be .ico)
5. navigate to JRE tab
6. Bundled JRE path: Browse for location of your jdk (Example C:\Program Files\Java\jdk-14.0.1)
7. At the top of window, click the Build Wrapper (gear icon)
8. name and save the Lauch4j config file where you want
9. Your application.exe should be saved to your output file location (no longer need previous files)
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

	
//	public static void displayArray(Integer[] arr) {
//		for(Integer a : arr) {
//			System.out.println(a);
//		}
//	}
//	
//	public static void displayArray(Double[] arr) {
//		for(Double a : arr) {
//			System.out.println(a);
//		}
//	}
//	
//	public static void displayArray(Character[] arr) {
//		for(Character a : arr) {
//			System.out.println(a);
//		}
//	}
//	
	public static <T> void displayArray(T[] arr){
		for(T a : arr) {
			System.out.println(a);
		}
	}
	
	public static <T> T returnFirstGeneric(T[] arr) {
		return arr[0];
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
