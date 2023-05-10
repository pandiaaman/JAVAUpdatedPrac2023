package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * jvm : java virtual machine : loads code -> verifies code -> executes code 
 * 		class loader
 * 			bootstrap classloader : loads rt.jar file that contains all the class files of java from java standard edition
 * 			extension classloader : loads jar files located inside $JAVA_HOME/jre/lib/ext directory
 * 			application classloader : loads all the class files from the class path
 * 		multiple memory areas
 * 			method area/class area : stores code for methods, static, non static variables
 * 			stack area : different methods have different stack areas that store local variables
 * 			heap area : objects are allocated here
 * 			pc registers (program counter)
 * 			native method stack
 * jre : java runtime environment
 * jdk : java development kit
 */
public class A_HelloWorld {

	//static variable
	static int count = 0;
	//static block
	static {
		System.out.println("this is a static block");
	}
	
	//constructor
	public A_HelloWorld(){
		count++;
	}
	
	public int var = 5;
	class InnerMemberClass{
		public int getVar() {
			int varMain = var; //we are accessing s1 from the outside class
			return varMain;
		}
	}
	
	public enum Days {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}
	
	public enum Months {JAN(0),FEB(1),MAR(2),APR(10),JUN(4),JUL(5),AUG(6),SEP(7),OCT(20),NOV(16),DEC(14);
			
		int value;
		Months(int value){
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("helloworld");
		
		System.out.println("STREAMS");
		
		List<Integer> arrList = Arrays.asList(1,2,3,4);
		List<Integer> arrList1 = new ArrayList<Integer>();
		arrList1.add(1);
		arrList1.add(2);
		arrList1.add(3);
		arrList1.add(4);
		arrList1.add(5);
		arrList1.add(6);
		
		//map
		List<Integer> arrSqList = arrList.stream().map(x -> x*x).collect(Collectors.toList());
		arrSqList.forEach(System.out::println);
		
		//filter
		List<Integer> arrOddList1 = arrList1.stream().filter(x->(x%2==0)).collect(Collectors.toList());
		arrOddList1.forEach(System.out::println);
		
		//sorted
		List<Integer> arrSorted = arrList1.stream().sorted().collect(Collectors.toList());
		arrSorted.forEach(System.out::println);
		
		//using foreach directly
		System.out.println("foreach");
		arrList.stream().map(x->x*x).forEach(x->System.out.println(x));
		
		List ls = new ArrayList();
		List<Integer> lsi = new ArrayList<Integer> ();
		List<String> lss = new ArrayList<String> ();
		
		List ll = new LinkedList();
		List<Integer> lli = new LinkedList<Integer>();
		List<String> lls = new LinkedList<String>();
		
		List vec = new Vector();
		List<Integer> veci = new Vector<Integer>();
		List st = new Stack();
//		Queue q = new ArrayList();
		
		//using reduce
		List<Integer> redList = Arrays.asList(1,2,3,4,5,6);
		redList.stream().map(x->x).forEach(System.out::println);
		int evens = redList.stream().filter(x->x%2==0).reduce(0,(ans,i) -> ans+i);
		System.out.println(evens);
		
		//converting an array to a stream
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		IntStream arrListStream = Arrays.stream(arr).map(x->x*x);
		int sumarr = Arrays.stream(arr).sum();
		//Optional Double
		OptionalDouble avgarr = Arrays.stream(arr).average();	
		//converting optionalDouble to double, since it is easier to play around with primitives
		double avgarrDouble = avgarr.getAsDouble();
		System.out.println("sum of all items in an array : " + sumarr);
		System.out.println("length of array : " + arr.length);
		System.out.println("avg is :" + avgarrDouble + " on normal division : " + (sumarr/arr.length));
		arrListStream.forEach(System.out::println);
		
		//creating streams using stream.of
		Stream<Integer> intStream = Stream.of(1,2,3,4);
//		intStream.map(x->x).forEach(System.out::println);
		
        
		long intStreamCount = intStream.collect(Collectors.counting());
		System.out.println(intStreamCount);
//		strToList.add(5);
//		strToList.forEach(System.out::println);
		
		System.out.println("TYPE CASTING");
		//type casting : two types : type narrowing , type widening
		/*
		 * byte : 1 : 8 bits : - 2^(8-1) to 2^(8-1) - 1 : - 128 to 127
		 * char : 2 : 16 bits : java uses Unicode system not ASCII code system
		 * boolean : 1bit
		 * int : 4 : 32 bits : - 2^(32-1) to 2^(32-1) - 1 : 2,147,483,648 to 2,147,483,647 
		 * float : 4 : 32 bits
		 * double : 8 : 64 bits
		 * short : 2 : 16 bits : - 2^(16-1) to 2^(16-1) - 1 : - 32768 to 32767
		 * long : 8 : 64 bits
		 */
		int a = 5;
		//type widening
		double castDobleA = a; //GOOD : type widening : double (8 bytes) can accomodate int (4 bytes)
//		short castShortA = a; //Type mismatch: cannot convert from int to short
		//type narrowing
		short castShortA = (short) a; //casting a to short : type narrowing, cant put a 4 byte int inside a 2 byte short
		System.out.println(castShortA); //prints 5
		
		//casting int to short for a value that is higher than the range of short : short ranges from 32768 to 32767
		int a1 = 32768;
		short castShortA1 = (short) a1;
		System.out.println(castShortA1); //goes on the negative side of the line
		
		//casting char (2 bytes)
		char c = 'A';
		int castIntC = (int) c;
		System.out.println(castIntC); //65
		System.out.println(++castIntC); //66
		System.out.println((char) castIntC); //B
		
		double castDoubleC = (double) c;
		System.out.println(castDoubleC); //65.0
		
		int ia = 10;
		float fa = ia;
		System.out.println(fa);
		
		float fb = 18.3f;
		int ib = (int) fb; // converting float to an int is type narrowing (casting)
		System.out.println(ib);
		
		byte ba = 10;
		byte bb = 10;
		byte bsum = (byte) (ba + bb); //while adding, bytes are implicitly converted to int so we need to cast it
		
		//the reason why they are implicitly converted to int can be seen below
		byte ba1 = 127; //if we add one more, this will go out of range for byte
		byte ba2 = 2;
		byte b12sum = (byte) (ba1 + ba2); //now if we add these, it would obviously go beyond bytes range
		System.out.println(b12sum); //answers : -127
		
		boolean bval = true;
//		int boolres = (int) bval; //here we cant even cast // Cannot cast from boolean to int
		
		
		System.out.println("OPERATORS IN JAVA");
		/*
		 * arithmetic operators + - * / % **
		 * relational > < >= <= instanceOf
		 * bitwise | & ^
		 * assignment == = += -=
		 * logical || && 
		 * shift << >> >>>
		 * unary ++ -- ! ~
		 * ternary ?:
		 * 
		 */
//		System.out.println(Math.nextAfter(3, 1));
		System.out.println(Math.pow(3,2));
		
		//~ unary operator
		int uoa = 15;
		System.out.println(~uoa); //-16
		
		//left shift operator (m << n) : m * 2^n
		int lsa = 5; //000101
		System.out.println(lsa << 1);//001010 : 10 :: 5*2^1 : 10
		System.out.println(lsa << 2);//010100 : 20 :: 5*2^2 : 20
		
		//right shift operator
		int rsa = 6;//000110 :: (m >> n) : m/2^n
		System.out.println(rsa >> 1);//000011 : 3 :: 6 / 2^1 : 3
		
		//For negative number, >>> changes parity bit (MSB) to 0
		System.out.println(-20>>>2);  
		
		//bitwise operators
		int bwoa = 11 & 21; //001011 & 010101 : 000001 : 1
		System.out.println(bwoa);
		
		int bwoo = 11 | 21; //001011 | 010101 : 011111 : 31
		System.out.println(bwoo);
		
		//logical operators
		if(true && true) {
			System.out.println("using logical and");
		}
		
		System.out.println((3<4) && (4>5)); //true && false  : false
		
		//ternary operator
		boolean toa = 15>5?true:false;
		System.out.println(toa);
		
		
		System.out.println("JAVA KEYWORDS");
		//abstract keyword
		/*
		 * abstract classes are like blueprints for the class, they are much like interfaces
		 * we can not create objects or instances of the abstract class, these can be extended
		 * there is no multiple inheritence using abstract class, so we  need interface
		 * abstract class can have abstract and non abstract methods, while interface can only have abstract method
		 * abstract method is any method that does not have any definition associated to it
		 * abstract method can only be used in the abstract class
		 */
				
		//boolean keyword
		/*
		 * boolean is 1 bit with true or false values
		 */

		//break
		for(int i=0;i<5;i++) {
			if(i==3) {
				break;
			}
			System.out.println(i);
		}
		
		//byte : holds 8 bit chars
		
		//case switch
		int switcha =3;
		switch(switcha) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("answer");
			break;
		default:
			System.out.println("default");
			break;
		}
		
		
		//catch : error handling : try throw catch throws(class)
		try {
			int trya = 12/0;
		}catch(Exception e) {
			System.out.println("error " + e);
		}
		
		try {
			int trya1 = 5;
			if(trya1 == 5) {
				throw new ArrayIndexOutOfBoundsException();
			}
			if(trya1 == 6) {
				throw new ArithmeticException();
			}
			if(trya1 == 7) {
				throw new RuntimeException();
			}
		}catch(Exception e) {
			System.out.println("error " + e);
			
		}
		
		
		
		//char
		char chara = 'a';
		int charaval = (int) chara;
		System.out.println(charaval);
		
		
		//class : OOPS main concept is to have classes in code
		//class in java : inheritance, polymorphism, encapsulation
		Students s1 = new Students(1, "asd");
		
		//inner classes : can access all members of the outer class
		class InnerClass{
			public int accessStudents() {
				int stRollNo = s1.getRollNo(); //we are accessing s1 from the outside class
				return stRollNo;
			}
		}
		
		A_HelloWorld obj = new A_HelloWorld();
		
		//accessing class inside main method of main class
		InnerClass inObj = new InnerClass();
		int rollInner = inObj.accessStudents();
		
		//accessing the inner member class, outside main method
		A_HelloWorld.InnerMemberClass inMObj = obj.new InnerMemberClass();
		System.out.println(inMObj.getVar());
		
		//continue : used in loops
		for(int i=0;i<=5;i++) {
			if(i==3) {
				continue;
			}
			System.out.println(i);
		}
		
		aa:
		for(int i=0;i<=5;i++) {
			bb:
			for(int j=0;j<=5;j++) {
				if(i==3 && j==3) {
					continue aa;
				}
				System.out.println( i + " " + j);
			}
		}
		
		
		int whilevar = 0;
		while(whilevar <=5) {
			if(whilevar == 3) {
				//IMPORTANT   if we dont increment whilevar, then INFINITE LOOP
				//will remain 3, will keep on continuing
				whilevar++; //we need to increment it here also
				continue;
			}
			
			System.out.println(whilevar);
			
			whilevar++;
		}
		
		
		//default : used with switch case
		
		int swVar = 7;
		switch(swVar) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		default:
			System.out.println("default case");
			break;		
		}
		
		
		//do : used with do while loop : we make sure that it is executed atleast once
		
		int doWhileI = 10;
		do {
			if(doWhileI == 3) {
				break;
			}
			
			if(doWhileI == 6) {
				doWhileI--;
				continue;
			}
			
			System.out.println(doWhileI);
			
			doWhileI--;
		}while(doWhileI >= 0 );
		
		
		//double : 8 bytes : 64 bits
		double doubleVar = 2345.0d;
		
		//else : if else
		if(3<4 && 5>6) {
			System.out.println("true");
		}else if(4<2) {
			System.out.println("else true");
		}else {
			if(1>4) {
				System.out.println("why here");
			}else if(5>3) {
				System.out.println("finally");
			}
			System.out.println("finally true");
		}
		
		
		//enum : enumeration : assign a variable/string a number
		/*
		 * think of it as a class 	with fixed set of constants
		 * java enum constants are final and static implicitly
		 * Enum improves type safety
			Enum can be easily used in switch
			Enum can be traversed
			Enum can have fields, constructors and methods
			Enum may implement many interfaces but cannot extend any class because it internally extends Enum class
		 */
		
//	LOOK IN THE ABOVE CLASS MAIN DECLARATION, ENUM CANNOT BE DEFINED INSIDE A METHOD
		//public enum Days {SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}
		
		for(Days d : Days.values()){
			System.out.println(d);
		}
		System.out.println("value of THURSDAY is : " + Days.valueOf("THURSDAY"));
		System.out.println("Index/ordinal of FRIDAY is : " + Days.valueOf("FRIDAY").ordinal());
		
		//USING THE MONTHS ENUM FOR UNDERSTANDING CONSTANT VALUES ASSOCIATED TO ENUM	
		
		for(Months m : Months.values()) {
			System.out.println(m + " "+  m.value);
		}
		
		
		//extends
		/*
		 * inheritance : java does not support multiple inheritance
		 * single : A -> B
		 * multi level : A -> B -> C
		 * heirarichal : B->A C->A
		 * hybrid : mix of three above
		 */
		
		//final
		/*
		 * final variable : value can not be changed/updated
		 * final method : can not be overridden
		 * final class : can not be extended
		 * 
		 * we can have blank final variables, and those can only be initialized in the constructors
		 */
		
		//finally
		/*
		 * part of error handling in java
		 * try catch throw finally
		 * shows what has to be done compulsory in case an error is found
		 */
		
		try {
			int itry = 4/2; //change it to 4/0 to get to exception
		}catch(Exception e) {
			System.out.println("error "+ e);
		}finally {
			System.out.println("this will be done either ways");
		}
		
		
		//float : 4 bytes : use f at the end, decimal values
		//type narrowing and widening : with float, an int can be converted to float, but not vice versa without casting
		int afloat = 4;
		float arealfloat = afloat; //no issues
		
		int afakefloat = (int) arealfloat; //Type mismatch: cannot convert from float to int
		
		//for : looping : basic loops
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//if, nested if, if else
		int ifI = 3;
		if(ifI > 0) {
			System.out.println("as");
		}
		
		//implements : 	used with interfaces : 
		/*
		 * interface is like blueprint of what is required
		 * it has static and default method definitions along with method declarations
		 * it can have only final and static variables assigned inside it
		 * we can not create an instance of an interface
		 * interfacce are like abstracct classes
		 * a class implements an interface, but one interface extends another interface
		 * we can have default and static methods in interface	
		 * 
		 * generally ends with -able : Cloneable, 
		 * 
		 * there are different types of interfaces : 
		 * 
		 * marker interface : having NO method inside the interface eg. Serializable, Cloneable, Remote
		 * 	marker interface is used for internet flags and annotations (to perform specific operation to it)
		 * 
		 * Functional Interface is an interface that has only pure one abstract method
		 */
		
		Drawable rect = new Rectangle();
		rect.msg();
		//calling static methods in interface
		Drawable.handDrawn();
		
		
		//cloneable interface
		
		ToBeCloned originalObj = new ToBeCloned(3,"str");
		ToBeCloned clonedObj;
		try {
			clonedObj = (ToBeCloned) originalObj.Clone();
			System.out.println(clonedObj.x);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//serializable interface
		/*
		 * Serialization – Converting an object into byte stream.
		 * Deserialization – Converting byte stream into an object.
		 */
		Students sObj = new Students(3, "deepak");
		
		FileOutputStream fos = new FileOutputStream("xyz.txt");
		ObjectOutputStream oos =  new ObjectOutputStream(fos);
		oos.writeObject(sObj);
		
		//Deserealizing
		FileInputStream fis = new FileInputStream("xyz.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Students serializedObj = (Students) ois.readObject();
		System.out.println(serializedObj.name);
		
		//long : 8 bytes : 64 bits
		long lvar = 2323l;
		
		//new
		/*
		 * used to create new objects 
		 */
		
		//null : 
		
		//access modifiers
		/*
		 * private : not accessible outside the class
		 * 
		 * public : accessible everywhere
		 * 
		 * protected : accessible to package and the classes that inherit the base class
		 */
		
		//short : 2 bytes : 16 bits : - 2^(16-1) to 2^(16-1) - 1 
		short svar = 23;
		int svarcast = svar;
		System.out.println(svarcast);
		
		byte svartoByte = (byte) svar;
		System.out.println(svartoByte);
		
		System.out.println(Math.pow(2, 15)); //32768
		
		//static
		/*
		 * static class does not need an object to use its data
		 * static method : belongs to class, no need to create an instance of class  
		 * static variable : common property of all objects, like the school name for all students
		 * 		static variable is also used as a counter for counting the objects
		 * static block : Is used to initialize the static data member.
		 * 		It is executed before the main method at the time of classloading.
		 */
		
		//super keyword
		/*
		 * it is used to call the parent class objects, while inheriting
		 */
		
		
		//synchronized: Java synchronized keyword is used to specify the critical sections or methods in multithreaded code.
		/*
		 * synchronization is the capability to control the access of multiple threads to any shared resource
		 * To prevent thread interference.
		 * To prevent consistency problem.
		 * 
		 * There are two types of synchronization
			Process Synchronization
			Thread Synchronization
		 */
		
		//this : refers the current object
		
		//throw : to throw an error explicitly, it is mainly used to throw custom exceptions
		
		//transient
		//During the serialization, when we do not want an object to be serialized we can use a transient keyword.
		// if a program accepts a user's login details and password. But we don't want to store the original password in the file. 
		
		Dog newDog = new Dog(true, "doggo", 1,3);
		
		System.out.println(" original age :" + newDog.age);
		
		FileOutputStream foss = new FileOutputStream("asdf.txt");
		ObjectOutputStream ooss = new ObjectOutputStream(foss);
		ooss.writeObject(newDog);
		
		FileInputStream fiss = new FileInputStream("asdf.txt");
		ObjectInputStream oiss = new ObjectInputStream(fiss);
		Dog serializedDog = (Dog) oiss.readObject();
		
		System.out.println("after serialization : " + serializedDog.age); //since transient

		
		//volatile: Java volatile keyword is used to indicate that a variable may change asynchronously.
		
		
		
		//JAVA OOPS concepts
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
	
	class Students implements Serializable{
		//variables
		public int rollno;
		public String name;
		//methods
		public void study() {
			System.out.println("studying");
		}
		//constructor
		Students(int rollno, String name){
			this.rollno = rollno;
			this.name = name;
		}
		//getters and setters
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setRollNo(int rollno) {
			this.rollno = rollno;
		}
		
		public int getRollNo() {
			return this.rollno;
		}
	}
	
	
	interface Color{
		public void color(String col);
	}
	
	interface Drawable extends Color{
		public void draw();
		
		public static void handDrawn() {
			System.out.println("this is hand drawn");
		}
		
		public default void msg() {
			System.out.println("this is a message from Drawable interface");
		}
	}
	
	class Rectangle implements Drawable{

		@Override
		public void draw() {
			System.out.println("drawing rectangle");	
		}

		@Override
		public void color(String col) {
			// TODO Auto-generated method stub
			System.out.println(col);
		}
		
//		public void msg() { //this will override the msg() method in Drawable interface
//			System.out.println("this is a message form rectangle");
//		}
	}
	
	class ToBeCloned implements Cloneable{
		int x;
		String str;
		
		public ToBeCloned(int x, String str) {
			this.x = x;
			this.str = str;
		}
		
		protected Object Clone() throws CloneNotSupportedException{
			return super.clone();			
		}
		
	}
	
	class Animal implements Serializable{
		boolean male;
		String name;
		
		public Animal(boolean male, String name) {
			this.male = male;
			this.name = name;
		}
		
		public void breathe() {
			System.out.println("breathing...");
		}
	}

	class Dog extends Animal{
		int paws;
		transient int age;
		public Dog(boolean male, String name, int paws, int age) {
			super(male,name);
			this.paws = paws;
			this.age = age; 
		}
	}
	
	//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

