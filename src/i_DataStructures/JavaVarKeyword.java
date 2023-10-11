package i_DataStructures;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

enum Leaves{
	CL(1),PL(2),LOP(3);
	
	public int value;
	private Leaves(int value) {
		this.value = value;
	}
}

enum Seasons{
	WINTER, SUMMER, FALL, SPRING
}

/**
 * 
 */
public class JavaVarKeyword {
	
	static {
		System.out.println("static block running...");
	}

	public static final float PI = 3.14159f;
	
	public static void display() {
		System.out.println("display static method");
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		display();
		JavaVarKeyword.display();
		
		var st = new TempStudent();
		
		st.setName("aman");
		System.out.println(st);
		
		Rabbit rabbitOne = new Rabbit(4, "rabbit");
		rabbitOne.walk();
		rabbitOne.travel();
		
		AnimalAbstract.eat();
		
		for(int i=0;i<10;i++) {
			if(i==3) {
				continue;
			}
			System.out.println(i);
			if(i == 7) {
				break;
			}
		}
		
		//tochararray
		String strr = "hello there";
		char[] strarr = strr.toCharArray();
		for(char c : strarr) {
			System.out.println(c);
		}
		
		//toarrya
		List<Integer> intlist = Arrays.asList(1,3,5,6);
		intlist.stream().forEach(System.out::println);
		
		intlist.forEach(x -> System.out.print(x + " "));
		
		int resultadd = intlist.stream().reduce(0, (a,i)-> a+i);
		System.out.println(resultadd);
		
		
		//switch case
		int p = 3;
		switch(p) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3: 
			System.out.println("wednesday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		default:
			System.out.println("unknown");
			break;
		}
		
		
		//do while
		
		
		int i1 = 15;
		do {
			System.out.println("this will always happen atleast once");
			System.out.println(i1);
			i1++;
		}
		while(i1<10);
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("enter your name");
		String uname;
		do {
//			uname = sc.next();
			uname = "asdf";
			if(uname.equalsIgnoreCase("") || uname.isBlank()) {
				System.out.println("enter again");
			}
			else if(Pattern.matches("\\d*", uname)) {
				System.out.println("enter characters");
			}else {
				break;
			}
		}while(true);
		
		System.out.println(uname);
		
		
		//enums
		for(Seasons s : Seasons.values()) {
			System.out.println(s);
		}
		
		for(Leaves l : Leaves.values()) {
			System.out.println(l + " " + l.value);
		}
		
		
		LinkedList<Integer> llist1 = new LinkedList<Integer>();
		
		llist1.push(11);
		llist1.push(12);
		llist1.push(13);
		llist1.push(14);
		llist1.push(15);
		llist1.push(16);
		llist1.push(17);
		llist1.push(18);
		
		llist1.pop();
		
		System.out.println(llist1);
		llist1.forEach(System.out::print);
		
		System.out.println(llist1.peek());//stack
		System.out.println(llist1.element());//queue
		
		System.out.println(llist1.pop());
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		System.out.println(stack.pop());
		
		System.out.println(stack instanceof Stack);
		
		
		try {
//			PI = 24.23f;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//serialization
		ThisSerializableClass obb = new  ThisSerializableClass(4);
		
		try {
			FileOutputStream fos = new FileOutputStream("file1.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obb);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		//deserialization
		ThisSerializableClass obRead = new ThisSerializableClass();
		try {
			FileInputStream fis = new FileInputStream("file1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			obRead = (ThisSerializableClass) ois.readObject();
			System.out.println("deserialized : " + obRead);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//cloneable
		try {
			ThisSerializableClass clonedOb = (ThisSerializableClass) obRead.clone();
			System.out.println(clonedOb);
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
		//interface default and static methods
		ColorBook book = new ColorBook();
		
		book.callingStaticInterfaceMethod(1, 3);
		book.color();
		System.out.println(book.add(3, 8));
		
		
		//strings
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2); //checking by address reference
		System.out.println(s1.equals(s2));//checking by data
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s1);
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		System.out.println(s3 == s1.intern());
		
		//multi threading
		Thread threadd1 = new Thread(new ThreadTry(2000,2));
		Thread threadd2 = new Thread(new ThreadTry(1500,2));
		
		threadd1.start();
		threadd2.start();
		
		Thread threadd3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("calling another thread");
			}
		});
		
		Thread threadd4 = new Thread(()->{
			System.out.println("arrow function thread");
		});
		
		
		//custom exception 
		try {
			System.out.println("trying out custom exceptions");
			throw new CustomException("this is an exception");
		}catch(CustomException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//tight and loose coupling
		B obB = new B(2,3);
		obB.foo();
		
		
		//cloning
		CloneCheck objj = new CloneCheck(1,3);
		try {
			CloneCheck objj2 = (CloneCheck)objj.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("finding the random number");
		int rand = (int) Math.floor(Math.random()*10 + 1);
		System.out.println("randddd : " + rand);
		
		//autoboxing and unboxing
		//autoboxing: automatic conversion of primitive to object : wrapper class
		int integerval = 5;
		Integer integerwrapper = integerval;
		System.out.println(integerwrapper);
		
		//unboxing
		int unwrapped = integerwrapper;
		
		
	}
}


//threads
class ThreadTry implements Runnable{
	
	private int sleepTime;
	private int loopSize;
	
	public ThreadTry(int sleepTime, int loopSize) {
		this.sleepTime = sleepTime;
		this.loopSize = loopSize;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		try {
			syncMethod();
			for(int i=0; i<this.loopSize; i++) {
				System.out.println(i);
				syncMethod();
				Thread.sleep(this.sleepTime);
			}
		}catch(IllegalThreadStateException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void syncMethod() {
		System.out.println("out of sync " + Thread.currentThread().getName());
		synchronized(this) {
			System.out.println("in sync " + Thread.currentThread().getName());
		}
	}
}

abstract class AnimalAbstract{
	private String place = "earth";
	private int legs;
	private String speciesName;
	
	public AnimalAbstract(int legs, String name) {
		this.legs = legs;
		this.speciesName = name;
	}
	
	public void walk() {
		System.out.println(this.speciesName + " is walking");
	}
	
	public abstract void travel();
	
	/**
	 * 
	 */
	public static void eat() {
		System.out.println("animal is eating");
	}
}

class Rabbit extends AnimalAbstract{

	public Rabbit(int legs, String name) {
		super(legs, name);
		
	}

	@Override
	public void travel() {
		System.out.println("it hops");
	}
	
}


//interfaces
interface Colorable{
	public void color();
	
	int a = 5;
	//default method in interface
	public default int add(int a, int b) {
		return a+b;
	}
	//static method in interface
	public static int multiply(int a, int b) {
		return a*b;
	}
}

class ColorBook implements Colorable{

	@Override
	public void color() {
		System.out.println("coloring");
	}
	
	public void callingStaticInterfaceMethod(int a, int b) {
		System.out.println(Colorable.multiply(a, b));
	}
	
	
}

final class FinalClass{
	public int value = 10;
}

//class FinalChildClass extends FinalClass{
//	
//}




class TempStudent{
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "name : " + this.name;
	}
}

class ThisSerializableClass implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int something;
	
	public ThisSerializableClass() {
		System.out.println("okay creating object");
	}
	
	public ThisSerializableClass(int some) {
		super();
		this.something = some;
	}
	
	@Override
	public String toString()
	{
		return "something : " + something;
	}
	
	//cloneable
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}

//custom exception
class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CustomException(String msg) {
		super(msg);
		System.out.println("some error");
	}
}

//tight coupling example
class A{
	private int x;
	private int y;
	public A(int x, int y) {
		System.out.println("A");
	}
	
	public void foo() {
		System.out.println("printing from A");
	}
	
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
}

class B extends A{
	private int a;
	private int b;
	private int c;
	
//	public B() { //will not work due to tight coupling
//		super();
//		System.out.println("B");
//	}
	public B(int a, int b) {
		super(a, b);
	}
	
	public void foo() {
		System.out.println("printing from B");
	}
}


//loose coupling
interface Parent{
	public void foo();
}

class A1 implements Parent{
	private int x;
	private int y;
	
	public A1(int x, int y) {
		System.out.println("A");
	}
	
	@Override
	public void foo() {
		System.out.println("printing from A");
	}
	
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
}

class B1 implements Parent{
	private int a;
	private int b;
	private int c;
	
	public B1() { //will not work due to tight coupling
		System.out.println("B");
	}
//	public B(int a, int b) {
//		super(a, b);
//	}
	
	public void foo() {
		System.out.println("printing from B");
	}
}


//multiple inheritance
interface interOne{
	public void display();
}

interface interTwo{
	public void display();
}

class MultIntheritance implements interOne, interTwo{

	@Override
	public void display() {
		System.out.println("displaying");
		
	}
	
}

//cloning
class CloneCheck implements Cloneable {
	
	private int a;
	private int b;
	public CloneCheck(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}













