package basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Field;

class Emp{
	private int eid;
	private String ename;
	private double esal;
	
	public Emp() {
		super();
	}
	
	public Emp(int eid) {
		this.eid = eid;
	}
	
	public Emp(int eid, String ename, double esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	
	public double caculateIncome(double bonus) {
		return 12*this.esal + bonus;
	}
	
	@Override
	public String toString() {
		return "Emp [eid : " + this.eid + " ename : " + this.ename + " esal : "+ this.esal + "]";
	}
}

public class B_ReflectionAPI {

	/*
	 * is used to examine or modify the behavior of methods, classes and interfaces at runtime
	 * reflection gives us the info about the class to which an object belongs and the methods that can be called using that object
	 * using reflection, we can invoke methods at runtime IRRESPECTIVE of access specifier used with them
	 * 
	 * 
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class c = Class.forName("basics.Emp");
		
		Constructor<Emp>[] constructors = c.getDeclaredConstructors();
		
		for(Constructor cons : constructors) {
			System.out.println("name of the constructor : " + cons);
			System.out.println("count of constr parameters : " + cons.getParameterCount());
			
			Parameter[] parameters = cons.getParameters();
			for(Parameter param : parameters) {
				System.out.println("param in constructor " + cons.getName() + " : " + param);
			}
			System.out.println();
		}
		
		Method[] methods = c.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println("method name : " + method.getName());
			System.out.println("return type : " + method.getReturnType());
			System.out.println("parameter count : " + method.getParameterCount());
			
			Parameter[] parameters = method.getParameters();
			
			for(Parameter param : parameters) {
				System.out.println("param in method " + method.getName() + " : " + param);
			}
		}
		
		
		Emp e1 = (Emp)c.newInstance();
		System.out.println(e1);
		
		
		Emp e2 = new Emp(2,"aman",563584.0125d);
		Field privateeid = Emp.class.getDeclaredField("eid");
		Field privateename = c.getDeclaredField("ename");
		Field privateesal = c.getDeclaredField("esal");
		
		privateeid.setAccessible(true);
		privateename.setAccessible(true);
		privateesal.setAccessible(true);
		
		int storedEid = privateeid.getInt(e2);
		String storedEname = (String)privateename.get(e2);
		double storedEsal = privateesal.getDouble(e2);
		
		System.out.println(storedEid + " " + storedEname + " " + storedEsal);
		
		
		
		//traditional way of checking instance type
		Object o = 12;
		if(o instanceof String) {
			String s = (String) o;
			String.format("string %s", s);
		}if(o instanceof Integer) {
			Integer i = (Integer) o;
			String.format("int %d", i);
		}if(o instanceof Double) {
			Double d = (Double) o;
			String.format("double %f", d);
		}
		
		
	}
	
	
	
}
