package B_oops;

class Employee{
	private int eid;
	private String ename;
	
	public Employee(int eid, String ename) {
		this.eid= eid;
		this.ename =  ename;
	}
	
	public int getEid() {
		return this.eid;
	}
	
	public String getEname() {
		return this.ename;
	}
	
	public void setEid(int id) {
		this.eid = id;
	}
	
	public void setEname(String name) {
		this.ename = name;
	}
	
	public String toString() {
		return "Employee ["+ this.eid +" : " + this.ename + "]";
	}
}

public class CallByValueCallByReference {

	/*
	 * In call by value, the modification done to the parameter passed does not reflect in the caller's scope 
	 * while in the call by reference, the modification done to the parameter passed are persistent and changes
	 * are reflected in the caller's scope.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("asdf");
		
		//call by  reference  If we pass object in place of any primitive value, original value will be changed. 
		Employee e1 = new Employee(1,"aman");
		System.out.println(e1);
		
		updateEmployee(e1);
		
		System.out.println(e1);
		
		//In case of call by value original value is not changed : sending primitive data to a method call
		int i = 5;
		System.out.println(i);
		
		updateInteger(i);
		
		System.out.println(i);
		
		//call by reference for primitive type in java using object wrapping
		Integer k = 7;
		
		System.out.println(k);
		updateInterByRef(k);
		System.out.println(k);
		
		
	}

	private static void updateInterByRef(Integer i) {
		i = 15;
	}
	
	private static void updateInteger(int i) {
		i = 10;
		
	}

	public static void updateEmployee(Employee e) {
		e.setEname("abhay");
	}
}
