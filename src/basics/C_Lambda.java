package basics;

@FunctionalInterface //makes sure there is only one abstract method
interface FuncInterface{
	
	public void funcMethod(); //one abstract method in functional interface
	
	public static void funcMethodDefined() {
		System.out.println("this is a defined method");
	}
}

/*
 * we use interface to declare functionality and we use class to define this functionality
 * interface with multiple abstract methods is normal interface
 * functional interface is one with one abstract method
 */

class TestFuncInterface implements FuncInterface{
	

	@Override
	public void funcMethod() {
		// TODO Auto-generated method stub
		System.out.println("functional interface from test function");
	}
}
public class C_Lambda {

	public static void main(String[] args) {
		
		TestFuncInterface t1 = new TestFuncInterface();
		t1.funcMethod();
		
		FuncInterface t2 = new TestFuncInterface();
		t2.funcMethod();
		
		//anonymous inner class
		FuncInterface t3 = new FuncInterface() {
			public void funcMethod() {
				System.out.println("this is from an anonymous class");
			}
		};
		
		t3.funcMethod();
		
		FuncInterface t = () -> System.out.println("this is functional interface");
		t.funcMethod();
		
		
		
	}

}
