package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SerializationEx implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int var;
	private transient int transVar;
	
	public SerializationEx() {
	}
	
	public SerializationEx(int var, int tvar) {
		this.var = var;
		this.transVar = tvar;
	}
	
	public void setVar(int var) {
		this.var =var;
	}
	
	public int getVar() {
		return this.var;
	}
	
	public void setTransVar(int tvar) {
		this.transVar =tvar;
	}
	
	public int getTransVar() {
		return this.transVar;
	}
	
	public String toString() {
		return "[SerializationEx : var : " + this.var + " and transient var :" + this.transVar +  " ]";
	}
}

interface ObjectInterface{
	public void nameObject();
}

interface VehicleInterface extends ObjectInterface{
	/*
	 * interface works as a blue print/structure
	 * variables inside interface are by default final and static
	 * methods can be only static and default
	 * 
	 * interface supports multiple inheritence
	 */
	
	public static final int varinter = 1;
	int varinter2 = 32; //by default public static final
	
	public default void printinterface() {
		System.out.println("printing in interface");
	}
	
	public default int returningIntInterface() {
		return 5;
	}
	
	public static void staticMethodInterface() {
		System.out.println("printing using a static method in interface");
	}
	
	public void normalInterfaceMethod();
	
}

class Bike implements VehicleInterface{

	@Override
	public void normalInterfaceMethod() {
		System.out.println("coming from a child class");
		
	}

	@Override
	public void nameObject() {
		System.out.println("bike");
		
	}
	
}

abstract class VehicleAbClass{
	/*
	 * abstract classes : are very flexible
	 * can contain abstract and non abstract methods : if a class has abstract method, it must be an abstract class
	 * 
	 */
	enum BrandType{
		MERC("Mercedes"),
		SUZUKI("Suzuki"),
		AUDI("Audi");
		
		public final String label;
		
		private BrandType(String label) {
			this.label = label;
		}
		
	}
	
	protected String brandname;
	protected BrandType brandType;
	
	public abstract void driving();
	
	public abstract void breaking();
	
	public void printValue() {
		System.out.println("i am coming from an abstract class");
	}
	
	public static void printStaticValue() {
		System.out.println("i am coming from a static method from abstract class");
	}
	
}

class MercVehicle extends VehicleAbClass{

	
	@Override
	public void driving() {
		System.out.println("merc driving");
		
	}

	@Override
	public void breaking() {
		System.out.println("merc breaking");
		
	}
	
	
}



public class A_intro {

	/*
	 * object oriented
	 * write once run anywhere
	 * platform independent
	 * secure
	 * multi threaded
	 * high performance
	 */
	
	private static int staticVar = 1;
	private int nonStaticVar = 2;
	
	//constant
	private final static int FINAL_STATIC_CONST = 5;
	
	public static void main(String[] args) {
		System.out.println("hello there");
		/*
		 * automatic memory management :
		 * java has automatic garbage collection, we will learn about the memory managemenet in some time
		 * we can explicitly call the garbage collection using System.gc()
		 * to check the amount of free memory we can use : Runtime.getRuntime().freeMemory();
		 * 
		 */
		
		System.out.println(Runtime.getRuntime().freeMemory());
		
		for(int i=0; i<100000; i++) {
			Double d = new Double(300);
		}
		
		System.out.println(Runtime.getRuntime().freeMemory());
		
		System.gc(); //running the garbage collector
		
		System.out.println(Runtime.getRuntime().freeMemory());
		
		
		/*
		 * java code is converted to bytecode on compliation
		 * javac FileName.java => java FileName
		 * first step is for compilation of code that creates byte code 
		 * next the byte code is executed
		 * 
		 */
		
		/*
		 * JDK : java development kit : made for developers, contains JRE and development tools like java compiler, debugger etc
		 * JRE : java runtime env : contains all the required libraries needed for development and JVM
		 * JVM : java virtual machine : acts as a hardware machine that runs the java code, it is a universal platform to run java code
		 * 		acts as a hardware processor : executes the stack based instruction set and manages memory like an OS
		 * 
		 * JIT : just in time compilation : along with compiling source code to byte code, java compiles byte code to native machine code
		 * 		on the fly, called just in time compilation, optimizing the performance 
		 */
		
		/*
		 * keywords in java : 
		 * public : access modifier : makes the accessibility of the class/variable public : accessible to everywhere in project
		 * private : access modifier : accessible to only the class they are defined in
		 * protected : access modifier : accessible to package and to classes that extend the given class
		 * default : access modifier : accessible to the package
		 * boolean : data type :1 bit : true or false
		 * byte : data type : 1 byte : 8 bits : -127 to 0 to 128 (2^7)
		 * char : data type : 2 byte : unicodes : A(65) a(97) 
		 * short : data type : 2 byte : 16 bits : 0 to 2^15 : -32,768 to 32,767
		 * int : data types : 4 bytes
		 * float : data type : 4 bytes
		 * double : data type : 8 bytes
		 * long : data type : 8 bytes
		 * if 
		 * else
		 * do
		 * while
		 * for
		 * break
		 * continue
		 * return
		 * switch
		 * case
		 * try
		 * catch
		 * throw
		 * throws
		 * finally
		 * static : can be a class(nested internal), method, variable(do not need an object of class to be instantiated)
		 * final : can be a class(can not be extended), method(can not be overriden), variable (can not be changed)
		 * abstract : class, like an interface, provides the blue print but no implementation, method has no implementation
		 * import 
		 * new : creates and allocates memory in heap area for new objects created
		 * package 
		 * class
		 * interface : provides structure, methods can only be default final static and methods can be either static or default or normal
		 * extends
		 * implements
		 * enum : enumeration in java : 
		 * synchronized : makes methods or block of codes synchronous, that means thread safe, one thread can affect at one time
		 * transient
		 * volatile :  is used to indicate that a variable's value may be modified by multiple threads simultaneously.
		 * 	 	It ensures that the variable is always read from and written to the main memory, rather than from 
		 * 		thread-specific caches, ensuring visibility across threads.
		 * 
		 * goto dont use
		 * const use public static final instead
		 * 
		 * assert
		 * instanceof
		 * strictfp
		 * super
		 */
		
		//char to int
		System.out.println((int)'A');
		
		//break and continue
		for(int i=0; i<10; i++) {
			if(i==5) {
				continue;
			}
			if(i==7) {
				break;
			}
			System.out.println(i);
		}
		
		
		
		//switch case
		String str = "Monday";
		
		switch(str) {	
		case "Monday":
			System.out.println("weekday");
			break;
		case "Saturday":
			System.out.println("weekend");
			break;
		}
		
		//static and non static
		System.out.println(staticVar);
		
		A_intro obj = new A_intro();
		System.out.println(obj.nonStaticVar);
		
//		FINAL_STATIC_CONST = 8; //The final field A_intro.FINAL_STATIC_CONST cannot be assigned
		System.out.println(FINAL_STATIC_CONST);
		
		//checked exception 
		try {
			
			FileInputStream fis = new FileInputStream("fileOne.txt");
			FileReader reader = new FileReader("fileOne.txt");
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("continues...");
		
		//unchecked exception : runtime
		try {
			System.out.println(24/0);
		}catch(ArithmeticException e){
			System.out.println("cant divide by 0");
			e.printStackTrace();
		}
		//unchecked exception
		try {
			A_intro ob1 = null;
			ob1.nonStaticVar = 10;
			System.out.println(ob1.nonStaticVar);
		}catch(NullPointerException e) {
			System.out.println("null pointer");
			e.printStackTrace();
		}
		
		System.out.println("continuing..");
		//custom exception
		try {
			int res = 4/2;
			if(res == 2) {
				throw new UserCustomException("well the result is 2");
			}else {
				System.out.println("you are good to go");
			}
		}catch(UserCustomException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally...");
		}
		
		
		//type casting
		/*
		 * byte -> char -> short -> int -> float -> long -> double
		 * type upcasting : smaller value in a big box
		 * type downcasting : bigger value in a small box
		 */
		
		//type downcasting/narrowing : 
		long l1 = 43556l;
		int i1 = (int)l1;
		float f1 = (float)l1;
		short s1 = (short) i1;
		
		//widening
		int i2 = 2356;
		long l2 = i2; //no casting required here, since smaller value in a bigger box
		double d2 = i2;
		float f2 = i2;
		double d1 = l1;
		
		//wrapper classes : boxing and unboxing
		int i3 = 5;
		Integer in1 = i3;
		
		int i4 = in1;
		
		Double do1 = 234.23d;
		double d5 = do1;
		int i5 = (int)d5;
		
		
		//casting/uncasting to string
		int i6 = 234;
		String st6 = String.valueOf(i6);
		
		int i7 = Integer.parseInt(st6);
		
		short s7 = Short.parseShort(st6);
		
//		VehicleAbClass abstrClass = new VehicleAbClass(); //Cannot instantiate the type VehicleAbClass since abstract
		
		MercVehicle merc = new MercVehicle();
		merc.brandname = "mercedes";
		merc.brandType = merc.brandType.MERC;
		merc.printValue();
		merc.driving();
		
		System.out.println(merc.brandType);
		
		//interface
		Bike bike = new Bike();
//		bike.varinter2 = 10; //The final field VehicleInterface.varinter2 cannot be assigned
		System.out.println(bike.varinter2);
		System.out.println(bike.returningIntInterface());
		
		//synchronous : runnable is a functional interface
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getName() + " " +  i);
					threadSyncTest();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i= 20; i>0; i--) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				threadSyncTest();
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("continues...");
		
		
		SerializationEx serOb = new SerializationEx(5,10);
		System.out.println("before serialization : " + serOb);
		//serialize : process of changing the objects in their current state to a byte stream
		try {
		FileOutputStream fos = new FileOutputStream("fileSerialize.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serOb);
		oos.flush();
		oos.close();
		System.out.println("serialized");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//deserialize : process of converting the byte stream back to object
		try {
			FileInputStream fis = new FileInputStream("fileSerialize.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SerializationEx deserOb  = (SerializationEx) ois.readObject();
			System.out.println("value after deserialization : " + deserOb);
			ois.close();
		}catch(FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//instance of operator
		HashMap<Integer, String> hmap = new HashMap<>();
		System.out.println(hmap instanceof Map);
		System.out.println(hmap instanceof Set);
		System.out.println(hmap instanceof List);
		/*
		 * instanceof operator help avoiding the classcastException in the run time
		 */
		
		List<String> lst = new ArrayList<String>();
		
		if(lst instanceof ArrayList) {
			ArrayList<String> arlst = (ArrayList<String>) lst;
		}else if(lst instanceof LinkedList) {
			LinkedList<String> llst = (LinkedList<String>) lst;
		}
		
	}
	
	public static int i = 10;
	
	public static void threadSyncTest() {
		synchronized(ObjectInterface.class) {
			System.out.println(Thread.currentThread().getName() + "this is a thread test for synchronization " + i++);	
		}
	}
	
	
}
