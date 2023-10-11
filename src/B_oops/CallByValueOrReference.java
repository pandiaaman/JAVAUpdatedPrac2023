package B_oops;

import java.util.ArrayList;

class RandomClass{
	int a;
	int b;
	
	public RandomClass() {
		System.out.println("constructor");
	}
	public RandomClass(int a, int b) {
		this();
		this.a = a;
		this.b = b;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	
	@Override
	public String toString() {
		return "randomobject : " + this.a + " and " + this.b;
	}
}

public class CallByValueOrReference {

	public static void main(String[] args) {
		System.out.println("hello");
		
		int x = 5;
		change(x);
		System.out.println(x);
		
		Integer y = 5;
		changeWrapper(y);
		System.out.println(y);
		
		String s = "hello";
		changeString(s);
		System.out.println(s);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		updateList(list);
		list.forEach(item -> System.out.print(item));
		System.out.println();
		
		RandomClass object = new RandomClass(4,5);
		System.out.println(object);
		updateRandomObject(object);
		System.out.println(object);
		
		//talking about string immutability or immutability in general
		String str1 = "aman";
		String str2 = "aman";
		System.out.println(str1.hashCode() + " " + str2.hashCode());
		String str3 = new String("aman");
		System.out.println(str3.hashCode());
		
		//== operator compares reference or memory location of objects in the heap
		System.out.println(str1 == str2);
		System.out.println(str1 == str3); //FALSE : pointing to different addresses
		
		//equals() is a method compares the content of the objects
		System.out.println(str1.equals(str3));
		
		//String buffer and String builder : used to make strings mutable (changeable/updatable)
		String normal = new String("normal string");
		normal.concat("wow");
		System.out.println(normal);
		
		StringBuffer buffer = new StringBuffer("buffer string");
		buffer.reverse();
		System.out.println(buffer);
		
		StringBuilder builder = new StringBuilder("ride");
		builder.append("ola");
		System.out.println(builder);
		
		String s1 = "hello";
		if(s1.contains("el")) {
			s1 = s1.concat("-woah-"); //Explicitly updating string since it is immutable
			System.out.println(s1);
		}
		
		String[] splits = s1.split("-");
		System.out.println(splits.length);
		
		s1 = s1.substring(s1.indexOf("-")+1, s1.lastIndexOf("-"));
		System.out.println(s1);
	
	}
	
	public static void change(int x) {
		x = 10;
		
		System.out.println(x);
	}
	
	public static void changeWrapper(int y) {
		y = 10;
		
		System.out.println(y);
	}
	
	public static void changeString(String s) {
		s = "world";
		
		System.out.println(s);
	}
	
	public static void updateList(ArrayList<Integer> list) {
		list.add(5);
		
		list.forEach(item -> System.out.print(item));
		System.out.println();
	}
	
	public static void updateRandomObject(RandomClass obj) {
		obj.setA(6);
		obj.setB(7);
		
		System.out.println(obj);
	}
}
