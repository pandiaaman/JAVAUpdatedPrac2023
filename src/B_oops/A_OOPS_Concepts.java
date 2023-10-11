package B_oops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class A_OOPS_Concepts{
	
	int a;
	String str;
	
	//static method
	public static void printit(String x) {
		System.out.println(x);
	}
	
	//non static method
	private void printthistoo(String x) {
		printit(x);
	}
	
	//calling non static method from another method
	public void printingall(String x) {

		str = x;
		printit(str);
		this.printthistoo(str);
	}
	
	//constructor
	public A_OOPS_Concepts() {
		System.out.println("this is a constructor");
	}
	//constructor overloading
	public A_OOPS_Concepts(int x, int y) {
		this(); //calls default constructor
		System.out.println("this is a constructor with :" + x + " " + y);
	}
	//constructor overloading
	public A_OOPS_Concepts(int x, String y) {
		this();
		System.out.println("this is a constructor with :" + x + " " + y);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		/*
		 * Object, class, Inheritance, Polymorphism, Abstraction, encapsulation
		 * 
		 * class : 
		 * 
		 * Inheritance : extends, interface extends other interface, classes implements interface
		 * 
		 * Polymorphism :
		 * 	compiletime poly : method overloading : same name but different return types, different inputs
		 * 	runtime poly : method overriding : upcasting : BaseClass obj = new ChildClass();
		 * 
		 * Abstraction : hiding details from the user abstract class are like blue prints
		 * 
		 * encapsulation : hiding data : putting data and methods together
		 * 
		 * coupling : how tightly or heavily are two classes dependent on each other, should be losely coupled
		 * 
		 * cohesion : 
		 * 
		 * association : there can be different types of object associations, one to one, one to many, many to many
		 * 
		 * aggregation : has-a relationship : when one object contains the other object inside it
		 * 
		 * composition : the child element can not exist without the parent element
		 * 
		 * super keyword : is for immediate parent class
		 * 
		 * ways to create an object
		 * - new keyword : ClassName obj = new ClassName();
		 * 		SuperClass obj = new SubClass(); //upcasting //runtime polymorphism
		 * - clone method marker interface: implements Cloneable : public Object clone() throws CloneNotSupportedException{return super.clone();}
		 * - newInstance() : Object ob = null; Class C = Class.forName("ClassName"); ob = C.newInstance();
		 * - deserialization : implements Serializable : FileOutputStream, ObjectOuputStream, writeObject; FIS, OIS, readObject(casting)
		 * - factory method
		 * 
		 * 3 ways to initialize objects:
		 * - constructor initialization : ClassName obj = new ClassName(1,"asdf");
		 * - reference initialization : obj.id = 1; obj.name = "asdf";
		 * - method initialization : public void setValues(int id, String name){this.id=id;this.name=name;}
		 * 
		 * 
		 * static variable is stored in the class area
		 */
		
		//calling constructors:
		A_OOPS_Concepts ob = new A_OOPS_Concepts();
		A_OOPS_Concepts ob1 = new A_OOPS_Concepts(1,3);
		A_OOPS_Concepts ob2 = new A_OOPS_Concepts(1,"Asdf");
		
		
		//calling static method
		A_OOPS_Concepts.printit("asdf");
		printit("asdfagain"); //both ways are correct
		
		//
		ob1.printingall("hello");
		
		
		LearnStaticMethod obj = new LearnStaticMethod();
		int x = LearnStaticMethod.staticmethod(2, 5);
		System.out.println(x);
		
		List<Students> studArList = new ArrayList<Students>();
		
		studArList.add( new Students(1,"Aman"));
		studArList.add( new Students(3,"Vaibhav"));
		studArList.add( new Students(2,"Saurabh"));
		
//		System.out.println(s1 + " \n" + s2 + " \n" + s3);
		
		studArList.forEach(System.out::println);
		
		Collections.sort(studArList,new ComareByRollNo());
		System.out.println("after sorting by roll no");
		studArList.forEach(System.out::println);
		
		Collections.sort(studArList,new CompareByName());
		System.out.println("after sorting by name");
		studArList.forEach(System.out::println);
		
		//cloning
		System.out.println(new Students(4,"ayaz").hashCode());
		
		Students sobj5 = new Students(5,"anisha");
		Students sobjcloned5 = (Students) sobj5.clone();
		
		System.out.println(sobjcloned5);
		
		studArList.add(sobj5);
		
		//serializing
		FileOutputStream fos = new FileOutputStream ("xyz.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(studArList);
		
		//deserealizing
		FileInputStream fis = new FileInputStream("xyz.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList incomingArray = (ArrayList) ois.readObject();
		incomingArray.forEach(System.out::println);
		
		//wrapper class in java: autoboxing and unboxing : primitives into objects and objects into primitives
		/*
		 * wrapper classes are used to convert the primitive types into their corresponding objects
		 * we can use Integer.valueOf() method for converting from primitive to wrapper
		 * and we can use .intValue() method for conversion from wrapper to primitive
		 * 
		 * there is auto boxing and auto unboxing too
		 */
		int a = 10;
		Integer wrapAutoA = a; //autoboxing
		//other way is
		Integer wrapA = Integer.valueOf(a);
		System.out.println(wrapAutoA + " " + wrapA);
		//auto unboxing
		int unboxa = wrapA.intValue();
		System.out.println(unboxa);
	}

}

class LearnStaticMethod{
	static int a = 5;
	public static int staticmethod(int x, int y) {
		return x*y-a;
	}
}

class Students implements Cloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rollno;
	private String name;
	private static String college = "SRM";
	
	public Students(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	
	public String toString() {
		return "roll no : " + this.rollno + " and name " + this.name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
}


class ComareByRollNo implements Comparator<Students>{

	@Override
	public int compare(Students o1, Students o2) {
		// TODO Auto-generated method stub
		return o1.getRollno() - o2.getRollno();
	}
	
}

class CompareByName implements Comparator<Students>{

	@Override
	public int compare(Students o1, Students o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}


